package properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Properties;

public class DatabaseConfiguration {

    Properties properties = new Properties();

    public DatabaseConfiguration() {
        try (InputStreamReader reader = new InputStreamReader(DatabaseConfiguration.class.getResourceAsStream("/db.properties"), StandardCharsets.UTF_8)){
            properties.load(reader);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
    }


    public DatabaseConfiguration(File file) {

        try (BufferedReader reader = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8)){
            properties.load(reader);
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file");
        }
    }

    public String getHost() {
        return properties.getProperty("db.host");
    }

    public int getPort() {
        return Integer.parseInt(properties.getProperty("db.port"));
    }

    public String getSchema() {
        return properties.getProperty("db.schema");
    }
}
