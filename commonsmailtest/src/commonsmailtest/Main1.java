package commonsmailtest;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class Main1 {

	public static void main(String[] args) throws EmailException {
		HtmlEmail email = new HtmlEmail();//发送html格式邮件
		email.setHostName("smtp.163.com");
		email.setCharset("UTF-8");
		// 登陆邮件服务器的用户名和密码
		email.setAuthentication("rupengtest01@163.com", "123rupeng");
		email.addTo("rupengtest01@163.com");
		email.setFrom("rupengtest01@163.com");
		email.setSubject("管理报表统计");
		email.setMsg("你好，测试一下，<a href='http://www.rupeng.com'>点击访问如鹏网</a>");
		email.send();

	}

}
