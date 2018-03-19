package com.app.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class StatistaPage {
	
	private WebDriver driver;
	
	 public StatistaPage() {
		 this.driver=Driver.getDriver();
		 PageFactory.initElements(driver, this);
	 }
	
	 
	 @FindBy(id="homepageSearch")
	 public WebElement homepageTextSearch;
	 
	 @FindBy(className="button button--primary colOne")
	 public WebElement hompageSearchButton;
	 
	 @FindBy(id="q")
	 public WebElement searchBoxText;
	 
	 @FindBy(xpath="//label[@class='entitiy__label']")
	 public List<WebElement> topicNameLists;
	 
	 @FindBy(xpath="//h3[@class='entitiy__headline cursor-pointer']")
	 public List<WebElement> topicLists;
	 
	 @FindBy(xpath="//input[@class='entitiy__checkbox']")
	 public List<WebElement> topicCheckBoxes;
	 
	 @FindBy(xpath="//div[@class='newAlert info']")
	 public WebElement alertMessage;
	 
	 @FindBy(xpath="//i[@class='fa-search fa']")
	 public WebElement searchButton;
	 
	 @FindBy(xpath="//div[@class='note note--info']")
	 public WebElement suggestionMessage;
	 
	 @FindBy(xpath="//h2[@class='h5 text-color--darkerblue margin-bottom-0 text-ellipsis']")
	 public WebElement firstResultText;
	 
	 @FindBy(xpath="(//h4)[1]//span[@class='text-normal']")
	 public WebElement resultNum;
	 
	 @FindBy(id="refreshBtn")
	 public WebElement refreshSearchButton;
	

}
