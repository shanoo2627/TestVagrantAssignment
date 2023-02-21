package org.Assgnt.objectRepository.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IMDBDetails_InformationPage {

	public IMDBDetails_InformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[.='Release date']/following-sibling::div")

	private WebElement actualReleaseDateText;
	
	@FindBy(xpath = "//button[.='Country of origin']/following-sibling::div")

	private WebElement actualCountryOfOriginText;


//business library
	/**
	 * This method is used to click on the create Campaign button
	 * 
	 * @return
	 */
	public String getActualReleaseDate() {
		return actualReleaseDateText.getText();
	}
	public String getActualCountryName() {
		return actualCountryOfOriginText.getText();
	}
}
