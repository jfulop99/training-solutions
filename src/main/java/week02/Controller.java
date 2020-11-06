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
            System.out.println("Length of the " + (i+1) + ". meeting room:");
            length = scanner.nextInt();
            System.out.println("Width of the " + (i+1) + ". meeting room:");
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
                            "7. Keresés terület alapján");
    }

    public static void main(String[] args) {
        Controller controller = new Controller();

        controller.printMenu();
        controller.readOffice();
    }
}
