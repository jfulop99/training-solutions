package week13.d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class School {


    private Map<String, List<Lesson>> tutors;

    public School() {

        tutors = new HashMap<>();

    }

    public Map<String, List<Lesson>> getTutors() {
        return new HashMap<>(tutors);
    }


    public void readDataFromFile(BufferedReader reader) {

        try (reader){
            readTutorFromFile(reader);
        } catch (IOException | NullPointerException e) {
            throw new IllegalStateException("Cannot find/read file", e);
        }

    }

    private void readTutorFromFile(BufferedReader reader) throws IOException {

        String tutor;
        while ((tutor = reader.readLine()) != null) {
            if (!tutors.containsKey(tutor)) {
                tutors.put(tutor, new ArrayList<>());
            }
            tutors.get(tutor).add(createLessonFromFile(reader));
        }
    }

    private Lesson createLessonFromFile(BufferedReader reader) throws IOException {
        String name = reader.readLine();
        String className = reader.readLine();
        int hours = Integer.parseInt(reader.readLine());
        return new Lesson(name, className, hours);
    }

    public int getTeachingHoursPerWeek(String tutor) {

        List<Lesson> lessons = tutors.get(tutor);

        return lessons.stream().mapToInt(Lesson::getHours).sum();

    }
}

