package attributes.person;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person("John Doe", "123456XY");
        Address address = new Address("Hungary", "Budapest", "Main street 13.", "1111");

        System.out.println(person.personToString());
        person.moveTo(address);
        System.out.println(person.personToString());
        Address newAddress = new Address("Germany", "Leipzig", "Karl Marx Strasse", "8953");
        person.moveTo(newAddress);
        System.out.println(person.personToString());
        person.correctData("Jack Doe", "123456XY");
        System.out.println(person.personToString());
        person.getAddress().corectData("Germany", "Karl Marx Stadt", "Karl Marx Strasse", "8953");
        System.out.println(person.personToString());
    }
}
