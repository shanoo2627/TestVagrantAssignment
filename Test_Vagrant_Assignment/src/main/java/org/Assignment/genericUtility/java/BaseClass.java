package org.Assignment.genericUtility.java;


import org.Assgnt.objectRepository.java.IMDBDetails_InformationPage;
import org.Assgnt.objectRepository.java.WikiMovie_InformationPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass extends InstanceClass {

	@BeforeSuite
	public void suiteSetup() {

		// Create Object for Generic Utility
		fileUtility = new FileUtility();
		webdriverUtility = new WebDriverUtility();
		javaUtility = new JavaUtility();
		

		// Initialize data from property file
		fileUtility.initiallizePropertyFile(IConstants.TESTVIGPROPERTYFILEPATH);

		

		// fetch the data from property file
		browser = fileUtility.getDataFromProperty("browser");
		imdburl = fileUtility.getDataFromProperty("imdburl");
		wikiurl = fileUtility.getDataFromProperty("wikiurl");
		String timeouts = fileUtility.getDataFromProperty("timeout");

		// Convert string to long
		longTimeOut = javaUtility.convertStringToLong(timeouts);
	}

	@BeforeClass
	public void classSetup() {
		// Launching the browser in run time based on
		driver = webdriverUtility.setupDriver(browser);

		// pre-setting for the browser
		webdriverUtility.maxmizeBrowser();
		webdriverUtility.implicitWait(longTimeOut);

		// Initialize the implicit wait,actions
		webdriverUtility.intiallizeActions();

	
	}

	@BeforeMethod
	public void methodSetup() {

		

	}

	@AfterMethod
	public void methodTearDown() {
		

	}

	@AfterClass
	public void classTearDown() {
		// closeBrowser
		webdriverUtility.closeBrowser();
	}

}
