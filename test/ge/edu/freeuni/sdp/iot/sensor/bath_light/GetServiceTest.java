package ge.edu.freeuni.sdp.iot.sensor.bath_light;


import ge.edu.freeuni.sdp.iot.sensor.bath_light.controller.MyJaxBean;
import ge.edu.freeuni.sdp.iot.sensor.bath_light.model.HouseEntity;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.json.XML;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import com.microsoft.azure.storage.StorageException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public void get_1_elem_list() throws StorageException {

        FakeRepository.instance().clear();
        MyJaxBean jxb = TestHelper.createRandomJXB();
        HouseEntity entity = new HouseEntity(jxb);
        FakeRepository.instance().insertOrUpdate(entity);

        Response result = target("status").request().get();
        assertEquals(200, result.getStatus());

        String body = result.readEntity(String.class);
        try {
            JSONArray array = new JSONArray(body);
            assertEquals(1, array.length());
            JSONObject json = (JSONObject) array.get(0);
            String resId = json.getString("houseId");
            String resStatus = json.getString("status");
            String resTime = json.getString("time");
            assertEquals(jxb.getHouseId(), resId);
            assertEquals(jxb.getStatus(), resStatus);
            assertEquals(jxb.getTime(), resTime);
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    @Test
    public void get_several_elem_list() throws StorageException {

        FakeRepository.instance().clear();
        ArrayList<MyJaxBean> jxbs = new ArrayList<MyJaxBean>();
        Random rand = new Random();
        int n = rand.nextInt(10);
        for (int i = 0; i < n; i++) {
            MyJaxBean jxb = TestHelper.createRandomJXB();
            jxbs.add(jxb);
            HouseEntity entity = new HouseEntity(jxb);
            FakeRepository.instance().insertOrUpdate(entity);
        }

        MyJaxBean[] result =
                target("status")
                        .request()
                        .get(MyJaxBean[].class);

        List<MyJaxBean> resList = Arrays.asList(result);

        assertTrue(jxbs.containsAll(resList) && resList.containsAll(jxbs));
    }

    @Test
    public void get_1_elem() throws StorageException {

        FakeRepository.instance().clear();
        MyJaxBean jxb = TestHelper.createRandomJXB();
        HouseEntity entity = new HouseEntity(jxb);

        FakeRepository.instance().insertOrUpdate(entity);

        MyJaxBean result =
                target("status/house/"+jxb.getHouseId())
                        .request()
                        .get(MyJaxBean.class);

        assertEquals(result, jxb);
    }

    @Test
    public void get_1_nonexistent_elem() throws StorageException {

        FakeRepository.instance().clear();

        Response res =
                target("status/house/7")
                        .request()
                        .get();
        assertEquals(
                Response.Status.NOT_FOUND.getStatusCode(),
                res.getStatus());
    }
}
