package ge.edu.freeuni.sdp.iot.sensor.bath_light;

import ge.edu.freeuni.sdp.iot.sensor.bath_light.controller.PingService;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.Assert.*;


public class PingServiceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(PingService.class);
    }

    @Test
    public void ping() throws Exception {
        Response response = target("ping").request().get();
        assertEquals(200, response.getStatus());
    }

}