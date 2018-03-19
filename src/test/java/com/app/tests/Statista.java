package com.app.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.app.pages.StatistaPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.TestBase;

public class Statista extends TestBase{
	
	StatistaPage statistaPage = new StatistaPage();
	//1,7,13,19
//	@Test(priority=1)
	public void testST01() {
		
		String title="• Statista - The Statistics Portal for Market Data, Market Research and Market Studies";
		String url="https://www.statista.com/";
		String dataSearch="Panera Bread";
		
	//1
		assertTrue(driver.getTitle().equals(title));
		System.out.println(driver.getTitle().equals(title));
	//2
		assertEquals(driver.getCurrentUrl(), url);
		System.out.println(driver.getCurrentUrl().equals(url));
	//3
		BrowserUtils.searchStatistaButton(statistaPage.homepageTextSearch, dataSearch);
	//4
		assertEquals(statistaPage.searchBoxText.getAttribute("value"), dataSearch);
		System.out.println(statistaPage.searchBoxText.getAttribute("value").equals(dataSearch));
		BrowserUtils.waitForPageToLoad(3);
	}
	
//	@Test(priority=7)
	public void testST07() {
		
		BrowserUtils.waitForPageToLoad(3);
		
		String alrtMessage="Unfortunately, no content could be found. Please check your spelling, try an alternative term or expand your search to the Statista archive.";
		String narrowMessage="Didn’t find what you were looking for?";
		
	//1
		assertTrue(driver.findElement(By.id("statistaLogo")).isDisplayed());
		System.out.println(driver.findElement(By.id("statistaLogo")).isDisplayed());
	//2
		statistaPage.homepageTextSearch.sendKeys("Hello");
		BrowserUtils.waitFor(5);
		statistaPage.homepageTextSearch.clear();
	//3
		BrowserUtils.searchStatistaButton(statistaPage.homepageTextSearch, "%%, **, !!");
	//4
		assertTrue(driver.findElement(By.id("statistaLogo")).isDisplayed());
		System.out.println(driver.findElement(By.id("statistaLogo")).isDisplayed());
	//5
		assertTrue(statistaPage.alertMessage.isDisplayed());
		assertTrue(statistaPage.alertMessage.getText().contains(alrtMessage));
		System.out.println(statistaPage.alertMessage.isDisplayed());
		
	//6
		statistaPage.searchButton.click();
		
		assertTrue(statistaPage.suggestionMessage.isDisplayed());
		assertTrue(statistaPage.suggestionMessage.getText().contains(narrowMessage));
		System.out.println(statistaPage.suggestionMessage.isDisplayed());

	}
	
	
	
//	@Test (priority=13)
	public void testST013() {
		
		String dataSearch="Panera Bread";
		String firstResultName="Americans preferring Panera Bread in the U.S. in 2016 and 2017, by gender";
	//1
		assertTrue(BrowserUtils.isAt());
	//2
		BrowserUtils.searchStatistaButton(statistaPage.homepageTextSearch, dataSearch);
		assertEquals(statistaPage.searchBoxText.getAttribute("value"), dataSearch);
		System.out.println(statistaPage.searchBoxText.getAttribute("value").equals(dataSearch));
	//3
		assertTrue(driver.getTitle().equals("• Search | Statista"));
		System.out.println(driver.getTitle().equals("• Search | Statista"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Statistics"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Statistics"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Forecasts & surveys"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Forecasts & surveys"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Infographics"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Infographics"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Topics"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Topics"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Dossiers"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Dossiers"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Statista studies"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Statista studies"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Industry & country reports"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Industry & country reports"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Additional studies"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Additional studies"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Digital Markets"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Digital Markets"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Consumer Markets"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Consumer Markets"));
		assertTrue(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Companies"));
		System.out.println(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Companies"));
		
		assertTrue(statistaPage.firstResultText.getText().equals(firstResultName));
		System.out.println(statistaPage.firstResultText.getText());
	//4
		int resultNum1=Integer.parseInt(statistaPage.resultNum.getText().substring(1, statistaPage.resultNum.getText().length()-1));
		System.out.println(resultNum1);
	//5
		BrowserUtils.checkAndUncheck("Dossiers");
		BrowserUtils.checkAndUncheck("Statista studies");
		BrowserUtils.checkAndUncheck("Industry & country reports");
		BrowserUtils.checkAndUncheck("Additional studies");
		statistaPage.refreshSearchButton.click();
		BrowserUtils.waitFor(3);
		int resultNum2=Integer.parseInt(statistaPage.resultNum.getText().substring(1, statistaPage.resultNum.getText().length()-1));
		System.out.println(resultNum2);
		System.out.println(BrowserUtils.getTopicNamesResultNum("Dossiers")
			    +BrowserUtils.getTopicNamesResultNum("Statista studies")
			    +BrowserUtils.getTopicNamesResultNum("Industry & country reports")
			    +BrowserUtils.getTopicNamesResultNum("Additional studies")
			    +resultNum2+" "+resultNum1);
		assertEquals(BrowserUtils.getTopicNamesResultNum("Dossiers")
				    +BrowserUtils.getTopicNamesResultNum("Statista studies")
				    +BrowserUtils.getTopicNamesResultNum("Industry & country reports")
				    +BrowserUtils.getTopicNamesResultNum("Additional studies")
				    +resultNum2, resultNum1);
		
	}
	
	
	
	@Test(priority=19)
	public void testST019() {
		
		String dataSearch="cat and dog";
		String firstResultName="Dog/cat food import volume in South Korea from U.S. 2000-2017";
	//1
		assertTrue(BrowserUtils.isAt());
		assertTrue(driver.getCurrentUrl().equals("https://www.statista.com/"));
	//2
		BrowserUtils.searchStatistaButton(statistaPage.homepageTextSearch, dataSearch);
		assertEquals(statistaPage.searchBoxText.getAttribute("value"), dataSearch);
		System.out.println(statistaPage.searchBoxText.getAttribute("value").equals(dataSearch));
	//3
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Statistics"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Statistics"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Forecasts & surveys"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Forecasts & surveys"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Infographics"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Infographics"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Topics"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Topics"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Dossiers"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Dossiers"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Statista studies"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Statista studies"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Industry & country reports"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Industry & country reports"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Additional studies"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Additional studies"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Digital Markets"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Digital Markets"));
		assertTrue(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Consumer Markets"));
		System.out.println(BrowserUtils.verifingCheckBoxIsChecked(statistaPage.topicCheckBoxes, "Consumer Markets"));
		assertTrue(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Companies"));
		System.out.println(BrowserUtils.verifingCheckBoxIsUnchecked(statistaPage.topicCheckBoxes, "Companies"));
//		assertTrue(statistaPage.firstResultText.getText().equals(firstResultName));
		System.out.println(statistaPage.firstResultText.getText());	
	//4
		int resultNum1=Integer.parseInt(statistaPage.resultNum.getText().substring(1, statistaPage.resultNum.getText().length()-1));
	//5
		BrowserUtils.getTopicListsAndClick(statistaPage.topicLists, "Statistics");
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
		int resultNum2=Integer.parseInt(statistaPage.resultNum.getText().substring(1, statistaPage.resultNum.getText().length()-1));
		System.out.println(resultNum2);
		System.out.println(BrowserUtils.getTopicNamesResultNum("Statistics")
			    +BrowserUtils.getTopicNamesResultNum("Forecasts & surveys")
			    +BrowserUtils.getTopicNamesResultNum("Infographics")
			    +BrowserUtils.getTopicNamesResultNum("Topics")
			    +" "+resultNum2);
		assertEquals(BrowserUtils.getTopicNamesResultNum("Statistics")
				    +BrowserUtils.getTopicNamesResultNum("Forecasts & surveys")
				    +BrowserUtils.getTopicNamesResultNum("Infographics")
				    +BrowserUtils.getTopicNamesResultNum("Topics"),
				    resultNum2);
//		assertTrue(statistaPage.firstResultText.getText().equals(firstResultName));
		System.out.println(statistaPage.firstResultText.getText());
	//6
//		assertTrue(resultNum1>resultNum2);
		System.out.println(resultNum1>resultNum2);
		
		
	}

}
