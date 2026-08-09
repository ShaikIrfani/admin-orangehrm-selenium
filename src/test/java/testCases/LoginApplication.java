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
public class LoginApplication extends BaseClass {
		
@Test(priority=1,dataProvider="Login",dataProviderClass = DataProviders.class)
public void verifyValidLogin(String userName, String password) {
LoginPage loginpage= new LoginPage(driver) ;	
Assert.assertEquals(loginpage.getLoginPageText(), "Login");
loginpage.login(userName,password);
HomePage homepage=new HomePage(driver);
Assert.assertEquals(homepage.getDashboardText(), "Dashboard1");
}

@Test(priority=1,dataProvider="Login",dataProviderClass=DataProviders.class)
public void verifyInValidLogin(String userName, String password) {
	LoginPage loginpage= new LoginPage(driver) ;	
	loginpage.login(userName, password);
}



	
}



	





