package com.app.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.app.pages.StatistaPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.TestBase;

public class SmokeTest extends TestBase{
	
StatistaPage statistaPage = new StatistaPage();
	
	@Test(priority=0,description="Smoke Test")
	public void Test() {
		
		assertTrue(BrowserUtils.isAt());
		BrowserUtils.searchStatistaButton(statistaPage.homepageTextSearch, "Panera Bread");
		assertEquals("Panera Bread",statistaPage.searchBoxText.getAttribute("value"), 
				"Verifying search box text");
		assertTrue(statistaPage.searchBoxText.isDisplayed(), 
				"Verifying text inside the search box isDisplayed");
		String name="Statistics";
//		assertTrue(statistaPage.optionsStatic.isDisplayed()) ;
		assertTrue(BrowserUtils.getTopicNameLists(statistaPage.topicNameLists,name).equals(name), 
				"Verifying TopicNameLists \"Statistics\"");
		
		name="Forecasts & surveys";
//		assertTrue(statistaPage.optionsInfos.isDisplayed());
		assertTrue(BrowserUtils.getTopicNameLists(statistaPage.topicNameLists,name).equals(name), 
				"Verifying TopicNameLists \"Forecasts & surveys\"");
		
		name="Infographics";
//		assertTrue(statistaPage.optionsInfos.isDisplayed());
		assertTrue(BrowserUtils.getTopicNameLists(statistaPage.topicNameLists,name).equals(name), 
				"Verifying TopicNameLists \"Infographics\"");
		
		name="Topics";
//		assertTrue(statistaPage.optionsTopics.isDisplayed());
		assertTrue(BrowserUtils.getTopicNameLists(statistaPage.topicNameLists,name).equals(name), 
				"Verifying TopicNameLists \"Topics\"");
		
		BrowserUtils.getTopicListsAndClick(statistaPage.topicLists, "Statistics");
		BrowserUtils.waitFor(3);
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Statistics"),
				"Statista check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Forecasts & surveys"),
				"Forecasts & surveys check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Infographics"),
				"Infographics check box");
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "opics"),
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
	}

}
