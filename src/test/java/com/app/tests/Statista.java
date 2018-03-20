package com.app.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.app.pages.StatistaPage;
import com.app.pages.StatistaSearchPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.ConfigurationReader;
import com.app.utilities.TestBase;

import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.ManifestReading.SealBaseLocator;

public class Statista extends TestBase{
	
	StatistaSearchPage searchPage = new StatistaSearchPage();
	StatistaPage statistaPage = new StatistaPage();
	
	
	//1,7,13,19
	@Test(priority=1)
	public void testST01() {
		
		String title="â€¢ Statista - The Statistics Portal for Market Data, Market Research and Market Studies";
		String url="https://www.statista.com/";
		String dataSearch="Panera Bread";
		
	//1
		assertTrue(driver.getTitle().equals(title), "Verifying Title");
	//2
		assertEquals(driver.getCurrentUrl(), url, "Verifying URL");
	//3
		BrowserUtils.searchStatistaButton(statistaPage.homepageTextSearch, dataSearch);
	//4
		assertEquals(statistaPage.searchBoxText.getAttribute("value"), dataSearch,"Checking search box text");
//		BrowserUtils.waitForPageToLoad(3);
	}
	
	@Test(priority=7)
	public void testST07() {
		
		driver.get(ConfigurationReader.getProperty("url"));
		
		String alrtMessage="Unfortunately, no content could be found. Please check your spelling, try an alternative term or expand your search to the Statista archive.";
		String narrowMessage="Didnâ€™t find what you were looking for?";
		
	//1
		assertTrue(driver.findElement(By.id("statistaLogo")).isDisplayed(), "Verifying \"statistaLogo\" isDisplayed 1");
	//2
		statistaPage.homepageTextSearch.sendKeys("Hello");
		BrowserUtils.waitFor(5);
		statistaPage.homepageTextSearch.clear();
	//3
		BrowserUtils.searchStatistaButton(statistaPage.homepageTextSearch, "%%, **, !!");
	//4
		assertTrue(driver.findElement(By.id("statistaLogo")).isDisplayed(), "Verifying \"statistaLogo\" isDisplayed 2");
	//5
		assertTrue(statistaPage.alertMessage.isDisplayed(), "Verifying alert message isDisplayed");
		assertTrue(statistaPage.alertMessage.getText().contains(alrtMessage), "Verifying alert message text");
	//6
		statistaPage.searchButton.click();
		assertTrue(statistaPage.suggestionMessage.isDisplayed(), "Verifying narrow message isDisplayed");
		assertTrue(statistaPage.suggestionMessage.getText().contains(narrowMessage), "Verifying narrow message text");	
	}
		
	@Test(priority=13)
	public void testST013() {
		
		driver.get(ConfigurationReader.getProperty("url"));
		
		String dataSearch="Panera Bread";
		String firstResultName="Americans preferring Panera Bread in the U.S. in 2016 and 2017, by gender";
	//1
		assertTrue(BrowserUtils.isAt(), "Verifying HomePage Title");
	//2
		BrowserUtils.searchStatistaButton(statistaPage.homepageTextSearch, dataSearch);
		assertEquals(statistaPage.searchBoxText.getAttribute("value"), dataSearch, "Checking search box text");
	//3
		assertTrue(driver.getTitle().equals("â€¢ Search | Statista"), "Verifying Result Title");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Statistics"),
				"Statista check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Forecasts & surveys"),
				"Forecasts & surveys check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Infographics"),
				"Infographics check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Topics"),
				"Topics check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Dossiers"),
				"Dossiers check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Statista studies"),
				"Statista studies check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Industry & country reports"),
				"Industry & country reports check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Additional studies"),
				"Additional studies check box");	
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Digital Markets"),
				"Digital Markets check box");	
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Consumer Markets"),
				"Consumer Markets check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Companies"),
				"Companies uncheck box");
		assertTrue(statistaPage.firstResultText.getText().equals(firstResultName), "Compairing First Results text");
	//4
		int resultNum1=Integer.parseInt(statistaPage.resultNum.getText().substring(1, statistaPage.resultNum.getText().length()-1));
	//5
		BrowserUtils.checkAndUncheck("Dossiers");
		BrowserUtils.checkAndUncheck("Statista studies");
		BrowserUtils.checkAndUncheck("Industry & country reports");
		BrowserUtils.checkAndUncheck("Additional studies");
		statistaPage.refreshSearchButton.click();
		BrowserUtils.waitFor(3);
		
		int resultNum2=Integer.parseInt(statistaPage.resultNum.getText().substring(1, statistaPage.resultNum.getText().length()-1));
	
		assertEquals(BrowserUtils.getTopicNamesResultNum("Dossiers")
				    +BrowserUtils.getTopicNamesResultNum("Statista studies")
				    +BrowserUtils.getTopicNamesResultNum("Industry & country reports")
				    +BrowserUtils.getTopicNamesResultNum("Additional studies")
				    +resultNum2, resultNum1,"Verifying TopicNamesResultNum 1 == ");
		
	}
	
	
	
	@Test(priority=19)
	public void testST019() {
		
		driver.get(ConfigurationReader.getProperty("url"));
		
		String dataSearch="cat and dog";
		String firstResultName="Dog/cat food import volume in South Korea from U.S. 2000-2017";
	//1
		assertTrue(BrowserUtils.isAt(),"Verifying Title");
		assertTrue(driver.getCurrentUrl().equals("https://www.statista.com/"),"Verifyung URL");
	//2
		BrowserUtils.searchStatistaButton(statistaPage.homepageTextSearch, dataSearch);
		assertEquals(statistaPage.searchBoxText.getAttribute("value"), dataSearch
				,"Checking search box text ");
	//3
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Statistics"),
				"Statista check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Forecasts & surveys"),
				"Forecasts & surveys check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Infographics"),
				"Infographics check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Topics"),
				"Topics check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Dossiers"),
				"Dossiers check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Statista studies"),
				"Statista studies check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Industry & country reports"),
				"Industry & country reports check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Additional studies"),
				"Additional studies check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Digital Markets"),
				"Digital Markets check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Consumer Markets"),
				"Consumer Markets check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Companies"),
				"Companies uncheck box");
//		assertTrue(statistaPage.firstResultText.getText().equals(firstResultName),
//				"Compairing First Results text 1");
	//4
		int resultNum1=Integer.parseInt(statistaPage.resultNum.getText().substring(1, statistaPage.resultNum.getText().length()-1));
	//5
		BrowserUtils.getTopicListsAndClick(statistaPage.topicLists, "Statistics");
		BrowserUtils.waitFor(3);
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Statistics"),
				"Statistics check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Forecasts & surveys"),
				"Forecasts & surveys check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Infographics"),
				"Infographics check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Topics"),
				"Topics check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Dossiers"),
				"Dossiers uncheck box");
		assertTrue(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Statista studies"),
				"Statista studies uncheck box");
		assertTrue(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Industry & country reports"),
				"Industry & country reports uncheck box");
		assertTrue(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Additional studies"),
				"Additional studies uncheck box");
		assertTrue(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Digital Markets"),
				"Digital Markets uncheck box");
		assertTrue(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Consumer Markets"),
				"Consumer Markets uncheck box");
		assertTrue(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Companies"),
				"Companies uncheck box");
		
		int resultNum2=Integer.parseInt(statistaPage.resultNum.getText().substring(1, statistaPage.resultNum.getText().length()-1));
		
		assertEquals(BrowserUtils.getTopicNamesResultNum("Statistics")
				    +BrowserUtils.getTopicNamesResultNum("Forecasts & surveys")
				    +BrowserUtils.getTopicNamesResultNum("Infographics")
				    +BrowserUtils.getTopicNamesResultNum("Topics"),
				    resultNum2,"Verifying TopicNamesResultNum 2 ==");
//		assertTrue(statistaPage.firstResultText.getText().equals(firstResultName),
//				"Comparing First result text 2");
	//6
		assertTrue(resultNum1>resultNum2, "Compairing results num < >");
	}
	
	@Test(priority=4)
	public void testST004() {
		
		driver.get(ConfigurationReader.getProperty("url"));

		String dataSearch="Dog";
		assertTrue(BrowserUtils.isAt());
		assertTrue(driver.getCurrentUrl().equals("https://www.statista.com/"));
		BrowserUtils.searchStatistaButton(statistaPage.searchField, dataSearch);
		assertEquals(statistaPage.searchBoxText.getAttribute("value"), dataSearch);
		assertTrue(BrowserUtils.firstThree(statistaPage.searchResults, dataSearch));
		assertTrue(BrowserUtils.isContains(dataSearch));	
	}
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

		searchPage.FilerElement(searchPage.filtersNameLists, "companies").click();
		BrowserUtils.waitFor(5);

		String ResultNumberExpected = searchPage.SearchResultNumber.getText();
		ResultNumberExpected = ResultNumberExpected.substring(1, ResultNumberExpected.length() - 1);

		assertEquals(searchPage.resultNumberFilter("companies", searchPage.filtersNameLists),
				Integer.parseInt(ResultNumberExpected));
		assertEquals(searchPage.listRsultAfterFilter.size(), 1, "Only one company is available after the search");
		assertTrue(searchPage.verifingCheckBoxIsUnchecked(searchPage.topicCheckBoxes, "Companie"));

		searchPage.refreshSearch.click();

	}
	

}
