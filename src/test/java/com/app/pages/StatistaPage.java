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
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='homepageSearch']")
	public WebElement searchField;
	@FindBy(xpath = "//input[@value='Statista Search']")
	public WebElement searchClick;

	 @FindBy(xpath="//div[@class='padding-all-20 padding-horizontal-s-0']")
	 public List<WebElement> result;

	@FindBy(xpath = "//input[@id='q']")
	public WebElement searchButton2;

	@FindBy(xpath = "(//div[@class='row'])[5]")
	public WebElement resultMoreThanOne;

	@FindBy(xpath = "//div[@class='margin-bottom-30']//h2")
	public List<WebElement> searchResults;
	
	@FindBy(xpath="(//h2[@class='h5 text-color--darkerblue margin-bottom-0 text-ellipsis'])[1]")
	public WebElement matchFirst;
	
	@FindBy(xpath="(//h2[@class='h5 text-color--darkerblue margin-bottom-0 text-ellipsis'])[2]")
	public WebElement matchSecond;
	
	@FindBy(xpath="(//h2[@class='h5 text-color--darkerblue margin-bottom-0 text-ellipsis'])[3]")
	public WebElement matchThird;


	
	 
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
