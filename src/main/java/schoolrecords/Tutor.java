package schoolrecords;

import filescanner.library.Library;

import java.util.ArrayList;
import java.util.List;

public class Tutor {
    private String name;
    private List<Subject> taughtSubject = new ArrayList<>();

    public Tutor(String name, List<Subject> taughtSubject) {
        if (taughtSubject == null || isEmpty(name)) {
            throw new NullPointerException("Tutor name and subject list not must be empty");
        }
        else
        {
            this.name = name;
            this.taughtSubject = taughtSubject;
        }
    }

    private boolean isEmpty(String data) {
        return (data == null || data.length() == 0);
    }

    public boolean tutorTeachingSubject(Subject targetSubject) {
        if (taughtSubject == null) {
            throw new NullPointerException("Object not must be empty");
        }
        else {
            for (Subject subject : taughtSubject) {
                if (subject.getSubjectName().equals(targetSubject.getSubjectName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
