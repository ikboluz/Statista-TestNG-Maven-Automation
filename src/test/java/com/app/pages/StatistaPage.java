package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class StatistaPage {
	
	private WebDriver driver;
	
	 public StatistaPage() {
		 this.driver=Driver.getDriver();
		 PageFactory.initElements(driver, this);
	 }

}
