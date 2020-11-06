package week02;

import java.util.Scanner;

public class Controller {
    private Office office;
    private Scanner scanner = new Scanner(System.in);

    public void readOffice(){
        office = new Office();
        System.out.println("Number of meeting rooms: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        String name;
        int length;
        int width;
        for (int i = 0; i < number; i++){
            System.out.println("Name of the " + (i+1) + ". meeting room:");
            name = scanner.nextLine();
            System.out.println("Length of " + name + " meeting room:");
            length = scanner.nextInt();
            System.out.println("Width of " + name + " meeting room:");
            width = scanner.nextInt();
            scanner.nextLine();
            office.addMeetingRoom(new MeetingRoom(name, length, width));
        }

    }

    public void printMenu(){
        System.out.println( "1. Tárgyalók sorrendben \n\r" +
                            "2. Tárgyalók visszafele sorrendben\n\r" +
                            "3. Minden második tárgyaló\n\r" +
                            "4. Területek\n\r" +
                            "5. Keresés pontos név alapján\n\r" +
                            "6. Keresés névtöredék alapján\n\r" +
                            "7. Keresés terület alapján\n\r");
    }

    public void runMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select (1-7)");
        int selection = scanner.nextInt();
        scanner.nextLine();
        if (selection == 1) {
            office.printNames();
            return;
        }
        if (selection == 2){
            office.printNamesReverse();
            return;
        }
        if (selection == 3) {
            office.printEvenNames();
            return;
        }
        if (selection == 4) {
            office.printAreas();
            return;
        }
        if (selection == 5) {
            System.out.println("Name of meetingroom:");
            office.printMeetingRoomsWithName(scanner.nextLine());
            return;
        }
        if (selection == 6) {
            System.out.println("Part of the name:");
            office.printMeetingRoomsContains(scanner.nextLine());
            return;
        }
        if (selection == 7) {
            System.out.println("Minimum area:");
            office.printAreasLargerThan(scanner.nextInt());
            scanner.nextLine();
            return;
        }

/* Töröltem, mert még nem tanultuk
        switch (selection){
            case 1:
                office.printNames();
                break;
            case 2:
                office.printNamesReverse();
                break;
            case 3:
                office.printEvenNames();
                break;
            case 4:
                office.printAreas();
                break;
            case 5:
                System.out.println("Name of meetingroom:");
                office.printMeetingRoomsWithName(scanner.nextLine());
                break;
            case 6:
                System.out.println("Part of the name:");
                office.printMeetingRoomsContains(scanner.nextLine());
                break;
            case 7:
                System.out.println("Minimum area:");
                office.printAreasLargerThan(scanner.nextInt());
                scanner.nextLine();
        }

 */
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);

        controller.readOffice();
        String read = "";
        while ( !read.toUpperCase().equals("EXIT")) {
            controller.printMenu();
            controller.runMenu();
            System.out.println("Press ENTER to continue... ( Exit = Exit )");
            read = scanner.nextLine();
        }
    }
}
