package ge.edu.freeuni.sdp.iot.sensor.bath_light.controller;

/**
 * Created by Babalah on 6/24/2016.
 */
public class HouseCollectionFactory {
    private static HouseCollection collection = null;

    public static HouseCollection getInstance(){
        if (collection == null){
            collection = new HouseCollection();
        }
        return collection;
    }
}
