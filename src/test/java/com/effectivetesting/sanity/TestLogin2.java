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

public class TestLogin2 {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("localhost:5000");
	}
	
	@Test
	public void TestLoginProperly() {
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("email")).sendKeys("admin1@gmail.com");
		driver.findElement(By.id("password")).sendKeys("admin1");
		driver.findElement(By.id("btn-submit")).click();
		
		String currentMessage = driver.findElement(By.xpath("//*[@id=\"notification\"]/span")).getText();
		
		assertEquals("Successfully logged in as admin1@gmail.com.", currentMessage);
		
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
