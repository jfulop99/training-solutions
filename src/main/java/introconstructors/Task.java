package introconstructors;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private String title;
    private String description;
    private LocalDateTime startDateTime;
    private LocalTime duration;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public void start(){
        startDateTime = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public static void main(String[] args) {
        Task task = new Task("Projektmunka", "A kiadott projektmunka elkészítése");

        task.start();
        task.setDuration(LocalTime.parse("02:30"));
        System.out.println(task.getTitle() + " - " + task.getDescription() + " Start: " + task.getStartDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " Duration: " + task.getDuration());

    }
}
