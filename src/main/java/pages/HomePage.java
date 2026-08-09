package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import wrappers.ProjectWrappers;

public class HomePage extends ProjectWrappers{
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	public String getDashboardText() {
		return getTextByXpath("//h6[text()='Dashboard']");
		
	}
}
	
	