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

	@FindBy(id = "homepageSearch")
	public WebElement homepageTextSearch;

	@FindBy(className = "button button--primary colOne")
	public WebElement homepageSearchButton;

	@FindBy(id = "q")
	public WebElement searchBoxText;

	@FindBy(xpath = "//label[@class='entitiy__label']")
	public List<WebElement> topicNameLists;

	@FindBy(xpath = "//h3[@class='entitiy__headline cursor-pointer']")
	public List<WebElement> topicLists;

	@FindBy(xpath = "//input[@class='entitiy__checkbox']")
	public List<WebElement> topicCheckBoxes;

	@FindBy(xpath = "//*[@id='searchForm']/div[1]/div/div[2]/div/div[1]/h4[1]/span")
	public WebElement searchResultNumber;

	@FindBy(xpath = "//*[@id='searchResults']/div/div/p")
	public WebElement alertMessage;

	@FindBy(xpath = "//*[@id='searchForm']/div[1]/div/div[1]/section/div/div[1]/div[1]/div[4]/div[1]/label/span[1]")
	public WebElement statisticButton;

	@FindBy(id = "isocountrySearch")
	public WebElement searchBoxStatPage;

	@FindBy(id = "refreshBtn")
	public WebElement refreshButton;

	@FindBy(xpath = "//i[@class='fa-search fa']")
	public WebElement searchButton;

	@FindBy(xpath = "//div[@class='note note--info']")
	public WebElement suggestionMessage;

	@FindBy(xpath = "//h2[@class='h5 text-color--darkerblue margin-bottom-0 text-ellipsis']")
	public WebElement firstResultText;

	@FindBy(xpath = "(//h4)[1]//span[@class='text-normal']")
	public WebElement resultNum;

	@FindBy(id = "refreshBtn")
	public WebElement refreshSearchButton;

	@FindBy(xpath = "//input[@id='homepageSearch']")
	public WebElement searchField;

	@FindBy(xpath = "//div[@class='margin-bottom-30']//h2")
	public List<WebElement> searchResults;

	@FindBy(xpath = "(//h2[@class='h5 text-color--darkerblue margin-bottom-0 text-ellipsis'])[1]")
	public WebElement matchFirst;

	@FindBy(xpath = "(//h2[@class='h5 text-color--darkerblue margin-bottom-0 text-ellipsis'])[2]")
	public WebElement matchSecond;

	@FindBy(xpath = "(//h2[@class='h5 text-color--darkerblue margin-bottom-0 text-ellipsis'])[3]")
	public WebElement matchThird;

	@FindBy(xpath = "//input[@value='Statista Search']")
	public WebElement StatistaSearchSubmit;

	@FindBy(className = "ui-menu-item-wrapper")
	public List<WebElement> DynamicDropSearch;

	@FindBy(id = "iscountrySearch")
	public WebElement country;

	@FindBy(id = "isocountry_840")
	public WebElement UnitedStatesCheckBox;
	
	@FindBy(xpath="//*[@id='js-regular-filter']/div[2]/div[2]/div/div[2]/div")
	public WebElement USbox;
	
	@FindBy(id ="js-reset-all-filters")
	public WebElement resetButton;

}
