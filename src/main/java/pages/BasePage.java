package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import wrappers.ProjectWrappers;

public class BasePage extends ProjectWrappers {
	
	protected WebDriver driver;
	
	public  BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
