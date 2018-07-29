package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcessingTime {
	
	public String processTime(String startDate,String endDate)
	{
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		 
		Date d1 = null;
		Date d2 = null;
		String processTime =null;
		try {
			d1 = format.parse(startDate);
			d2 = format.parse(endDate);
 
			//in milliseconds
			long diff = d2.getTime() - d1.getTime();
 
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
 
			System.out.print(diffDays + " days, ");
			System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
			System.out.print(diffSeconds + " seconds.");
			
			processTime = diffDays+" days, "+diffHours+" hours, "+ diffMinutes+" minutes, "+diffSeconds+"seconds.";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return processTime;
	}
}
