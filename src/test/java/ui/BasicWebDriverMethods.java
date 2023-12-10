package ui;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicWebDriverMethods {

	public static String browser = "Chrome"; // External configuration - XLS, CSV
	public static WebDriver driver;

	public static void main(String[] args) {

		if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		/*
		 * driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html");
		 * 
		 * driver.manage().window().maximize();
		 * 
		 * String currentUrl = driver.getCurrentUrl();
		 * 
		 * String title = driver.getTitle();
		 * 
		 * String pageSource = driver.getPageSource();
		 * 
		 * driver.navigate().to("https://google.com");
		 */

		
		 driver.get("https://www.saucedemo.com/");
		 driver.findElement(By.id("user-name")).sendKeys("standard_user");
		 driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		 driver.findElement(By.id("login-button")).click(); 
		 // driver.close();
		 
		 List<WebElement> webElements = driver.findElements(By.xpath("//div[@class='inventory_list']/div"));
		 System.out.println(webElements);
		 
		 driver.navigate().to("https://sugarcrm.com/");
		 String windowHandle = driver.getWindowHandle();
		 System.out.println(windowHandle);
		 
		 

	}

}
