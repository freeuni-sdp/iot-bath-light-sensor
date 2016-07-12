package ge.edu.freeuni.sdp.iot.sensor.bath_light;

import ge.edu.freeuni.sdp.iot.sensor.bath_light.controller.MyJaxBean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Babalah on 7/12/2016.
 */
public class TestHelper {
    public static MyJaxBean createRandomJXB(){
        MyJaxBean jxb = new MyJaxBean();
        Random rand = new Random();
        String id = ""+rand.nextInt(100);
        jxb.setHouseId(id);
        jxb.setStatus(""+rand.nextBoolean());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:s.SS'Z'");
        jxb.setTime(df.format(new Date()));
        return jxb;
    }

    public static MyJaxBean createIncompleteJXB(){
        MyJaxBean jxb = new MyJaxBean();
        Random rand = new Random();
        jxb.setStatus(""+rand.nextBoolean());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:s.SS'Z'");
        jxb.setTime(df.format(new Date()));
        return jxb;
    }
}
