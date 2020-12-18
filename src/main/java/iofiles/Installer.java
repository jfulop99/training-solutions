package iofiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class Installer {

    private List<String> files = new ArrayList<>();

    public void install(String installDir) {


        Path path = Path.of(installDir);

        if (!Files.exists(path) || !Files.isDirectory(path)) {
            throw new IllegalArgumentException("The given directory doesn't exist");
        }

        readInstallFile();

        try {
            for (String file : files) {
                if (file.endsWith("/")) {
                    Files.createDirectories(path.resolve(file));
                }
                else {
                    Files.copy(Installer.class.getResourceAsStream("/install/" + file), path.resolve(file), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Something went wrong", e);
        }
    }

    private void readInstallFile() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Installer.class.getResourceAsStream("/install/install.txt")))){
            String line;
            while ((line = reader.readLine()) != null) {
                files.add(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read install.txt", e);
        }
    }

    public static void main(String[] args) {
        Installer installer = new Installer();
        installer.install("temp/");
    }

}
