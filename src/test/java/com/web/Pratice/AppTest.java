package com.web.Pratice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	private static final String ACCESS_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51Ijo4MDkwNTUzLCJ4cC5wIjo4MDExNTgyLCJ4cC5tIjoxNjA3MTc2NDcwNDAzLCJleHAiOjE5MjI2MzA0MjEsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.3L36xT8cQv-ZIHMalFGfTEXEJj4qY3Q-QGOuYVqWw_k";
	private RemoteWebDriver driver;
	private URL url;
	private DesiredCapabilities dc = new DesiredCapabilities();

	@BeforeTest
	public void setUp() throws Exception {
		dc.setCapability("testName", "Quick Start Chrome Browser Demo");
		dc.setCapability("accessKey", ACCESS_KEY);
		dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		driver = new RemoteWebDriver(new URL("https://cloud.seetest.io/wd/hub"), dc);
	}

	@Test
	public void browserTestGoogleSearch() {
		for (int i = 0; i < 7; i++) {
			driver.get("https://www.google.com");
			new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
			WebElement searchBar = driver.findElement(By.name("q"));
			searchBar.click();
			searchBar.sendKeys("Experitest");
			searchBar.sendKeys(Keys.ENTER);
		}
	}

	@AfterTest
	public void tearDown() {
		System.out.println("Report URL: " + driver.getCapabilities().getCapability("reportUrl"));
		driver.quit();
	}

}