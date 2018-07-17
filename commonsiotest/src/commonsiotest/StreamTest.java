package commonsiotest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class StreamTest {
	public static void main(String[] args) {
		InputStream inStream = null;
		Reader reader = null;
		
		try {
			inStream = new FileInputStream("D:\\test\\me.txt");
			reader = new InputStreamReader(inStream,"UTF-8");
			//当读到流的最后返回-1
			int i ;
			while((i=reader.read())>=0){
				char ch = (char)i;
				System.out.println(ch);
			}
		} catch (FileNotFoundException e) {
			System.out.println("文件没找到");
		}catch(IOException e){
			System.out.println("读取文件错误");
		}finally{
			CloseFile.closeQuietly(reader);
			CloseFile.closeQuietly(inStream);
		}
		
		
	}
}
