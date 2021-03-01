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

    public void printMenu() {

        System.out.println("1. Regisztráció");
        System.out.println("2. Tömeges regisztráció");
        System.out.println("3. Generálás");
        System.out.println("4. Oltás");
        System.out.println("5. Oltás meghiúsulás");
        System.out.println("6. Riport");
        System.out.println("0. Kilépés");

    }


    public UserInterface() {
        sc = new Scanner(System.in);
    }

    public Scanner getSc() {
        return sc;
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


        UserInterface userInterface = new UserInterface();
        VaccineController vaccineController = new VaccineController(dataSource);
        userInterface.printMenu();
        Scanner sc = userInterface.getSc();
        String select;
        while (!"0".equals(select = sc.nextLine())) {
            switch (select) {
                case "1" -> System.out.println("1. Regisztráció");
                case "2" -> userInterface.massRegistration(vaccineController);
                case "3" -> System.out.println("3. Generálás");
                case "4" -> System.out.println("4. Oltás");
                case "5" -> System.out.println("5. Oltás meghiúsulás");
                case "6" -> vaccineController.reportByPostalCode();
                default -> System.out.println("Hibás választás");
            }
            System.out.println("Press ENTER to continue");
            sc.nextLine();
            userInterface.printMenu();
        }

    }

    public void massRegistration(VaccineController vaccineController) {

        boolean endOfRead = true;
        while (endOfRead) {
            System.out.print("Kérem a beolvasandó fálj nevét (registered_tesztfile.csv): ");
            String fileName = sc.nextLine();

            try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
                vaccineController.massRegistration(reader);
                endOfRead = false;
            } catch (IOException e) {
                System.out.println("Hibás fájlnév " + fileName);
            }
        }
    }
}