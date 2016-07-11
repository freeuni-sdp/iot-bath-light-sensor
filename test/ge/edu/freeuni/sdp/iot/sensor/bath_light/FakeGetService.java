package ge.edu.freeuni.sdp.iot.sensor.bath_light;


import com.microsoft.azure.storage.StorageException;
import ge.edu.freeuni.sdp.iot.sensor.bath_light.controller.GetService;
import ge.edu.freeuni.sdp.iot.sensor.bath_light.model.Repository;

public class FakeGetService extends GetService {

    @Override
    public Repository getRepository() throws StorageException {
        return FakeRepository.instance();
    }
}
