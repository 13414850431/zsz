package commonsiotest;

import java.io.File;

public class Test2 {
	public static void main(String[] args) {
		//File file = new File("D:\\test","aa.txt");//File(String parent ,String child); �����ƶ��ĸ��ļ��ж�������ļ������ļ��д�������
		
		//System.out.println(file.toString());
		File file = new File("D:\\test\\mkdir\\aa");//�����ļ���
		//file.mkdir();//�����ƶ�Ŀ¼��������ڣ��Ͳ�������Ҫ�Ǹ�Ŀ¼�����ھͲ������������
		
		//file.mkdirs();//�����ƶ�Ŀ¼��������ڣ��Ͳ�������Ҫ�Ǹ�Ŀ¼�����ڣ�������Ŀ¼
		
		//System.out.println(file.isDirectory());//�ж϶����Ƿ����ļ���
		
		//System.out.println(file.exists());//�ж��Ƿ����
		
		//file.delete();//��ΪD:\\test\\mkdir\\aa�´������ݣ�Ҫ������ļ����µ����ݲ���ɾ����ֱ��ɾ�������Ż���վ
		
		//System.out.println(file.exists());//�ж��Ƿ����
		
		/*
		System.out.println(file.canRead());//�ɶ�
		System.out.println(file.canWrite());//��д
		System.out.println(file.canExecute());//��ִ��
		*/
		
		//System.out.println(file.getAbsolutePath());//�����D:\test\mkdir\aa
		
		//System.out.println(file.length());//�������ļ��������ļ�������û����
		
		System.out.println(file.list());
		
	}
}
