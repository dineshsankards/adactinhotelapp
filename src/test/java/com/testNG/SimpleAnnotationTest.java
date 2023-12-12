package com.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class SimpleAnnotationTest {

	WebDriver task1;

	@BeforeSuite
	private void set_Property() {
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver1\\chromedriver.exe");
		System.out.println("Property was set");
	}

	@BeforeTest
	private void browser_Launch() {
		task1 = new ChromeDriver();
		System.out.println("chromedriver lauched successfully");
	}

	@BeforeClass
	private void get_Url() {
		task1.manage().window().maximize();
		task1.get("https://adactinhotelapp.com/");
		System.out.println("adactin launched successfully");
		task1.findElement(By.xpath("//a[text()='New User Register Here']")).click();
		task1.findElement(By.xpath("//input[@name='username']")).sendKeys("Dineshrio");
		task1.findElement(By.xpath("//input[@name='password']")).sendKeys("Ds12345@");
		task1.findElement(By.xpath("//input[@name='re_password']")).sendKeys("Ds12345@");
		task1.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Dinesh sankar");
		task1.findElement(By.xpath("//input[@name='email_add']")).sendKeys("dineshrio2611@gmail.com");
		task1.findElement(By.xpath("//input[@type='checkbox']")).click();
		task1.findElement(By.xpath("//a[text()='Go back to Login page']")).click();
		System.out.println("Registration successfully");
	}

	@BeforeMethod
	private void registration_Module() {
		task1.findElement(By.xpath("//input[@name='username']")).sendKeys("sandinesh");
		task1.findElement(By.xpath("//input[@name='password']")).sendKeys("Ds12345@");
		task1.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println("Logged in successfully");
	}

	@Test(priority = 2)
	private void login_In() {
		WebElement findElement = task1.findElement(By.xpath("//select[@id='location']"));
		Select a = new Select(findElement);
		a.selectByValue("London");

		WebElement findelement1 = task1.findElement(By.xpath("//select[@name='hotels']"));
		Select b = new Select(findelement1);
		b.selectByIndex(3);

		WebElement findElement2 = task1.findElement(By.xpath("//select[@name='room_type']"));
		Select c = new Select(findElement2);
		c.selectByIndex(2);

		WebElement findElement3 = task1.findElement(By.xpath("//select[@name='room_nos']"));
		Select d = new Select(findElement3);
		d.selectByIndex(2);

		WebElement findelement4 = task1.findElement(By.xpath("//select[@name='adult_room']"));
		Select e = new Select(findelement4);
		e.selectByIndex(3);

		WebElement findelement5 = task1.findElement(By.xpath("//select[@name='child_room']"));
		Select f = new Select(findelement5);
		f.selectByIndex(1);

		task1.findElement(By.xpath("//input[@name='Submit']")).click();
		System.out.println("Hotel selected successfully");
		task1.findElement(By.xpath("//input[@type='radio']")).click();
		task1.findElement(By.xpath("//input[@name='continue']")).click();
		task1.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Dinesh");
		task1.findElement(By.xpath("//input[@name='last_name']")).sendKeys("sankar D");
		task1.findElement(By.xpath("//textarea[@name='address']"))
				.sendKeys("43, Muthu street" + "\n" + "Thoothukudi-628002.");
		task1.findElement(By.xpath("//input[@name='cc_num']")).sendKeys("4512 4845 8458 1125");
		// drop down.
		WebElement findElement6 = task1.findElement(By.xpath("//select[@name='cc_type']"));
		Select g = new Select(findElement6);
		g.selectByIndex(1);

		WebElement findElement7 = task1.findElement(By.xpath("//select[@name='cc_exp_month']"));
		Select h = new Select(findElement7);
		h.selectByIndex(10);

		WebElement findElement8 = task1.findElement(By.xpath("//select[@id='cc_exp_year']"));
		Select i = new Select(findElement8);
		i.selectByValue("2027");

		task1.findElement(By.xpath("//input[@name='cc_cvv']")).sendKeys("462");
		task1.findElement(By.xpath("//input[@name='book_now']")).click();
		System.out.println("Hotel booked successfully");
		System.out.println("1st Test Completed");
//		Actions act = new Actions(task1);
//		WebElement findElement9 = task1.findElement(By.id("my_itinerary"));
//		act.click(findElement9).build().perform();

	}
	@Test(priority = 1)
	private void my_Itinerary() {
		task1.findElement(By.xpath("//a[text()='Booked Itinerary']")).click();
		task1.findElement(By.xpath("//input[@name='check_all']")).click();
		task1.findElement(By.xpath("//input[@name='cancelall']")).click();
		task1.switchTo().alert().accept();
		System.out.println("2nd test completed");
	}

	@AfterMethod 
	private void log_Out() {
		task1.findElement(By.xpath("//a[text()='Logout']")).click();
		task1.findElement(By.xpath("//a[text()='Click here to login again']")).click();
		System.out.println("Logged out successfully");
	}

	@AfterClass
	private void delete_All_Cookies() {
		task1.manage().deleteAllCookies();
		System.out.println("Cookies deleted");
	}

	@AfterTest
	private void new_Build2() {
		task1.findElement(By.xpath("//strong[text()='Go to Build 2 ']")).click();
		System.out.println("Click the build 2 button successfully");
	}

	@AfterSuite
	private void driver_Closed() {
		task1.close();
		System.out.println("driver closed successfully");

	}

}
