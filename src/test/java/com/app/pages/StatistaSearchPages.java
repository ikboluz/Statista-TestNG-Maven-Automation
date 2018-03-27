package com.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.app.utilities.Driver;

public class StatistaSearchPages {

	private WebDriver driver;
	

	public StatistaSearchPages() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(id = "q")
	public WebElement searchBoxText;

	@FindBy(xpath = "//h2[@class='h5 text-color--darkerblue margin-bottom-0 text-ellipsis']")
	public List<WebElement> ResultsListAfterSearch;

	@FindBy(xpath = "//h4[@class='hl-module hideMobile']//span[@class='text-normal']")
	public WebElement SearchResultNumber;

	@FindBy(id = "refreshBtn")
	public WebElement refreshSearch;

	@FindBy(id = "//span[@id='refreshBtn'][@class='button button--fullwidth']")
	public WebElement refreshSearch1;

	@FindBy(xpath = "//label[@class='entitiy__label']")
	public List<WebElement> filtersNameLists;

	@FindBy(xpath = "//span[@class='font-italic']/span")
	public List<WebElement> resultlistfilter;

	@FindBy(xpath = "//td/a")
	public List<WebElement> listRsultAfterFilter;

	@FindBy(xpath = "//input[@class='entitiy__checkbox']")
	public List<WebElement> topicCheckBoxes;

	@FindBy(xpath = "//i[@data-tooltiptarget='#formSearchStatisticsTooltip']/..")
	public WebElement StatisticsHader;

	@FindBy(xpath = "//span[@data-searchrefresh='Refresh Search']")
	public WebElement RefreshSearch;

	@FindBy(xpath = "//input[@id='dossiers']")
	public WebElement dossiersCheckBox;

	@FindBy(id = "isoregion")
	public WebElement regionDropDownList;

	@FindBy(id = "isocountry_124")
	public WebElement canadaCheckBox;

	@FindBy(xpath = "//span[@class='text-normal']")
	public WebElement resultNumberAfterFilters;

	public static boolean DynamicDropMenuResults(List<WebElement> element, String search) {
		for (WebElement elmt : element) {
			if (elmt.getText().toLowerCase().contains(search.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	public WebElement RadioButton(String str) {
		return driver
				.findElement(By.xpath("//div[@class='form_row__radio width33']//label[.='" + str + "']/..//input"));
	}

	public boolean isClickable() {
		if (driver.getTitle().contains("Search | Statista")) {
			return true;
		}
		return false;
	}

	public WebElement FilerElement(List<WebElement> list, String filter) {
		WebElement Filter = null;
		for (WebElement webElement : list) {
			if (webElement.getText().toLowerCase().contains(filter.toLowerCase())) {
				Filter = webElement;
			}
		}
		return Filter;
	}

	public int resultNumberFilter(String str, List<WebElement> list) {
		int index = 0;
		for (WebElement webElement : list) {
			if (webElement.getText().toLowerCase().contains(str.toLowerCase())) {
				break;
			}
			index++;
		}
		return Integer.parseInt(resultlistfilter.get(index).getText());
	}

	public boolean verifingCheckBoxIsUnchecked(List<WebElement> elements, String name) {

		for (int i = 0; i < elements.size(); i++) {
			if (!filtersNameLists.get(i).getText().contains(name)) {
				if (elements.get(i).isSelected() == false) {
					return true;
				} else {
					continue;
				}
			}
		}
		return false;
	}

	public WebElement CheckBoxElement(String str, List<WebElement> list) {
		int index = 0;
		for (WebElement webElement : list) {
			if (webElement.getText().toLowerCase().contains(str.toLowerCase())) {
				break;
			}
			index++;
		}
		return topicCheckBoxes.get(index);
	}

	public int sumOfResultsfilter(List<WebElement> results) {
		int sum = 0;
		for (WebElement webElement : results) {

			sum += Integer.parseInt(webElement.getText());

		}

		return sum;

	}

	public boolean resultsDisplayed() {

		return (!ResultsListAfterSearch.isEmpty());
	}

	public int stringToINT(String s) {
		String i = "";
		for (String S : s.split("")) {
			if (S.equals("1") || S.equals("2") || S.equals("3") || S.equals("4") || S.equals("5") || S.equals("6")
					|| S.equals("7") || S.equals("8") || S.equals("9") || S.equals("0")) {
				i += S;
			}
		}
		return Integer.parseInt(i);
	}

	public void selectRegion(String s) {
		Select select = new Select(regionDropDownList);
		List<WebElement> options = select.getAllSelectedOptions();
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().equals(s)) {
				select.selectByIndex(i);
			}
		}
	}

	public boolean resultsContains(String s) {
		boolean b = false;
		for (WebElement we : ResultsListAfterSearch) {
			if (we.getText().contains(s)) {
				b = true;
			} else {
				b = false;
			}
		}

		return b;
	}
	
	
	
}
