package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ConfigReader;
import wrappers.ProjectWrappers;

public class BaseClass extends ProjectWrappers {

	protected ConfigReader config;

	public BaseClass() {

		config = new ConfigReader();
	}

	@BeforeMethod
	public void setUp() {

	    logger.info("========== Test Setup Started ==========");

	    logger.info("Launching browser: {}", config.getBrowser());
	    launchBrowser(config.getBrowser());

	    logger.info("Setting implicit wait: {} seconds",
	            config.implicitWait());
	    setImplicitWait(config.implicitWait());

	    logger.info("Loading application URL");
	    loadUrl(config.getSITUrl());

	    logger.info("========== Test Setup Completed ==========");
	}
	

	@AfterMethod
	public void close() {

	    logger.info("Closing browser");
	    closeBrowser();

	    logger.info("========== Test Execution Completed ==========");
	}
	private static final Logger logger =
	        LogManager.getLogger(BaseClass.class);
	
	
	
	}
	
