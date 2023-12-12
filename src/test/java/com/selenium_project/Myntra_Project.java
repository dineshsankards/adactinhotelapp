package com.selenium_project;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.analysis.function.Max;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.baseclass.BaseClass;
import com.fasterxml.jackson.annotation.JacksonInject.Value;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra_Project {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(
				"https://www.myntra.com/kids?f=Categories%3ATshirts%3A%3AGender%3Aboys%2Cboys%20girls&plaEnabled=false");
		List<WebElement> findElement = driver.findElements(By.xpath("//li[@class='product-base']"));
		for (WebElement w : findElement) {
			System.out.println(w.getText());
		}
		int size = findElement.size();
		System.out.println("Total number of products = " + size);
		System.out.println("=============================================");
		List<WebElement> Kids_Tshirt_Prices = driver.findElements(By.xpath("//span[@class='product-discountedPrice']"));
		int size1 = Kids_Tshirt_Prices.size();
		System.out.println("No of Products price = " + size1);
		List<WebElement> Product_Name = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		int size2 = Product_Name.size();
		System.out.println("Number of Products = " + size2);
		List<Integer> l = new ArrayList<>();
		Map<Integer, String> m = new HashMap<>();
		for (int i = 0; i < size - 2; i++) {
			String text = Kids_Tshirt_Prices.get(i).getText();
			String replace = text.replace("Rs. ", "");
			Integer Prices = Integer.valueOf(replace);
			l.add(Prices);
			String text1 = Product_Name.get(i).getText();
			m.put(Prices, text1);
		}
		System.out.println(m);
		Integer min = Collections.min(l);
		System.out.println(min);
		String string = m.get(min);
		System.out.println("Minimum Price of the product and its name = " + min + " , " + string);

//		Set<Entry<Integer, String>> entryset = m.entrySet();
//		System.out.println(m);
//		System.out.println(entryset);
//		int minValue = Integer.MIN_VALUE;

	}

}
