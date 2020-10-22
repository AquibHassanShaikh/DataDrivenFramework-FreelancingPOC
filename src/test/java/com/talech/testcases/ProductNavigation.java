package com.talech.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.talech.base.TestBase;

public class ProductNavigation extends TestBase {
		
	@Test
	public void productTest() {
		
		driver.findElement(By.xpath(OR.getProperty("productbtn"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("categorybtn"))));

	
		driver.findElement(By.xpath(OR.getProperty("categorybtn"))).click();
		
	}
	

}
