package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import wrappers.ProjectWrappers;

public class LoginPage extends ProjectWrappers{

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public LoginPage enterUserName(String username) {
		enterByXpath("//input[@name='username']",username);
		return this;
		
	}
	
	public LoginPage enterPassword(String password) {
		enterByXpath("//input[@name='password']",password);
		return this;
		
	}
	
	public LoginPage checkUsernamePasswordfieldEnabled() {
		isElementDisplayed("//input[@name='username']");
		isElementDisplayed("//input[@name='password']");
		return this;
		
	}
	
	public String getLoginPageText() {
		WebElement getLoginPageText=driver.findElement(By.xpath("//h5[text()='Login']"));
		waitForVisibility(getLoginPageText, config.explictWait());
			return getLoginPageText.getText();
		
	}	
	
	public HomePage clickLoginBtn() {
		clickByXpath("//button[@type='submit']");
		return new HomePage(driver);
	}
	
	public LoginPage verifyLoginPage() {
		Assert.assertEquals(getLoginPageText(), "Login");
		return this;
		
		
	}

@FindBy(xpath="//p[normalize-space()='Forgot your password?']")
private WebElement linkForgotPassword;



public HomePage login(String username, String password) {
	//verifyLoginPage();
	checkUsernamePasswordfieldEnabled();
	enterUserName(username);
	enterPassword(password);
	return clickLoginBtn();
}



}