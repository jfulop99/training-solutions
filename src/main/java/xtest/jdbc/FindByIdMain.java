package xtest.jdbc;


import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindByIdMain {

    public void selectNameById(MariaDbDataSource dataSource, long id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT emp_name FROM employees WHERE id = ?")) {
            ps.setLong(1, id);
            selectNameByPreparedStatement(ps);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    private void selectNameByPreparedStatement(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String name = rs.getString("emp_name");
                System.out.println(name);
            } else {
                throw new IllegalArgumentException("Not found");
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    public static void main(String[] args) {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("can not create datasource");
        }

        new FindByIdMain().selectNameById(dataSource, 1);
    }

}
