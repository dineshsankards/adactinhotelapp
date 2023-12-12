package com.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver browser_Launch(String type) {

		if (type.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Admin\\eclipse-workspace\\MavenProject\\chromedriver1\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (type.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Admin\\eclipse-workspace\\Practise_Selenium\\webdriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		return driver;
	}
	public static WebDriver Wait(WebDriver dwait) {
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		return driver;
	}

	public static WebDriver get_Url(String url) {
		driver.get(url);
		return driver;
	}

	public static WebDriver navigate_To_Url(String url1) {
		driver.navigate().to(url1);
		return driver;
	}
	public static WebDriver navigate_To_Backward(WebDriver d2) {
		driver.navigate().back();
		return driver;
	}
	public static WebDriver navigate_To_Forward(WebDriver d3) {
		driver.navigate().forward();
		return driver;
	}
	public static WebDriver navigate_To_Refresh(WebDriver d4) {
		driver.navigate().refresh();
		return driver;
	}

	public static boolean check_The_Window_Is_Displayed(WebElement w2) {
		boolean displayed = w2.isDisplayed();
		return displayed;
	}

	public static boolean check_Whether_The_Element_Is_Enabled(WebElement w3) {
		boolean enabled = w3.isEnabled();
		return enabled;
	}
	public static boolean check_Whether_The_It_Was_Selected_Or_Not(WebElement w4) {
		boolean selected = w4.isSelected();
		return selected;
	}

	public static String get_Url_Title(WebDriver urltitle) {
		String title = driver.getTitle();
		return title;
	}
//	public static String get_Title(WebDriver urltitle) {
//		String title = driver.getTitle();
//		return title;
//	}

	public static String get_Current_Url(WebDriver currenturl) {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	

	public static void clickOnElementRegister(WebElement w1) {
		w1.click();
	}

	public static void passTheMessageInTheElement(WebElement element, String R_username) {
		element.sendKeys(R_username);
	}

	public static String get_Text(WebElement elementText) {
		String text = elementText.getText();
		return text;
	}
	public static String get_The_Attribute_Value(WebElement element1, String name) {
		String attribute = element1.getAttribute(name);
		return attribute;
	}

	public static void taking_Screenshot(String screenshotname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File location = new File(
				"C:\\Users\\Admin\\eclipse-workspace\\MavenProject\\Screenshots\\" + screenshotname + ".png");
		FileUtils.copyFile(screenshotAs, location);
	}

	public static void mouse_Action(WebElement fe) {
		Actions act = new Actions(driver);
		act.click(fe).build().perform();
	}
	public static void select_By_Value(WebElement fe6, String value) {
		Select s = new Select(fe6);
		s.selectByValue(value);
	}
	public static void select_By_Text(WebElement fe7, String name) {
		Select s = new Select(fe7);
		s.selectByVisibleText(name);
	}
	public static void select_By_Index(WebElement fe8, int number) {
		Select s = new Select(fe8);
		s.selectByIndex(number);
	}
	public static boolean multiple_Element_Checking(WebElement fe9) {
		Select s = new Select(fe9);
		boolean multiple = s.isMultiple();
		return multiple;
	}
	public static List<WebElement> get_All_Options(WebElement fe10) {
		Select s = new Select(fe10);
		List<WebElement> options = s.getOptions();
		return options;
	}
	public static List<WebElement> get_All_Selected_Options(WebElement fe11) {
		Select s = new Select(fe11);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		return allSelectedOptions;
	}
	public static WebElement get_First_Selected_Options(WebElement fe12) {
		Select s = new Select(fe12);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		return firstSelectedOption;
	}
	public static WebDriver alert_Function(String type) {
		if(type.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().accept();	
		}
		else if(type.equalsIgnoreCase("dismiss")) {
			driver.switchTo().alert().dismiss();
		}
		else if(type.equalsIgnoreCase("getText")){
			driver.switchTo().alert().getText();
		}
		return driver;
	}
	public static WebDriver alert_Sendkeys(String name) {
		driver.switchTo().alert().sendKeys(name);
		return driver;
	}
	
	public static void scroll_Up(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("Window.scrollBy(0,-500);");
	}
	public static void scroll_Down(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("Window.scrollBy(0,500);");
	}
	public static void scroll_To_Element(WebDriver driver, WebElement w1) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();",w1);
	}
//	public static void robot_Class() throws AWTException {
//		Robot r = new Robot();
//	}
	public static String get_Window_Handle(WebDriver driver) {
		String w_Handle = driver.getWindowHandle();
		return w_Handle;
	}
	public static Set<String> get_Window_handles(WebDriver driver) {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}
//	public static WebDriver switch_To_Window(String window_Handle) {
//		WebDriver window = driver.switchTo().window(window_Handle);
//		return window;
//	}
	public static WebDriver browser_Window_Quit(WebDriver d5) {
		driver.quit();
		return driver;
	}

	public static WebDriver browser_Close(WebDriver d1) {
		driver.close();
		return driver;
	}

}
