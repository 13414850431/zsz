package commonsmailtest;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class Main1 {

	public static void main(String[] args) throws EmailException {
		HtmlEmail email = new HtmlEmail();//����html��ʽ�ʼ�
		email.setHostName("smtp.163.com");
		email.setCharset("UTF-8");
		// ��½�ʼ����������û���������
		email.setAuthentication("rupengtest01@163.com", "123rupeng");
		email.addTo("rupengtest01@163.com");
		email.setFrom("rupengtest01@163.com");
		email.setSubject("������ͳ��");
		email.setMsg("��ã�����һ�£�<a href='http://www.rupeng.com'>�������������</a>");
		email.send();

	}

}
