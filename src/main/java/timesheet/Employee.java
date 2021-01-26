package timesheet;

public class Employee {

    private final String firstName;

    private final String lastName;

    public Employee(String firstName, String lastName) {

        if (isEmpty(firstName)) {
            throw new IllegalArgumentException("Firstname is cannot be blank");
        }
        this.firstName = firstName;

        if (isEmpty(lastName)) {
            throw new IllegalArgumentException("Lastname is cannot be blank");
        }
        this.lastName = lastName;
    }

    private boolean isEmpty(String name) {
        return name == null || name.isBlank();
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
