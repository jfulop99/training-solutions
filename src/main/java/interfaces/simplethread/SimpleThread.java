package interfaces.simplethread;

import java.util.List;

public class SimpleThread implements Runnable{

    private List<String> tasks;

    public SimpleThread(List<String> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (nextStep()) {
        }
    }

    private boolean nextStep() {
        if (tasks.size() == 0) {
            return false;
        }
        String task;
        task = tasks.remove(tasks.size() - 1);
        return true;
    }

    public List<String> getTasks() {
        return tasks;
    }
}
