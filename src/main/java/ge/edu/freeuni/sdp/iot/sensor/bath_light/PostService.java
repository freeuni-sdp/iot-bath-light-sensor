package ge.edu.freeuni.sdp.iot.sensor.bath_light;

import javax.ws.rs.*;

@Path("status")
public class PostService {

    @POST
    @Consumes("application/json")
    public void post(final MyJaxBean input) {
        System.out.println("houseId = " + input.houseId + ", time = " + input.time + ", status = " + input.status);
    }
}
