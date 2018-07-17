package commonsiotest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) {
		//要读取文件，就用inPutStream
		InputStream inStream = null;
		
		try {
			/*
			 * 方法一：
			inStream  = new FileInputStream("D:\\学习\\java\\项目\\掌上租\\zsz\\commonsiotest\\src\\commonsiotest\\test.properties");
			Properties prop = new Properties();
			prop.load(inStream);
			*/
			
			inStream = PropertiesTest.class.getClassLoader().getResourceAsStream("commonsiotest/test.properties");
			
			Properties prop = new Properties();
			prop.load(inStream);
			
			String user = prop.getProperty("user");
			String age = prop.getProperty("age");
			String sex = prop.getProperty("sex");
			
			System.out.println("我叫"+user+",是个"+sex+"，今年"+age+"岁啦");
			
		} catch (FileNotFoundException e) {

			System.out.println("没找到"+e.getMessage());
		}catch (IOException e) {
			System.out.println("读取出错"+e.getMessage());
		}finally{
			CloseFile.closeQuietly(inStream);
		}
		
		
	}
}
