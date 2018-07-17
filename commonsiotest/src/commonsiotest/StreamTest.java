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
			//������������󷵻�-1
			int i ;
			while((i=reader.read())>=0){
				char ch = (char)i;
				System.out.println(ch);
			}
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�û�ҵ�");
		}catch(IOException e){
			System.out.println("��ȡ�ļ�����");
		}finally{
			CloseFile.closeQuietly(reader);
			CloseFile.closeQuietly(inStream);
		}
		
		
	}
}
