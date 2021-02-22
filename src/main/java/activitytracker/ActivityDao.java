package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true";
    private static final String JDBC_USER = "activitytracker";
    private static final String JDBC_PASSWORD = "activitytracker";

    private MariaDbDataSource dataSource;

    public ActivityDao() {
        dataSource = getMariaDbDataSource();
    }

    private MariaDbDataSource getMariaDbDataSource() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl(JDBC_URL);
            dataSource.setUser(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Can not create datasource", sqlException);
        }
        return dataSource;
    }


    public Activity saveActivity(Activity activity) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement("INSERT INTO activities (start_time, activity_desc, activity_type) VALUES (?, ?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().toString());
            long id = executeAndGetGeneratedKey(stmt);
            return new Activity(id, activity.getStartTime(), activity.getDesc(), activity.getType());
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot insert", sqle);
        }
    }

    private long executeAndGetGeneratedKey(PreparedStatement stmt) {
        try (ResultSet rs = stmt.getGeneratedKeys();) {
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

             PreparedStatement ps = conn.prepareStatement("SELECT * FROM activities WHERE id = ?")) {

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
        List<Activity> result = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.add(new Activity(rs.getLong("id"), rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("activity_desc"), ActivityType.valueOf(rs.getString("activity_type"))));
            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }


    public List<Activity> listActivities() {

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM activities ORDER BY id")) {

            return getResult(ps);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    public MariaDbDataSource getDataSource() {
        return dataSource;
    }


}
