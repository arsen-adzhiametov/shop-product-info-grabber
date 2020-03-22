package com.adzhiametov.data;


import java.util.HashMap;
import java.util.Map;

public class Product {

	private String id;
	private Map<String, Integer> quantities = new HashMap<>();
	private String jsonData;

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	public void addSizeQuantity(String size, int quantity) {
		quantities.put(size, quantity);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Product{id='" + id + '\'' + ", quantities=" + quantities +'}';
	}
}
