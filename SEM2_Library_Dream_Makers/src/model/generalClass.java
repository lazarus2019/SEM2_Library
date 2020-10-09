package model;

import java.util.Calendar;
import java.util.Date;

public class generalClass {
	
	public static Date getCurrentDate() {
		return new Date(); 
	}
	
	public static Date plusDate(Date date) {
		Date dt = date;
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 5);
		dt = c.getTime();
		return dt;
	}
}
