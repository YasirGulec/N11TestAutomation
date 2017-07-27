package com.automation.n11.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class N11LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	private static final String LOGIN_WITH_FACEBOOK_BUTTON_XPATH = "//div[@class='button inicon facebook medium facebookBtn  btnLogin']";
	
	@SuppressWarnings("unused")
	private N11LoginPage () {
	}
	
	public N11LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}
	
	public void clickLoginWithFacebookButton () {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LOGIN_WITH_FACEBOOK_BUTTON_XPATH)));
		driver.findElement(By.xpath(LOGIN_WITH_FACEBOOK_BUTTON_XPATH)).click();
	}
}
