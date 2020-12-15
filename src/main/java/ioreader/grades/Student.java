package ioreader.grades;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private List<Integer> gradeList;

    public Student(String name, List<Integer> gradeList) {
        this.name = name;
        this.gradeList = new ArrayList<>(gradeList);
    }

    public double average() {
        double sum = 0.0;
        for (Integer grade: gradeList) {
            sum += grade.doubleValue();
        }
        return sum / gradeList.size();
    }

    public boolean isIncreasing() {
        int reference = 0;
        for (Integer grade: gradeList) {
            if (grade.intValue() < reference) {
                return false;
            }
            reference = grade.intValue();
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGradeList() {
        return new ArrayList<>(gradeList);
    }
}
