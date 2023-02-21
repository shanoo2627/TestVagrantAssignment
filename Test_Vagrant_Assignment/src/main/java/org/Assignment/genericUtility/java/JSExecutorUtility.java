package org.Assignment.genericUtility.java;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * this class contains all the JE reusable method /action
 * @author shanoo
 *
 */
public final class JSExecutorUtility {
	private JavascriptExecutor js;
	
	/**
	 * Initialize java script executor
	 * @param driver
	 */
	public void initializeExecutor( WebDriver driver) {
		
		js=(JavascriptExecutor)driver;
	}
	
	/**
	 * NavigateApp by using JSExecutor
	 * @param url
	 */
	public void navigateApp(String url) {
		js.executeScript("window.location=arguments[0]", url);
	}
	/**
	 * This method is used to send the data to textfield using js executor
	 * @param element
	 * @param data
	 */
	public void enterData(WebElement element,String data) {
		js.executeScript("argument[0].click()", element);
		
	}
/**
 * This method is used to scroll till the end of page
 */
	public void scrollTillEnd(String strategy) {
		String sign=strategy.equalsIgnoreCase("up")?"_":"+";
		js.executeScript("window.scrollBy(0,"+sign+"document.body.scrollHeight)");
	}

	/**
	 * This method is used to scroll till some position
	 * @paramy_position
	 */
	public void scrollTillSomePosition(int y_position,String strategy) {
		String sign=strategy.equalsIgnoreCase("up")?"_":"+";
		js.executeScript("window.scrollBy(0,"+sign+"arguments[0])",y_position);
	}
	/**
	 * This method is used to scroll till the element is visible
	 * @param element
	 */
	public void scrollTillElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView()",element);
		
	}
	/**
	 * This method is used to highlight the element
	 * @param element
	 */
	public void highlightElement(WebElement element) {
		js.executeScript("argument[0].setAttribute'style','border:Spx solid red;')",element);
	}
	/**
	 * This method ids used to scroll till the element is visible
	 * @param element
	 */
	public void scrollTillElements(WebElement element) {
		js.executeScript("argument[0].scrollIntoView()",element);
		
	}
	/**
	 * This method is used to highlight the element
	 * @param element
	 */
	public void highlightElements(WebElement element) {
		js.executeScript("argument[0].setAttributes('style','border:Spx solid red;')",element);
		
	}

}
