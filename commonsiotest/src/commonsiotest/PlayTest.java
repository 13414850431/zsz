package commonsiotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class PlayTest {
	public static void main(String[] args) {
		//输入一个链接
		System.out.println("请输入一个网址:");
		String url = null;
		Scanner scan = new Scanner(System.in);
		url = scan.nextLine();
		System.out.println(url);
		
		//拿到这个url的内容
		InputStream inStream = null;
		InputStreamReader reader = null;
		BufferedReader buffReader = null;
		
		URL netUrl;
		
		byte[] bytes = new byte[50];
		List<String> picUrls = new ArrayList<String>();  
		
		try {
			netUrl = new URL(url);
			inStream = netUrl.openStream();
			reader = new InputStreamReader(inStream,"UTF-8");
			buffReader = new BufferedReader(reader);
			
			while(buffReader.read()>=0){
				System.out.println(buffReader.readLine());
				/*
				buffReader.readLine().split("<img*>");
				picUrls.add()*/
			}
			
			
			
		} catch (MalformedURLException e1) {
			System.out.println("网址格式不对"+e1.getMessage());
		}catch (IOException e) {
			System.out.println("读取网址出错"+e.getMessage());
		} 
		finally{
			CloseFile.closeQuietly(buffReader);
			CloseFile.closeQuietly(reader);
			CloseFile.closeQuietly(inStream);
		}
		
		
		
		
			
			
	}
}
