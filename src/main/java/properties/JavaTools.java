package properties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class JavaTools {

    private Properties properties = new Properties();

    public JavaTools() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(JavaTools.class.getResourceAsStream("/javatools.properties"), StandardCharsets.UTF_8))){
            properties.load(reader);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }

    }

    public Set<String> getToolKeys() {

        Set<String> tools = new HashSet<>();
        for (String propertyName:properties.stringPropertyNames()) {
            tools.add(propertyName.substring(0,propertyName.indexOf('.')));
        }

        return tools;
    }

    public Set<String> getTools() {

        Set<String> tools = new HashSet<>();
        for (String key: getToolKeys()) {
            tools.add(getName(key));
        }
        return tools;
    }

    String getName(String key) {

        return properties.getProperty(key + ".name");
    }

    String getUrl(String key) {

        return properties.getProperty(key + ".url");
    }
}
