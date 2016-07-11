package ge.edu.freeuni.sdp.iot.sensor.bath_light;


import ge.edu.freeuni.sdp.iot.sensor.bath_light.model.HouseEntity;
import ge.edu.freeuni.sdp.iot.sensor.bath_light.model.InMemoryRepository;
import ge.edu.freeuni.sdp.iot.sensor.bath_light.model.Repository;

import java.util.HashMap;
import java.util.Map;

public class FakeRepository extends InMemoryRepository implements Repository {

    private static FakeRepository instance;

    public static FakeRepository instance() {
        if (instance==null) {
            instance = new FakeRepository(new HashMap<String, HouseEntity>());
        }
        return instance;
    }


    public FakeRepository(Map<String, HouseEntity> map) {
        super(map);
    }

    public boolean contains(String id) {
        return map.containsKey(id);
    }

    public void clear() {
        this.map.clear();
    }

}
