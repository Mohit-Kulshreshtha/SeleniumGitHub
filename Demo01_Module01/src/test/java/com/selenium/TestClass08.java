package com.selenium;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass08 {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohit.kulshreshtha\\Desktop\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(5000);
	}
	
	@Test
	public void method1() throws InterruptedException
	{
		// Add a new cookie in current domain
		Cookie name = new Cookie("mycookie", "12aw34156fr");
		driver.manage().addCookie(name);
		
		// Display all the cookies in the current domain
		Set<Cookie> listOfCookies = driver.manage().getCookies();
		
		for(Cookie c:listOfCookies)
		{
			System.out.println(c);
		}
		
		// Display a specific cookie
		System.out.println(driver.manage().getCookieNamed("mycookie"));
		
		// Delete a specific cookie
		driver.manage().deleteCookieNamed("mycookie");
		
		// Display a specific cookie "mycookie"
		System.out.println(driver.manage().getCookieNamed("mycookie"));
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
