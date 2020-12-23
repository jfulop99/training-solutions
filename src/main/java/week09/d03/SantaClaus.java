package week09.d03;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SantaClaus {

    private List<Person> people;
    private static Random rnd;

    public SantaClaus(List<Person> people, Random rnd) {
        if (people == null || people.size() == 0) {
            throw new IllegalArgumentException("Invalid people list");
        }
        this.people = people;
        if (rnd == null) {
            throw new IllegalArgumentException("Invalid random");
        }
        this.rnd = rnd;
    }

    public void getThroughChimneys() {
        for (Person person:people) {
            person.setPresent(rnd);
        }
    }

    public List<Person> getPeople() {
        return new ArrayList<>(people);
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Apa", 43));
        people.add(new Person("Anya", 40));
        people.add(new Person("Betti", 8));
        people.add(new Person("Borcsi", 11));
        people.add(new Person("Bence", 16));
        people.add(new Person("Nagyi", 70));

        SantaClaus santaClaus = new SantaClaus(people, new Random(1));
        santaClaus.getThroughChimneys();



        for (Person person:people) {
            System.out.println(person);
        }
    }
}
