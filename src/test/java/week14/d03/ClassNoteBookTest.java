package week14.d03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {

    private List<Student> studentList;
    private Student s1;
    private Student s2;
    private Student s3;
    private Student s4;
    private Student s5;
    private ClassNoteBook cn;

    @BeforeEach
    void setUp() {
        s1 = new Student("Alma");
        s2 = new Student("É");
        s3 = new Student("C");
        s4 = new Student("Ábel");
        s5 = new Student("E");

        s1.addMark("matematika", 2);
        s1.addMark("matematika", 3);
        s1.addMark("magyar", 5);
        s1.addMark("biológia", 4);

        s2.addMark("matematika", 1);
        s2.addMark("matematika", 2);
        s2.addMark("magyar", 3);
        s2.addMark("biológia", 5);

        studentList = new ArrayList<>(Arrays.asList(s3,s2,s1,s5,s4));

        cn = new ClassNoteBook(studentList);
    }

    @Test
    void getStudentList() {
        System.out.printf(cn.getStudentList().toString());

        assertEquals( 5 , cn.getStudentList().size());

        assertEquals("É", cn.getStudentList().get(1).getName());
    }

    @Test
    void sortNotebook() {
        System.out.println(cn.sortNotebook());
        assertEquals( 5 , cn.getStudentList().size());

        assertEquals("É", cn.sortNotebook().get(4).getName());
    }
}