package activitytracker;

import javax.sql.DataSource;
import java.io.*;
import java.sql.*;
import java.util.Optional;

public class ImagesDao {

    private DataSource dataSource;

    public ImagesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Image saveImage(String filename, InputStream is, long activity_id) throws IOException {

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO images(file_name, content, id) VALUES (?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, filename);
            Blob blob = conn.createBlob();

            byte[] content = is.readAllBytes();

            ByteArrayInputStream bais = new ByteArrayInputStream(content);

            fillBlob(bais, blob);
            ps.setBlob(2, blob);

            ps.setLong(3, activity_id);

            ps.executeUpdate();

            long id = returnGetGeneratedKey(ps);


            return new Image(id, filename, content, activity_id);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot insert image", sqlException);
        }

    }

    private void fillBlob(InputStream is, Blob blob) throws SQLException {
        try (OutputStream os = blob.setBinaryStream(1)) {
            is.transferTo(os);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write blob", e);
        }
    }

    private long returnGetGeneratedKey(PreparedStatement stmt) {
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

    public Optional<Image> getImageByName(String filename) {

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM images WHERE file_name = ?")
        ) {
            ps.setString(1, filename);

            return getResult(ps);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot read image", sqlException);
        }

    }

    private Optional<Image> getResult(PreparedStatement ps) throws SQLException {

        try (
                ResultSet rs = ps.executeQuery();
        ) {
            if (rs.next()) {
                byte[] content = new BufferedInputStream(rs.getBlob("content").getBinaryStream()).readAllBytes();
                return Optional.of(new Image(rs.getLong("image_id"), rs.getString("file_name"), content, rs.getLong("id")));
            }

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read blob", e);
        }
        return Optional.empty();
    }


}
