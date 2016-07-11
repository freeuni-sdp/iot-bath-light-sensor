package ge.edu.freeuni.sdp.iot.sensor.bath_light;


import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import javax.ws.rs.core.Application;

public class GetServiceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(FakeGetService.class);
    }

}
