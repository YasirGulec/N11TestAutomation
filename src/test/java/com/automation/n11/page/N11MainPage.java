package com.automation.n11.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class N11MainPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	private static final String SEARCH_INPUT_ID = "searchData";
	private static final String SEARCH_BUTTON_CLASS_NAME ="searchBtn";
	
	@SuppressWarnings("unused")
	private N11MainPage() {
	}
	
	public N11MainPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}
	
	public void enterSearchInput () {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SEARCH_INPUT_ID)));
		driver.findElement(By.id(SEARCH_INPUT_ID)).clear();
		driver.findElement(By.id(SEARCH_INPUT_ID)).sendKeys("iphone 7");
	}
	public void clickSearchButton () {
		wait.until(ExpectedConditions.elementToBeClickable(By.className(SEARCH_BUTTON_CLASS_NAME)));
		driver.findElement(By.className(SEARCH_BUTTON_CLASS_NAME)).click();
	}

}
