package week12.d04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClientsTest {

    @Test
    void findByRegNumber() {
        Clients clients = new Clients(Arrays.asList(new Client("A", "5555"), new Client("B",
                "4444"),new Client("X", "1111")));

        Client clinet = clients.findByRegNumber("1111");

        assertEquals("X", clinet.getName());
        assertEquals("1111", clinet.getRegNumber());

        Exception e = assertThrows(IllegalArgumentException.class, () -> clients.findByRegNumber("XXX") );

    }

    @Test
    void getClients() {
        Clients clients = new Clients();

        assertEquals(0, clients.getClients().size());

        clients.addClient("Gazsi", "0101222");

        assertEquals(1, clients.getClients().size());
        assertEquals("0101222", clients.getClients().get(0).getRegNumber());
        assertEquals("Gazsi", clients.getClients().get(0).getName());

    }

    @Test
    void addClient() {
        Clients clients = new Clients();

        assertEquals(0, clients.getClients().size());

        clients.addClient("Gazsi", "0101222");

        assertEquals(1, clients.getClients().size());
        assertEquals("0101222", clients.getClients().get(0).getRegNumber());
        assertEquals("Gazsi", clients.getClients().get(0).getName());

    }

    @Test
    void findByName() {
        Clients clients = new Clients(Arrays.asList(new Client("A", "5555"), new Client("B",
                "4444"),new Client("X", "1111")));


        clients.addClient("Mazsi", "0101333");
        clients.addClient("Gazsi", "0101222");

        List<Client> result = clients.findByName("azsi");
        result.sort(Comparator.naturalOrder());

        assertEquals(2, result.size());
        assertEquals("0101222", result.get(0).getRegNumber());
        assertEquals("Gazsi", result.get(0).getName());


    }
}