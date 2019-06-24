package com.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Base {
	public static WebDriver obj_driver;
	static WebDriverWait obj_wait;
	static Actions obj_action;
	static Select obj_select;

	public static void meth_openBrowser(String param_browser) {

		if (param_browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
			obj_driver = new ChromeDriver();
		} else if (param_browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:/Drivers/geckodriver.exe");
			obj_driver = new FirefoxDriver();
		}
		
		obj_driver.manage().window().maximize();
		obj_driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		obj_wait = new WebDriverWait(obj_driver, 5);
		obj_action = new Actions(obj_driver);
	}
	
	public static void meth_goToURL(String URL) {
		obj_driver.get(URL);
	}
	
	public static void meth_verifyURL(String URL) {
		Assert.assertEquals(obj_driver.getCurrentUrl(), URL);
		System.out.println("Correct URL");
	}
	
	public static void meth_verifyTitle(String title) {
		Assert.assertEquals(obj_driver.getTitle(), title);
		System.out.println("Correct title");
	}
	
	public static void meth_click(WebElement element) {
		element.click();
	}
	
	public static void meth_sendKeys(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public static void meth_clear(WebElement element) {
		element.clear();
	}
	
	public static void meth_hover(WebElement element) {
		obj_action.moveToElement(element).build().perform();
	}
	
	public static void meth_doubleClick(WebElement element) {
		obj_action.doubleClick(element).perform();
	}
	
	public static void meth_waitForElementToBeClickable(WebElement element) {
		obj_wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void meth_waitForVisibilityOfElement(WebElement element) {
		obj_wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void meth_waitForTextToBePresentInElement(WebElement element, String text) {
		obj_wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public static void meth_waitUntilAlertIsPresent() {
		obj_wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void meth_acceptAlertBox() {
		obj_driver.switchTo().alert().accept();
	}
	
	public static void meth_selectByVisibleText(WebElement element, String text) {
		obj_select = new Select(element);
		obj_select.selectByVisibleText(text);
	}
	
	public static void meth_closeBrowser() {
		obj_driver.close();
	}
	
	public static void meth_quitBrowser() {
		obj_driver.quit();
	}

}
