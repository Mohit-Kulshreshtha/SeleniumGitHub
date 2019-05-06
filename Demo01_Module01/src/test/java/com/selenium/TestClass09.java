package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass09 {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohit.kulshreshtha\\Desktop\\Drivers\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8081/TestMeApp/");
		Thread.sleep(5000);
	}
	
	@Test
	public void method1() throws InterruptedException
	{
		driver.findElement
		(By.xpath("//a[@href='RegisterUser.htm']"))
		.click();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor)
								driver;
		
		// Fetch domain name
		String domainName = 
				(String) js.executeScript
				("return document.domain");
		
		System.out.println("Domain name: " 
										+domainName);
		
		
		// Fetch title name
		String pageTitle = (String) 
				js.executeScript
				("return document.title");
		
		System.out.println("Page Title: " +pageTitle);
		
		
		// Generate alert box
		js.executeScript("alert('Hello');");
		Thread.sleep(5000);
		
		// Scrolling down to bottom
		js.executeScript
		("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(5000);
		
		
		
		
		
		WebElement registerBtn = 
				driver.findElement(By.name("Submit"));
		
		//High-lighter
		js.executeScript
		("arguments[0].style.border='7px dotted red'",
				registerBtn);
		Thread.sleep(5000);
		
		WebElement registerBtn1 = driver.findElement(By.name("Submit"));
		// Interact with element and Click the element
		js.executeScript("arguments[0].click();", registerBtn1);
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}

/*
Extra Notes:

// Scrolling down to specified point
	js.executeScript("window.scrollBy(0,50)");
	
*/

