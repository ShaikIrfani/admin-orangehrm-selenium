package DataProviders;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import utilities.ExcelReader;

public class DataProviders {

@DataProvider(name="Login")

public Object[][] getData(Method method) throws IOException {
	
	String sheetName=method.getName();
	System.out.println("Test method name: " + sheetName);
	return ExcelReader.getData("Login.xlsx", sheetName);
	
	 
}

	
}
