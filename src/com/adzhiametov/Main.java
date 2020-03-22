package com.adzhiametov;

import com.adzhiametov.util.Config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.util.Collections.singletonList;

public class Main {

	public static void main(String[] args) throws IOException {

		String output = Config.getProperty("output");

		if (args.length>0 && !args[0].isEmpty()) {
			output = args[0];
		}

		List<String> productsData = singletonList(new MantoShopProductInfoCollector().grab());
		Files.write(Paths.get(output), productsData);
	}
}