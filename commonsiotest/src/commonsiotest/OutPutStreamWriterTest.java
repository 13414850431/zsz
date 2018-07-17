package commonsiotest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class OutPutStreamWriterTest {
	public static void main(String[] args) {
		OutputStream outStream = null;
		
		OutputStreamWriter writer = null;
		
		try {
			outStream = new FileOutputStream("D:\\test\\test1.txt");
			
			writer = new OutputStreamWriter(outStream);
			
			writer.write("你是个人吗\n");
			
			writer.write("是的");
			
			writer.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			CloseFile.closeQuietly(outStream);
			
		}
		
		
		
	}
}
