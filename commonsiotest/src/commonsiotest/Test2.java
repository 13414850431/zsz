package commonsiotest;

import java.io.File;

public class Test2 {
	public static void main(String[] args) {
		//File file = new File("D:\\test","aa.txt");//File(String parent ,String child); 根据制定的父文件夹对象和子文件或者文件夹创建对象。
		
		//System.out.println(file.toString());
		File file = new File("D:\\test\\mkdir\\aa");//创建文件夹
		//file.mkdir();//创建制定目录，如果存在，就不创建，要是父目录不存在就不会继续创建。
		
		//file.mkdirs();//创建制定目录，如果存在，就不创建，要是父目录不存在，创建父目录
		
		//System.out.println(file.isDirectory());//判断对象是否是文件夹
		
		//System.out.println(file.exists());//判断是否存在
		
		//file.delete();//因为D:\\test\\mkdir\\aa下存在内容，要先清楚文件夹下的内容才能删除，直接删除，不放回收站
		
		//System.out.println(file.exists());//判断是否存在
		
		/*
		System.out.println(file.canRead());//可读
		System.out.println(file.canWrite());//可写
		System.out.println(file.canExecute());//可执行
		*/
		
		//System.out.println(file.getAbsolutePath());//结果：D:\test\mkdir\aa
		
		//System.out.println(file.length());//假如是文件，发现文件不存在没报错
		
		System.out.println(file.list());
		
	}
}
