package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass07 {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohit.kulshreshtha\\Desktop\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8081/TestMeApp/login.htm");
		Thread.sleep(5000);
	}
	
	@Test
	public void method1() throws InterruptedException
	{
		WebElement userNameTxtBox = driver.findElement(By.id("userName"));
		
		Point p = userNameTxtBox.getLocation();
		System.out.println("The X-Y coordinates are: " + p.x + "-" + p.y);
		
		Dimension d = userNameTxtBox.getSize();
		System.out.println("Dimensions are: " + d.height + "-" + d.width);
		
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
