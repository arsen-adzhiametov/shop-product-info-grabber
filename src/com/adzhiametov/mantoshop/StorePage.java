package com.adzhiametov.mantoshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StorePage {

	private static final String MANTOSHOP_URL = "http://www.*******.***/";

	private final By productCategory = By.cssSelector("[href^='/pol_m']");

	private WebDriver driver;

	public StorePage(WebDriver driver) {
		this.driver = driver;
	}

	public void visit() {
		driver.get(MANTOSHOP_URL);
	}

	public List<String> parseCategoriesUrl() {
		List<WebElement> categories = driver.findElements(productCategory);
		return categories.stream().map(webElement -> webElement.getAttribute("href")).collect(toList());
	}
}
