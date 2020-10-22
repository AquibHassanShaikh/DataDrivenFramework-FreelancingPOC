package com.talech.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.talech.base.TestBase;

public class AddNewCustomerTest extends TestBase {

	@Test(dataProvider = "getData")
	public void addNewCustomer(String firstName, String lastName, String company, String birthdate, String customerid,
			String email, String mobileno, String address, String city, String zip, String country, String loyaltycard,
			String customernote) throws InterruptedException {

		driver.findElement(By.xpath(OR.getProperty("customerbtn1"))).click();

		log.debug("Sucessfully Navigated to Customer Tab");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(OR.getProperty("customertbtn")))));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("addbtn"))));
		
		driver.findElement(By.xpath(OR.getProperty("addbtn"))).click();

		// js.executeScript("argument[0].click();",OR.getProperty("addbtn"));

		driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(firstName);
		driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(lastName);
		driver.findElement(By.cssSelector(OR.getProperty("company"))).sendKeys(company);
		driver.findElement(By.cssSelector(OR.getProperty("birthdate"))).sendKeys(birthdate);
		driver.findElement(By.cssSelector(OR.getProperty("customerid"))).sendKeys(customerid);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OR.getProperty("email"))));
		
		driver.findElement(By.cssSelector(OR.getProperty("email"))).sendKeys(email);

		driver.findElement(By.cssSelector(OR.getProperty("mobileno"))).sendKeys(mobileno);
		WebElement down = driver.findElement(By.cssSelector((OR.getProperty("customernote"))));

		js.executeScript("arguments[0].scrollIntoView(true)", down);
		
		driver.findElement(By.cssSelector(OR.getProperty("address"))).sendKeys(address);
		driver.findElement(By.cssSelector(OR.getProperty("city"))).sendKeys(city);
		driver.findElement(By.cssSelector(OR.getProperty("zip"))).sendKeys(zip);
		driver.findElement(By.cssSelector(OR.getProperty("country"))).sendKeys(country);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("loyaltycard"))));

		driver.findElement(By.xpath(OR.getProperty("loyaltycard"))).sendKeys(loyaltycard);
		driver.findElement(By.cssSelector(OR.getProperty("customernote"))).sendKeys(customernote);

		// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OR.getProperty("savebtn"))));

		// WebElement savebtn =
		// driver.findElement(By.xpath(OR.getProperty("savebtn1")));

		// JavascriptExecutor js = (JavascriptExecutor)driver;

		// js.executeScript("argument[0].click()",savebtn);
		

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OR.getProperty("savebtn"))));

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector(OR.getProperty("savebtn")))).click().perform();

		// driver.findElement(By.cssSelector(OR.getProperty("savebtn"))).click();

		//Thread.sleep(2500);
		
		

		log.debug("Customer Added Sucessfully");
	}

	@DataProvider
	public Object[][] getData() {

		String sheetName = "AddCustomerTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			for (int colNum = 0; colNum < cols; colNum++) {

				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);

			}

		}

		return data;
	}

}
