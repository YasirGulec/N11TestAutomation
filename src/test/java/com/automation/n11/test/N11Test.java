package com.automation.n11.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.automation.n11.page.N11FacebookLoginPopupPage;
import com.automation.n11.page.N11HomePage;
import com.automation.n11.page.N11LoginPage;
import com.automation.n11.page.N11MainPage;
import com.automation.n11.page.N11SearchResultPage;

public class N11Test {
	public static WebDriver driver;
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver.exe");
		ChromeOptions o = new ChromeOptions();
		o.addArguments("disable-extensions");
		o.addArguments("--start-maximized");
		driver = new ChromeDriver(o);
	}
	
	@Test
	public void test() {
		N11HomePage homePage = new N11HomePage(driver);
		homePage.clickLoginLink();
		
		N11LoginPage loginPage = new N11LoginPage(driver);
		loginPage.clickLoginWithFacebookButton();
		
		N11FacebookLoginPopupPage loginPopupPage = new N11FacebookLoginPopupPage(driver);
		loginPopupPage.enterEmail();
		loginPopupPage.enterPassword();
		loginPopupPage.clickLoginButton();
		
		N11MainPage mainPage = new N11MainPage(driver);
		mainPage.enterSearchInput();
		mainPage.clickSearchButton();
		
		N11SearchResultPage searchResultPage = new N11SearchResultPage(driver);
		searchResultPage.clickFirstRecord();
		
		Assert.assertTrue("Tıklanan üründen farklı bir ürün açıldı.", searchResultPage.isValidProduct());
	}

	@AfterClass
	public static void finish() {
		driver.close();
	}

}
