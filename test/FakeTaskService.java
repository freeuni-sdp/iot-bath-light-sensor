import com.microsoft.azure.storage.StorageException;

import ge.edu.freeuni.sdp.iot.sensor.bath_light.core.TaskService;
import ge.edu.freeuni.sdp.iot.sensor.bath_light.data.Repository;


public class FakeTaskService extends TaskService {
	@Override
	public Repository getRepository() throws StorageException {
		return FakeRepository.instance();
	}
}
