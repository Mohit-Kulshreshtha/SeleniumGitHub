package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utility.Class_ScreenShot;

public class TestClass06 {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohit.kulshreshtha\\Desktop\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8081/TestMeApp/");
		Thread.sleep(5000);
	}
	
	@Test
	public void method1() throws InterruptedException
	{
		try {
			driver.findElement(By.xpath("//a[@href='login.htm']")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("UserName")).sendKeys("Admin");
			Thread.sleep(5000);
			driver.findElement(By.id("password")).sendKeys("Password456");
			Thread.sleep(5000);
			driver.findElement(By.name("Login")).click();
			Thread.sleep(5000);
		}
		catch (Exception e) {
			System.out.println("Exception happened: " + e.getMessage());
			Class_ScreenShot.captureScreen(driver);
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
