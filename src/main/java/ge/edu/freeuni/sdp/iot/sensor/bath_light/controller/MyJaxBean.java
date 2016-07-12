package ge.edu.freeuni.sdp.iot.sensor.bath_light.controller;

import javax.validation.OverridesAttribute;
import javax.xml.bind.annotation.*;

/**
 * Created by Babalah on 6/24/2016.
 */
@XmlRootElement
public class MyJaxBean {
    @XmlElement private String houseId;
    @XmlElement private String time;
    @XmlElement private String status;

    public void setHouseId(String id){houseId = id;}
    public void setTime(String time){this.time = time;}
    public void setStatus(String status){this.status = status;}

    public String getHouseId(){return houseId;}
    public String getTime(){return time;}
    public String getStatus(){return status;}

    @Override
    public boolean equals(Object obj){
        System.out.println("obj");
        System.out.println(obj);
        System.out.println("this");
        System.out.println(this);
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyJaxBean other = (MyJaxBean) obj;
        System.out.println("other.status");
        System.out.println(other.status);
        System.out.println("this.status");
        System.out.println(this.status);
        if (houseId == null) {
            if (other.houseId != null)
                return false;
        } else if (!houseId.equals(other.houseId))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        if (time == null) {
            if (other.time != null)
                return false;
        } else if (!time.equals(other.time))
            return false;
        return true;
    }
}
