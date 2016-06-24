package ge.edu.freeuni.sdp.iot.sensor.bath_light;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public boolean houseExists(String houseId){
        return houses.containsKey(houseId);
    }

    public boolean getSingleStatus(String houseId) {
        House house = houses.get(houseId);
        return house.status;
    }

    public String getSingleTime(String houseId) {
        House house = houses.get(houseId);
        return house.time;
    }

    public ArrayList<MyJaxBean> getHouses () {
        ArrayList<MyJaxBean> jxbList = new ArrayList<MyJaxBean>();
        for (House house : houses.values()) {
            MyJaxBean jxb = new MyJaxBean();
            jxb.houseId = house.id;
            jxb.status = house.status ? "true" : "false";
            jxb.time = house.time;
            jxbList.add(jxb);
        }
        return jxbList;
    }

    public int getSize() {
        return houses.size();
    }
}
