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
			//FileUtils.copyDirectory(srcDir, destDir);//��srcDir�ļ����е����ݸ��Ƶ�destDir��
													//����destDir�����ڣ����Զ�����������	
			//FileUtils.cleanDirectory(srcDir);//��srcDir·������ļ����
			
			//FileUtils.deleteDirectory(srcDir);//��srcDirȫ��ɾ�ˣ��Ƚϲ���
			
			//FileUtils.copyFile(you, Me);//���ļ�you���Ƶ���Me��
			
			//FileUtils.copyFile(pic1,pic2);//��Ƭһ������
			
			//System.out.println(FileUtils.ONE_EB);//���Ϊ��1152921504606846976

		//} catch (IOException e) {
			
		//}
		
		//try {
			/*
			 *1.
			String me = FileUtils.readFileToString(Me,"UTF-8");
			System.out.println(me);                             //��ȡ�ļ�����String�����
			
			*2.
			List<String> list = FileUtils.readLines(Me,"UTF-8");
			for(int i =0;i<list.size();i++){					//һ��һ�еĶ�ȡ�ļ���װ��һ��list��
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
