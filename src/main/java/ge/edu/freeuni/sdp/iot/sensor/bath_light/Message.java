package ge.edu.freeuni.sdp.iot.sensor.bath_light;

/**
 * Created by Babalah on 6/25/2016.
 */
public class Message {
    private String light_switch_time;
    private String is_light_on;
    private String house_id;

    public void setTime(String time) {
        light_switch_time = time;
    }

    public void setStatus(String status ){
       is_light_on = status;
    }

    public void setHouseId(String houseId) {
        house_id = houseId;
    }

    public String getTime() {
        return light_switch_time;
    }

    public String getStatus() {
        return is_light_on;
    }

    public String getHouseId() {
        return house_id;
    }
}
