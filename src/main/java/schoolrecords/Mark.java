package schoolrecords;

public class Mark {
    private MarkType markType;
    private Subject subject;
    private Tutor tutor;

    public Mark(MarkType markType, Subject subject, Tutor tutor) {
        if (subject == null || tutor == null) {
            throw new NullPointerException("Both subject and tutor must be provided!");
        }
        else {
            this.markType = markType;
            this.subject = subject;
            this.tutor = tutor;
        }
    }

    @Override
    public String toString() {
        return String.format("%s(%d)", markType.getDescription(), markType.getValue());
    }

    public MarkType getMarkType() {
        return markType;
    }

    public Subject getSubject() {
        return subject;
    }

    public Tutor getTutor() {
        return tutor;
    }
}
