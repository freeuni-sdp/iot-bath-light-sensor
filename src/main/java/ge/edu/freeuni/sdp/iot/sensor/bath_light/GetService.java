package ge.edu.freeuni.sdp.iot.sensor.bath_light;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Babalah on 6/24/2016.
 */
@Path("status/house/{house_id}")
public class GetService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Message get(@PathParam("house_id") String houseId) {
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
        Message msg = new Message();
        msg.setTime(time);
        msg.setStatus(status ? "true" : "false");
        msg.setHouseId(houseId);
        return msg;
    }
}
