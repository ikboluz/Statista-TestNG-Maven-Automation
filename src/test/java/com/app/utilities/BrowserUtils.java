package com.app.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.pages.StatistaPage;

import net.bytebuddy.asm.Advice.Enter;

public class BrowserUtils {
	
	

	private static WebDriver driver = Driver.getDriver();

	public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static WebElement waitForVisibility(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static WebElement waitForClickablility(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement waitForClickablility(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static WebElement fluentWait(final WebElement webElement, int timeinsec) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeinsec, TimeUnit.SECONDS)
				.pollingEvery(timeinsec, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return webElement;
			}
		});
		return element;
	}

	public static void waitForPageToLoad(long timeOutInSeconds) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		try {
			System.out.println("Waiting for page to load...");
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(expectation);
		} catch (Throwable error) {
			System.out.println(
					"Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
		}
	}

	public static void waitFor(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void switchToWindow(String targetTitle) {
		String origin = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			if (driver.getTitle().equals(targetTitle)) {
				return;
			}
		}
		driver.switchTo().window(origin);
	}

	public static void getScreenShot(String fileName) throws IOException {
		File outputFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(outputFile, new File(System.getProperty("user.dir")
				+ "//src//test//java//com//companyname//projectname//screenshots//" + fileName + ".jpg"));
	}

	/*
	 * this method is for 
	 * "to find all links text".
	 */
	public static List<String> getElementsText(By locator) {

		List<WebElement> elems = driver.findElements(locator);
		List<String> elemTexts = new ArrayList<>();
		for (WebElement link : elems) {
			if (!link.getText().isEmpty()) {
				elemTexts.add(link.getText());
			}
		}

		return elemTexts;
	}

	/*
	 * this method is for Title is displayed.
	 */
	public static boolean isAt() {
		return driver.getTitle()
				.equals("• Statista - The Statistics Portal for Market Data, Market Research and Market Studies");
	}

	/*
	 * this method is for Home page search button.
	 * "Enter your element and data to search "
	 *
	 */
	public static void searchStatista(WebElement element, String search) {
		element.sendKeys(search);
		element.sendKeys(Keys.ENTER);
	}

	/*
	 * this method is for 
	 * "to find the Names under the Topics" 
	 * which is located on left side of page.
	 */
	public static String getTopicNameLists(List<WebElement> elements, String name) {
		String topicName="";
		List<WebElement> elems = elements;
		for (WebElement webElement : elems) {
			if (webElement.getText().contains(name)) {
				topicName=webElement.getText().substring(0, webElement.getText().length() - 3).trim();
			}
		}
		return topicName;
	}
	
	/*
	 * this method is for 
	 * "Topic Lists" you choose topics name
	 * and it's clicking on the check boxes.
	 */
	public static void getTopicListsAndClick(List<WebElement> elements, String name){
		List<WebElement> elems = elements;
		for (int i = 0; i < elems.size(); i++) {
			if(elems.get(i).getText().equals(name)) {
				elems.get(i).click();
			}
		}
	}
	
	
	/*
	 * This method is for
	 * "Verifying CheckBox is CHECKED".
	 */
	public static boolean verifingCheckBoxIsChecked(List<WebElement> elements, String name) {
		//label[@class='entitiy__label']//span[contains(text(),'Topics')]/../../input
		List<WebElement> elems = elements;
		StatistaPage statistaPage = new StatistaPage();
		for (int i = 0; i < elems.size(); i++) {
			if(statistaPage.topicNameLists.get(i).getText().contains(name)) {
				if(elems.get(i).getAttribute("checked")==null) {
					return false;
				}else {
					return true;
				}
			}
		}
		return false;
	}
	
	
	/*
	 * This method is for
	 * "Verifying CheckBox is UNCHECKED".
	 */
	public static boolean verifingCheckBoxIsUnchecked(List<WebElement> elements, String name) {
		
		//label[@class='entitiy__label']//span[contains(text(),'Topics')]/../../input
		List<WebElement> elems = elements;
		StatistaPage statistaPage = new StatistaPage();
		for (int i = 0; i < elems.size(); i++) {
			if(statistaPage.topicNameLists.get(i).getText().contains(name)) {
				if(elems.get(i).getAttribute("checked")==null) {
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}

}
