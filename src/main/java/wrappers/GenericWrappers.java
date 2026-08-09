package wrappers;

import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class GenericWrappers extends Wrappers{

  protected WebDriverWait wait;
  protected JavascriptExecutor js;
  protected Actions actions;
  
              
  public void waitForVisibility(WebElement element, int seconds) {
	  
	  wait= new WebDriverWait(driver, Duration.ofSeconds(seconds));
	  wait.until(ExpectedConditions.visibilityOf(element));
  }
  
  public void waitForInvisibility(WebElement element, int seconds) {
	  wait =new WebDriverWait(driver, Duration.ofSeconds(seconds));
	  wait.until(ExpectedConditions.invisibilityOf(element));
	  
  }
  public void waitForClickable(WebElement element, int seconds) {
	  wait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
	  wait.until(ExpectedConditions.elementToBeClickable(element));
  }
   public void javascriptClick(WebElement element) {
	   js = (JavascriptExecutor) driver;
	   js.executeScript("arguments[0].click();", element);	   
	   
   }
   
   public void javascriptScroll(WebElement element) {
	   js= (JavascriptExecutor) driver;
	   js.executeScript("argument[0].scrollIntoView(true);", element);
	   
   }
   
   public void dragAndDrop(WebElement source, WebElement target) {
	   actions  =new Actions(driver);
	   actions.dragAndDrop(source, target).perform();
   }
   public void mouseHover(WebElement element) {
	   actions =new Actions(driver);
	   actions.moveToElement(element).perform();
   }
   public String takeScreenShot(String screenshotName) {

	    File folder = new File("screenshots");

	    if (!folder.exists()) {
	        folder.mkdirs();
	    }

	    String timestamp =
	            new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	    String fileName = screenshotName + "_" + timestamp + ".png";

	    String destination = "screenshots/" + fileName;

	    File source =
	            ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	    try {
	        FileUtils.copyFile(source, new File(destination));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    // Path relative to ExtentReport.html
	    return "../screenshots/" + fileName;
	}
}



