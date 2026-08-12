package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import DataProviders.DataProviders;
import base.BaseClass;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

@Listeners(TestListener.class)
public class Login extends BaseClass {
		
@Test(priority=1,dataProvider="Login",dataProviderClass = DataProviders.class)
public void verifyLogin(String userName, String password, String expectedResult) {
	LoginPage loginpage = new LoginPage(driver);
	Assert.assertEquals(loginpage.getLoginPageText(), "Login"); 
	loginpage.login(userName ,password);
	if(expectedResult.equalsIgnoreCase("Success")) {
		HomePage homepage= new HomePage(driver);
		Assert.assertEquals(homepage.getDashboardText(), "Dashboard");
	}
	else if(expectedResult.equalsIgnoreCase("UsernameRequried"))
		Assert.assertEquals(loginpage.getUsernameRequiredErrorMessage(), "Requried");
		
	
	else if (expectedResult.equalsIgnoreCase("PasswordRequried")) {
			Assert.assertEquals(loginpage.getPasswordRequriedMessage(), "Requried");
		}
		
	}
	
}

		
		
	
	
	
	



