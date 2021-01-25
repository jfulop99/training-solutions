package xtest.introxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Gpx {

    @XmlAttribute(required = true)
    private String gpx_creator;

    private String metadata;

    private Track track;

}
