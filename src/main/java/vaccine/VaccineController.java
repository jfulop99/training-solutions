package vaccine;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class VaccineController {

    private DataSource dataSource;

    private VaccineDao vaccineDao;

    private VaccineValidator vaccineValidator;

    private Map<String, List<PostalCode>> postalCodes;

    public VaccineController(DataSource dataSource) {
        this.dataSource = dataSource;

        vaccineDao = new VaccineDao(dataSource);

        postalCodes = vaccineDao.readPostalCodesFromDatabase();

        vaccineValidator = new VaccineValidator(postalCodes);
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
        if (!wrongLines.isEmpty()) {
            writeErrorList(wrongLines);
        }
        return citizens;
    }

    private void writeErrorList(List<String> wrongLines) {
        System.out.println("Hibás sorok száma:" + wrongLines.size());
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("temp/vaccine/hibalista.txt"))) {
            for (String line : wrongLines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Cannot write file");
        }
        System.out.println("Hibalista kész!");
    }

    private Optional<Citizen> lineParser(String line) {
        String[] parts = line.split(";");
        System.out.print(".");
        if (parts.length != 5) {
            return Optional.empty();
        }
        String name = parts[0];
        String zip = parts[1];
        String age = parts[2];
        String email = parts[3];
        String taj = parts[4];
        if (!vaccineValidator.isEmpty(name) && !vaccineValidator.getPostalCode(zip).isEmpty()
                && vaccineValidator.isValidAge(age) && vaccineValidator.isValidEmail(email)
                && vaccineValidator.isValidTajNumber(taj)) {
            return Optional.of(new Citizen(name, zip, Integer.parseInt(age), email, taj));
        }
        return Optional.empty();
    }

    public void massRegistration(BufferedReader reader) throws IOException {
        System.out.println("2. Tömeges regisztráció");
        List<Citizen> citizens;
        List<Citizen> result = new ArrayList<>();
        citizens = readCitizensFromFile(reader);
        try {
            result = vaccineDao.insertCitizens(citizens);
        } catch (IllegalArgumentException e) {
            System.out.println("Rollback.. " + e.getMessage());
        }
        System.out.println(result.size() + " records inserted");
    }


    public void reportByPostalCode() {
        List<Report> reports = vaccineDao.reportByPostalCodes();
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("temp/vaccine/report.txt"))) {
            writer.write("Report");
            writer.newLine();
            writer.write("Postal Code Number of vaccination Number of citizens");
            writer.newLine();
            for (Report report : reports) {
                writer.write(String.format("    %4s           %2d           %8d%n", report.getPostalCode(), report.getNumberOfVaccination(), report.getNumberOfCitizen()));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file");
        }
    }

}
