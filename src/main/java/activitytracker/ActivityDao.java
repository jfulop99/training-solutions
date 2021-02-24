package activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {


    private DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public Activity saveActivity(Activity activity) {

        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt =
                         conn.prepareStatement("INSERT INTO activities (start_time, activity_desc, activity_type) VALUES (?, ?, ?)",
                                 Statement.RETURN_GENERATED_KEYS)) {

                LocalDateTime startTime = activity.getStartTime();
                stmt.setTimestamp(1, Timestamp.valueOf(startTime));

                String desc = activity.getDesc();
                stmt.setString(2, desc);

                ActivityType type = activity.getType();
                stmt.setString(3, type.toString());

                stmt.executeUpdate();
                long id = getGeneratedKey(stmt);

                List<TrackPoint> trackPoints = saveTrackPoints(conn, activity.getTrackPoints(), id);
                conn.commit();
                return new Activity(id, startTime, desc, type, trackPoints);
            } catch (SQLIntegrityConstraintViolationException e) {
                conn.rollback();
                return null;
            } catch (SQLException sqle) {
                throw new IllegalStateException("Cannot insert", sqle);
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot insert", sqlException);
        }
    }

    private List<TrackPoint> saveTrackPoints(Connection conn, List<TrackPoint> trackPoints, long activity_id) throws SQLException {
        List<TrackPoint> result = new ArrayList<>();
        try (PreparedStatement stmt =
                     conn.prepareStatement("INSERT INTO track_points (point_time, lat, lon, id) VALUES (?, ?, ?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            for (TrackPoint trackpoint : trackPoints) {

                LocalDateTime time = trackpoint.getTime();
                stmt.setTimestamp(1, Timestamp.valueOf(time));

                double lat = trackpoint.getLat();
                stmt.setDouble(2, lat);

                double lon = trackpoint.getLon();
                stmt.setDouble(3, lon);

                stmt.setLong(4, activity_id);

                stmt.executeUpdate();
                long id = getGeneratedKey(stmt);

                result.add(new TrackPoint(id, time, lat, lon));
            }
            return result;
        }
    }

    private long getGeneratedKey(PreparedStatement stmt) {
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getLong(1);
            } else {
                throw new SQLException("No key has generated");
            }

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Error by insert", sqlException);
        }
    }


    public Activity findActivityById(long id) {

        try (Connection conn = dataSource.getConnection();

             PreparedStatement ps = conn.prepareStatement("SELECT a.*, b.* FROM activities a, track_points b WHERE a.id = b.id AND a.id = ?")) {

            ps.setLong(1, id);
            if (getResult(ps).isEmpty()) {
                throw new IllegalArgumentException("Not found");
            }
            return getResult(ps).get(0);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }


    private List<Activity> getResult(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            return getActivities(rs);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    private List<Activity> getActivities(ResultSet rs) throws SQLException {
        List<Activity> result = new ArrayList<>();
        long id = 0L;
        LocalDateTime startTime = null;
        String desc = "";
        ActivityType type = null;
        List<TrackPoint> trackPoints = new ArrayList<>();

        while (rs.next()) {

            if (rs.getLong("a.id") != id) {
                if (id != 0) {
                    result.add(new Activity(id, startTime, desc, type, trackPoints));
                }
                id = rs.getLong("a.id");
                startTime = rs.getTimestamp("a.start_time").toLocalDateTime();
                desc = rs.getString("a.activity_desc");
                type = ActivityType.valueOf(rs.getString("a.activity_type"));


                trackPoints.clear();
            }
            trackPoints.add(new TrackPoint(rs.getTimestamp("b.point_time").toLocalDateTime(), rs.getDouble("b.lat"), rs.getDouble("b.lon")));
        }
        result.add(new Activity(id, startTime, desc, type, trackPoints));
        return result;
    }


    public List<Activity> listActivities() {

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT a.*, b.* FROM activities a, track_points b WHERE a.id = b.id ORDER BY a.id")) {

            return getResult(ps);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    public List<Activity> selectActivityByType(ActivityType activityType) {

        try (Connection conn = dataSource.getConnection();

             PreparedStatement ps = conn.prepareStatement("SELECT a.*, b.* FROM activities a, track_points b WHERE a.id = b.id AND a.activity_type = ?")) {

            ps.setObject(1, activityType.toString());
            if (getResult(ps).isEmpty()) {
                throw new IllegalArgumentException("Not found");
            }
            return getResult(ps);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    public Activity insertActivity(Activity activity) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "insert into activities(start_time, activity_desc,activity_type) values(?,?,?)",
                     Statement.RETURN_GENERATED_KEYS
             )) {
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().toString());
            stmt.executeUpdate();
            long id = executeAndGetGeneratedKey(stmt);
            return new Activity(
                    id, activity.getStartTime(), activity.getDesc(), activity.getType()
            );
        } catch (SQLException sqlException) {
            throw new IllegalArgumentException("Cannot insert", sqlException);
        }
    }

    private long executeAndGetGeneratedKey(PreparedStatement stmt) {
        try (
                ResultSet rs = stmt.getGeneratedKeys()
        ) {
            if (rs.next()) {
                return rs.getLong(1);
            } else {
                throw new SQLException("No key was generated.");
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Insertion failed.", e);
        }
    }

    public List<Activity> insertActivities(List<Activity> activities) {
        List<Activity> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "insert into activities(start_time, activity_desc,activity_type) values(?,?,?)",
                     Statement.RETURN_GENERATED_KEYS
             )) {
            for (Activity activity : activities) {

                stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
                stmt.setString(2, activity.getDesc());
                stmt.setString(3, activity.getType().toString());
                stmt.executeUpdate();
                long id = executeAndGetGeneratedKey(stmt);
                result.add(new Activity(
                        id, activity.getStartTime(), activity.getDesc(), activity.getType()));
            }
            return result;
        } catch (SQLException sqlException) {
            throw new IllegalArgumentException("Cannot insert", sqlException);
        }
    }
}
