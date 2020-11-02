package introcontrol;

import java.util.Scanner;

public class BoatRental {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleCount;
        int rest;
        int boatPeopleCount;
        int boatCount;
        while (true) {

            System.out.println("Írd be a csoport létszámát");
            peopleCount = scanner.nextInt();
            boatPeopleCount = 10;
            boatCount = 3;

            if (peopleCount == 0) {
                break;
            }
            if (peopleCount >= 5) {
                System.out.println("Elvitték az 5 személyes csónakot.");
                peopleCount -= 5;
                boatPeopleCount -= 5;
                boatCount--;
            }
            if (peopleCount >= 3) {
                System.out.println("Elvitték a 3 személyes csónakot.");
                peopleCount -= 3;
                boatPeopleCount -=3;
                boatCount--;
            }
            if (peopleCount >= 2) {
                System.out.println("Elvitték a 2 személyes csónakot.");
                peopleCount -= 2;
                boatPeopleCount -=2;
                boatCount--;
            }
            if ((peopleCount == 1) && (boatPeopleCount > 0)) {
                System.out.println("Elvitték a 2 személyes csónakot.");
                peopleCount--;
                boatPeopleCount -=2;
                boatCount--;
            }
            if (peopleCount > 0) {
                System.out.println("Még " + peopleCount + " fő maradt a parton.");
            }
            if (boatPeopleCount > 0) {
                System.out.println("Még " + boatPeopleCount + " fő mehet utánuk " + boatCount + " csónakkal.");
            }
        }

    }
}
