package ge.edu.freeuni.sdp.iot.sensor.bath_light;


import ge.edu.freeuni.sdp.iot.sensor.bath_light.controller.MyJaxBean;
import ge.edu.freeuni.sdp.iot.sensor.bath_light.model.HouseEntity;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.ws.rs.core.Application;

import com.microsoft.azure.storage.StorageException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GetServiceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(FakeGetService.class);
    }

    @Test
    public void get_empty_list() throws StorageException {
        FakeRepository.instance().clear();

        MyJaxBean[] result = target("status")
                            .request()
                            .get(MyJaxBean[].class);
        assertEquals(0, result.length);
    }

    @Test
    public void get_1_elem() throws StorageException {

        FakeRepository.instance().clear();
        MyJaxBean jxb = new MyJaxBean();
        Random rand = new Random();
        String id = ""+rand.nextInt(100);
        jxb.setHouseId(id);
        jxb.setStatus(""+rand.nextBoolean());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:s.SS'Z'");
        jxb.setTime(df.format(new Date()));
        HouseEntity entity = new HouseEntity(jxb);
        FakeRepository.instance().insertOrUpdate(entity);

        MyJaxBean[] result =
                target("status")
                        .request()
                        .get(MyJaxBean[].class);

        assertEquals(1, result.length);
        assertEquals(jxb, result[0]);
    }
}
