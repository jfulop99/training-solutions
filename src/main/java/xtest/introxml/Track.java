package xtest.introxml;

import javax.xml.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "trk")
@XmlAccessorType(XmlAccessType.FIELD)
public class Track {



    @XmlElement(name = "metadata")
    @XmlAttribute
    private LocalDateTime time;

    @XmlElement(name = "trkseg")
    @XmlElementWrapper
    private List<TrackPoint> trk;

    private String name;

    private int type;

    public Track() {
        trk = new ArrayList<>();
    }

    public Track(List<TrackPoint> trk, String name, int type) {
        this.trk = trk;
        this.name = name;
        this.type = type;
    }
}
