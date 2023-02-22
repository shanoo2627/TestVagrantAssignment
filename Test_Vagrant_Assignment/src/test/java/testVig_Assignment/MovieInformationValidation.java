package testVig_Assignment;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.Assgnt.objectRepository.java.IMDBDetails_InformationPage;
import org.Assgnt.objectRepository.java.WikiMovie_InformationPage;
import org.Assignment.genericUtility.java.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MovieInformationValidation extends BaseClass {
	
	@Test
	public void imdbTest() throws InterruptedException {
		
		String imdbReleaseDate;
		String imdbCountry;
		String wikiReleaseDate;
		String wikiCountry;
		
		
		// create object for Common POM repo classes
		 imdb = new IMDBDetails_InformationPage(driver);
		 wiki = new WikiMovie_InformationPage(driver);

		// Navigating the Application
		webdriverUtility.openApplication(imdburl);
		Thread.sleep(5000);
		imdbReleaseDate = imdb.getActualReleaseDate();
		imdbCountry = imdb.getActualCountryName();
		webdriverUtility.openApplication(wikiurl);
		Thread.sleep(5000);
		wikiReleaseDate = wiki.getActualReleaseDate();
		wikiCountry = wiki.getActualCountryName();
		
		System.out.println(imdbReleaseDate);
		System.out.println(imdbCountry);
		System.out.println(wikiReleaseDate);
		System.out.println(wikiCountry);
		
		String[] sad = imdbReleaseDate.split("\\(");
        System.out.println(sad[0]);
        String imdbDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date(sad[0]));
        String wikiDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date(wikiReleaseDate));
        System.out.println("***********************************");
        System.out.println(imdbDate);
        System.out.println(wikiDate);
        System.out.println("***********************************");
        Assert.assertEquals(imdbDate, wikiDate);
        Assert.assertEquals(imdbCountry, wikiCountry);
		
		//String text = driver.findElement(By.xpath("//a[.='Release date']/following-sibling::div")).getText();
		//System.out.println("Release Date:-"+text);
		
		//String imdbCountryText = driver.findElement(By.xpath("//button[.='Country of origin']/following-sibling::div")).getText();
		//System.out.println("Country of origin:-"+imdbCountryText);
		
		//driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		
		//int y1 = driver.findElement(By.xpath("//span[@id='Plot']")).getLocation().getY();
		//JavascriptExecutor j1 = (JavascriptExecutor)driver;
		//j1.executeScript("window.scrollBy(0,"+y1+")");
		
		
		//String Text = driver.findElement(By.xpath("//tbody//div[.='Release date']/following::div[@class='plainlist']/descendant::li")).getText();
		//System.out.println("Release Date:-"+Text);
		
		//String wikiCountryText = driver.findElement(By.xpath("//tbody//td[.='India']")).getText();
		//System.out.println("Country:-"+wikiCountryText);
		
		
		//if (imdbCountryText.equals(wikiCountryText)) {
			//System.out.println("Successfully----> TC is Pass");
		//} else {
		//	System.out.println(" ----> TC is fail");
		//}
		
		
		
		
		
	}

}
