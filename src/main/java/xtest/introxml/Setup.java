package xtest.introxml;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "setup")
@XmlAccessorType(XmlAccessType.FIELD)
public class Setup {

    @XmlElement(name = "device")
    @XmlElementWrapper
    private List<Device> devices;

    public Setup() {
        devices = new ArrayList<>();
    }

    public Setup(List<Device> devices) {
        this.devices = new ArrayList<>(devices);
    }

    public List<Device> getDevices() {
        return new ArrayList<>(devices);
    }

    public void setDevices(List<Device> devices) {
        this.devices = new ArrayList<>(devices);
    }

    public void addEntry(Device setup) {
        devices.add(setup);
    }
}
