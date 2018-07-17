package commonsiotest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("D:\\test\\mkdir\\aa\\a.txt");
			byte[] bytes = new byte[2];
			
			while(fis.read(bytes)>0){//执行完下次执行的时候就从上次读完的位置开始
				String s = new String(bytes);
				System.out.println(s);
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("文件没找到啊");
		}
		 catch (IOException e1) {
			System.out.println("读入错误");
		}
		finally{
			if(fis!=null){ //如果fis没有复制，为空，会出现NullPointException
				try {
					fis.close();
				} catch (IOException e) {
					
				}
			}
		}
	}
}
