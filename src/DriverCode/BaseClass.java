package DriverCode;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Common.ElementFetch;

public class BaseClass{
	public static WebDriver driver;
	static String password = "dhana@251296";
	
	static String URL1 = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	static String windowhandle = "https://www.leafground.com/window.xhtml";
	static String GreyHr = "https://goldcoast.greythr.com/";
	ElementFetch actions = new ElementFetch();
	
	public void BrowserExecution(String URL) throws InterruptedException{		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kumaresan\\OneDrive\\Desktop\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		String BrowserName = "chrome";
		switch (BrowserName){
		case "chrome":	
			driver.get(URL);
			break;
		default:
			break;
		}
	}
	
	public void greyHRsample() throws InterruptedException {
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("PW78");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(5000);
			WebElement element = (WebElement) ((JavascriptExecutor)driver).executeScript("return document.querySelector(\"#mainSidebar > perfect-scrollbar > div > div.ps-content > gt-ess-menu\").shadowRoot.querySelector(\"nav > ul > span:nth-child(6) > li > a > figure > img\");");

			element.click();
	}
	//Dimension
	public void browserSize() {
		int width = 900;
		int height = 900;
		Dimension dim = new Dimension(width, height);
		driver.manage().window().setSize(dim);		
		Actions action = new Actions(driver);
		action.keyDown(Keys.ALT).keyDown(Keys.SHIFT).build().perform();
		
	}

	public static void main(String[] args) throws InterruptedException {		
		BaseClass Base = new BaseClass();
		Base.BrowserExecution(GreyHr);
		Base.greyHRsample();
		
	}

}
