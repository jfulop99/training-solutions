package ioreadstring.names;

public class Human {

    private final String lastName;
    private final String firstName;

    public Human(String firstName, String lastName) {
        if (isBlank(lastName)) {
            throw new IllegalArgumentException("Lastname is invalid");
        }
        this.lastName = lastName;
        if (isBlank(firstName)) {
            throw new IllegalArgumentException("Firstname is invalid");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    private boolean isBlank(String str) {
        return str == null || str.isBlank();
    }
}
