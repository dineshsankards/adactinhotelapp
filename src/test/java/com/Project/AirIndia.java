package com.Project;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.baseclass.BaseClass;

public class AirIndia extends BaseClass{

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\MavenProject\\chromedriver1\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		navigate_To_Url("https://www.igp.com/");
		driver.manage().window().maximize();
		WebElement cake = driver.findElement(By.xpath("(//span[text()='Cakes'])[2]"));
		Actions act = new Actions(driver);
		act.click(cake).build().perform();
		

//		driver.findElement(By.xpath("//span[text()='Designer Cakes']")).click();
//		List<WebElement> gift = driver.findElements(By.xpath(
//				"//div[@class='product-item product-item-revamp z-depth-1 hoverable listing-igp   igp-rebrand-class  ']"));
//		int size = gift.size();
//		// System.out.println(size);
//
//		for (WebElement giftthings : gift) {
//			String text = giftthings.getText();
//			System.out.println(text);
//		}
	}
}
