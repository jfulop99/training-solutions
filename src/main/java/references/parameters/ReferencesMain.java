package references.parameters;

public class ReferencesMain {

    public static void main(String[] args) {
        Person firstPerson;
        Person secondPerson;

        firstPerson = new Person("John Doe", 35);
        secondPerson = firstPerson;

        secondPerson.setName("Jack Daniels");

        System.out.println(firstPerson.getName());
        System.out.println(secondPerson.getName());

        // mindkét név megváltozott, mert ugyanarra az objektumra mutatnak

        int temp1;
        int temp2;

        temp1 = 24;
        temp2 = temp1;

        temp2++;

        System.out.println(temp1);
        System.out.println(temp2);
        // csak a temp2 változott, mert külön területen vannak a memóriában

        firstPerson = new Person("John Doe", 56);
        System.out.println(firstPerson.getName() + " + " + firstPerson.getAge());
        System.out.println(secondPerson.getName() + " + " + secondPerson.getAge());
        // most már két külön objektum van
    }
}
