package ge.edu.freeuni.sdp.iot.sensor.bath_light.core;


import javax.ws.rs.Path;

import ge.edu.freeuni.sdp.iot.sensor.bath_light.data.InMemoryRepository;
import ge.edu.freeuni.sdp.iot.sensor.bath_light.data.Repository;

import com.microsoft.azure.storage.StorageException;

@Path("memtodos")
public class InMemoryTaskService extends TaskService {
	
	@Override
	public Repository getRepository() throws StorageException {
		return InMemoryRepository.instance();
	}

}
