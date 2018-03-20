package com.app.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class StatistaPage {

	private WebDriver driver;
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

	@FindBy(xpath = "//input[@value='Statista Search']")
	public WebElement StatistaSearchSubmit;

	@FindBy(className = "ui-menu-item-wrapper")
	public List<WebElement> DynamicDropSearch;

}
