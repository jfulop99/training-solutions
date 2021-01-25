package xtest.introxml;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        Setup setup = new Setup();

        setup.addEntry(new Device(SetupType.ENABLED, "Device1", "192.168.100.1", "public", ""));
        setup.addEntry(new Device(SetupType.ENABLED, "Device2", "192.168.100.2", "public", ""));
        setup.addEntry(new Device(SetupType.ENABLED, "Device3", "192.168.100.3", "cisco", ""));
        setup.addEntry(new Device(SetupType.ENABLED, "Device4", "192.168.100.4", "public", ""));


        try {
            JAXBContext context = JAXBContext.newInstance(Setup.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            Path path = Path.of("setup.xml");

            marshaller.marshal(setup, path.toFile());
            marshaller.marshal(setup, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        Gpx gpx = new Gpx();

        try {
            JAXBContext context1 = JAXBContext.newInstance(Gpx.class);

            Unmarshaller unmarshaller = context1.createUnmarshaller();

            //gpx = (Gpx) unmarshaller.unmarshal(Main.class.getResourceAsStream("/track.gpx"));

            System.out.println(gpx);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
