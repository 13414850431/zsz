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
			
			while(fis.read(bytes)>0){//ִ�����´�ִ�е�ʱ��ʹ��ϴζ����λ�ÿ�ʼ
				String s = new String(bytes);
				System.out.println(s);
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�û�ҵ���");
		}
		 catch (IOException e1) {
			System.out.println("�������");
		}
		finally{
			if(fis!=null){ //���fisû�и��ƣ�Ϊ�գ������NullPointException
				try {
					fis.close();
				} catch (IOException e) {
					
				}
			}
		}
	}
}
