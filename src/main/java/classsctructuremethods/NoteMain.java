package classsctructuremethods;

import java.util.Scanner;

public class NoteMain {
    public static void main(String[] args) {
        Note note = new Note();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        note.setName(scanner.nextLine());
        System.out.println("Topic:");
        note.setTopic(scanner.nextLine());
        System.out.println("Text:");
        note.setText(scanner.nextLine());
        System.out.println(note.getNoteText());
    }
}
