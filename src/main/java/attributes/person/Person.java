package attributes.person;

public class Person {
    private String name;
    private String identificationCard;
    private Address address = new Address("","","","");

    public Person(String name, String identificationCard) {
        this.name = name;
        this.identificationCard = identificationCard;
    }

    public String personToString() {
        return name + " - " + identificationCard + " - " + address.addressToString();
    }

    public void moveTo(Address address){
        this.address = address;
    }

    public void correctData(String name, String identificationCard){
        this.name = name;
        this.identificationCard = identificationCard;
    }

    public String getName() {
        return name;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public Address getAddress() {
        return address;
    }
}
