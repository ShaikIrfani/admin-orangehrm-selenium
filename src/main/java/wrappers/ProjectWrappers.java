package wrappers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;


public class ProjectWrappers extends GenericWrappers {

	String browser;
	protected ConfigReader config = new ConfigReader();

	public void launchBrowser(String browser) {

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Unsupported Browser : " + browser);

		}
		driver.manage().window().maximize();
	}

	public void loadUrl(String applicationUrl) {
		if (applicationUrl == null || applicationUrl.isBlank()) {

			throw new IllegalArgumentException("URL cannot be empty or null");

		}
		driver.get(applicationUrl);

	}

	@Override
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
			driver=null;
		}

	}

//	@Override
//	public void quitBrowser() {
//		if (driver != null) {
//			driver.quit();
//		}
//
//	}

	public void setImplicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public void enterByXpath(String xpath, String value) {
		WebElement element = driver.findElement(By.xpath(xpath));
		element.clear();
		element.sendKeys(value);
	}

	public void enterCssSelector(String cssSelector, String value) {
		WebElement element = driver.findElement(By.cssSelector(cssSelector));
		element.clear();
		element.sendKeys(value);
	}

	public void clickByXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public String getTextByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public boolean isElementDisplayed(String xpath) {
		return driver.findElement(By.xpath(xpath)).isDisplayed();		
		
	}
	public void waitForVisibility(WebElement element, int seconds) {
	    WebDriverWait wait = new WebDriverWait(
	        driver,
	        Duration.ofSeconds(seconds)
	    );

	    wait.until(ExpectedConditions.visibilityOf(element));
	}

}
