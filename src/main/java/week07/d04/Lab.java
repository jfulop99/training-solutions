package week07.d04;

import java.time.LocalDate;

public class Lab {

    String title;
    boolean completed = false;
    LocalDate completedAt;

    public Lab(String title) {
        if (isNullOrEmpty(title)) {
            throw new IllegalArgumentException("Title is not valid");
        }
        this.title = title;
    }

    public Lab(String title, LocalDate completedAt) {
        if (isNullOrEmpty(title)) {
            throw new IllegalArgumentException("Title is not valid");
        }
        this.title = title;
        this.completedAt = completedAt;
        completed = true;
    }

    public void complete(){
        completed = true;
        completedAt = LocalDate.now();
    }

    public void complete(LocalDate date){
        completed = true;
        completedAt = date;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "title='" + title + '\'' +
                ", completed=" + completed +
                ", completedAt=" + completedAt +
                '}';
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDate getCompletedAt() {
        return completedAt;
    }

    private boolean isNullOrEmpty(String title) {
        return (title == null || title.isBlank());
    }

    public static void main(String[] args) {
        Lab lab1 = new Lab("Exception");
        System.out.println(lab1);
        Lab lab2 = new Lab("Inheritance", LocalDate.of(2020, 12, 06));
        System.out.println(lab2);
        Lab lab3 = new Lab("Exception");
        System.out.println(lab3);

        lab1.complete();
        lab3.complete(LocalDate.of(2020,12,9));

        System.out.println(lab1);

        System.out.println(lab2);

        System.out.println(lab3);

    }

}
