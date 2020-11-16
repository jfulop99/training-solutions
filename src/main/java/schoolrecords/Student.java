package schoolrecords;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Student {
    private List<Mark> marks = new ArrayList<>();
    private String name;

    public Student(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        else {
            this.name = name;
        }
    }

    public double calculateAverage() {
        int sum = 0;
        int counter = 0;
        for (Mark mark:marks) {
            sum += mark.getMarkType().getValue();
            counter++;
        }
//        if (counter == 0) {
//            throw new ArithmeticException("No marks present, average calculation aborted!");
//        }
        return Math.round(((double)sum / counter) * 100) / 100.0;
    }

    public double calculateSubjectAverage(Subject subject) {
        int sum = 0;
        int counter = 0;
        for (Mark mark:marks) {
            if (mark.getSubject().equals(subject)) {
                sum += mark.getMarkType().getValue();
                counter++;
            }
        }
//        if (counter == 0) {
//            throw new ArithmeticException("No marks present, average calculation aborted!");
//        }
        return Math.round(((double)sum / counter) * 100) / 100.0;
    }

    public boolean equals(Student student) {
        return name.equals(student.getName());
    }

    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        else {
            marks.add(mark);
        }
    }

    @Override
    public String toString() {
        StringBuilder marksString = new StringBuilder();
        for (Mark mark:marks) {
            marksString.append(mark.getSubject().getSubjectName());
            marksString.append(": ");
            marksString.append(mark.toString());
            marksString.append(" ");

        }
        return String.format("%s marks: %s", name, marksString.toString().trim());
    }

    public String getName() {
        return name;
    }

    private boolean isEmpty(String data) {
        return (data == null || data.length() == 0);
    }

}
