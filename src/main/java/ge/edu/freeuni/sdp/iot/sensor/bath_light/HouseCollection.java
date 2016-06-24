package ge.edu.freeuni.sdp.iot.sensor.bath_light;

import java.util.HashMap;

/**
 * Created by Babalah on 6/24/2016.
 */
public class HouseCollection {
    //              id,     House
    private HashMap<String, House> houses = null;

    public HouseCollection(){
        houses = new HashMap<String, House>();
    }

    public void add(MyJaxBean input) {
        if (houses.containsKey(input.houseId))
            houses.get(input.houseId).write(input);
        else {
            House house = new House(input.houseId);
            house.write(input);
            houses.put(input.houseId, house);
        }
    }

    public int getSize() {
        return houses.size();
    }
}
