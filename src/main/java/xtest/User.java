package xtest;

import java.text.Collator;
import java.util.Locale;

public class User implements Comparable<User> {

    private String name;

    private int salary;

    private Collator collator = Collator.getInstance(new Locale("hu", "HU"));


    public User(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(User o) {
        return collator.compare(name, o.getName());
    }
}
