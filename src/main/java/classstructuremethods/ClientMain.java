package classstructuremethods;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();
        // Set parameters
        client.setName("Maci Laci");
        client.setYear(1967);
        client.setAddress("Kerekerdő");
        // Print parameters
        System.out.println("Name: " + client.getName());
        System.out.println("DoB : " + client.getYear());
        System.out.println("Addr: " + client.getAddress());
        // Change address
        client.migrate("Négyszögletes kerek erdő");
        // Print new address
        System.out.println("New address: " + client.getAddress());

    }
}
