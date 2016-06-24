package ge.edu.freeuni.sdp.iot.sensor.bath_light;

import java.util.HashMap;

/**
 * Created by Babalah on 6/24/2016.
 */
public class House {
    public String id;
    private HashMap<String, Boolean> History;
    public boolean status;
    public String time;

    public House(String id) {
        this.id = id;
        History = new HashMap<String, Boolean>();
    }

    public void write(MyJaxBean input) {
        status = input.status.equals("on");
        time = input.time;
        History.put(input.time, status);
    }
}
