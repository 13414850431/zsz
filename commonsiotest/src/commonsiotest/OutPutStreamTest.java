package commonsiotest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutPutStreamTest {
	public static void main(String[] args) {
		OutputStream fos = null;
		byte[] bytes = "��ð����ֹ���".getBytes();//�½���д����һ���ļ���û����
		
		try {
			fos = new FileOutputStream("D:\\test\\test.txt");
			fos.write(bytes);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			CloseFile.closeQuietly(fos);
		}
		
	}
}
