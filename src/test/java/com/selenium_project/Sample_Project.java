package com.selenium_project;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample_Project {
	public static WebDriver driver;

	private static void browser_Launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.myntra.com/kids?f=Categories%3ATshirts%3A%3AGender%3Aboys%2Cboys%20girls&plaEnabled=false");
	}
	private static void total_No_Of_Products() {
		List<WebElement> findElement = driver.findElements(By.xpath("//li[@class='product-base']"));
		for (WebElement w : findElement) {
			System.out.println(w.getText());
		}
		System.out.println("---------------------------------------------");
		int size = findElement.size();
		System.out.println("Total number of products = " + size);
		System.out.println("---------------------------------------------");
	}
	private static void minimum_Price_Of_The_Product() {
		List<WebElement> Kids_Tshirt_Prices = driver.findElements(By.xpath("//span[@class='product-discountedPrice']"));
		int size = Kids_Tshirt_Prices.size();
		System.out.println(size);
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			String text = Kids_Tshirt_Prices.get(i).getText();
			System.out.println(text);
			String replace = text.replace("Rs. ","");
			System.out.println(replace);
			Integer Prices = Integer.valueOf(replace);
			l.add(Prices);
		}
		Integer minimum_price = Collections.min(l);
		System.out.println("Minimum price = Rs. "+minimum_price);
	}
	private static void minimum_Price_And_Its_Product() {
		List<WebElement> Product_Name = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		int size = Product_Name.size();
		for (int i = 0; i < size; i++) {
			String text = Product_Name.get(i).getText();
			System.out.println(text);
		}
	}
	private static void Mapping_Product() {
		List<WebElement> Product_Name = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		Map<Key,Value> m = new HashMap<Key, Value>();
		int size = Product_Name.size();
		for (int i = 0; i < size; i++) {
			String text = Product_Name.get(i).getText();
			System.out.println(text);
		}
	}
	

	public static void main(String[] args) {
		browser_Launch();
		total_No_Of_Products();
		minimum_Price_Of_The_Product();
		minimum_Price_And_Its_Product();
	}
}
