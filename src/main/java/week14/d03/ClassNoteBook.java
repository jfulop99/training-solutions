package week14.d03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClassNoteBook {

    private List<Student> studentList;

    public ClassNoteBook(List<Student> studentList) {
        this.studentList = new ArrayList<>(studentList);
    }

    public List<Student> getStudentList() {
        return new ArrayList<>(studentList);
    }

    public List<Student> sortNotebook() {

        List<Student> result = new ArrayList<>(studentList);


        result.sort(Comparator.naturalOrder());

        return result;
    }
}
