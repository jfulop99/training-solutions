package gyaxi.orokles.airport;

public abstract class Person {
    private String name;
    private Integer age;
    private PersonType type;

    public Person(String name, Integer age, PersonType type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public PersonType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return type == person.type;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    public void increaseAge() {
        if (age != null) {
            age++;
        }
    }

}
