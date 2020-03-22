package com.adzhiametov.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {

	public static String getTextForElement(WebDriver driver, WebElement element) {
		return (String) ((JavascriptExecutor) driver).executeScript(
				"return jQuery(arguments[0]).text();", element);
	}

}
