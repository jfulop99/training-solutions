package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImagesDaoTest {

    private ImagesDao imagesDao;
    private ActivityDao activityDao;

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


        imagesDao = new ImagesDao(dataSource);
        activityDao = new ActivityDao(dataSource);

        Flyway flyway = Flyway.configure()
                .locations("/db/migration/activitytracker")
                .dataSource(dataSource)
                .load();
        flyway.clean();
        flyway.migrate();

    }

    @Test
    void saveImage() throws IOException {

        Image image;
        List<TrackPoint> trackPoints = new ArrayList<>();
        trackPoints.add(new TrackPoint(LocalDateTime.of(2021, 01, 11, 10, 10), 47.1234567, 19.1234567));
        trackPoints.add(new TrackPoint(LocalDateTime.of(2021, 01, 12, 12, 12), 47.1234567, 19.1234567));

        Activity activity =
                activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 11, 10, 12), "Leírás 1", ActivityType.BIKING, trackPoints));

        assertEquals(1, activity.getId());
        assertEquals(ActivityType.BIKING, activity.getType());

        try (BufferedInputStream is = new BufferedInputStream(ImagesDao.class.getResourceAsStream("training360.gif"))) {

            image = imagesDao.saveImage("training360.gif", is, 1);

        }

        assertEquals(1, image.getId());
        assertEquals(1, image.getActivity_id());
        assertEquals("training360.gif", image.getFileName());
        assertEquals(5360, image.getContent().length);

    }

    @Test
    void getImageByNameTest() throws IOException {

        Image image;
        List<TrackPoint> trackPoints = new ArrayList<>();
        trackPoints.add(new TrackPoint(LocalDateTime.of(2021, 01, 11, 10, 10), 47.1234567, 19.1234567));
        trackPoints.add(new TrackPoint(LocalDateTime.of(2021, 01, 12, 12, 12), 47.1234567, 19.1234567));

        Activity activity =
                activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 11, 10, 12), "Leírás 1", ActivityType.BIKING, trackPoints));

        try (BufferedInputStream is = new BufferedInputStream(ImagesDao.class.getResourceAsStream("training360.gif"))) {

            image = imagesDao.saveImage("training360.gif", is, 1);

        }
        Optional<Image> result = imagesDao.getImageByName("training360.gif");

        assertTrue(result.isPresent());
        assertEquals("training360.gif", result.get().getFileName());
        assertEquals(5360, result.get().getContent().length);


    }

    @Test
    void getImageByNameNotFoundTest() throws IOException {

        Image image;
        List<TrackPoint> trackPoints = new ArrayList<>();
        trackPoints.add(new TrackPoint(LocalDateTime.of(2021, 01, 11, 10, 10), 47.1234567, 19.1234567));
        trackPoints.add(new TrackPoint(LocalDateTime.of(2021, 01, 12, 12, 12), 47.1234567, 19.1234567));

        Activity activity =
                activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 11, 10, 12), "Leírás 1", ActivityType.BIKING, trackPoints));

        try (BufferedInputStream is = new BufferedInputStream(ImagesDao.class.getResourceAsStream("training360.gif"))) {

            image = imagesDao.saveImage("training360.gif", is, 1);

        }
        Optional<Image> result = imagesDao.getImageByName("xraining360.gif");

        assertTrue(result.isEmpty());

    }
}