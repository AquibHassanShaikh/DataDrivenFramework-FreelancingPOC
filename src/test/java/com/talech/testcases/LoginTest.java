package com.talech.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.talech.base.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void loginAdmin() throws InterruptedException {

		log.debug("Inside Dashboard");
		//driver.findElement(By.cssSelector(OR.getProperty("loginbtn"))).click();
		//driver.findElement(By.cssSelector(OR.getProperty("username"))).sendKeys("admin@possystem.com");
		//driver.findElement(By.cssSelector(OR.getProperty("pass"))).sendKeys("Test@123");
		 driver.findElement(By.xpath(OR.getProperty("signin1"))).click();
		 Thread.sleep(4000);

		 //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector(OR.getProperty("customertbtn")))));

		log.debug("Login Sucessfully Executed");

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(OR.getProperty("customertbtn1"))));

		
		

	}

}
