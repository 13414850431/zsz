package com.rupeng.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.rupeng.aa.Calc;

public class CalcTest {
	
	//58%从来没写过单元测试
	//10%认真写过详细的单元测试

	//标注@BeforeClass的方法会在CalcTest运行之前执行一次
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
	}

	//标注@AfterClass的方法会在CalcTest运行之后执行一次
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
	}

	//@Before每个测试方法执行之前都会执行
	@Before
	public void setUp() throws Exception {
		System.out.println("@Before");
	}
	
	//@After是在测试方法执行之后都会执行
	@After
	public void tearDown() throws Exception {
		System.out.println("@After");
	}

	@Test
	public void test() {
		System.out.println("test");
		int i = Calc.add(1, 2);
		assertEquals(i, 3);//Assert.assertEquals  import static
		
		assertEquals(Calc.add(1, -1), 0);
		/*
		if(i!=3)
		{
			fail("失败");
		}*/
	}
	
	@Test
	public void test2()
	{
		System.out.println("test2");
		assertEquals(Calc.add(3, 5), 8);
	}

}
