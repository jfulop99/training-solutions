package week14.d03;

import java.text.Collator;
import java.util.*;

public class Student implements Comparable<Student>{

    private String name;

    private Map<String, List<Integer>> marks;


    public Student(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;

        Collator collator = Collator.getInstance(new Locale("hu", "HU"));
        marks = new TreeMap<>(collator);
    }

    public String getName() {
        return name;
    }

    public Map<String, List<Integer>> getMarks() {
        return marks;
    }

    public void addMark(String subject, int mark) {

        if (!marks.containsKey(subject)) {
            marks.put(subject, new ArrayList<>());
        }
        marks.get(subject).add(mark);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }


    @Override
    public int compareTo(Student o) {
        Collator collator = Collator.getInstance(new Locale("hu", "HU"));
        return collator.compare(this.name, o.getName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
