package commonsiotest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Test {
	public static void main(String [] args){
		//File srcDir = new File("D:\\test\\inTest");
		File destDir = new File("D:\\test\\inTest2");
		File Me = new File("D:\\test\\me.txt");
		File you = new File("D:\\test\\you.txt");
		File pic1 = new File("D:\\test\\1.jpg");
		File pic2 = new File("D:\\test\\s.jpg");
		//try {
			//FileUtils.copyDirectory(srcDir, destDir);//把srcDir文件夹中的内容复制到destDir，
													//假如destDir不存在，会自动创建并复制	
			//FileUtils.cleanDirectory(srcDir);//把srcDir路径里的文件清除
			
			//FileUtils.deleteDirectory(srcDir);//把srcDir全部删了，比较残忍
			
			//FileUtils.copyFile(you, Me);//把文件you复制到了Me中
			
			//FileUtils.copyFile(pic1,pic2);//照片一样可以
			
			//System.out.println(FileUtils.ONE_EB);//结果为：1152921504606846976

		//} catch (IOException e) {
			
		//}
		
		//try {
			/*
			 *1.
			String me = FileUtils.readFileToString(Me,"UTF-8");
			System.out.println(me);                             //读取文件并以String输出来
			
			*2.
			List<String> list = FileUtils.readLines(Me,"UTF-8");
			for(int i =0;i<list.size();i++){					//一行一行的读取文件，装到一个list中
				System.out.println(i+list.get(i));
			}
			*/ 
			/*
			URL url = new URL("http://www.iqiyi.com/");
			InputStream inStream = url.openStream();
			
			InputStreamReader reader = new InputStreamReader(inStream,"UTF-8");
			BufferedReader buff = new BufferedReader(reader);
			
			while(buff.readLine()!=null){
				System.out.println(buff.readLine());
			}
			
			buff.close();
			reader.close();
			inStream.close();
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
}
