package commonsiotest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) {
		//Ҫ��ȡ�ļ�������inPutStream
		InputStream inStream = null;
		
		try {
			/*
			 * ����һ��
			inStream  = new FileInputStream("D:\\ѧϰ\\java\\��Ŀ\\������\\zsz\\commonsiotest\\src\\commonsiotest\\test.properties");
			Properties prop = new Properties();
			prop.load(inStream);
			*/
			
			inStream = PropertiesTest.class.getClassLoader().getResourceAsStream("commonsiotest/test.properties");
			
			Properties prop = new Properties();
			prop.load(inStream);
			
			String user = prop.getProperty("user");
			String age = prop.getProperty("age");
			String sex = prop.getProperty("sex");
			
			System.out.println("�ҽ�"+user+",�Ǹ�"+sex+"������"+age+"����");
			
		} catch (FileNotFoundException e) {

			System.out.println("û�ҵ�"+e.getMessage());
		}catch (IOException e) {
			System.out.println("��ȡ����"+e.getMessage());
		}finally{
			CloseFile.closeQuietly(inStream);
		}
		
		
	}
}
