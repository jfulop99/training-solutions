package week13.d03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SchoolTest {

    private School school;

    @BeforeEach
    void setUp() {

        school = new School();

        school.readDataFromFile(new BufferedReader(new InputStreamReader(School.class.getResourceAsStream("beosztas.txt"))));

    }

    @Test
    void getTutors() {

        System.out.println(school.getTutors().size());

        assertEquals(49, school.getTutors().size());

        assertEquals("biologia", school.getTutors().get("Kaffer Kada").get(2).getName());

    }

    @Test
    void readDataFromFile() {

        System.out.println(school.getTutors().size());

        assertEquals(49, school.getTutors().size());

        assertEquals("biologia", school.getTutors().get("Kaffer Kada").get(2).getName());

    }

    @Test
    void getTeachingHoursPerWeek() {

        School school = new School();

        school.readDataFromFile(new BufferedReader(new InputStreamReader(School.class.getResourceAsStream("beosztas.txt"))));

        int result = school.getTeachingHoursPerWeek("Kaffer Kada");

        System.out.println(result);

        assertEquals(23, result);


    }

}