package tweets.cli;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	
}