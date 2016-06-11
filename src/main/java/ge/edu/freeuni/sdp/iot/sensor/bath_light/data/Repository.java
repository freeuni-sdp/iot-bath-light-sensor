package ge.edu.freeuni.sdp.iot.sensor.bath_light.data;

import com.microsoft.azure.storage.StorageException;

public interface Repository {

	public abstract void insertOrUpdate(TaskEntity task)
			throws StorageException;

	public abstract TaskEntity delete(String id) throws StorageException;

	public abstract TaskEntity find(String id) throws StorageException;

	public abstract Iterable<TaskEntity> getAll();

}