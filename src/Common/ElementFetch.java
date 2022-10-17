package Common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import DriverCode.BaseClass;

/*
Selenium common features implemented in this class.
1. ClickByElement.
2. ClickByElements.
3. DragandDrop.
4. DropDown Selection/Deselection.
5. Alerts - Pendings
6. 
 */

public class ElementFetch{
	
	static Select select;
	
	public WebElement clickByElement(String selector, String value) {
		selector = selector.toLowerCase();	
		switch (selector) {
		case "id":
			return BaseClass.driver.findElement(By.id(value));
		case "name":
			return BaseClass.driver.findElement(By.name(value));
		case "classname":
			return BaseClass.driver.findElement(By.className(value));
		case "xpath":
			return BaseClass.driver.findElement(By.xpath(value));
		case "linktext":
			return BaseClass.driver.findElement(By.linkText(value));
		case "partiallinktext":
			return BaseClass.driver.findElement(By.partialLinkText(value));
		case "tagname":
			return BaseClass.driver.findElement(By.tagName(value));
		case "cssselector":
			return BaseClass.driver.findElement(By.cssSelector(null));
		default:
			return null;
		}	
	}
	
	public List<WebElement> clickByElements(String selector, String value) {
		selector = selector.toLowerCase();	
		switch (selector) {
		case "id":
			return BaseClass.driver.findElements(By.id(value));
		case "name":
			return BaseClass.driver.findElements(By.name(value));
		case "classname":
			return BaseClass.driver.findElements(By.className(value));
		case "xpath":
			return BaseClass.driver.findElements(By.xpath(value));
		case "linktext":
			return BaseClass.driver.findElements(By.linkText(value));
		case "partiallinktext":
			return BaseClass.driver.findElements(By.partialLinkText(value));
		case "tagname":
			return BaseClass.driver.findElements(By.tagName(value));
		case "cssselector":
			return BaseClass.driver.findElements(By.cssSelector(null));
		default:
			return null;
		}
		
	}
	
	public Actions dragAndDrop(WebElement From, WebElement Target) {
		Actions act = new Actions(BaseClass.driver);
		return act.dragAndDrop(From, Target);	
	}
	
	public void dropDownSelect(WebElement DropDownBOX, String selectiontype, int value) {
		selectiontype = selectiontype.toLowerCase();
		select = new Select(DropDownBOX);
		switch (selectiontype) {
		case "selectbyindex":
			select.selectByIndex(value);
			break;
		default:
			break;
		}
		
	}
	
	public void dropDownSelect(WebElement DropDownBOX, String selectiontype, String value) {
		selectiontype = selectiontype.toLowerCase();
		select = new Select(DropDownBOX);
		switch (selectiontype) {
		case "selectbyvalue":		
			select.selectByValue(value);
			break;
		case "selectbyvisibletext":		
			select.selectByVisibleText(value);
			break;
		default:
			break;
		}
	}
	
	public void dropDownDeSelect(WebElement DropDownBOX, String selectiontype, int value) {
		selectiontype = selectiontype.toLowerCase();
		select = new Select(DropDownBOX);
		switch (selectiontype) {
		case "deselectbyindex":
			select.deselectByIndex(value);
			break;
		default:
			break;
		}
		
	}
	
	public void dropDownDeSelect(WebElement DropDownBOX, String selectiontype, String value) {
		selectiontype = selectiontype.toLowerCase();
		select = new Select(DropDownBOX);
		switch (selectiontype) {
		case "deselectbyvalue":		
			select.deselectByValue(value);
			break;
		case "deselectbyvisibletext":		
			select.deselectByVisibleText(value);
			break;
		default:
			break;
		}
	}
	
	
	
	
	
	
    public void windowHandle() {
		
		BaseClass.driver.findElement(By.xpath("//*[contains(text(),'Open Multiple')]")).click();
		
		String mainwindow = BaseClass.driver.getWindowHandle();

//		ArrayList<String> list = new ArrayList<>(BaseClass.driver.getWindowHandles());	
//		
//		for (String string : list) {
//			String WindowTitle = BaseClass.driver.switchTo().window(string).getTitle();
//		}
		
		
		Set<String> allwindow = BaseClass.driver.getWindowHandles();		
		Iterator<String> it = allwindow.iterator();
		
		while(it.hasNext()) {
			String iterateeachwindow = it.next();
			String eachwindowtitle = BaseClass.driver.switchTo().window(iterateeachwindow).getTitle();
			
			System.out.println(eachwindowtitle);
			if(eachwindowtitle.contains("Dashboard")) {
				BaseClass.driver.close();
			}else if(eachwindowtitle.contains("Web Table")){
				BaseClass.driver.close();
			}
		}
		
		//BaseClass.driver.quit();
	}

}
