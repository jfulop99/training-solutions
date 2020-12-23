package week09.d03;

import java.util.ArrayList;
import java.util.List;

public class SantaClaus {

    private List<Person> people;

    public SantaClaus(List<Person> people) {
        if (people == null || people.size() == 0) {
            throw new IllegalArgumentException("Invalid people list");
        }
        this.people = people;
    }

    public void getThroughChimneys() {
        for (Person person:people) {
            person.setPresent();
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Apa", 43));
        people.add(new Person("Anya", 40));
        people.add(new Person("Betti", 8));
        people.add(new Person("Borcsi", 11));
        people.add(new Person("Bence", 16));
        people.add(new Person("Nagyi", 70));

        SantaClaus santaClaus = new SantaClaus(people);
        santaClaus.getThroughChimneys();

        for (Person person:people) {
            System.out.println(person);
        }
    }
}
