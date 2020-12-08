package week07d02;

public interface User {

    String getUserName();
    String getFirstName();
    String getLastName();
    default String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    static User of (String userName, String firstName, String lastName) {
        return new UserImpl(userName, firstName, lastName);
    }

}
