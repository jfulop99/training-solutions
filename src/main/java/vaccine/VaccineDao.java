package vaccine;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VaccineDao {

    private DataSource dataSource;

    public VaccineDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Citizen> readCitizensFromFile(BufferedReader reader) throws IOException {
        List<Citizen> citizens = new ArrayList<>();
        List<String> wrongLines = new ArrayList<>();

        String line;
        reader.readLine();
        System.out.println("Processing");
        int counter = 0;
        while ((line = reader.readLine()) != null) {
            Optional<Citizen> citizen = lineParser(line);
            if (citizen.isEmpty()) {
                wrongLines.add(line);
            } else {
                citizens.add(citizen.get());
            }
            counter++;
            if (counter == 200) {
                counter = 0;
                System.out.println("");
            }
        }
        return citizens;
    }

    private Optional<Citizen> lineParser(String line) {
        String[] parts = line.split(";");
        System.out.print(".");
        if (parts.length != 5 || selectPostalCode(parts[1]).isEmpty()) {
            return Optional.empty();
        }
        try {
            return Optional.of(new Citizen(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4]));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
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


}
