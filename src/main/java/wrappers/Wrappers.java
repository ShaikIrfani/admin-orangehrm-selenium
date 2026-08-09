package wrappers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class Wrappers {
	
	protected WebDriver driver;
	
	public void click(WebElement element) {
		  element.click();
		
	}
  
	public void type(WebElement element, String value){
		 	element.clear();
		 	element.sendKeys(value);
	}
	public void clear(WebElement element) {
		element.clear();
	}
	
	public String getText(WebElement element) {
		return element.getText();
}
	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
		
	}
	
	public boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}
	public boolean isSelected(WebElement element) {
		return element.isSelected();
		
	}
	
	public String getTitle() {
		return driver.getTitle();
		
	}
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
		
	}
	public void closeBrowser() {
		driver.close();
	}
	public void quitBrowser() {
		driver.quit();
	}
	public void refreshPage() {
		driver.navigate().refresh();
	}
	public void back() {
		driver.navigate().back();
	}
	public void forward() {
		driver.navigate().forward();
			
	}
	public void selectByVisibleText(WebElement element, String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
		
	}
	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
		
	}
	public void selectByIndex(WebElement element, int index) {
		Select select =new Select(element);
		select.selectByIndex(index);
		
	}
	public void takeScreenshot(String fileName) {
		
	}
	}
	



 

