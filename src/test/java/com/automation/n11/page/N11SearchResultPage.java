package com.automation.n11.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class N11SearchResultPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private String clickedProductName;
	
	private static final String SEARCH_RESULTS_XPATH ="//div [@id='view']/ul/li";
	
	@SuppressWarnings("unused")
	private N11SearchResultPage() {
	}
	
	public N11SearchResultPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}
	
	public void clickFirstRecord() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH_RESULTS_XPATH)));
		clickedProductName = driver.findElements(By.xpath(SEARCH_RESULTS_XPATH)).get(0).findElement(By.className("plink")).findElement(By.tagName("h3")).getText();
		driver.findElements(By.xpath(SEARCH_RESULTS_XPATH)).get(0).findElement(By.xpath("//a[@class='textImg moreOptBtn']")).click();
	}

	public boolean isValidProduct() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nameHolder']")));
		String productName = driver.findElement(By.xpath("//div[@class='nameHolder']")).findElement(By.tagName("h1")).getText();
		if (!clickedProductName.equals(productName)) {
			return false;
		}
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.className("logoutBtn")));
		return true;
	}
}
