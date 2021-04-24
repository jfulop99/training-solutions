package gyaxi.orokles.airport;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Plane {

    private List<Person> personList;

    public Plane(List<Person> personList) {
        if (personList == null) {
            throw new IllegalArgumentException("Person list is a must!");
        }
        this.personList = new ArrayList<>(personList);
    }

    public Set<Stewardess> getCabinCrew() {

        return personList.stream()
                .filter(t -> t.getType() == PersonType.STEWARDESS)
                .map(person -> (Stewardess) person)
                .collect(Collectors.toSet());
    }

    public String findTheOldest() {
        return personList.stream()
                .filter(person -> !person.getType().isTravel())
                .max(Comparator.comparing(Person::getAge))
                .orElseThrow(() -> new IllegalStateException("The plane is empty!"))
                .getName();
    }

    public String findTheYoungest() {
        return personList.stream()
                .filter(person -> person.getType().isTravel() && person.getAge() != null)
                .min(Comparator.comparing(Person::getAge))
                .orElseThrow(() -> new IllegalStateException("The plane is empty!"))
                .getName();
    }

    public Pilot findTheCatain() {
        return personList.stream()
                .filter(person -> person.getType() == PersonType.PILOT)
                .map(person -> (Pilot) person)
                .filter(pilot -> pilot.getPosition() == Position.CAPTAIN)
                .findFirst().orElseThrow(() -> new IllegalStateException("The plane is empty!"));
    }

    public Map<String, Passenger> getPassangerList() {
        return personList.stream()
                .filter(person -> person.getType() == PersonType.PASSENGER)
                .map(person -> (Passenger) person)
                .collect(Collectors.toMap(Passenger::getSeat, Function.identity()));
    }

    public void newYearsEve() {
        for (Person item : personList) {
            item.increaseAge();
        }
    }

    public List<Person> getPepople() {
        return new ArrayList<>(personList);
    }

    public void beforeTakeOff() {
        Iterator<Person> it = personList.iterator();
        while (it.hasNext()) {
            Person item = it.next();
            if (item.getType() == PersonType.GROUND_STAFF) {
                it.remove();
            }
        }
    }

    public Optional<Integer> howOldTheCatain() {
        return personList.stream()
                .filter(person -> person.getType() == PersonType.PILOT)
                .map(person -> (Pilot) person)
                .filter(pilot -> pilot.getPosition() == Position.CAPTAIN)
                .map(Person::getAge)
                .findFirst();
    }

    public void relocate() {
        for (Person item : personList) {
            if (item.getType() == PersonType.PASSENGER) {
                Passenger passenger = (Passenger) item;
                passenger.changeSeat();
            }
        }
    }
}
