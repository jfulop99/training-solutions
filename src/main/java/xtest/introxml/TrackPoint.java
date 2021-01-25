package xtest.introxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDateTime;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class TrackPoint {

    @XmlAttribute(required = true)
    private final double lat;
    private final double lon;
    private final double ele;
    private final LocalDateTime time;

    public TrackPoint(double lat, double lon, double ele, LocalDateTime time) {
        this.lat = lat;
        this.lon = lon;
        this.ele = ele;
        this.time = time;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public double getEle() {
        return ele;
    }

    public LocalDateTime getTime() {
        return time;
    }

    /*
   <trkpt lat="47.2181020" lon="18.5411940">
    <ele>134.2</ele>
    <time>2020-12-27T08:59:38Z</time>
    <extensions>
     <gpxtpx:TrackPointExtension>
      <gpxtpx:atemp>24</gpxtpx:atemp>
      <gpxtpx:hr>91</gpxtpx:hr>
      <gpxtpx:cad>49</gpxtpx:cad>
     </gpxtpx:TrackPointExtension>
    </extensions>
*/
}
