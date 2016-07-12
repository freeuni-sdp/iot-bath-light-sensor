package ge.edu.freeuni.sdp.iot.sensor.bath_light.model;


import com.microsoft.azure.storage.table.TableServiceEntity;
import ge.edu.freeuni.sdp.iot.sensor.bath_light.controller.MyJaxBean;

public class HouseEntity extends TableServiceEntity {
    private final static String PARTITION = "7";

    public HouseEntity(MyJaxBean house){
        this.partitionKey = PARTITION;
        this.rowKey = house.getHouseId();
        this.time = house.getTime();
        this.status = house.getHouseId();
    }

    public HouseEntity(){}

    public static String getPartitionValue(){
        return PARTITION;
    }

    String time;
    String status;

    public void setTime(String time){
        this.time = time;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getTime(){
        return this.time;
    }

    public String getStatus(){
        return this.status;
    }
}
