package com.rupeng.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.rupeng.aa.Compare;

public class CompareTest {

	@BeforeClass
	public static void setUpBeforeClass(){
		System.out.println("@beforeClass");
	}
	
	@AfterClass
	public static void tearDownAfterClass(){
		System.out.println("@AfterClass");
	}
	
	@Before
	public void setUp(){
		System.out.println("@before");
	}
	
	@After
	public void tearDown(){
		System.out.println("@After");
	}
	
	@Test
	public void test() {
		assertEquals(Compare.comm(4, 2), 4);
	}

}
