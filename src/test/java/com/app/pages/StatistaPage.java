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
	 public WebElement homepageSearchButton;
	 
	 @FindBy(id="q")
	 public WebElement searchBoxText;
	 
	 @FindBy(xpath="//label[@class='entitiy__label']")
	 public List<WebElement> topicNameLists;
	 
	 @FindBy(xpath="//h3[@class='entitiy__headline cursor-pointer']")
	 public List<WebElement> topicLists;
	 
	 @FindBy(xpath="//input[@class='entitiy__checkbox']")
	 public List<WebElement> topicCheckBoxes;
	 
	 @FindBy(xpath="//*[@id='searchForm']/div[1]/div/div[2]/div/div[1]/h4[1]/span")
	 public WebElement searchResultNumber;
	 
	@FindBy(xpath="//*[@id='searchResults']/div/div/p")
	public WebElement alertMessage;
	
	@FindBy(xpath="//*[@id='searchForm']/div[1]/div/div[1]/section/div/div[1]/div[1]/div[4]/div[1]/label/span[1]")
	public WebElement statisticButton;
	
	@FindBy(id="isocountrySearch")
	public WebElement searchBoxStatPage;
	
	@FindBy(id="refreshBtn")
	public WebElement refreshButton;
}
