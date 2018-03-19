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
		
		assertEquals("Panera Bred",statistaPage.searchBoxText.getAttribute("value"));
		assertTrue(statistaPage.searchBoxText.isDisplayed());
		
		String name="Statistics";
//		assertTrue(statistaPage.optionsStatic.isDisplayed());
		System.out.println(BrowserUtils.getTopicNameLists(statistaPage.topicNameLists, name));
		assertTrue(BrowserUtils.getTopicNameLists(statistaPage.topicNameLists,name).equals(name));
		
		name="Forecasts & surveys";
//		assertTrue(statistaPage.optionsInfos.isDisplayed());
		System.out.println(BrowserUtils.getTopicNameLists(statistaPage.topicNameLists, name));
		assertTrue(BrowserUtils.getTopicNameLists(statistaPage.topicNameLists,name).equals(name));
		
		name="Infographics";
//		assertTrue(statistaPage.optionsInfos.isDisplayed());
		System.out.println(BrowserUtils.getTopicNameLists(statistaPage.topicNameLists, name));
		assertTrue(BrowserUtils.getTopicNameLists(statistaPage.topicNameLists,name).equals(name));
		
		name="Topics";
//		assertTrue(statistaPage.optionsTopics.isDisplayed());
		System.out.println(BrowserUtils.getTopicNameLists(statistaPage.topicNameLists, name));
		assertTrue(BrowserUtils.getTopicNameLists(statistaPage.topicNameLists,name).equals(name));
		
		BrowserUtils.getTopicListsAndClick(statistaPage.topicLists, "Statistics");

		BrowserUtils.waitFor(3);
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Statistics"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Statistics"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Forecasts & surveys"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Forecasts & surveys"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Infographics"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Infographics"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Topics"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Topics"));
		
		assertTrue(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Dossiers"));
		System.out.println(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Dossiers"));
		assertTrue(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Statista studies"));
		System.out.println(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Statista studies"));
		assertTrue(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Industry & country reports"));
		System.out.println(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Industry & country reports"));
		assertTrue(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Additional studies"));
		System.out.println(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Additional studies"));
		assertTrue(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Digital Markets"));
		System.out.println(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Digital Markets"));
		assertTrue(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Consumer Markets"));
		System.out.println(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Consumer Markets"));
		assertTrue(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Companies"));
		System.out.println(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Companies"));

					
	}

}
