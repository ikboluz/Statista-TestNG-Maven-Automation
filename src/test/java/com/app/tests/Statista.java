package com.app.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.app.pages.StatistaPage;
import com.app.pages.StatistaSearchPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.ConfigurationReader;
import com.app.utilities.TestBase;

public class Statista extends TestBase {

	StatistaPage statistaPage = new StatistaPage();
	StatistaSearchPage searchPage = new StatistaSearchPage();

	@Test(priority = 2)
	public void testST002() {

		assertEquals(driver.getCurrentUrl().substring(0, 24), "https://www.statista.com");
		assertEquals(driver.getTitle(),
				"• Statista - The Statistics Portal for Market Data, Market Research and Market Studies");

		statistaPage.homepageTextSearch.sendKeys("Apple");
		statistaPage.StatistaSearchSubmit.click();
		assertTrue(searchPage.searchBoxText.getAttribute("value").contains("Apple"));
	}

	@Test(priority = 8)
	public void testST008() {

		driver.get(ConfigurationReader.getProperty("url"));
		assertTrue(BrowserUtils.isAt(), "Statista main page should be displayed");

		statistaPage.homepageTextSearch.sendKeys("Cat and dog");
		statistaPage.StatistaSearchSubmit.click();

		assertTrue(searchPage.searchBoxText.getAttribute("value").contains("Cat and dog"));
		assertTrue(searchPage.isClickable(), "Search submit button should be clickable");
		assertTrue(driver.getTitle().contains("Search | Statista"));
		assertNotSame(searchPage.ResultsListAfterSearch.get(0).getText(), "Pet market in Europe");
	}

	@Test(priority = 14)
	public void testTS014() {

		driver.get(ConfigurationReader.getProperty("url"));
		assertTrue(BrowserUtils.isAt(), "Statista main page is not displayed");

		statistaPage.homepageTextSearch.sendKeys("Panera Bread");
		assertTrue(StatistaSearchPage.DynamicDropMenuResults(statistaPage.DynamicDropSearch, "Panera Bread"));

		statistaPage.StatistaSearchSubmit.click();
		assertTrue(driver.getTitle().contains("Search | Statista"), "Statista Search page is not displayed");

		String ResultNumberStep4 = searchPage.SearchResultNumber.getText();
		ResultNumberStep4 = ResultNumberStep4.substring(1, ResultNumberStep4.length() - 1);

		searchPage.RadioButton("Wide").click();
		assertTrue(searchPage.RadioButton("Wide").isSelected(), "Wide radio button should be selected");
		assertFalse(searchPage.RadioButton("Normal").isSelected(), "Normal radio button should not be selected");
		assertFalse(searchPage.RadioButton("High").isSelected(), "High radio button should not be selected");

		searchPage.refreshSearch.click();
		assertTrue(searchPage.RadioButton("Wide").isSelected(), "Wide radio button should be selected");

		BrowserUtils.waitFor(3);
		String ResultNumberStep8 = searchPage.SearchResultNumber.getText();
		ResultNumberStep8 = ResultNumberStep8.substring(3, ResultNumberStep8.length() - 1);
		ResultNumberStep8 = ResultNumberStep8.replace(",", "");

		assertTrue(Integer.parseInt(ResultNumberStep8) > Integer.parseInt(ResultNumberStep4),
				"Result Number in step6 should be Higher than Result Number in step4");

		searchPage.RadioButton("High").click();
		assertTrue(searchPage.RadioButton("High").isSelected(), "Wide radio button should be selected");
		assertFalse(searchPage.RadioButton("Normal").isSelected(), "Normal radio button should not be selected");
		assertFalse(searchPage.RadioButton("Wide").isSelected(), "Wide radio button should not be selected");

		searchPage.refreshSearch.click();
		assertTrue(searchPage.RadioButton("High").isSelected(), "Wide radio button should be selected");

		BrowserUtils.waitFor(3);
		String ResultNumberStep11 = searchPage.SearchResultNumber.getText();
		ResultNumberStep11 = ResultNumberStep11.substring(1, ResultNumberStep11.length() - 1);

		assertTrue(Integer.parseInt(ResultNumberStep11) < Integer.parseInt(ResultNumberStep8),
				"Result Number in step11 should be Lower than Result Number in step8");

		searchPage.RadioButton("Normal").click();
		assertTrue(searchPage.RadioButton("Normal").isSelected(), "Notmal radio button should be selected");
		assertFalse(searchPage.RadioButton("High").isSelected(), "High radio button should not be selected");
		assertFalse(searchPage.RadioButton("Wide").isSelected(), "High radio button should not be selected");

		searchPage.refreshSearch.click();
		assertTrue(searchPage.RadioButton("Normal").isSelected(), "Normal radio button should be selected");

		BrowserUtils.waitFor(3);
		String ResultNumberStep14 = searchPage.SearchResultNumber.getText();
		ResultNumberStep14 = ResultNumberStep14.substring(1, ResultNumberStep14.length() - 1);
		assertEquals(Integer.parseInt(ResultNumberStep14), Integer.parseInt(ResultNumberStep4),
				"Result Number in step14 should be the same as  the Result Number in step4");

	}

	@Test(priority = 20)
	public void testTS020() {

		driver.get(ConfigurationReader.getProperty("url"));
		assertEquals(driver.getCurrentUrl().substring(0, 24), "https://www.statista.com");
		assertEquals(driver.getTitle(),
				"• Statista - The Statistics Portal for Market Data, Market Research and Market Studies");
		statistaPage.homepageTextSearch.sendKeys("Panera Bread");
		assertTrue(StatistaSearchPage.DynamicDropMenuResults(statistaPage.DynamicDropSearch, "Panera Bread"),
				"Text type in search box should visible in searchbox");
		statistaPage.StatistaSearchSubmit.click();
		String ResultNumber = searchPage.SearchResultNumber.getText();
		ResultNumber = ResultNumber.substring(1, ResultNumber.length() - 1);
		assertTrue(Integer.parseInt(ResultNumber) > 0, "The result number should be more than 0");
		
		assertEquals(searchPage.ResultsListAfterSearch.get(0).getText(),
				"Americans preferring Panera Bread in the U.S. in 2016 and 2017, by gender");

		searchPage.CheckBoxElement("Companies", searchPage.filtersNameLists).click();
		BrowserUtils.waitFor(5);



	}

}
