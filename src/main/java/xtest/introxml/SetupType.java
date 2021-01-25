package xtest.introxml;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum(Integer.class)
public enum SetupType {

    @XmlEnumValue("0") DISABLED,
    @XmlEnumValue("1") ENABLED

}
