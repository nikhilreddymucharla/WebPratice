package com.web.Pratice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;import java.util.stream.Collector;
import java.util.stream.Collectors;

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
	private DesiredCapabilities dc = new DesiredCapabilities().chrome();

	@BeforeTest
	public void setUp() throws Exception {
		//dc.setCapability("testName", "Quick Start Chrome Browser Demo");
		//dc.setCapability("accessKey", ACCESS_KEY);
		//dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		//driver = new RemoteWebDriver(new URL("https://cloud.seetest.io/wd/hub"), dc);
		driver = new RemoteWebDriver(new URL("http://selenium-ch:4444/wd/hub"), dc);
		driver.get("https://qe.acto.com/auth/sso");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@Test
	public void browserTestGoogleSearch() {
			new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'sign in with email')]")));
			driver.findElement(By.xpath("//span[contains(text(),'sign in with email')]")).click();
			
	}

	@AfterTest
	public void tearDown() {
		//System.out.println("Report URL: " + driver.getCapabilities().getCapability("reportUrl"));
		driver.quit();
	}

}