package vaccine;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuController {

    private DataSource dataSource;

    private VaccineDao vaccineDao;

    public MenuController(DataSource dataSource) {
        this.dataSource = dataSource;
        vaccineDao = new VaccineDao(dataSource);
    }

    public void printMenu() {

        System.out.println("1. Regisztráció");
        System.out.println("2. Tömeges regisztráció");
        System.out.println("3. Generálás");
        System.out.println("4. Oltás");
        System.out.println("5. Oltás meghiúsulás");
        System.out.println("0. Kilépés");

    }

    public void massRegistration() {
        System.out.println("2. Tömeges regisztráció");
        List<Citizen> citizens;
        try (BufferedReader reader = Files.newBufferedReader(Path.of("registered_tesztfile.csv"))) {
            citizens = vaccineDao.readCitizensFromFile(reader);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
        citizens = vaccineDao.insertCitizens(citizens);
        System.out.println(citizens.size() + " records inserted");
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


        MenuController menuController = new MenuController(dataSource);
        Scanner sc = new Scanner(System.in);
        menuController.printMenu();
        String select;
        while (!"0".equals(select = sc.nextLine())) {
            switch (select) {
                case "1" -> System.out.println("1. Regisztráció");
                case "2" -> menuController.massRegistration();
                case "3" -> System.out.println("3. Generálás");
                case "4" -> System.out.println("4. Oltás");
                case "5" -> System.out.println("5. Oltás meghiúsulás");
                default -> System.out.println("Hibás választás");
            }
            System.out.println("Press ENTER to continue");
            sc.nextLine();
            menuController.printMenu();
        }

    }

}
