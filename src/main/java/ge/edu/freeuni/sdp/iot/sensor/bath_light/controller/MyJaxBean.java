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

//    @Override
//    public boolean equals(Object obj){
//        if (obj.getClass().equals()
//    }
}
