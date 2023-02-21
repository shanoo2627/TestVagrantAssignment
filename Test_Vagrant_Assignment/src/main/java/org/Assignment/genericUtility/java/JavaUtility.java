package org.Assignment.genericUtility.java;


import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * this class contains java reusable method
 * 
 * @author shanoo
 *
 */
public final class JavaUtility {

	/**
	 * This method is used to generate the random number with in limit
	 * 
	 * @return
	 */
	public int getRandomNumber(int limit) {

		return new Random().nextInt(limit);
	}
	/**
	 * This method is used to generate the random number with in 1000
	 * 
	 * @return
	 */
	public int getRandomNumber() {

		return new Random().nextInt(1000);
	}

	/**
	 * This Method is used to convert the string to long data type
	 * 
	 * @param stringData
	 * @return
	 */
	public long convertStringToLong(String stringData) {

		return Long.parseLong(stringData);
	}

	/**
	 * this method is used to print the values in console
	 * 
	 * @param value
	 */
	public void printStatement(String value) {
		System.out.println(value);
	}
	
	/**
	 * This Method is used to split the string based on strategy
	 * @param value
	 * @param strategy
	 * @return
	 */
	public String[] splitString(String value, String strategy) {
		
		return value.split(strategy);
	}
	/**
	 * This method is used to get current data in specific strategy
	 * @param strategy
	 * @return
	 */
	
	public String getCurrentDate(String strategy) {
		
		return new SimpleDateFormat(strategy).format(new Date());
		
	}
	/**
	 * This Method is used to Convert Month from string to int
	 * @param monthName
	 * @param strategy
	 * @return
	 */
	public int convertMonthFromStringToInt(String monthName, String strategy) {
		
		return DateTimeFormatter.ofPattern(strategy)
				.withLocale(Locale.ENGLISH)
				.parse(monthName)
				.get(ChronoField.MONTH_OF_YEAR);
		
	}
	
	public void convertMonthFromIntToString() {
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
