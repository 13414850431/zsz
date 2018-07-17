import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main1 {

	public static void main(String[] args) {
	
		int[] nums = {3,8,9,1};
		System.out.println(toString(nums));

		String[] strs = {"afasdf","rupeng","qqq"};
		System.out.println(toString(strs));
		
		List<Object> list = toList(strs);
		for(Object obj : list)
		{
			System.out.println(obj);
		}
	}
	
	private static List<Object> toList(Object arrays)
	{
		if(arrays.getClass().isArray()==false)
		{
			throw new IllegalArgumentException("传进来的不是数组");
		}
		
		List<Object> list = new ArrayList<Object>();
		int len = Array.getLength(arrays);
		for(int i=0;i<len;i++)
		{
			Object item = Array.get(arrays, i);//
			list.add(item);
		}
		return list;
		
		
	}
	
	/*
	
	private static String toString(int[] arrays)
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arrays.length;i++)
		{
			sb.append(arrays[i]);
			if(i!=arrays.length-1)
			{
				sb.append(",");
			}
		}
		return sb.toString();
	}*/

	private static String toString(Object  arrays)
	{
		if(!arrays.getClass().isArray())//�жϴ������������ǲ�����������
		{
			throw new IllegalArgumentException("����Ĳ�������");
		}
		
		StringBuilder sb = new StringBuilder();
		int len = Array.getLength(arrays);//�������ĳ���  arrays.length
		for(int i=0;i<len;i++)
		{
			sb.append(Array.get(arrays, i));//��ȡ�����i��Ԫ�ص�ֵ  arrays[i];
			if(i!=len-1)
			{
				sb.append(",");
			}
		}
		return sb.toString();
	}
}
