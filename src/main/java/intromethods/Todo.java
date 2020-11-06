package intromethods;

public class Todo {
    private String caption;
    private boolean finished;

    public Todo(String caption) {
        this.caption = caption;
    }

    public void finish(){
        finished = true;
    }

    @Override
    public String toString() {
        return caption + "(" + finished + ")";
    }

    public String getCaption() {
        return caption;
    }

    public boolean isFinished() {
        return finished;
    }
}
