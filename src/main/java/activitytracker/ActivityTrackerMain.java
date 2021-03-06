package activitytracker;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityTrackerMain {


    private DataSource dataSource;

    public ActivityTrackerMain(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void insertActivity(Activity activity) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("INSERT INTO activities (start_time, activity_desc, activity_type) VALUES (?, ?, ?)")) {
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().toString());
            stmt.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot insert", sqle);
        }
    }

    public Activity getActivityById(long id) {

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

    public List<Activity> getActivities() {

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM activities ORDER BY id")) {

            return getResult(ps);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }

    }


    public static void main(String[] args) {

        MariaDbDataSource dataSource = new MariaDbDataSource();

        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Can not create datasource", sqlException);
        }

        ActivityTrackerMain activityDao = new ActivityTrackerMain(dataSource);

        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(1, LocalDateTime.of(2021, 1, 11, 10, 12), "Leírás 1", ActivityType.BIKING));
        activities.add(new Activity(2, LocalDateTime.of(2021, 1, 12, 10, 22), "Leírás 2", ActivityType.BASKETBALL));
        activities.add(new Activity(3, LocalDateTime.of(2021, 1, 13, 10, 32), "Leírás 3", ActivityType.HIKING));
        activities.add(new Activity(4, LocalDateTime.of(2021, 1, 14, 10, 42), "Leírás 4", ActivityType.RUNNING));
        activities.add(new Activity(5, LocalDateTime.of(2021, 1, 15, 10, 52), "Leírás 5", ActivityType.BIKING));


        Flyway flyway = Flyway.configure().locations("/db/migration/activitytracker").dataSource(dataSource).load();

        flyway.clean();
        flyway.migrate();

        for (Activity item : activities) {
            activityDao.insertActivity(item);
        }

        System.out.println(activityDao.getActivityById(3));
        System.out.println(activityDao.getActivities());


    }


}
