package ge.edu.freeuni.sdp.iot.sensor.bath_light.controller;

import com.microsoft.azure.storage.StorageException;
import ge.edu.freeuni.sdp.iot.sensor.bath_light.model.CloudRepository;
import ge.edu.freeuni.sdp.iot.sensor.bath_light.model.HouseEntity;
import ge.edu.freeuni.sdp.iot.sensor.bath_light.model.Repository;
import ge.edu.freeuni.sdp.iot.sensor.bath_light.model.RepositoryFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Path("status")
public class PostService {

    @Context
    private UriInfo uriInfo;

    public Repository getRepository() throws StorageException {
        return RepositoryFactory.create();
    }

    @POST
    @Consumes("application/json")
    public Response post(final MyJaxBean input) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:s.SS'Z'");
        input.setTime(df.format(new Date()));
        System.out.println("houseId = " + input.getHouseId() + ", time = " + input.getTime() + ", status = " + input.getStatus());
        if (input.getHouseId() == null) {
            return Response.noContent().build();
        }
        try {
            Repository repository = getRepository();
            repository.insertOrUpdate(new HouseEntity(input));
            final URI createdUri = uriInfo.getAbsolutePathBuilder().path(input.getHouseId()).build();
            return Response.created(createdUri).build();
        } catch (StorageException | ProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
