package ge.edu.freeuni.sdp.iot.sensor.bath_light.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Babalah on 6/24/2016.
 */
@Path("status")
public class GetService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<MyJaxBean> getAllHouses() {
        HouseCollection collection = HouseCollectionFactory.getInstance();
        return collection.getHouses();
    }

    @GET
    @Path("/house/{house_id}")
    @Produces({MediaType.APPLICATION_JSON})
    public MyJaxBean getSingleHouse(@PathParam("house_id") String houseId) {
        HouseCollection collection = HouseCollectionFactory.getInstance();
        if(!collection.houseExists(houseId))
            return null;
        boolean status = collection.getSingleStatus(houseId);
        String time = collection.getSingleTime(houseId);
//        JSONObject obj = new JSONObject();
//        obj.put("house_id", houseId);
//        obj.put("is_light_on", status ? "true" : "false");
//        obj.put("light_switch_time", time);
//        System.out.println(obj);
        MyJaxBean jxb = new MyJaxBean();
        jxb.time = time;
        jxb.status = status ? "true" : "false";
        jxb.houseId = houseId;
        return jxb;
    }
}
