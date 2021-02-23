package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ActivityDaoTest {

    ActivityDao activityDao;

    List<TrackPoint> trackPoints;

    @BeforeEach
    void setUp() {

        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Can not create datasource", sqlException);
        }


        activityDao = new ActivityDao(dataSource);

        Flyway flyway = Flyway.configure()
                .locations("/db/migration/activitytracker")
                .dataSource(dataSource)
                .load();
        flyway.clean();
        flyway.migrate();

        trackPoints = new ArrayList<>();
        trackPoints.add(new TrackPoint(LocalDateTime.of(2021, 01, 11, 10, 10), 47.1234567, 19.1234567));
        trackPoints.add(new TrackPoint(LocalDateTime.of(2021, 01, 12, 12, 12), 47.1234567, 19.1234567));

    }

    @Test
    void saveActivityTest() {

        Activity activity =
                activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 11, 10, 12), "Leírás 1", ActivityType.BIKING, trackPoints));

        assertEquals(1, activity.getId());
        assertEquals(ActivityType.BIKING, activity.getType());

    }

    @Test
    void saveActivityRollBackTest() {

        trackPoints.add(new TrackPoint(LocalDateTime.of(2021, 01, 12, 12, 12), 99.1234567, 19.1234567));

        Activity activity =
                activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 11, 10, 12), "Leírás 1", ActivityType.BIKING, trackPoints));

        assertNull(activity);

    }

    @Test
    void findActivityByIdTest() {
        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 11, 10, 12), "Leírás 1", ActivityType.BIKING, trackPoints));
        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 12, 10, 22), "Leírás 2", ActivityType.BASKETBALL, trackPoints));
        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 13, 10, 32), "Leírás 3", ActivityType.HIKING, trackPoints));
        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 14, 10, 42), "Leírás 4", ActivityType.RUNNING, trackPoints));
        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 15, 10, 52), "Leírás 5", ActivityType.BIKING, trackPoints));

        Activity activity = activityDao.findActivityById(3);
        assertEquals(ActivityType.HIKING, activity.getType());
        assertEquals(3, activity.getId());
        assertEquals(2, activity.getTrackPoints().size());
        assertEquals(47.1234567, activity.getTrackPoints().get(0).getLat());
        assertEquals(12, activity.getTrackPoints().get(1).getTime().getMinute());

    }

    @Test
    void listActivitiesTest() {
        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 11, 10, 12), "Leírás 1", ActivityType.BIKING, trackPoints));
        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 12, 10, 22), "Leírás 2", ActivityType.BASKETBALL, trackPoints));
        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 13, 10, 32), "Leírás 3", ActivityType.HIKING, trackPoints));
        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 14, 10, 42), "Leírás 4", ActivityType.RUNNING, trackPoints));
        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 15, 10, 52), "Leírás 5", ActivityType.BIKING, trackPoints));

        List<Activity> result = activityDao.listActivities();

        assertEquals(5, result.size());
        assertEquals(LocalDateTime.of(2021, 1, 11, 10, 12), result.get(0).getStartTime());
        assertEquals(LocalDateTime.of(2021, 1, 15, 10, 52), result.get(4).getStartTime());
        assertEquals(2, result.get(0).getTrackPoints().size());
        assertEquals(2, result.get(4).getTrackPoints().size());
    }

    @Test
    void selectActivityByTypeTest() {
        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 11, 10, 12), "Leírás 1", ActivityType.BIKING, trackPoints));
        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 12, 10, 22), "Leírás 2", ActivityType.BASKETBALL, trackPoints));
        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 13, 10, 32), "Leírás 3", ActivityType.HIKING, trackPoints));
        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 14, 10, 42), "Leírás 4", ActivityType.RUNNING, trackPoints));
        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 15, 10, 52), "Leírás 5", ActivityType.BIKING, trackPoints));

        List<Activity> result = activityDao.selectActivityByType(ActivityType.BIKING);

        assertEquals(2, result.size());
        assertEquals(LocalDateTime.of(2021, 1, 11, 10, 12), result.get(0).getStartTime());
        assertEquals(LocalDateTime.of(2021, 1, 15, 10, 52), result.get(1).getStartTime());


    }
}