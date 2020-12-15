package ioreader.grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {

    private List<Student> students;

    public SchoolRecordsManager() {
        this.students = new ArrayList<>();
    }

    public void readGradesFromFile(String fileName) {

        Path path = Path.of(fileName);

        try (BufferedReader reader = Files.newBufferedReader(path)){
            String line = null;
            while ((line = reader.readLine()) != null) {
                recordParser(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
    }

    private void recordParser(String line) {
        String[] parts = line.split(" ");
        String name = parts[0];
        List<Integer> grades = new ArrayList<>();
        for (String part: parts) {
            if (part.length() < 3) {
                grades.add(Integer.parseInt(part));
            }
        }
        students.add(new Student(name, grades));
    }

    public List<Student> getStudents() {
        return students;
    }

    public double classAverage() {

        double sum = 0.0;
        for (Student student:students) {
            sum += student.average();
        }
        return sum / students.size();
    }
}
