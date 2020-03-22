package com.adzhiametov.mantoshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductPage {

	private By productName = By.cssSelector(".product_info h1");

	private WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public void visit(String productUrl) {
		driver.get(productUrl);
	}

	public String extractProductDataJson() {
		String pageSource = driver.getPageSource();
		String potentialJson = pageSource.substring(pageSource.indexOf("var product_data") + 19, pageSource.indexOf("var currency_format")).trim();
		return potentialJson;

	}

	public String extractProductName() {
		return driver.findElement(productName).getText().replace("\"", "\\\"");
	}
}
