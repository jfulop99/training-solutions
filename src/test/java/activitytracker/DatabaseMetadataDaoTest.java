package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DatabaseMetadataDaoTest {

    private DatabaseMetadataDao metaDataDao;

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

        Flyway flyway = Flyway.configure()
                .locations("/db/migration/activitytracker")
                .dataSource(dataSource)
                .load();
        flyway.clean();
        flyway.migrate();

        metaDataDao = new DatabaseMetadataDao(dataSource);

    }

    @Test
    void getColumnsForTable() {

        List<String> names = metaDataDao.getColumnsForTable("activities");
        System.out.println(names);

        assertTrue(names.contains("activity_desc"), "Contains activity_desc column");

    }

    @Test
    void getTableNames() {

        List<String> names = metaDataDao.getTableNames();
        System.out.println(names);

        assertTrue(names.contains("activities"), "Contains activities table");

    }
}