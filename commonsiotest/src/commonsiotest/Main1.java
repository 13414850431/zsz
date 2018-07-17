package commonsiotest;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

public class Main1 {

	public static void main(String[] args) {
		
		String s = "d:\\temp\\2.txt";
		System.out.println("文件名："+FilenameUtils.getName(s));
		System.out.println("路径："+FilenameUtils.getFullPath(s));
		System.out.println("后缀"+FilenameUtils.getExtension(s));
		System.out.println("纯文件名："+FilenameUtils.getBaseName(s));			
	}
	
	public static void main1(String[] args) throws IOException {
		File srcDir = new File("E:\\快盘\\NextBig\\java课程\\JavaWeb项目（掌上租）\\开发包\\commons");
		File destDir = new File("D:\\temp\\ccc");
		//FileUtils.copyDirectory(srcDir, destDir);
		//FileUtils.cleanDirectory(destDir);
		//FileUtils.deleteDirectory(destDir);
		
		//String s = FileUtils.readFileToString(new File("d:\\temp\\1.txt"), "UTF-8");
		//System.out.println(s);
		List<String> list = FileUtils.readLines(new File("d:\\temp\\2.txt"), "UTF-8");
		for(int i=0;i<list.size();i++)
		{
			System.out.println(i+list.get(i));
		}
		
		URL url = new URL("http://www.rupeng.com");
		InputStream inStream = url.openStream();
		InputStreamReader inReader = new InputStreamReader(inStream,"UTF-8");
		BufferedReader buffReader= new BufferedReader(inReader);
		String line;
		while((line=buffReader.readLine())!=null)		
		{
			System.out.println(line);
		}
		
		buffReader.close();
		inReader.close();
		inStream.close();
		
		/*
		String html =  IOUtils.toString(url, "UTF-8");
		System.out.println(html);*/
	}

}
