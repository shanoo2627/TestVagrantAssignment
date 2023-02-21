package org.Assignment.genericUtility.java;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This Class Contains all the web driver action
 * 
 * @author shanoo
 *
 */
public final class WebDriverUtility {

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions act;

	/**
	 * This method is used to setup driver instance
	 * 
	 * @param browser
	 * @return
	 */
	public WebDriver setupDriver(String browser) {

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		default:
			System.out.println("Entered wrong browser key in the Property file");

			break;
		}
		return driver;
	}

	/**
	 * This method is used to maximize the browser
	 */
	public void maxmizeBrowser() {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to wait the page by using Implicit wait
	 * 
	 * @param longTimeout
	 */
	public void implicitWait(long longTimeout) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
	}

	/**
	 * This method is used to navigate the application
	 * 
	 * @param url
	 */
	public void openApplication(String url) {
		driver.get(url);

	}

	/**
	 * This method is used to initialize the action class
	 */
	public void intiallizeActions() {
		act = new Actions(driver);
	}

	/**
	 * This method is used to MouseHover on element
	 * 
	 * @param element
	 */
	public void mouseHoverOnElement(WebElement element) {
		act.moveToElement(element).perform();
	}

	/**
	 * This method is used to perform right click action on current mouse location
	 * 
	 * @param element
	 */
	public void rightClickAction(WebElement element) {
		act.contextClick(element).perform();
	}

	/**
	 * this method is used to close particular Browser
	 */
	public void closeBrowser() {
		driver.quit();
	}

	/**
	 * this method is used to close particular Tab
	 */
	public void closeTab() {
		driver.quit();
	}

	/**
	 * This method is used to switch frame based on index
	 * 
	 * @param index
	 */
	public void switchFrame(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switch frame based on webElement address
	 * 
	 * @param index
	 */
	public void switchFrame(WebElement element) {
		driver.switchTo().frame(element);

	}

	/**
	 * This method is used to switch frame based on name or id
	 * 
	 * @param index
	 */
	public void switchFrame(String nameOrID) {
		driver.switchTo().frame(nameOrID);
	}

	/**
	 * This method is used to handle <select> tag Dropdown by using value attribute
	 * of the <options> tag
	 * 
	 * @param value
	 * @param dropDownElement
	 */
	public void handleSelectDropdown(String value, WebElement dropDownElement) {
		Select select = new Select(dropDownElement);
		select.selectByValue(value);
	}

	/**
	 * This method is used to handle <select> tag Dropdown by using index
	 * 
	 * @param value
	 * @param dropDownElement
	 */
	public void handleSelectDropdown(WebElement dropDownElement, int indexNumber) {
		Select select = new Select(dropDownElement);
		select.selectByIndex(indexNumber);
	}

	/**
	 * This method is used to handle <select> tag Dropdown by using VisibleText
	 * 
	 * @param value
	 * @param dropDownElement
	 */
	public void handleSelectDropdown(WebElement dropDownElement, String visibleText) {
		Select select = new Select(dropDownElement);
		select.selectByVisibleText(visibleText);
	}

	/**
	 * This method is used to take the current page screen shot
	 * 
	 * @param currentClass
	 * @param javaUtility
	 */
	public void takeScreenShotPage(Object currentClass, JavaUtility javaUtility) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./errorshots/" + currentClass.getClass().getSimpleName() + "_"
				+ javaUtility.getCurrentDate("dd_MM_yyyy_HH_mm_sss") + ".png");

		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	/**
	 * This Method is used to take the particular element screen shot
	 * 
	 * @param element
	 * @param currentClass
	 * @param javaUtility
	 */
	public void takeScreenShotElement(WebElement element, Object currentClass, JavaUtility javaUtility) {

		File src = element.getScreenshotAs(OutputType.FILE);
		File dst = new File("./elementScreenShots/" + currentClass.getClass().getSimpleName() + ""
				+ javaUtility.getCurrentDate("dd_MM_yyyy_HH_mm_sss") + ".png");

		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	/**
	 * This method will wait till the element is clickable(Custom wait)
	 * 
	 * @param totalDuration
	 * @param pollingTime
	 * @param element
	 */
	public void waitTillElementClickable(int totalDuration, long pollingTime, WebElement element) {

		int currentTime = 10;

		while (currentTime <= totalDuration) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(1000);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		}
	}

	/**
	 * This method is used to initialize the ExplicitWait or webdriverwait
	 * 
	 * @param timeOuts
	 * @param pollingTime
	 */
	public void intiallizeExplicitWait(long timeOuts, long pollingTime) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOuts));
		wait.pollingEvery(Duration.ofMillis(pollingTime));
		wait.ignoring(Exception.class);
	}

	/**
	 * This method is used to wait untill element is visible
	 * 
	 * @param element
	 */
	public void waitTillElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to wait untill element is visible
	 * 
	 * @param element
	 */
	public void waitTillElementInVisible(WebElement element) {

		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	/**
	 * This method is used to accept the js popup/confirmation popup/allert popup
	 */
	public void jsPopupaccept() {

		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to Dismiss the js popup/confirmation popup/allert popup
	 */
	public void jsPopupdecline() {

		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method is used to send the js popup/confirmation popup/allert popup
	 * 
	 * @param data
	 */
	public void jsPopupSendData(String data) {

		driver.switchTo().alert().sendKeys(data);
	}

	/**
	 * This method is used to fetch the data from the js popup/confirmation
	 * popup/allert popup
	 */
	public void jsPopupGetText() {

		driver.switchTo().alert().getText();
	}

	/**
	 * This method is used to Windo handles
	 * 
	 * @param partialText
	 * @param strategy
	 */
	public void switchWindow(String partialText, String strategy) {

		Set<String> winlds = driver.getWindowHandles();
		for (String id : winlds) {

			driver.switchTo().window(id);
			if (strategy.equalsIgnoreCase("url")) {

				if (driver.getCurrentUrl().contains(partialText)) {
					break;
				}
			} else if (strategy.equalsIgnoreCase("title")) {
				if (driver.getTitle().contains(partialText)) {
					break;
				}

			}

		}
	}

}
