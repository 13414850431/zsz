package commonslangtest;

import org.apache.commons.lang3.ArrayUtils;

public class Main1 {

	public static void main(String[] args) {
		int[] nums={3,5,8};
		int[] newNums = ArrayUtils.add(nums,999);
		int[] nums3= ArrayUtils.addAll(nums,333,555,66);
		int[] nums4=new int[0];
		int[] nums5=null;
		
		/*
		for(int i : nums)
		{
			System.out.println(i);
		}*/
		
		/*
		System.out.println(ArrayUtils.toString(nums));
		System.out.println(ArrayUtils.toString(newNums));
		System.out.println(ArrayUtils.toString(nums3));
		System.out.println(ArrayUtils.contains(nums3, 555));
		System.out.println(ArrayUtils.isEmpty(nums3));
		System.out.println(ArrayUtils.isEmpty(nums4));
		System.out.println(ArrayUtils.isEmpty(nums5));*/
		
		//Integer[] nums9=nums;//java中原始类型的数组和包装类型的数组之间无法直接赋值
		//Integer[] nums9= toObject(nums);
		Integer[] nums9=ArrayUtils.toObject(nums);
		System.out.println(ArrayUtils.toString(nums9));
		
		//int[] nums10=(int[])nums9;
		int[] nums10= ArrayUtils.toPrimitive(nums9);
	}
	
	static Integer[] toObject(int[] nums)
	{
		Integer[] objs = new Integer[nums.length];
		for(int i=0;i<nums.length;i++)
		{
			objs[i] = nums[i];//装箱
		}
		return objs;
	}

}
