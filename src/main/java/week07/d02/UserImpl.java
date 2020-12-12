package week07.d02;

public class UserImpl implements User{

    private String userName;
    private String firstName;
    private String lastName;

    public UserImpl(String userName, String firstName, String lastName) {
        if (isEmptyOrNull(userName)) {
            throw new IllegalArgumentException("Invalid Username");
        }
        this.userName = userName;

        if (isEmptyOrNull(firstName)) {
            throw new IllegalArgumentException("Invalid Firstname");
        }
        this.firstName = firstName;

        if (isEmptyOrNull(lastName)) {
            throw new IllegalArgumentException("Invalid Lastname");
        }
        this.lastName = lastName;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    private boolean isEmptyOrNull(String s) {
        return (s == null || s.isBlank());
    }
}
