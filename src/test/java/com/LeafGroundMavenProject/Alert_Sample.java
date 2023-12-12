package com.LeafGroundMavenProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.baseclass.BaseClass;

public class Alert_Sample extends BaseClass {

	public static void leaf_ground() throws InterruptedException {
		driver = browser_Launch("chrome");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		navigate_To_Url("https://www.leafground.com/alert.xhtml");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Show']")).click(); // simple alert.
//		Thread.sleep(1000);
		alert_Function("accept");
		driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click(); // confirm alert.
//		Thread.sleep(1000);
		alert_Function("accept");
		driver.findElement(By.xpath("(//span[text()='Show'])[3]")).click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Show'])[4]")).click();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[2]")).click();

		driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
//		Thread.sleep(1000);
		alert_Sendkeys("Rio bruno");
//		Thread.sleep(1000);
		alert_Function("accept");

		driver.findElement(By.xpath("//span[text()='Delete']")).click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Show'])[6]")).click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[3]")).click();

//		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		leaf_ground();
	}
}
