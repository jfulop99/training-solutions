package schoolrecords;

import java.awt.image.Kernel;
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
                                new Tutor("Kovács Béla", Arrays.asList(new Subject("magyar irodalom"), new Subject("történelm"))),
                                new Tutor("Kissné Kovács Etelka", Arrays.asList(new Subject("testnevelés"), new Subject("angol"), new Subject("fizika"))),
                                new Tutor("Nagy Aranka", Arrays.asList(new Subject("matematika"))));
    }

    public void repetition() {
        String message = "";
        Student victim = null;
        System.out.println("Feleltetés:\n\r");

        try {
            victim = firstClass.repetition();
        }catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        if (victim != null) {
            System.out.println("Az áldozat: " + victim.getName() + "\n\r");

            int selectedTutor = selectTutor();

            int selectedSubject = selectSubject(selectedTutor);

            String selectedMark = selectMark();

            victim.grading(new Mark(MarkType.valueOf(selectedMark) , new Subject(subjectNames.get(selectedSubject)), tutors.get(selectedTutor)));
            System.out.println("Sikeres rögzítés");
        }
        return;
    }

    public int selectTutor() {

        Scanner sc = new Scanner(System.in);
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
                sc.nextLine();
            }
            if (tutorIndex < 1 || tutorIndex > maxIndex) {
                tutorIndex = 0;
            }
        }
        tutorIndex--;
        return tutorIndex;
    }

    public int selectSubject(int tutorIndex) {

        Scanner sc = new Scanner(System.in);
        int subjectIndex = 0;
        for (String subjectName:subjectNames) {
            if (tutors.get(tutorIndex).tutorTeachingSubject(new Subject(subjectName))) {
                System.out.println(subjectIndex + 1 + ". " + subjectName);
                subjectIndex++;
            }
        }
        System.out.println("Select subject 1 - " + subjectIndex);
        int maxIndex = subjectIndex;
        subjectIndex = 0;
        while (subjectIndex == 0) {
            try {
                subjectIndex = sc.nextInt();
            }catch (InputMismatchException e) {
                subjectIndex = 0;
                sc.nextLine();
            }
            if (subjectIndex < 1 || subjectIndex > maxIndex) {
                subjectIndex = 0;
            }
        }
        subjectIndex--;
        return subjectIndex;
    }

    public String selectMark() {

        Scanner sc = new Scanner(System.in);
        int markIndex = 0;
        for (MarkType mark: MarkType.values()) {
            System.out.println(String.format("%1s - ( %1d ) %-15s",MarkType.values()[markIndex], mark.getValue(), mark.getDescription()));
            markIndex++;
        }
        String mark = "";
        System.out.print("Select mark ( ");
        for (MarkType item:MarkType.values()) {
            System.out.print(item + " ");
        }
        System.out.println(")");
        while (mark.equals("")) {
            mark = sc.nextLine();
            mark = mark.toUpperCase();
            switch (mark) {
                case "A":
                case "B":
                case "C":
                case "D":
                case "F":
                    break;
                default:
                    mark = "";
            }
        }
        return mark;
    }

    public Student selectStudent() {

        int studentIndex = 0;
        String studentNames = null;
        Student studentItem = null;
        try {
            studentNames = firstClass.listStudentNames();
        }catch (StringIndexOutOfBoundsException e) {
            System.out.println("No student in the class " + e.getMessage());
        }
        if (studentNames != null) {
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
                    sc.nextLine();
                    studentIndex = 0;
                }
                if (studentIndex < 1 || studentIndex > maxIndex) {
                    studentIndex = 0;
                }
            }
            studentIndex--;
            studentItem = firstClass.findStudentByName(students.get(studentIndex));
        }
        return studentItem;
    }

    public void averageByStudent(boolean subj) {

        Student selectedStudent = selectStudent();
        if (selectedStudent != null) {
            if (!subj) {
                try {
                    System.out.println(String.format("Student: %-20s - Average: %4.2f", selectedStudent.getName(), selectedStudent.calculateAverage()));
                } catch (ArithmeticException e) {
                    System.out.println(String.format("Student: %-20s - %s", selectedStudent.getName(), e.getMessage()));
                }
            } else {
                System.out.println(selectedStudent.getName() + " : Average by subjects:");
                for (String subjectname : subjectNames) {
                    try {
                        System.out.println(String.format("Subject: %-20s - Average: %4.2f", subjectname, selectedStudent.calculateSubjectAverage(new Subject(subjectname))));
                    } catch (ArithmeticException e) {
                        System.out.println(String.format("Subject: %-20s - %30s", subjectname, e.getMessage()));
                    }
                }
            }
        }
    }

    public void printStudentAverage() {
        List<StudyResultByName> studyResultByNames = new ArrayList<>();
        studyResultByNames = firstClass.listStudyResults();
        if (studyResultByNames.size() > 0) {
            for (StudyResultByName item : studyResultByNames) {
                System.out.println(String.format("%-20s - Average: %4.2f", item.getStudentName(), item.getStudyAverage()));
            }
        }
        else {
            System.out.println("No student in the class ");
        }
    }

    public void printClassAverageBySubject() {
        for (String subjectname: subjectNames) {
            try {
                System.out.println(String.format("Subject: %20s - Average: %4.2f", subjectname, firstClass.calculateClassAverageBySubject(new Subject(subjectname))));
            }catch (ArithmeticException e) {
                System.out.println(String.format("Subject: %20s - %30s", subjectname, e.getMessage()));
            }
        }
    }

    public void printClassAverage() {
        try {
            System.out.println("Az ostály átlaga: " + firstClass.calculateClassAverage());
        }catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printStudents() {
        try {
            System.out.println(firstClass.listStudentNames());
        }catch (StringIndexOutOfBoundsException e) {
            System.out.println("No student in the class " + e.getMessage());
        }
    }

    public void findStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add meg a keresendő diák nevét!");
        try {
            System.out.println(firstClass.findStudentByName(scanner.nextLine()).toString());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addNewStudent() {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Add meg az új diák nevét!");
        try {
            String studentName = scanner.nextLine();


            System.out.println(firstClass.addStudent(new Student(studentName)) ? "Sikeres rögzítés" : "Van már ilyen nevű diák!");
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add meg a törlendő diák nevét!");
        try {
            System.out.println(firstClass.removeStudent(firstClass.findStudentByName(scanner.nextLine())) ? "Sikeres ": "SIKERTELEN " +  "törlés!");
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }catch (IllegalStateException e) {
            System.out.println(e.getMessage());
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
                            "10. Diák tantárgyakhoz tartozó átlagának kiírása\n\r" +
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
                select = 12;
            }
            switch (select) {
                case 1:     //Diákok nevének listázása
                    schoolRecordsController.printStudents();
                    break;
                case 2:     //Diák név alapján keresése
                    schoolRecordsController.findStudent();
                    break;
                case 3:     //Diák létrehozása
                    schoolRecordsController.addNewStudent();
                    break;
                case 4:     //Diák név alapján törlése
                    schoolRecordsController.removeStudent();
                    break;
                case 5:     //Diák feleltetése
                    schoolRecordsController.repetition();
                    break;
                case 6:     //Osztályátlag kiszámolása
                    schoolRecordsController.printClassAverage();
                    break;
                case 7:     //Tantárgyi átlag kiszámolása
                    schoolRecordsController.printClassAverageBySubject();
                    break;
                case 8:     //Diákok átlagának megjelenítése
                    schoolRecordsController.printStudentAverage();
                    break;
                case 9:     //Diák átlagának kiírása
                    schoolRecordsController.averageByStudent(false);
                    break;
                case 10:    //Diák tantárgyakhoz tartozó átlagának kiírása
                    schoolRecordsController.averageByStudent(true);
                    break;
                case 11:    //Exit
                    run = false;
                    break;
                default:
                    System.out.println("Hibás választás!");
            }
            if (select != 11) {
                System.out.println("Press ENTER to continue.");
                scanner.nextLine();
            }
        }
    }
}
