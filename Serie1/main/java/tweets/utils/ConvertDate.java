package tweets.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by z003crvk on 27-10-2014.
 */

public class ConvertDate {

    public static long getInstant(String str) {
        Date d = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd'T'kk:mm:ss");
        try {
            d = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance(); c.setTime(d);
        return c.getTimeInMillis()/1000;
    }

    public static void main(String[] args) {
        System.out.println(getInstant("2014-06-30T02:11:03") + " seconds");
        System.out.println(getInstant("2014-06-30T05:04:35") + " seconds");
    }
}