package schoolrecords;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class ClassRecords {
    private String className;
    private Random rnd;
    private List<Student> students = new ArrayList<>();

    public boolean addStudent(Student student) {
        if (student == null) {
            throw new NullPointerException("Nullp");
        }
        else {
            for (Student studentItem:students) {
                if (student.equals(studentItem)) {
                    return false;
                }
            }
            students.add(student);
        }
        return true;
    }

    public boolean removeStudent(Student student) {
        if (student == null) {
            throw new NullPointerException("Nullp");
        }
        else {
            int index = 0;
            for (Student studentItem:students) {
                if (student.equals(studentItem)) {
                    students.remove(index);
                    return true;
                }
                index++;
            }
        }
        return false;
    }

    public double calculateClassAverage() {
        double sum = 0.0D;
        int counter = 0;
        for (Student studentItem:students) {
            sum += studentItem.calculateAverage();
            counter++;
            if (sum == 0) {
                throw new ArithmeticException("No marks present, average calculation aborted!");
            }
        }
        if (counter == 0) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        return Math.round((sum / counter) * 100.0) / 100.0;
    }

    public String getClassName() {
        return className;
    }

    public double calculateClassAverageBySubject(Subject subject) {
        double sum = 0.0D;
        int counter = 0;
        double studentAverage = 0.0D;
        for (Student studentItem:students) {
                studentAverage = studentItem.calculateSubjectAverage(subject);
                sum += studentAverage;
                if (studentAverage != 0) {
                    counter++;
                }
//                if (sum == 0) {
//                    throw new ArithmeticException("No marks present, average calculation aborted!");
//                }
        }
        if (counter == 0) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        return Math.round((sum / counter) * 100.0) / 100.0;
    }

    public Student findStudentByName(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        if (students.size() == 0) {
            throw new IllegalStateException("No students to search!");
        }
        Student foundItem = null;
        for (Student studentItem : students) {
            if (name.equals(studentItem.getName())) {
                foundItem = studentItem;
            }
        }
        if (foundItem == null)
            {
                throw new IllegalArgumentException("Student by this name cannot be found! "+name);
            }
        return foundItem;
    }

    public String listStudentNames() {
        String message = null;
        StringBuilder studentName = new StringBuilder();
        studentName.append("");
        for (Student studentItem:students) {
            studentName.append(studentItem.getName() + ", ");
        }
        studentName.setLength(studentName.length()-2);
        message = studentName.toString().trim();
        return message;
    }

    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> studyResultByNames = new ArrayList<>();
        for (Student studentItem:students) {
            studyResultByNames.add(new StudyResultByName(studentItem.calculateAverage(), studentItem.getName()));
        }
        return studyResultByNames;
    }

    public Student repetition() {
        if (students.size() == 0) {
            throw new IllegalStateException("No students to select for repetition!");
        }
        return students.get(rnd.nextInt(students.size()));
    }

    public ClassRecords(String className, Random rnd) {
        if (isEmpty(className)) {
            throw new IllegalArgumentException("");
        }
        else {
            this.className = className;
            this.rnd = rnd;
        }
    }

    private boolean isEmpty(String data) {
        return (data == null || data.trim().length() == 0);
    }

}
