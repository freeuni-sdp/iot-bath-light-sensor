package ge.edu.freeuni.sdp.iot.sensor.bath_light;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by Babalah on 6/24/2016.
 */
@Path("status/house/{house_id}")
public class GetService {

    @GET
    public Response get(@PathParam("house_id") String houseId) {
        HouseCollection collection = HouseCollectionFactory.getInstance();
        boolean status = collection.getSingleStatus(houseId);
        String time = collection.getSingleTime(houseId);
        JSONObject obj = new JSONObject();
        obj.put("house_id", houseId);
        obj.put("is_light_on", status ? "true" : "false");
        obj.put("light_switch_time", time);
        return Response.status(200).entity(obj).build();
    }
}
