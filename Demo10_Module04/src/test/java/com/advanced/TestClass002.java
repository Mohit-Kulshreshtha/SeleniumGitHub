package com.advanced;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestClass002 {

	@Test
	public void signIn()
	{
		System.out.println("We are performing SignIn functionality");
		Assert.assertTrue(true);
	}
	
	@Test(dependsOnMethods= { "signIn" })
	public void login()
	{
		System.out.println("We are performing Login functionality");
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods= { "login" })
	public void logOut()
	{
		System.out.println("We are performing LogOut functionality");
	}
}