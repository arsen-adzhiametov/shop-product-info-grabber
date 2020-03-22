package com.adzhiametov.mantoshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class CategoryPage {

	private By products = By.cssSelector("[class='product-icon load-img'][href^='/product-pol']");


	private WebDriver driver;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
	}

	public void visit(String href) {
		driver.get(href);
	}

	public List<String> parseProductsUrl() {
		List<WebElement> productsUrl = driver.findElements(products);
		return productsUrl.stream().map(webElement -> webElement.getAttribute("href")).collect(toList());
	}
}
