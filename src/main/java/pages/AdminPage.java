package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class AdminPage extends BaseClass {

	public AdminPage(WebDriver driver) {

		this.driver = driver;

	}

	public AdminPage clickAdminMenu() {
		WebElement Adminmenu = driver.findElement(By.xpath("//span[text()='Admin']"));
		Adminmenu.click();
		return this;

	}
	
	public AdminPage enterUserName(String username) {
		WebElement enterUserName=driver.findElement(By.xpath("//input[contains(@class, 'oxd-input oxd-input--active')][2]"));
		enterUserName.sendKeys(username);
		return this;
	}
	
	public AdminPage userRoledropdown(String userrole) {
	WebElement userRoledropdown=driver.findElement(By.xpath("//i[contains(@class, 'oxd-icon bi-caret-down-fill oxd-select-text--arrow')][1]"));
	userRoledropdown.click();
	return this;
	}
	
	public AdminPage EmployeeNameAutoSelect(String employeename) {
		//List<WebElement> employName=driver.findElements(By.xpath("//input[@placeholder='Type for hints...']"));
		List<WebElement> employName=driver.findElements(By.xpath("//div[contains(@class, 'oxd-autocomplete-text-input oxd')]"));
		System.out.println("EmployeeNameList:" + employName.size());
		for (int i = 0; i < employName.size(); i++) {
			waitForVisibility(employName.get(i) , config.explictWait());
			String employeeText=employName.get(i).getText();
			System.out.println("employeelist:" +employeeText);
			
			if (employeeText.contains(employeename)) {
				employName.get(i).click();
				break;			
				
			}
			
			
		}
		return this;
	}

}
