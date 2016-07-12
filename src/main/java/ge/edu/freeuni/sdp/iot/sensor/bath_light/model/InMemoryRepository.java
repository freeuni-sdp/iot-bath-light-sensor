package ge.edu.freeuni.sdp.iot.sensor.bath_light.model;


import com.microsoft.azure.storage.StorageException;

import java.util.HashMap;
import java.util.Map;

public class InMemoryRepository implements Repository{
    private static InMemoryRepository instance;
    protected Map<String, HouseEntity> map;

    public static InMemoryRepository instance() {
        if (instance == null) {
            instance = new InMemoryRepository(new HashMap<String, HouseEntity>());
        }
        return instance;
    }

    public InMemoryRepository(Map<String, HouseEntity> map) {
        super();
        this.map = map;
    }


    @Override
    public void insertOrUpdate(HouseEntity bathroom) throws StorageException {
        String id = bathroom.getRowKey();
        map.put(id, bathroom);
    }

    @Override
    public HouseEntity delete(String id) throws StorageException {
        return map.remove(id);
    }

    @Override
    public HouseEntity find(String id) throws StorageException {
        return map.get(id);
    }

    @Override
    public Iterable<HouseEntity> getAll() {
        return map.values();
    }
}
