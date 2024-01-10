package com.testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.beust.jcommander.Parameter;

public class ParameterTest extends BaseClass {
	WebDriver driver;

	@Test
	private void browser_Launch() {
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver1\\chromedriver.exe");
		System.out.println("Property was set");
		driver = new ChromeDriver();
		System.out.println("chromedriver lauched successfully");
	}

	@Parameter()
	@Test
	private void parameter_Demo() {
		driver.get("https://adactinhotelapp.com/");
	}

}
