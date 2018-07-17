package commonsiotest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutPutStreamTest {
	public static void main(String[] args) {
		OutputStream fos = null;
		byte[] bytes = "你好啊，林国龙".getBytes();//新建并写入了一个文件，没乱码
		
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
