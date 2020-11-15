package schoolrecords;

public class Subject {
    private String subjectName;

    public Subject(String subjectName) {
        if (!isEmpty(subjectName)) {
            this.subjectName = subjectName;
        }
        else {
            throw new IllegalArgumentException("Subject name must not be empty");
        }
    }

    private boolean isEmpty(String data) {
        return (data == null || data.length() == 0);
    }

    public boolean equals(Subject subject) {
        return subjectName.equals(subject.getSubjectName());
    }

    public String getSubjectName() {
        return subjectName;
    }
}
