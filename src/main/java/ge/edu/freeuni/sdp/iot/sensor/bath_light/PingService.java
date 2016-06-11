package ge.edu.freeuni.sdp.iot.sensor.bath_light;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("ping")
public class PingService {

  @GET
  public Response get() {
    return Response.ok().build();
  }

}
