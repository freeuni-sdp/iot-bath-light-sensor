package ge.edu.freeuni.sdp.iot.sensor.bath_light.model;

import com.microsoft.azure.storage.StorageException;

public interface Repository {

    public abstract void insertOrUpdate(BathroomEntity bathroom)
            throws StorageException;

    public abstract BathroomEntity delete(String id) throws StorageException;

    public abstract BathroomEntity find(String id) throws StorageException;

    public abstract Iterable<BathroomEntity> getAll();

}