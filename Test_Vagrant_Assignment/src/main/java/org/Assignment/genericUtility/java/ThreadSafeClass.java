package org.Assignment.genericUtility.java;

import org.openqa.selenium.WebDriver;

public class ThreadSafeClass {
	
	
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();

	public static ThreadLocal<WebDriver> getDriver() {
		return driver;
	}

	public static void setDriver(ThreadLocal<WebDriver> driver) {
		ThreadSafeClass.driver = driver;
	}

}
