package com.rupeng.test;

import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

//loadOnStartup表示：网站启动的时候自动初始化QuartzInitServlet（即init被调用）
@WebServlet(value = "/QuartzInitServlet", loadOnStartup = 1)
public class QuartzInitServlet extends HttpServlet {
	
	private static final Logger logger = LogManager.getLogger(QuartzInitServlet.class);
	@Override
	public void init() throws ServletException {
		super.init();
		
		try
		{
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			JobDetail job = JobBuilder.newJob(TestJob.class).build();
			CronScheduleBuilder cronScheduleBuilder = 
					CronScheduleBuilder.cronSchedule("0 0 0/1 * * ? ").inTimeZone(TimeZone.getTimeZone("GMT+08:00"));
					//CronScheduleBuilder.cronSchedule("10/5 * * * * ? ").inTimeZone(TimeZone.getTimeZone("GMT+08:00"));//从10秒开始，每隔5秒执行一次
					//CronScheduleBuilder.cronSchedule("45 53 23 * * ? ").inTimeZone(TimeZone.getTimeZone("GMT+08:00"));//每天23:53:45
					//CronScheduleBuilder.dailyAtHourAndMinute(23, 48).inTimeZone(TimeZone.getTimeZone("GMT+08:00"));
			CronTrigger trigger = TriggerBuilder.newTrigger().withSchedule(cronScheduleBuilder).build();
			scheduler.scheduleJob(job, trigger);
			scheduler.start();//不要忘了启动
		}
		catch(Throwable ex)
		{
			logger.error("定时任务安排出错",ex);
		}
	}
}
