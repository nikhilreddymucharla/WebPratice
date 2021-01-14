package com.web.Pratice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private WebDriver driver;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://selenium-ch:4444/wd/hub"), capability);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
	@org.testng.annotations.Test
	public void m1() throws MalformedURLException {
		
		driver.get("https://google.com");
		driver.findElement(By.xpath("//div[@class='pR49Ae gsfi']")).sendKeys("HI google");

	}

	@AfterSuite
	public void afterTest() {
		if (driver != null) {
			driver.quit();
		}
	}
}