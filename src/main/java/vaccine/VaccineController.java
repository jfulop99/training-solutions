package vaccine;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VaccineController {

    public static final String EXIST_SIGN = "Exist";
    public static final String COLUMN_SEPARATOR = ";";

    private VaccineDao vaccineDao;

    private VaccineValidator vaccineValidator;

    public VaccineController(DataSource dataSource) {

        vaccineDao = new VaccineDao(dataSource);

        vaccineValidator = new VaccineValidator(vaccineDao.readPostalCodesFromDatabase());
    }

    public VaccineValidator getVaccineValidator() {
        return vaccineValidator;
    }

    public List<Citizen> readCitizensFromFile(BufferedReader reader) throws IOException {
        List<Citizen> citizens = new ArrayList<>();
        List<String> pocessedLines = new ArrayList<>();

        String line;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            Optional<Citizen> citizen = lineParser(line);
            if (citizen.isEmpty()) {
                pocessedLines.add("***** Hibás adat(ok) ***** " + line);
            } else {
                if (EXIST_SIGN.equals(citizen.get().getFullName())) {
                    pocessedLines.add("***** Regisztrált TAJ szám ***** " + line);
                } else {
                    pocessedLines.add("--- Feldogozott " + line);
                    citizens.add(citizen.get());
                }
            }
        }
        writeErrorList(pocessedLines);
        return citizens;
    }

    private void writeErrorList(List<String> wrongLines) {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("temp/vaccine/inputresult.txt"))) {
            writer.write("Process report\nDate: " + LocalDateTime.now());
            writer.newLine();
            int lineNumber = 1;
            for (String line : wrongLines) {
                writer.write(String.format("%6d %s%n", lineNumber++, line));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file");
        }
    }

    private Optional<Citizen> lineParser(String line) {
        String[] parts = line.split(COLUMN_SEPARATOR);
        if (parts.length != 5) {
            return Optional.empty();
        }
        String name = parts[0];
        String zip = parts[1];
        String age = parts[2];
        String email = parts[3];
        String taj = parts[4];

        if (vaccineDao.isTajExist(taj)) {
            return Optional.of(new Citizen(EXIST_SIGN, "0000", 100, "a@.hu", "000000000"));
        }

        if (!vaccineValidator.isEmpty(name) && !vaccineValidator.getPostalCode(zip).isEmpty()
                && vaccineValidator.isValidAge(age) && vaccineValidator.isValidEmail(email)
                && vaccineValidator.isValidTajNumber(taj)) {
            return Optional.of(new Citizen(name, zip, Integer.parseInt(age), email, taj));
        }
        return Optional.empty();
    }

    public int massRegistration(BufferedReader reader) throws IOException {
        List<Citizen> citizens;
        List<Citizen> result;
        citizens = readCitizensFromFile(reader);
        result = vaccineDao.insertCitizens(citizens);
        return result.size();
    }


    public void reportByPostalCode() {
        List<Report> reports = vaccineDao.reportByPostalCodes();
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("temp/vaccine/report.txt"))) {
            writer.write("Report" + LocalDateTime.now());
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

    public int callReportGenerator(String postalCode) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm;");
        LocalTime appointment = LocalTime.of(8, 0);
        StringBuilder sb = new StringBuilder("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám\n");

        List<Citizen> citizens = vaccineDao.getCitizensForVaccination();
        String prevPostalCode = citizens.get(0).getZipNumber();
        if (!postalCode.isBlank()) {
            prevPostalCode = postalCode;
            citizens = citizens
                    .stream()
                    .filter(c -> c.getZipNumber().equals(postalCode))
                    .collect(Collectors.toList());
        }
        if (citizens.isEmpty()) {
            return 0;
        }
        int fileCounter = 1;

        for (Citizen citizen : citizens) {
            if (!prevPostalCode.equals(citizen.getZipNumber())) {
                writeReportToFile(prevPostalCode, sb.toString());
                appointment = LocalTime.of(8, 0);
                prevPostalCode = citizen.getZipNumber();
                sb = new StringBuilder("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám\n");
                fileCounter++;
            }
            if (appointment.isBefore(LocalTime.of(16, 0))) {
                sb.append(appointment.format(format));
                sb.append(citizen.toString());
                appointment = appointment.plusMinutes(30);
            }
        }
        writeReportToFile(prevPostalCode, sb.toString());
        return fileCounter;
    }

    private void writeReportToFile(String postalCode, String content) {
        Path path = Path.of("temp/vaccine/" + postalCode + "_" + LocalDate.now().toString() + ".txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(content);
        } catch (IOException e) {
            throw new IllegalStateException("File írási hiba " + path.toString() + e.getMessage());
        }
    }

    public boolean isRegisteredTaj(String taj) {
        return vaccineDao.isTajExist(taj);
    }

    public VaccinationData getCitizenDatas(String taj) {
        Citizen citizen = vaccineDao.getCitizenByTaj(taj);
        long id = citizen.getId();
        return new VaccinationData(citizen, vaccineDao.getVaccinationByCitizenId(id));
    }

    public void insertVaccination(Vaccination vaccination) {

        vaccineDao.insertVaccination(vaccination);

    }

    public Citizen insertCitizen(Citizen citizen) {
        return vaccineDao.insertCitizens(List.of(citizen)).get(0);
    }
}
