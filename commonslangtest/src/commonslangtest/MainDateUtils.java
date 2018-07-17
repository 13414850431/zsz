package commonslangtest;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.StopWatch;

public class MainDateUtils {

	public static void main(String[] args) throws ParseException, IOException {
		/*
		Date date = new Date();
		System.out.println(date);
		//Date d1 = DateUtils.addDays(date, -3);
		Date d1 = DateUtils.addHours(date, 30);
		
		System.out.println(d1);
		System.out.println(DateUtils.isSameDay(date, d1));

		Date d2 = DateUtils.parseDate("2008-08-08", "yyyy-MM-dd");
		System.out.println(d2);*/
		
		
		StopWatch sw  = new StopWatch();
		sw.start();
		
		for(int i=0;i<20;i++)
		{
			FileUtils.readLines(new File("d:\\soft\\QQPlayer_Setup_37_892.exe"));
		}
		
		
		sw.stop();
		System.out.println(sw.getTime());
	}

}
