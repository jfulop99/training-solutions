package vaccine;

import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private Scanner sc;

    private VaccineController vaccineController;

    public UserInterface(VaccineController vaccineController) {
        sc = new Scanner(System.in);
        this.vaccineController = vaccineController;
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
                    case "1" -> System.out.println("1. Regisztráció");
                    case "2" -> massRegistration();
                    case "3" -> callReportGeneration();
                    case "4" -> vaccination();
                    case "5" -> System.out.println("5. Oltás meghiúsulás");
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

    public void vaccination() {
        System.out.println("4. Oltás");
        System.out.println("Kérem a TAJ számot: ");
        String taj = sc.nextLine();
        if (!vaccineController.isRegisteredTaj(taj)) {
            System.out.println("Nincs ilyen TAJ szám");
            return;
        }
        VaccinationData vaccinationData = vaccineController.getCitizenDatas(taj);
        printVaccinationData(vaccinationData);


    }

    private void printVaccinationData(VaccinationData vaccinationData) {
        System.out.println(" TAJ szám                         Páciens neve");
        System.out.println(String.format("%10s %40s ", vaccinationData.getCitizen().getTajNumber(), vaccinationData.getCitizen().getFullName()));
        System.out.println("---------------------- Oltási adatok -------------------------------------------------------------------------");
        System.out.println(String.format(" Dátum:          %20s %20s %50s", "Vakcina típus", "Státusz", "Megjegyzés"));
        for (Vaccination item : vaccinationData.getVaccinations()) {
            System.out.println(String.format("%tY.%<tm.%<td %<tH:%<tM %20s %20s %50s", item.getVaccinationDate(),
                    item.getVaccineType().toString(), item.getStatus(), item.getNote()));
        }
    }

    public void callReportGeneration() {
        System.out.println("3. Generálás");
        int fileCount = vaccineController.callReportGenerator();
        System.out.println("A fájlok (" + fileCount + ") elkészültek XXXX_ÉÉÉÉ-HH-NN.txt néven (XXXX irányítószám)");
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

    public static void main(String[] args) {

        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/vaccine_control?useUnicode=true");
            dataSource.setUser("vaccine");
            dataSource.setPassword("vaccine");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Can not create datasource", sqlException);
        }

        VaccineController vaccineController = new VaccineController(dataSource);

        UserInterface userInterface = new UserInterface(vaccineController);

        userInterface.mainMenu();
    }


}