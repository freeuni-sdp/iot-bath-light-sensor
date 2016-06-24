package ge.edu.freeuni.sdp.iot.sensor.bath_light;

import javax.xml.bind.annotation.*;

/**
 * Created by Babalah on 6/24/2016.
 */
@XmlRootElement
public class MyJaxBean {
    @XmlElement public String houseId;
    @XmlElement public String time;
    @XmlElement public String status;
}
