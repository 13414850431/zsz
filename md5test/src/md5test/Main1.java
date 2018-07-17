package md5test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main1 {

	public static void main(String[] args) throws IOException {
		//String md5 = calcMD5("abc123");
		//System.out.println(md5);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("D:\\soft\\UltraCompare.rar");
			
			String md5 = calcMD5(fis);
			System.out.println(md5);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			fis.close();
		}
	}

	
	public final static String calcMD5(String s)
	{
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try
		{
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++)
			{
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public final static String calcMD5(InputStream inStream)
	{
		MessageDigest digest = null;
		byte buffer[] = new byte[1024];
		int len;
		try
		{
			digest = MessageDigest.getInstance("MD5");
			while ((len = inStream.read(buffer, 0, 1024)) != -1)
			{
				digest.update(buffer, 0, len);
			}
		} catch (NoSuchAlgorithmException | IOException e)
		{
			throw new RuntimeException(e);
		}
		BigInteger bigInt = new BigInteger(1, digest.digest());
		return bigInt.toString(16);
	}
}
