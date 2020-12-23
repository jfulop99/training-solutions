package week09.d03;

import java.util.Random;

public class Person {

    private String name;
    private int age;
    private Present present;


    public Person(String name, int age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid name");
        }

        this.name = name;
        if (age < 0) {
            throw new IllegalArgumentException("invalid age age: " + age);
        }
        this.age = age;
    }

    public void setPresent(Random rnd) {
        Present present = Present.randomPresent(rnd);
        while (age > 14 && present == Present.TOY) {
            present = Present.randomPresent(rnd);
        }
        this.present = present;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Present getPresent() {
        return present;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", present=" + present +
                '}';
    }
}
