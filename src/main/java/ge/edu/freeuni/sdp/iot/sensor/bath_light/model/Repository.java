package ge.edu.freeuni.sdp.iot.sensor.bath_light.model;

import com.microsoft.azure.storage.StorageException;

public interface Repository {

    public abstract void insertOrUpdate(HouseEntity bathroom)
            throws StorageException;

    public abstract HouseEntity delete(String id) throws StorageException;

    public abstract HouseEntity find(String id) throws StorageException;

    public abstract Iterable<HouseEntity> getAll();

}