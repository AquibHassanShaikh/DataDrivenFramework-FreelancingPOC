package com.talech.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.talech.base.TestBase;

public class AddCategoryTest extends TestBase {

	@Test(dataProvider = "getData")
	public void addCategoryTest(String category) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("addcategorybtn"))));
		driver.findElement(By.xpath(OR.getProperty("addcategorybtn"))).click();

		driver.findElement(By.cssSelector(OR.getProperty("categoryname"))).sendKeys(category);

		// driver.findElement(By.cssSelector(OR.getProperty("savebtncat"))).click();

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector(OR.getProperty("savebtncat")))).click().perform();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("addcategorybtn"))));

		log.debug("Category Added Sucessfully");
	}

	@DataProvider
	public Object[][] getData() {

		String sheetName = "AddCategory";
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
