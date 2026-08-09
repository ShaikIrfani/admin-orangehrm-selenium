package listeners;

	import org.testng.ITestListener;
	import org.testng.ITestResult;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import reports.ExtentReportManager;

	public class TestListener implements ITestListener {

	    private ExtentReports extent =
	            ExtentReportManager.getReportInstance();

	    private ExtentTest test;

	    @Override
	    public void onTestStart(ITestResult result) {

	        test = extent.createTest(result.getMethod().getMethodName());

	        test.info("Test execution started");
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {

	        test.pass("Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {

	        test.fail("Test Failed");
	        test.fail(result.getThrowable());

	        String testName = result.getMethod().getMethodName();

	        try {
	            BaseClass baseClass = (BaseClass) result.getInstance();

	            String screenshotPath = baseClass.takeScreenShot(testName);

	            test.addScreenCaptureFromPath(screenshotPath);

	        } catch (Exception e) {
	            test.fail("Unable to capture screenshot: " + e.getMessage());
	        }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {

	        test.skip("Test Skipped");
	    }

	    @Override
	    public void onFinish(org.testng.ITestContext context) {

	        extent.flush();
	    }
	}


