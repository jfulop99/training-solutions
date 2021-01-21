package week12.d04;

import java.util.*;

public class Clients {

    private Map<String, Client> clients;

    public Clients(List<Client> clients) {

        this.clients = new HashMap<>();

        if (clients == null || clients.isEmpty()) {
            return;
        }

        for (Client item: clients ) {
            this.clients.put(item.getRegNumber(), item);
        }

    }

    public Clients() {

        this.clients = new HashMap<>();

    }

    public Client findByRegNumber(String regNum) {
        Client client = clients.get(regNum);
        if (client == null) {
            throw new IllegalArgumentException("Cannot find " + regNum);
        }
        return client;
    }


    public List<Client> getClients() {

        if (clients.isEmpty()) {
            return new ArrayList<>();
        }

        return new ArrayList<>(clients.values());
    }

    public void addClient(String name, String regNumber) {
        clients.put(regNumber, new Client(name, regNumber));
    }

    public List<Client> findByName(String name) {
        List<Client> result = new ArrayList<>();

        if (clients.isEmpty()) {
            return result;
        }

        for (Client client:clients.values()) {
            if (client.getName().contains(name)) {
                result.add(client);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Clients clients = new Clients(Arrays.asList(new Client("A", "5555"), new Client("B", "4444"),new Client("X", "1111")));

        clients.addClient("Gazsi", "0101222");
        System.out.println(clients.findByRegNumber("0101222"));
        System.out.println(clients.findByRegNumber("1111"));
        System.out.println(clients.getClients());
        System.out.println(clients.findByName("azs"));
        Clients ccc =new Clients();
        clients.findByRegNumber("3456");

    }
}
