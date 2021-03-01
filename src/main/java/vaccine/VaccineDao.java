package vaccine;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class VaccineDao {

    private DataSource dataSource;

    public VaccineDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<PostalCode> selectPostalCode(String postalCode) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT id, zip, city, city_part FROM zip_numbers WHERE zip = ? ORDER BY id")) {
            ps.setString(1, postalCode);
            return getPostalCodeResult(ps);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    private List<PostalCode> getPostalCodeResult(PreparedStatement ps) {
        List<PostalCode> postalCodes = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                postalCodes.add(new PostalCode(rs.getLong("id"), rs.getString("zip"),
                        rs.getString("city"), rs.getString("city_part")));
            }
            return postalCodes;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    public List<Citizen> insertCitizens(List<Citizen> citizens) {
        List<Citizen> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(
                    "insert into citizens(citizen_name, zip, age, email, taj, number_of_vaccination) values(?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS)) {

                for (Citizen citizen : citizens) {

                    stmt.setString(1, citizen.getFullName());
                    stmt.setString(2, citizen.getZipNumber());
                    stmt.setInt(3, citizen.getAge());
                    stmt.setString(4, citizen.getEmailAddress());
                    stmt.setString(5, citizen.getTajNumber());
                    stmt.setInt(6, 0);
                    stmt.executeUpdate();
                    long id = getGeneratedKey(stmt);
                    result.add(new Citizen(
                            id, citizen.getFullName(), citizen.getZipNumber(), citizen.getAge(), citizen.getEmailAddress(), citizen.getTajNumber()));
                }
                conn.commit();
                return result;
            } catch (SQLIntegrityConstraintViolationException e) {
                conn.rollback();
                throw new IllegalArgumentException("Van már ilyen TAJ számmal regisztráció ", e);
            } catch (Exception e) {
                conn.rollback();
                throw new SQLException(e);
            }
        } catch (SQLException sqlException) {
            throw new IllegalArgumentException("Cannot insert", sqlException);
        }
    }

    private long getGeneratedKey(PreparedStatement stmt) {
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

    public List<Citizen> getCitizenByPostalCode(String postalCode) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT citizen_id, citizen_name, zip, age, email, taj FROM citizens WHERE zip = ? ORDER BY citizen_id")) {
            ps.setString(1, postalCode);
            return getCitizenResults(ps);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    private List<Citizen> getCitizenResults(PreparedStatement ps) {
        List<Citizen> result = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.add(new Citizen(rs.getLong("citizen_id"), rs.getString("citizen_name"),
                        rs.getString("zip"), rs.getInt("age"), rs.getString("email"),
                        rs.getString("taj")));
            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }


    public Map<String, List<PostalCode>> readPostalCodesFromDatabase() {
        Map<String, List<PostalCode>> result = new TreeMap<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT id, zip, city, city_part FROM zip_numbers ORDER BY id")) {
            return getPostalCodeResult(ps).stream().collect(Collectors.groupingBy(PostalCode::getZipNumber));

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    public List<Report> reportByPostalCodes() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT zip, number_of_vaccination, " +
                     "COUNT(citizen_id) AS 'Number of citizens' FROM citizens GROUP BY zip, number_of_vaccination ORDER BY zip, number_of_vaccination")) {
            return getReportResults(ps);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    private List<Report> getReportResults(PreparedStatement ps) {
        List<Report> result = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.add(new Report(rs.getString(1), rs.getInt(2), rs.getInt(3)));
            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

}
