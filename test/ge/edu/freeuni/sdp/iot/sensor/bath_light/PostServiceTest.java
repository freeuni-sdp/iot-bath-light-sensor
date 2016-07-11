package ge.edu.freeuni.sdp.iot.sensor.bath_light;

import ge.edu.freeuni.sdp.iot.sensor.bath_light.controller.MyJaxBean;
import ge.edu.freeuni.sdp.iot.sensor.bath_light.controller.PostService;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

public class PostServiceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(FakePostService.class);
    }

    @Test
    public void post() throws Exception {
        MyJaxBean jxb = new MyJaxBean();
        jxb.houseId = "3";
        jxb.time = "now";
        jxb.status = "on";
        Response response = target("status").request().post(Entity.json(jxb));
    }
}
