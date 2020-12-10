package exceptionclass.course;

public class Course {

    private String name;
    private SimpleTime begin;

    public Course(String name, SimpleTime begin) {

        if (isNullOrBlank(name)) {
            throw new IllegalArgumentException("Name is invalid " + name);
        }
        this.name = name;
        if (begin == null) {
            throw new IllegalArgumentException("Begin is null");
        }
        this.begin = begin;
    }

    private boolean isNullOrBlank(String string) {
        return (string == null || string.isBlank());
    }

    public String getName() {
        return name;
    }

    public SimpleTime getBegin() {
        return begin;
    }

    @Override
    public String toString() {
        return begin.toString() + ": " + name;
    }
}
