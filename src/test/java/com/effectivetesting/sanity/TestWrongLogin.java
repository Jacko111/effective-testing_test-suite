package com.effectivetesting.sanity;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWrongLogin {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("localhost:5000");
	}
	
	@Test
	public void TestWrongLogin() {
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("email")).sendKeys("no-reply@gmail.com");
		driver.findElement(By.id("password")).sendKeys("nopass");
		driver.findElement(By.id("btn-submit")).click();
		
		String currentMessage = driver.findElement(By.xpath("//*[@id=\"content_title\"]/form/div[1]/div/span[2]")).getText();
		assertEquals("Invalid email or password.", currentMessage);
		
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
