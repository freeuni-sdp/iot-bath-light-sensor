package ge.edu.freeuni.sdp.iot.sensor.bath_light;


import com.microsoft.azure.storage.StorageException;
import ge.edu.freeuni.sdp.iot.sensor.bath_light.controller.PostService;
import ge.edu.freeuni.sdp.iot.sensor.bath_light.model.Repository;

public class FakePostService extends PostService {

    @Override
    public Repository getRepository() throws StorageException {
        return FakeRepository.instance();
    }

}
