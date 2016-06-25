package ge.edu.freeuni.sdp.iot.sensor.bath_light.controller;

import javax.ws.rs.*;

@Path("status")
public class PostService {

    @POST
    @Consumes("application/json")
    public void post(final MyJaxBean input) {
        System.out.println("houseId = " + input.houseId + ", time = " + input.time + ", status = " + input.status);
        HouseCollection collection = HouseCollectionFactory.getInstance();
        collection.add(input);
        System.out.println(collection.getSize());
    }
}
