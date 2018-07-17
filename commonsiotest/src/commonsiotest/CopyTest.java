package commonsiotest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class CopyTest {

	
	
	public static void copy(InputStream inStream,OutputStream outStream,int bufferSize) throws IOException{
		//先进行参数有效性检查
		if(inStream==null||outStream==null){
			throw new IllegalArgumentException("输入流输出流不能为空");
		}
		if(bufferSize<=0){
			throw new IllegalArgumentException("bufferSize不能为小于等于0");
		}
		byte[] bytes = new byte[bufferSize];
		int len;
		
		while((len=inStream.read(bytes))>0){
			outStream.write(bytes,0,len);
		}
		
		
	}
	
	public static void main(String[] args) {
		InputStream inStream = null;
		OutputStream outStream = null;
		
		try {
			URL url = new URL("http://www.baidu.com/img/bd_logo1.png");
			inStream= url.openStream();
			outStream = new FileOutputStream("D:\\test\\baidu.png");
			copy(inStream, outStream, 100);
			System.out.println("下载成功");
			
		} catch (MalformedURLException e) {
			System.out.println("网址格式不正确"+e.getMessage());
		}catch (IOException e) {
			System.out.println("下载失败"+e.getMessage());
		}
		  
	}
	
}
