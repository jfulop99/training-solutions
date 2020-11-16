package schoolrecords;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.*;

public class SchoolRecordsController {
    private ClassRecords firstClass;
    private List<Subject> subjects = new ArrayList<>();

    private List<Tutor> tutors;


    private List<String> subjectNames = Arrays.asList("matematika", "biológia", "fizika", "magyar irodalom", "testnevelés", "angol", "földrajz", "történelem");


    public SchoolRecordsController(ClassRecords firstClass) {
        this.firstClass = firstClass;
    }

    public void initSchool() {
        for (String subjectname:subjectNames) {
            subjects.add(new Subject(subjectname));
        }
        tutors = Arrays.asList( new Tutor("Kiss Géza", Arrays.asList(new Subject("földrajz"), new Subject("biológia"))),
                                new Tutor("Nagy Aranka", Arrays.asList(new Subject("matematika"))));
    }
    public String removeStudent(String name) {
        String message;
        try {
            message =firstClass.removeStudent(firstClass.findStudentByName(name)) ? "Sikeres ": "SIKERTELEN ";
            message += "törlés!";
        }catch (IllegalArgumentException e) {
            message = e.getMessage();
        }catch (IllegalStateException e) {
            message = e.getMessage();
        }
        return message;
    }

    public String addStudent(String name) {
        String message;
        try {
            message = firstClass.addStudent(new Student(name)) ? "Sikeres rögzítés" : "Van már ilyen nevű diák!";
        }catch (IllegalArgumentException e) {
            message = e.getMessage();
        }
        return message;
    }

    public String findStudent(String name) {
        String message;
        try {
            message = firstClass.findStudentByName(name).toString();
        }catch (IllegalArgumentException e){
            message = e.getMessage();
        }catch (IllegalStateException e) {
            message = e.getMessage();
        }

        return message;
    }

    public String repetition() {
        String message = "";
        Student victim = null;
        Scanner sc = new Scanner(System.in);
        try {
            victim = firstClass.repetition();
        }catch (IllegalStateException e) {
            message = e.getMessage();
        }
        if (victim != null) {
            System.out.println("Az áldozat: " + victim.getName());
            int tutorIndex = 0;
            for (Tutor tutor:tutors) {
                System.out.println(tutorIndex+1 + ". " + tutor.getName());
                tutorIndex++;
            }
            System.out.println("Select tutor 1 - " + tutorIndex);
            int maxIndex = tutorIndex;
            tutorIndex = 0;
            while (tutorIndex == 0) {
                try {
                    tutorIndex = sc.nextInt();
                } catch (InputMismatchException e) {
                    tutorIndex = 0;
                }
                if (tutorIndex < 1 || tutorIndex > maxIndex) {
                    tutorIndex = 0;
                }
            }
            tutorIndex--;

            int subjectIndex = 0;
            for (String subjectName:subjectNames) {
                if (tutors.get(tutorIndex).tutorTeachingSubject(new Subject(subjectName))) {
                    System.out.println(subjectIndex + 1 + ". " + subjectName);
                    subjectIndex++;
                }
            }
            System.out.println("Select subject 1 - " + subjectIndex);
            maxIndex = subjectIndex;
            subjectIndex = 0;
            while (subjectIndex == 0) {
                try {
                    subjectIndex = sc.nextInt();
                }catch (InputMismatchException e) {
                    subjectIndex = 0;
                }
                if (subjectIndex < 1 || subjectIndex > maxIndex) {
                    subjectIndex = 0;
                }
            }
            subjectIndex--;
            int markIndex = 0;
            for (MarkType mark: MarkType.values()) {
                System.out.println((char)(65+markIndex) + " " + mark.getDescription() + " " + mark.getValue());
                markIndex++;
            }
            String mark = "";
            System.out.println("Select mark A - E");
            while (mark.equals("")) {
                mark = sc.nextLine();
                mark = mark.toUpperCase();
                switch (mark) {
                    case "A":
                    case "B":
                    case "C":
                    case "D":
                    case "E":
                        break;
                    default:
                        mark = "";
                }
            }
            victim.grading(new Mark(MarkType.valueOf(mark) , new Subject(subjectNames.get(subjectIndex)), tutors.get(tutorIndex)));
            message = "Sikeres rögzítés";
        }

        return message;
    }

    public String calculateClassAverage() {
        String message = "";
        try {
            message = "Az ostály átlaga: " + firstClass.calculateClassAverage();
        }catch (ArithmeticException e) {
            message = e.getMessage();
        }
        return message;
    }

    public void averageByStudents() {
        String studentNames = firstClass.listStudentNames();
        Scanner sc = new Scanner(studentNames).useDelimiter(", ");
        while (sc.hasNext()) {
            Student studentItem = firstClass.findStudentByName(sc.next());
            try {
                System.out.println(String.format("Student: %20s - Average: %4.2f",studentItem.getName(), studentItem.calculateAverage()));
            }catch (ArithmeticException e) {
                System.out.println(String.format("Student: %20s - %s",studentItem.getName(),e.getMessage()));
            }
        }
    }

    public void averageBySubject() {
        for (String subjectname: subjectNames) {
            try {
                System.out.println(String.format("Subject: %20s - Average: %4.2f", subjectname, firstClass.calculateClassAverageBySubject(new Subject(subjectname))));
            }catch (ArithmeticException e) {
                System.out.println(String.format("Subject: %20s - %30s", subjectname, e.getMessage()));
            }
        }
    }

    public void averageByStudent(boolean subj) {
        int studentIndex = 0;
        String studentNames = firstClass.listStudentNames();
        try {
            firstClass.findStudentByName("Test");
        }catch (IllegalArgumentException e) {
            // Csak elkapás
        }
        List<String> students = new ArrayList<>();
        Scanner sc = new Scanner(studentNames).useDelimiter(", ");
        while (sc.hasNext()) {
            students.add(sc.next());
            System.out.println(studentIndex + 1 + ". " + students.get(studentIndex));
            studentIndex++;
        }
        System.out.println("Select student: 1 - " + (studentIndex));
        sc.close();
        sc = new Scanner(System.in);
        int maxIndex = studentIndex;
        studentIndex = 0;
        while (studentIndex == 0) {
            try {
                studentIndex = sc.nextInt();
            } catch (InputMismatchException e) {
                studentIndex = 0;
            }
            if (studentIndex < 1 || studentIndex > maxIndex) {
                studentIndex = 0;
            }
        }
        studentIndex--;
        Student studentItem = firstClass.findStudentByName(students.get(studentIndex));
        if (!subj) {
            try {
                System.out.println(String.format("Student: %20s - Average: %4.2f", studentItem.getName(), studentItem.calculateAverage()));
            } catch (ArithmeticException e) {
                System.out.println(String.format("Student: %20s - %s", studentItem.getName(), e.getMessage()));
            }
        }
        else {
            System.out.println(studentItem.getName() + " : Average by subjects:");
            for (String subjectname: subjectNames) {
                try {
                    System.out.println(String.format("Subject: %20s - Average: %4.2f", subjectname, studentItem.calculateSubjectAverage(new Subject(subjectname))));
                }catch (ArithmeticException e) {
                    System.out.println(String.format("Subject: %20s - %30s", subjectname, e.getMessage()));
                }
            }
        }
    }

    public void printMenu() {
        System.out.println( " 1. Diákok nevének listázása\n\r" +
                            " 2. Diák név alapján keresése\n\r" +
                            " 3. Diák létrehozása \n\r" +
                            " 4. Diák név alapján törlése\n\r" +
                            " 5. Diák feleltetése \n\r" +
                            " 6. Osztályátlag kiszámolása\n\r" +
                            " 7. Tantárgyi átlag kiszámolása\n\r" +
                            " 8. Diákok átlagának megjelenítése\n\r" +
                            " 9. Diák átlagának kiírása\n\r" +
                            "10. Diák tantárgyhoz tartozó átlagának kiírása\n\r" +
                            "11. Kilépés");
    }

    public static void main(String[] args) {
        SchoolRecordsController schoolRecordsController = new SchoolRecordsController(new ClassRecords("First Class", new Random()));

        schoolRecordsController.initSchool();

        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        while (run) {
            schoolRecordsController.printMenu();
            int select = 0;
            try {
                select = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Hibás adat! " + e.getMessage());
                continue;
            }
            switch (select) {
                case 1:
                    System.out.println(schoolRecordsController.firstClass.listStudentNames());
                    break;
                case 2:
                    System.out.println("Add meg a keresendő diák nevét!");
                    System.out.println(schoolRecordsController.findStudent(scanner.nextLine()));
                    break;
                case 3:
                    System.out.println("Add meg az új diák nevét!");
                    System.out.println(schoolRecordsController.addStudent(scanner.nextLine()));
                    break;
                case 4:
                    System.out.println("Add meg a törlendő diák nevét!");
                    System.out.println(schoolRecordsController.removeStudent(scanner.nextLine()));
                    break;
                case 5:
                    System.out.println("Feleltetés");
                    System.out.println(schoolRecordsController.repetition());
                    break;
                case 6:
                    System.out.println(schoolRecordsController.calculateClassAverage());
                    break;
                case 7:
                    schoolRecordsController.averageBySubject();
                    break;
                case 8:
                    try {
                        schoolRecordsController.averageByStudents();
                    }catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    try {
                        schoolRecordsController.averageByStudent(false);
                    }catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 10:
                    try {
                        schoolRecordsController.averageByStudent(true);
                    }catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 11:
                    run = false;
                    break;
            }
            if (select != 11) {
                System.out.println("Press ENTER to continue.");
                scanner.nextLine();
            }
        }


    }
}
