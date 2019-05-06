package com.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass10 {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohit.kulshreshtha\\Desktop\\Drivers\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/upload/");
		Thread.sleep(5000);
	}
	
	@Test
	public void method1() throws InterruptedException
	{
		driver.findElement
		(By.id("uploadfile_0")).click();
		
		uploadFiles("C:\\Sample.png");
		
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	//File upload by Robot Class
    public void uploadFiles (String filePath) {
    	
        StringSelection stringSelection = 
        		new StringSelection(filePath);
        
        Clipboard clipboard = 
        		Toolkit.getDefaultToolkit().
        		getSystemClipboard();
        
        clipboard.setContents
        		(stringSelection, null);
 
        Robot robot = null;
 
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(150);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
    }
}
