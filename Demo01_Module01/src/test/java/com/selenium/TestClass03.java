package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass03 {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohit.kulshreshtha\\Desktop\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		Thread.sleep(5000); 
	}
	
	@Test
	public void method1() throws InterruptedException
	{
		
		WebElement dragElement = driver.findElement(By.xpath("//li[@id='credit2']/a"));
		WebElement dropElement = driver.findElement(By.xpath("//ol[@id='bank']/li"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(dragElement, dropElement).build().perform();
		
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
