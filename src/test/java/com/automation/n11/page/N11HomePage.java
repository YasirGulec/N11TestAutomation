package com.automation.n11.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class N11HomePage {
	private WebDriver driver;
	private WebDriverWait wait; 
	
	private static final String URL = "http://www.n11.com/";
	private static final String LOGIN_LINK_CLASS_NAME = "btnSignIn";
	
	@SuppressWarnings("unused")
	private N11HomePage() {
	}
	
	public N11HomePage(WebDriver driver) {
		driver.get(URL);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}
	
	public void clickLoginLink() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(LOGIN_LINK_CLASS_NAME)));
		driver.findElement(By.className(LOGIN_LINK_CLASS_NAME)).click();
	}
}
