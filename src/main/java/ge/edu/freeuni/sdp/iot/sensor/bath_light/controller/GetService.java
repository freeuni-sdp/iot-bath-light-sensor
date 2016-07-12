package ge.edu.freeuni.sdp.iot.sensor.bath_light.controller;

import com.microsoft.azure.storage.StorageException;
import ge.edu.freeuni.sdp.iot.sensor.bath_light.model.HouseEntity;
import ge.edu.freeuni.sdp.iot.sensor.bath_light.model.Repository;
import ge.edu.freeuni.sdp.iot.sensor.bath_light.model.RepositoryFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Babalah on 6/24/2016.
 */
@Path("status")
public class GetService {

    public Repository getRepository() throws StorageException {
        return RepositoryFactory.create();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<MyJaxBean> getAllHouses() {
        Iterable<HouseEntity> iter = null;
        try {
            Repository repository = getRepository();
            iter = repository.getAll();
        } catch (StorageException e) {
            e.printStackTrace();
        }
        List<MyJaxBean> list = new ArrayList<>();
        for(HouseEntity house : iter){
            MyJaxBean bean = new MyJaxBean();
            bean.setHouseId(house.getRowKey());
            bean.setStatus(house.getStatus().equals("on") ? "true" : "false");
            bean.setTime(house.getTime());
            list.add(bean);
        }

        return list;
    }

    @GET
    @Path("/house/{house_id}")
    @Produces({MediaType.APPLICATION_JSON})
    public MyJaxBean getSingleHouse(@PathParam("house_id") String houseId) {
        HouseEntity house = null;
        try {
            Repository repository = getRepository();
            house = repository.find(houseId);
            System.out.println(house.getStatus() + " " + house.getTime());
        } catch (StorageException e) {
            e.printStackTrace();
        }

        MyJaxBean jxb = new MyJaxBean();
        jxb.setStatus(house.getStatus().equals("on") ? "true" : "false");
        jxb.setTime(house.getTime());
        jxb.setHouseId(houseId);
        return jxb;
    }
}
