package com.tests;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(com.listeners.TestListners.class)
public class TestClass001 {
	@Test
	public void Login1()
	{
		System.out.println("Hello..");
		org.testng.Assert.assertTrue(true);
	}
	@Test()
	public void Login2()
	{
		System.out.println("Hi");
		org.testng.Assert.assertTrue(false);
	}
	
	
	@Test()
	public void Login3()
	{
		throw new SkipException (" Don't say bye");
	}
	
	
	@Test(groups="smoke")
	public void method1()
	{
		System.out.println("test method 1 - smoke test");
	}
	
	@Test(groups="smoke")
	
	public void method2()
	{
		System.out.println("test method 2 - smoke test");
	}
	
	@Test(groups="Regression")
	public void method3()
	{
		System.out.println("test method 3 - regression test");
	}
	
	@Test(groups="Regression")
	public void method4()
	{
		System.out.println("test method 4 - regression test");
	}
	
	@Test(groups= {"Smoke","Regression"})
	public void method5()
	{
		System.out.println("test method 5 - Both test");
	}
	
	
	
	}
	


