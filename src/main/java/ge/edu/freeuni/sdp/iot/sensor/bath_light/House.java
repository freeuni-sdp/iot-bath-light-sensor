package ge.edu.freeuni.sdp.iot.sensor.bath_light;

import jdk.internal.util.xml.impl.Pair;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Babalah on 6/24/2016.
 */
public class House {
    private int id;
    private HashMap<String, Boolean> History;
    private boolean status;

    public House(String id) {
        this.id = Integer.parseInt(id);
        History = new HashMap<String, Boolean>();
    }

    public void write(MyJaxBean input) {
        status = input.status.equals("on");
        History.put(input.time, status);
    }
}
