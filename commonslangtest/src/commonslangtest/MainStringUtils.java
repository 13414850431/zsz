package commonslangtest;

import org.apache.commons.lang3.StringUtils;

public class MainStringUtils {

	public static void main(String[] args) {
		/*
		String s1 = null;
		String s2 = "";
		String s3 = null;
		System.out.println(StringUtils.isEmpty(s1));
		System.out.println(StringUtils.isEmpty(s2));
		System.out.println(StringUtils.isEmpty(s3));
		
		//if(s1.length()==0)//调用s1指向对象的length( ）方法
		//if(s1.equals(""))
		if(StringUtils.isEmpty(s1))
		{
			System.out.println("s1为空");
		}*/
		/*
		String[] strs = {"rupeng","qq","ali"};
		String s = StringUtils.join(strs, '|');
		
		
		
		System.out.println(s);*/
		
		String str= "如鹏网";
		//String t = StringUtils.left(s,6);
		//String t = s.substring(0,6);
		//System.out.println(t);
		String t = StringUtils.leftPad(str, 10,'*');
		System.out.println(t);
		
		String s1 = StringUtils.repeat('a', 5);
		System.out.println(s1);
		

	}

}
