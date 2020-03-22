package com.adzhiametov;

import com.adzhiametov.mantoshop.CategoryPage;
import com.adzhiametov.mantoshop.ProductPage;
import com.adzhiametov.mantoshop.StorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static com.adzhiametov.util.Config.chromeDriverPath;

public class MantoShopProductInfoCollector {

	private static final String CHROME_DRIVER_KEY = "webdriver.chrome.driver";

	private WebDriver driver;

	public MantoShopProductInfoCollector() {

		System.setProperty(CHROME_DRIVER_KEY, chromeDriverPath());
		driver = new ChromeDriver();
	}

	public String grab() {
		List<String> jsonDatas = new ArrayList<>();


		StorePage page = new StorePage(driver);
		page.visit();

		List<String> categories = page.parseCategoriesUrl();
		StringBuilder stringBuilder = new StringBuilder("{\n");
		for (String href : categories) {
//		for (int i = 0; i < 1; i++) {


			CategoryPage categoryPage = new CategoryPage(driver);
//			categoryPage.visit(categories.get(i));
			categoryPage.visit(href);

			List<String> productUrls = categoryPage.parseProductsUrl();

			for(String productUrl : productUrls) {
//			for (int j = 0; j < 1; j++) {
				ProductPage productPage = new ProductPage(driver);
//				productPage.visit(productUrls.get(j));
				productPage.visit(productUrl);
				String productName = productPage.extractProductName();
				String jsonData = productPage.extractProductDataJson();
				stringBuilder.append("\"" + productName + "\"" + " : " + jsonData);
				stringBuilder.append(",\n\n");

				jsonDatas.add(jsonData);
				sleep();
			}

			sleep();
		}

		stringBuilder = new StringBuilder(stringBuilder.substring(0, stringBuilder.lastIndexOf(",")));
		stringBuilder.append("\n}");

		driver.close();
		return stringBuilder.toString();
	}

	private void sleep() {
		try {
			Thread.sleep(2250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
