package vaccine;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner sc;

    private VaccineController vaccineController;

    private VaccineValidator vaccineValidator;

    public UserInterface(VaccineController vaccineController) {
        sc = new Scanner(System.in);
        this.vaccineController = vaccineController;
        this.vaccineValidator = vaccineController.getVaccineValidator();
    }

    public void printMenu() {

        System.out.println("1. Regisztráció");
        System.out.println("2. Tömeges regisztráció");
        System.out.println("3. Generálás");
        System.out.println("4. Oltás");
        System.out.println("5. Oltás meghiúsulás");
        System.out.println("6. Riport");
        System.out.println("0. Kilépés");

    }


    public void mainMenu() {

        String select;

        printMenu();

        while (!"0".equals(select = sc.nextLine())) {
            try {

                switch (select) {
                    case "1" -> registration();
                    case "2" -> massRegistration();
                    case "3" -> callReportGeneration();
                    case "4", "5" -> vaccination();
                    case "6" -> reportGeneration();
                    default -> System.out.println("Hibás választás");
                }
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println("Hiba!  " + e.getMessage());
            }
            System.out.println("Press ENTER to continue");
            sc.nextLine();
            printMenu();
        }
    }

    public void registration() {
        System.out.println("1. Regisztráció\n");

        String fullName = getFullName();
        String postalCode = getPostalCode();
        String emailAddress = getEmail();
        int age = getAge();
        String taj = getTajNumber();

        if (vaccineController.isRegisteredTaj(taj)) {
            System.out.println("Ez a TAJ szám már regisztrált!");
            return;
        }
        System.out.printf("%nRegisztráció:%n");
        System.out.printf("Név: %-30s TAJ szám: %9s Irányítószám: %4s Életkor: %3d E-mail: %-30s%n%n", fullName, taj, postalCode, age, emailAddress);
        if (selectOption("Adatok rendben? (i)gen / (n)em ", "i", "n").equals("i")) {
            Citizen citizen = new Citizen(fullName, postalCode, age, emailAddress, taj);
            citizen = vaccineController.insertCitizen(citizen);
            System.out.println("Letárolva " + citizen.getId() + " azonosítóval.");
        }

    }

    private String getTajNumber() {
        String taj = "";
        boolean inValid;

        inValid = true;
        while (inValid) {
            System.out.println("Kérem a TAJ számot: ");
            inValid = !vaccineValidator.isValidTajNumber(taj = sc.nextLine());
        }
        return taj;
    }

    private int getAge() {
        boolean inValid;

        inValid = true;
        int age = 0;
        while (inValid) {
            String strAge;
            System.out.println("Kérem az életkort: ");
            strAge = sc.nextLine();
            inValid = !vaccineValidator.isValidAge(strAge);
            age = Integer.parseInt(strAge);
        }
        return age;
    }

    private String getEmail() {
        boolean inValid;

        inValid = true;
        String email = "";
        while (inValid) {
            System.out.println("Kérem az E-mail címet: ");
            String email1 = sc.nextLine();
            System.out.println("Kérem az E-mail címet még egyszer: ");
            email = sc.nextLine();
            if (email.equals(email1)) {
                inValid = !vaccineValidator.isValidEmail(email);
            }
        }
        return email;
    }

    private String getPostalCode() {
        boolean inValid;

        inValid = true;
        List<PostalCode> postalCodes = new ArrayList<>();
        while (inValid) {
            System.out.println("Kérem az irányítószámot: ");
            postalCodes = vaccineValidator.getPostalCode(sc.nextLine());
            if (!postalCodes.isEmpty()) {
                inValid = false;
                System.out.println(postalCodes.get(0).getCity() + " " + postalCodes.get(0).getCityPart());
            }
        }
        return postalCodes.get(0).getZipNumber();
    }

    private String getFullName() {
        boolean inValid = true;
        String name = null;
        while (inValid) {
            System.out.println("Kérem a nevet: ");
            name = sc.nextLine();
            inValid = vaccineValidator.isEmpty(name);
        }
        return name;
    }


    public void vaccination() {
        System.out.println("4. Oltás / Oltás meghiúsulás");
        System.out.println("Kérem a TAJ számot: ");
        String taj = sc.nextLine();
        if (!vaccineController.isRegisteredTaj(taj)) {
            System.out.println("Nincs ilyen TAJ szám");
            return;
        }
        VaccinationData vaccinationData = vaccineController.getCitizenDatas(taj);
        if (printVaccinationData(vaccinationData)) {
            return;
        }
        if ("i".equals(selectOption("Oltás rendben? (i)gen / (n)em ", "i", "n"))) {
            registrationVaccination(vaccinationData);
        } else {
            rejectedVaccination(vaccinationData);
        }
    }

    private void rejectedVaccination(VaccinationData vaccinationData) {
        VaccineType vaccineType = null;
        VaccinationStatus vaccinationStatus = null;

        int select = Integer.parseInt(selectOption("Kérem a meghiúsulás okát : (1:Visszautasítás, 2:Egészségügyi porbléma) ", "1", "2"));
        vaccinationStatus = VaccinationStatus.values()[select + 2];
        System.out.print("Megjegyzés ");
        String note = sc.nextLine();
        System.out.println("Tárolandó adatok:");
        System.out.printf("Vakcina : %-25s Státusz: %-20s Megjegyzés: %-100s%n", vaccineType, vaccinationStatus, note);
        if ("i".equals(selectOption("Adatok rendben? (i)gen / (n)em: ", "i", "n"))) {
            vaccineController.insertVaccination(new Vaccination(vaccinationData.getCitizen().getId(),
                    LocalDateTime.now(), vaccinationStatus, note, vaccineType));
        }

    }

    private void registrationVaccination(VaccinationData vaccinationData) {
        VaccineType vaccineType = null;
        VaccinationStatus vaccinationStatus = VaccinationStatus.FIRST_VACCINATION;
        for (Vaccination item : vaccinationData.getVaccinations()) {
            if (item.getStatus() == VaccinationStatus.FIRST_VACCINATION) {
                vaccineType = item.getVaccineType();
                vaccinationStatus = VaccinationStatus.SECOND_VACCINATION;
            }
        }
        if (vaccineType == null) {
            int select = Integer.parseInt(selectOption("Kérem a vakcina típusát : (1:SINOPHARM, 2:PFIZER_BIONTECH, 3:MODERNA, 4:SPUTNIK_V, 5:ASTRAZENECA)",
                    "1", "2", "3", "4", "5"));
            vaccineType = VaccineType.values()[select - 1];
        }
        System.out.printf("Vakcina : %-25s Státusz: %-20s %n", vaccineType, vaccinationStatus);
        System.out.print("Megjegyzés ");
        String note = sc.nextLine();
        System.out.println("Tárolandó adatok:");
        System.out.printf("Vakcina : %-25s Státusz: %-20s Megjegyzés: %-100s%n", vaccineType, vaccinationStatus, note);
        if ("i".equals(selectOption("Adatok rendben? (i)gen / (n)em: ", "i", "n"))) {
            vaccineController.insertVaccination(new Vaccination(vaccinationData.getCitizen().getId(),
                    LocalDateTime.now(), vaccinationStatus, note, vaccineType));
        }
    }

    private boolean printVaccinationData(VaccinationData vaccinationData) {
        System.out.println(" TAJ szám                         Páciens neve");
        System.out.printf("%10s %40s %n", vaccinationData.getCitizen().getTajNumber(), vaccinationData.getCitizen().getFullName());
        System.out.println("---------------------- Oltási adatok -------------------------------------------------------------------------");
        System.out.printf(" Dátum:          %20s %20s %50s%n", "Vakcina típus", "Státusz", "Megjegyzés%n");
        boolean alert = false;
        String message = "";
        for (Vaccination item : vaccinationData.getVaccinations()) {
            System.out.printf("%tY.%<tm.%<td %<tH:%<tM %20s %20s %50s%n", item.getVaccinationDate(),
                    item.getVaccineType().toString(), item.getStatus(), item.getNote());
            if (item.getStatus() == VaccinationStatus.SECOND_VACCINATION) {
                alert = true;
                message = "A páciens már megkapta a második oltást is.";
            }
            if (item.getStatus() == VaccinationStatus.FIRST_VACCINATION && ChronoUnit.DAYS.between(item.getVaccinationDate(), LocalDateTime.now()) < 15) {
                alert = true;
                message = "Az első oltás óta nem telt még el 15 nap";
            }
        }
        if (alert) {
            System.out.println(message);
        }
        return alert;
    }

    public void callReportGeneration() {
        System.out.println("3. Generálás");
        System.out.println("Kérem az irányítószámot (Üres = mind): ");
        String postalCode;
        while (vaccineValidator.getPostalCode(postalCode = sc.nextLine()).isEmpty()) {
            System.out.println("Hibás irányítószám");
        }
        int fileCount = vaccineController.callReportGenerator(postalCode);
        if (fileCount == 0) {
            System.out.println("Nincs regisztrált/oltható páciens");
        } else {
            System.out.println("A fájl(ok) (" + fileCount + ") elkészült(ek) XXXX_ÉÉÉÉ-HH-NN.txt néven (XXXX irányítószám)");
        }
    }

    public void reportGeneration() {
        System.out.println("6. Riport generálás");
        vaccineController.reportByPostalCode();
        System.out.println("A riport.txt fájl elkészült");
    }

    public void massRegistration() {
        boolean endOfRead = true;

        while (endOfRead) {
            System.out.println("2. Tömeges regisztráció");
            System.out.print("Kérem a beolvasandó fálj nevét (pl.: teszt.csv): ");
            String fileName = sc.nextLine();
            if (fileName.isBlank()) {
                endOfRead = false;
            } else {
                try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
                    System.out.println("Processing...");
                    int records = vaccineController.massRegistration(reader);
                    endOfRead = false;
                    System.out.println(records + " records inserted (see inputresult.txt)");
                } catch (IOException e) {
                    System.out.println("Hibás fájlnév " + fileName);
                }
            }
        }
    }

    public String selectOption(String selectText, String... selectOptions) {
        boolean selected = false;
        String select = "";
        System.out.print(selectText);
        while (!selected) {
            select = sc.nextLine();
            for (String item : selectOptions) {
                if (item.equals(select)) {
                    selected = true;
                }
            }
        }
        return select;
    }

    public static void main(String[] args) {

        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/vaccine_control?useUnicode=true");
            dataSource.setUser("vaccine");
            dataSource.setPassword("vaccine");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Can not create datasource", sqlException);
        }

        Flyway flyway = Flyway.configure()
                .locations("/db/migration/vaccine")
                .dataSource(dataSource)
                .load();
        flyway.clean();
        flyway.migrate();


        VaccineController vaccineController = new VaccineController(dataSource);

        UserInterface userInterface = new UserInterface(vaccineController);

        userInterface.mainMenu();
    }


}