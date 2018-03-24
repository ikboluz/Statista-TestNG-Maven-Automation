package com.app.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.app.pages.StatistaPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.ConfigurationReader;
import com.app.utilities.Driver;
import com.app.utilities.TestBase;

public class Stat extends TestBase {
	StatistaPage statistaPage = new StatistaPage();
	WebDriver driver = Driver.getDriver();
	
	//TEst==== STOO3
	//@Test(priority=1,description="Test 0")
	public void searchFieldValidation() {
		//validate Title of the page
		System.out.println("here");
		assertTrue(BrowserUtils.isAt());
		
		//search for Cat
		BrowserUtils.searchStatistaButton(statistaPage.homepageTextSearch, "Cat");
		//compare the two  values after search button clicked
		assertEquals("Cat",statistaPage.searchBoxText.getAttribute("value"));
		//verify searchbox is displayed
		assertTrue(statistaPage.searchBoxText.isDisplayed());
	}

	//Test === ST009	
	//@Test(priority=2,description="Test 1")
	public void searchForMisspelledWord(){
		driver.get(ConfigurationReader.getProperty("url"));

		
		//validate Title of the page
		assertTrue(BrowserUtils.isAt());
		
		//search for FaseBook -- enter misspelled word and click search
		BrowserUtils.searchStatistaButton(statistaPage.homepageTextSearch, "FaseBook");
		
		//Verify SearchResult is Zero
		assertEquals("(0)", statistaPage.searchResultNumber.getText());
		//verify alert message
		String expectedErrorMessage ="Unfortunately, no content could be found. Please check your spelling, try an alternative term or expand your search to the Statista archive.";
		String actualerrormessage = statistaPage.alertMessage.getText();
		assertEquals(expectedErrorMessage, actualerrormessage);
	}
	
	//Test === ST015
	@Test(priority=3,description="Test 2")
	public void test15(){
		driver.get(ConfigurationReader.getProperty("url"));

		//validate Title of the page
		assertTrue(BrowserUtils.isAt());
		
		//search for FaseBook -- enter misspelled word and click search
		BrowserUtils.searchStatistaButton(statistaPage.homepageTextSearch, "Panera Bread");
		String searchResult = statistaPage.searchResultNumber.getText();
	
		BrowserUtils.getTopicListsAndClick(statistaPage.topicLists, "Statistics");
		//click refresh search
		driver.findElement(By.id("refreshBtn")).click();
		String newSearchResult = statistaPage.searchResultNumber.getText();
	
		if(searchResult.equals(newSearchResult)){
			assertEquals(searchResult, newSearchResult);
		} else{
			assertTrue(true);
		}
		
		//click reset button
		driver.findElement(By.id("js-reset-all-filters")).click();
		String updatedResult= statistaPage.searchResultNumber.getText();
		
		if(searchResult.equals(newSearchResult)){
			assertEquals(searchResult, updatedResult);			
		} else{
			assertTrue(true);
		}
	}	
}
