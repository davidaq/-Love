package cc.ccme.love.util;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	@SuppressLint("SimpleDateFormat")
	public static String dateToString(long date)
	{
		Date dat=new Date(date);  
        GregorianCalendar gc = new GregorianCalendar();   
        gc.setTime(dat);  
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
        String sb=format.format(gc.getTime());
        return sb;
	}
}
