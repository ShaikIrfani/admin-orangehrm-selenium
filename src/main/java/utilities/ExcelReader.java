package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelReader {
	public static Object[][] getData(String fileName, String sheetName) throws IOException {
		
		String path= System.getProperty("user.dir") +"/src/test/resources/TestData/" +fileName;
		
		FileInputStream fis =new FileInputStream(path);
		Workbook workbook= new XSSFWorkbook(fis);
		System.out.println("Excel file: " + path);
		System.out.println("Available sheets:");

		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
		    System.out.println("Sheet " + i + ": [" 
		            + workbook.getSheetName(i) + "]");
		}
		Sheet sheet =  workbook.getSheet(sheetName);
		int rowCount= sheet.getLastRowNum();
		int columnCount= sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rowCount][columnCount];

        for (int i = 1; i <= rowCount; i++) {

            Row row = sheet.getRow(i);

            for (int j = 0; j < columnCount; j++) {

            	Cell cell = row.getCell(j);

            	if (cell == null) {
            	    data[i - 1][j] = "";
            	} else {
            	    data[i - 1][j] = cell.toString();
            	}
            }
        }

        workbook.close();
        fis.close();

        return data;
    }
		
		
	}


