package commonsiotest;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class BufferedWriterTest {
	public static void main(String[] args) {
		OutputStream fos = null;
		OutputStreamWriter writer = null;
		BufferedWriter buffWriter = null;
		
		try {
			fos = new FileOutputStream("D:\\test\\test2.txt");
			
			writer = new OutputStreamWriter(fos);
			
			buffWriter = new BufferedWriter(writer);
			
			buffWriter.write("你个煞笔哦傻逼");
			
			buffWriter.newLine();
			
			buffWriter.write("是啊");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			CloseFile.closeQuietly(buffWriter);//顺序要注意,先关依赖的，再关被依赖的
			
			CloseFile.closeQuietly(writer);
			
			CloseFile.closeQuietly(fos);
			
		}
		
		
	}
}
