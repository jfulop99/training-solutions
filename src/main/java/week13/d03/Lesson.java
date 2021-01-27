package week13.d03;

public class Lesson {

    private String name;

    private String className;

    private int hours;

    public Lesson(String name, String className, int hours) {
        this.name = name;
        this.className = className;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", hours=" + hours +
                '}';
    }
}
