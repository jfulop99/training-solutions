package xtest.introxml;


import javax.xml.bind.annotation.*;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Device {

    @XmlAttribute(required = true)
    private SetupType type;
    private String name;
    private String ipAddress;
    private String snmpCommunity;
    @XmlTransient
    private String status;

    public Device() {
    }

    public Device(SetupType type, String name, String ipAddress, String snmpCommunity, String status) {
        this.type = type;
        this.name = name;
        this.ipAddress = ipAddress;
        this.snmpCommunity = snmpCommunity;
        this.status = status;
    }

    public SetupType getType() {
        return type;
    }

    public void setType(SetupType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getSnmpCommunity() {
        return snmpCommunity;
    }

    public void setSnmpCommunity(String snmpCommunity) {
        this.snmpCommunity = snmpCommunity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
