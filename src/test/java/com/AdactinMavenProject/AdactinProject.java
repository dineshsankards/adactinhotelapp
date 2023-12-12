package com.AdactinMavenProject;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.baseclass.BaseClass;

public class AdactinProject extends BaseClass {
	private static void project_Adactin() throws IOException, InterruptedException {
		driver = browser_Launch("chrome");
		navigate_To_Url("https://adactinhotelapp.com/");
		String title = get_Url_Title(driver);
		System.out.println(title);
		String currentUrl = get_Current_Url(driver);
		System.out.println(currentUrl);
		WebElement Register = driver.findElement(By.xpath("//a[text()='New User Register Here']"));
		boolean t_or_f1 = check_The_Window_Is_Displayed(Register);
		System.out.println("Whether it is displayed true/false = " + t_or_f1);
		clickOnElementRegister(Register);
		Thread.sleep(3000);
		navigate_To_Backward(driver);
		navigate_To_Refresh(driver);
		navigate_To_Forward(driver);
		WebElement Regis_username = driver.findElement(By.xpath("//input[@name='username']"));
		passTheMessageInTheElement(Regis_username, "Dineshrio");
		String attribute_Value = get_The_Attribute_Value(Regis_username, "name");
		System.out.println("get_The_Attribute_Value = "+attribute_Value);
		WebElement Create_Password = driver.findElement(By.xpath("//input[@name='password']"));
		passTheMessageInTheElement(Create_Password, "Ds12345@");
		WebElement Retype_Password = driver.findElement(By.xpath("//input[@name='re_password']"));
		passTheMessageInTheElement(Retype_Password, "Ds12345@");
		WebElement Fullname = driver.findElement(By.xpath("//input[@name='full_name']"));
		passTheMessageInTheElement(Fullname, "Dinesh sankar D");
		WebElement Email_address = driver.findElement(By.xpath("//input[@name='email_add']"));
		passTheMessageInTheElement(Email_address, "dineshrio2611@gmail.com");
		WebElement a = driver.findElement(By.xpath("//input[@type='checkbox']"));
		clickOnElementRegister(a);
		WebElement b = driver.findElement(By.xpath("//a[text()='Go back to Login page']"));
		clickOnElementRegister(b);
		// log in;
		WebElement Login_Username = driver.findElement(By.xpath("//input[@name='username']"));
		boolean usernameIsEnableOrNot = check_Whether_The_Element_Is_Enabled(Login_Username);
		System.out.println("check_Whether_The_Element_Is_Enabled =" + usernameIsEnableOrNot);
		passTheMessageInTheElement(Login_Username, "sandinesh");
		WebElement Login_Password = driver.findElement(By.xpath("//input[@name='password']"));
		boolean passwordIsEnableOrNot = check_Whether_The_Element_Is_Enabled(Login_Username);
		System.out.println("check_Whether_The_Element_Is_Enabled =" + passwordIsEnableOrNot);
		passTheMessageInTheElement(Login_Password, "Ds12345@");
		WebElement Login_Button = driver.findElement(By.xpath("//input[@value='Login']"));
		boolean t_or_f = check_The_Window_Is_Displayed(Login_Button);
		System.out.println("Whether it is displayed or not = " + t_or_f);
		clickOnElementRegister(Login_Button);

		// drop down;
		WebElement findElement = driver.findElement(By.xpath("//select[@id='location']"));
		String text = get_Text(findElement);
		System.out.println(text);
		List<WebElement> get_Options = get_All_Options(findElement);
		for(WebElement we: get_Options) {
			System.out.println(get_Text(we));
		}
		Select s1 = new Select(findElement);
		s1.selectByValue("London");
		
		List<WebElement> get_All_Selected_Options = get_All_Selected_Options(findElement);
		for(WebElement we1:get_All_Selected_Options) {
			System.err.println("get_Selected_Options = "+get_Text(we1));
		}

		WebElement findelement1 = driver.findElement(By.xpath("//select[@name='hotels']"));
		Select s2 = new Select(findelement1);
		s2.selectByIndex(3);

		WebElement findElement2 = driver.findElement(By.xpath("//select[@name='room_type']"));
		Select s3 = new Select(findElement2);
		s3.selectByIndex(2);

		WebElement findElement3 = driver.findElement(By.xpath("//select[@name='room_nos']"));
		Select s4 = new Select(findElement3);
		s4.selectByIndex(2);

		WebElement findelement4 = driver.findElement(By.xpath("//select[@name='adult_room']"));
		Select s5 = new Select(findelement4);
		s5.selectByIndex(3);

		WebElement findelement5 = driver.findElement(By.xpath("//select[@name='child_room']"));
		Select s6 = new Select(findelement5);
		s6.selectByIndex(1);

		WebElement c = driver.findElement(By.xpath("//input[@name='Submit']"));
		clickOnElementRegister(c);
		WebElement d = driver.findElement(By.xpath("//input[@type='radio']"));
		clickOnElementRegister(d);
		WebElement e = driver.findElement(By.xpath("//input[@name='continue']"));
		clickOnElementRegister(e);
		WebElement Enter_Firstname = driver.findElement(By.xpath("//input[@name='first_name']"));
		passTheMessageInTheElement(Enter_Firstname, "Dinesh");
		WebElement Enter_Lastname = driver.findElement(By.xpath("//input[@name='last_name']"));
		passTheMessageInTheElement(Enter_Lastname, "sankar D");
		WebElement Address = driver.findElement(By.xpath("//textarea[@name='address']"));
		passTheMessageInTheElement(Address, "43, Muthu Street" + "\n" + "Thoothukudi - 628002.");
		WebElement CardNumber = driver.findElement(By.xpath("//input[@name='cc_num']"));
		passTheMessageInTheElement(CardNumber, "4512 4845 8458 1125");
		// drop down.
		WebElement findElement6 = driver.findElement(By.xpath("//select[@name='cc_type']"));
		Select g = new Select(findElement6);
		g.selectByIndex(1);

		WebElement findElement7 = driver.findElement(By.xpath("//select[@name='cc_exp_month']"));
		boolean multiple_Or_Not = multiple_Element_Checking(findElement7);
		System.err.println("multiple or not = "+multiple_Or_Not);
		Select h = new Select(findElement7);
		h.selectByIndex(10);

		WebElement findElement8 = driver.findElement(By.xpath("//select[@id='cc_exp_year']"));
		select_By_Value(findElement8, "2027");

		WebElement Cvv = driver.findElement(By.xpath("//input[@name='cc_cvv']"));
		passTheMessageInTheElement(Cvv, "462");
		WebElement BookNow = driver.findElement(By.xpath("//input[@name='book_now']"));
		clickOnElementRegister(BookNow);
		Thread.sleep(7000);
		WebElement findElement9 = driver.findElement(By.cssSelector("input#my_itinerary"));
		taking_Screenshot("screenshot");  //screenshot.
	 	mouse_Action(findElement9);
		browser_Close(driver);
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		project_Adactin();
	}
}