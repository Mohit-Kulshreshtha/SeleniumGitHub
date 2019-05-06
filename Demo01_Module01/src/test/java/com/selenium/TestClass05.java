package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass05 {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohit.kulshreshtha\\Desktop\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://jqueryui.com/resources/demos/slider/default.html");
		Thread.sleep(5000);
	}
	
	@Test
	public void method1() throws InterruptedException
	{
		WebElement spanButton = driver.findElement(By.xpath("//div[@id='slider']/span"));
		
		Actions act = new Actions(driver);
		act.dragAndDropBy(spanButton, 250, 0).build().perform();
		
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
