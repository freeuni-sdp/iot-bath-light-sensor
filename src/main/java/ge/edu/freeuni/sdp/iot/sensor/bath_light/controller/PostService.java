package ge.edu.freeuni.sdp.iot.sensor.bath_light.controller;

import javax.ws.rs.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Path("status")
public class PostService {

    @POST
    @Consumes("application/json")
    public void post(final MyJaxBean input) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:s.SS'Z'");
        input.time = df.format(new Date());
        System.out.println("houseId = " + input.houseId + ", time = " + input.time + ", status = " + input.status);
        HouseCollection collection = HouseCollectionFactory.getInstance();
        collection.add(input);
        System.out.println(collection.getSize());
    }
}
