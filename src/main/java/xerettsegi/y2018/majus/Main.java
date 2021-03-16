package xerettsegi.y2018.majus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        LoungeService loungeService = new LoungeService();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(LoungeService.class.getResourceAsStream("/erettsegi/2018/majus/4_Tarsalgo/ajto.txt")))) {
            loungeService.readDataFromFile(reader);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

        System.out.println("2. feladat");
        System.out.println("Az első belépő: " + loungeService.getFirstIn());
        System.out.println("Az utolsó kilépő: " + loungeService.getLastOut());
        System.out.println("3. feladat");
        loungeService.writeMovingNumbersToFile();
        System.out.println("athaladas.txt kész");
        System.out.println("4. feladat");
        System.out.print("A végén a társalgóban voltak: ");
        for (Integer item : loungeService.getLastInList()) {
            System.out.printf("%d ", item);
        }
        System.out.println("");
        System.out.println("5. feladat");
        System.out.printf("Például %tH:%<tM-kor voltak a legtöbben a társalgóban.%n", loungeService.getMaxInTime());
        System.out.println("6. feladat");
        System.out.print("Adja meg a személy azonosítóját! ");
        int person = new Scanner(System.in).nextInt();
        System.out.println("7. feladat");
        System.out.println(loungeService.getStayingListById(person));
        System.out.println("8. feladat");
        Result result = loungeService.getStayingTimeById(person);
        System.out.printf("A(z) %d. személy összesen %d percet volt bent, a megfigyelés \nvégén %s",
                person, result.getMinutes(), result.isIn() ? "a társalgóban volt." : "nem volt a társalgóban.");

    }
}
