package com.rupeng.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main1 {

	// 规则：1、一个类一个Logger对象。声明为static final
	// getLogger()这里一般用当前类的Class
	private static final Logger logger = LogManager.getLogger(Main1.class);

	public static void main(String[] args) {

		/*
		 * for(int i=0;i<1000000;i++) { logger.warn("这是警告！");
		 * logger.debug("我又运行啦"); logger.error("有错礼物！"); }
		 */
		logger.debug("ffffffffffffffffffff");
		logger.debug("aaaaa");
		String s = "abc";
		String s1 = "123";
		//logger.debug("用户输入了"+s);
		logger.debug("用户输入了{}  s1是{}",s,s1);
		try {
			int i = Integer.parseInt(s);
			logger.debug("用户输入的"+s+"成功转换为整数类型"+i);
		} catch (Exception ex) {
			logger.error("输入错误，转换失败",ex);
		}

	}

}
