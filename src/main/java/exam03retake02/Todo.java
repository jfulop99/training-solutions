package exam03retake02;

public class Todo {

    private String text;

    private State state;

    private int priority;

    public Todo(String text, int priority) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Cannot be null");
        }
        this.text = text;
        if (priority < 1 || priority > 5) {
            throw new IllegalArgumentException("Must be between 1 - 5");
        }
        this.priority = priority;

        this.state = State.NON_COMPLETED;
    }

    public void complete() {
        this.state = State.COMPLETED;
    }

    public String getText() {
        return text;
    }

    public State getState() {
        return state;
    }

    public int getPriority() {
        return priority;
    }
}
