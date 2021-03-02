package vaccine;

public class Citizen {

    private long id;

    private final String fullName;

    private final String zipNumber;

    private final int age;

    private final String emailAddress;

    private final String tajNumber;


    public Citizen(String fullName, String zipNumber, int age, String emailAddress, String tajNumber) {
        this.fullName = fullName;
        this.zipNumber = zipNumber;
        this.age = age;
        this.emailAddress = emailAddress;
        this.tajNumber = tajNumber;
    }


    public Citizen(long id, String fullName, String zipNumber, int age, String emailAddress, String tajNumber) {
        this(fullName, zipNumber, age, emailAddress, tajNumber);
        this.id = id;
    }


    public String getFullName() {
        return fullName;
    }

    public String getZipNumber() {
        return zipNumber;
    }

    public int getAge() {
        return age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTajNumber() {
        return tajNumber;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return fullName + ";" + zipNumber + ";" + age + ";" + emailAddress + ";" + tajNumber + "\n";
    }
}
