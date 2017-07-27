package com.automation.n11.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class N11FacebookLoginPopupPage {
	private WebDriver driver;
	private WebDriverWait wait;
	String parentHandle;
	
	private static final String EMAIL_INPUT_ID = "email";
	private static final String PASSWORD_INPUT_ID = "pass";
	private static final String LOGIN_BUTTON_NAME = "login";
	
	@SuppressWarnings("unused")
	private N11FacebookLoginPopupPage() {
	}
	
	public N11FacebookLoginPopupPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		parentHandle = driver.getWindowHandle();
	}
	
	public void enterEmail () {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(EMAIL_INPUT_ID)));
		driver.findElement(By.id(EMAIL_INPUT_ID)).sendKeys("yasirtest@outlook.com");
	}
	
	public void enterPassword () {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PASSWORD_INPUT_ID)));
		driver.findElement(By.id(PASSWORD_INPUT_ID)).sendKeys("abc12345");
	}
	
	public void clickLoginButton () {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(LOGIN_BUTTON_NAME)));
		driver.findElement(By.name(LOGIN_BUTTON_NAME)).click();
		driver.switchTo().window(parentHandle);
	}

}
