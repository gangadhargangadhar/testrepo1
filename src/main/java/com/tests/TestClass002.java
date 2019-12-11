package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass002 {
	
	@Test
	public void signIn()
	{
		System.out.println("We are performing SignIn Functionality");
		Assert.assertTrue(true);
	}
	
	@Test(dependsOnMethods = {"signIn" })
	public void login()
	{
		System.out.println("ware are performing login functionality");
		Assert.assertTrue(false);
		
	}
	
	@Test(dependsOnMethods = {"login"} )
	public void logOut()
	{
		System.out.println("We are performing logout functionality");
	}
	
	}


