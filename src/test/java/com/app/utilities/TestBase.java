package com.app.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {

	protected WebDriver driver;
	
	

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		driver = Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(ConfigurationReader.getProperty("url"));

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		Driver.closeDriver();

	}

}
