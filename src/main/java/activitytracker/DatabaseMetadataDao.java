package activitytracker;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseMetadataDao {

    private DataSource dataSource;

    public DatabaseMetadataDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getColumnsForTable(String table) {
        try (Connection conn = dataSource.getConnection()) {
            DatabaseMetaData metaData = conn.getMetaData();
            return getColumnNamesByTable(metaData, table);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot read column names");
        }
    }

    private List<String> getColumnNamesByTable(DatabaseMetaData metaData, String table) throws SQLException {
        try (ResultSet rs = metaData.getColumns(null, null, table, null)) {
            List<String> names = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString(4);
                names.add(name);
            }
            return names;
        }
    }


    public List<String> getTableNames() {
        try (Connection conn = dataSource.getConnection()) {
            DatabaseMetaData metaData = conn.getMetaData();
            return getTableNamesByMetaData(metaData);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot read table names");
        }


    }

    private List<String> getTableNamesByMetaData(DatabaseMetaData metaData) throws SQLException {
        try (ResultSet rs = metaData.getTables(null, null, null, null)) {
            List<String> names = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString(3);
                names.add(name);
            }
            return names;
        }
    }

}
