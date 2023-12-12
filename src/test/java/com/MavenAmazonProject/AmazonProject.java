package com.MavenAmazonProject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.baseclass.BaseClass;

public class AmazonProject extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\EclipseWorkspace2\\LearnSelnium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		String currentUrl = driver.getCurrentUrl();
		System.out.println("currentUrl = " + currentUrl);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//drop down - getOptions:		
		WebElement fe = driver.findElement(By.xpath("//select[@name='url']"));
		fe.click();
		Select s = new Select(fe);
		List<WebElement> op = s.getOptions();
		int size = op.size();
		System.out.println("Number of categories = " + size);
		for (WebElement w : op) {
			String text = w.getText();
			System.out.println(text);
		}
		System.out.println("---------------------------------------------------------------------------");
		s.selectByVisibleText("Books");
		String st = "comics";
		System.out.println("search tag = " + st);
		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys(st); // comics
		WebElement searchsuggestion = driver.findElement(By.xpath(
				"//input[@id='twotabsearchtextbox']//parent::div//ancestor::form//parent::div//parent::div//parent::div//following-sibling::div[@id='nav-flyout-iss-anchor']//descendant::div//descendant::div//following::div//descendant::div[text()='comics'][2]"));
		String text = searchsuggestion.getText();
		System.out.println("Suggestions as per search = " + text);
		boolean contains = text.contains(st);
		System.err.println(contains);

		if (text.contains(st)) {
			driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
			Thread.sleep(2000);
			WebElement firstComicImage = driver.findElement(By.xpath(
					"//span[text()='Results']/parent::div//parent::div//parent::span//parent::div//parent::div//following-sibling::script//following::div//child::div//descendant::div//child::a//child::div//child::img[@class='s-image']"));
			WebElement firstComicText = driver.findElement(By.xpath(
					"//span[text()='Results']/parent::div//parent::div//parent::span//parent::div//parent::div//following-sibling::script//following::div//child::div//child::div//child::span//child::div//child::div//child::div//child::div//following-sibling::div[@class='puisg-col puisg-col-4-of-12 puisg-col-8-of-16 puisg-col-12-of-20 puisg-col-12-of-24 puis-list-col-right']//child::h2//child::span[@class='a-size-medium a-color-base a-text-normal']"));
			String text3 = firstComicText.getText();
			System.out.println(text3);
			firstComicImage.click();
// Window handling:
			String parentwindow = get_Window_Handle(driver);
//			String parentwindow = driver.getWindowHandle();
			Set<String> All_window = get_Window_handles(driver);
//			Set<String> childwindow = driver.getWindowHandles();
			Iterator<String> it = All_window.iterator();

			String pwindow = it.next();
			String cwindow = it.next();
			
			System.err.println("Mission failed...window closed");
//			driver.close();

		}
//		driver.quit();

	}
}
