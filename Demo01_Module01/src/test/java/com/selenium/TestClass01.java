package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass01 {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohit.kulshreshtha\\Desktop\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp");
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void method1() throws InterruptedException
	{
		Actions act = new Actions(driver);
		
		WebElement aboutUsLink = driver.findElement(By.linkText("AboutUs"));
		act.moveToElement(aboutUsLink).build().perform();
		Thread.sleep(5000);
		
		WebElement officesLink = driver.findElement(By.linkText("Our Offices"));
		act.moveToElement(officesLink).build().perform();
		Thread.sleep(5000);
		
		WebElement bangaloreLink = driver.findElement(By.linkText("Bangalore"));
		bangaloreLink.click();
		Thread.sleep(5000);
	}
	
	
}
