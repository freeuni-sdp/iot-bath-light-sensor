package ge.edu.freeuni.sdp.iot.sensor.bath_light;

import ge.edu.freeuni.sdp.iot.sensor.bath_light.controller.MyJaxBean;
import ge.edu.freeuni.sdp.iot.sensor.bath_light.controller.PostService;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PostServiceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(FakePostService.class);
    }

    @Test
    public void post_elem() throws Exception {
        FakeRepository.instance().clear();

        MyJaxBean jxb = TestHelper.createRandomJXB();

        Response actual =
                target("status")
                        .request()
                        .post(Entity.entity(jxb, MediaType.APPLICATION_JSON_TYPE));

        assertEquals(
                Response.Status.CREATED.getStatusCode(),
                actual.getStatus());

        String[] segments = actual.getLocation().getPath().split("/");
        String id = segments[segments.length - 1];

        assertTrue(FakeRepository.instance().contains(id));
    }

    @Test
    public void post_incomplete_elem() throws Exception {
        FakeRepository.instance().clear();

        MyJaxBean jxb = TestHelper.createIncompleteJXB();

        Response actual =
                target("status")
                        .request()
                        .post(Entity.entity(jxb, MediaType.APPLICATION_JSON_TYPE));

        System.out.print(actual.getStatus());

        assertEquals(
                Response.Status.BAD_REQUEST.getStatusCode(),
                actual.getStatus());
    }

}
