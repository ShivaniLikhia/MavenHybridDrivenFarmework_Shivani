package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {

	public static Object[][] getSheetAllRows(String filePath,String Sheetname) throws IOException{
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(inputStream);
		
		Sheet sheet = wb.getSheet(Sheetname);
		int totalRows = sheet.getLastRowNum();
		int totalCols = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[totalRows][totalCols];
		
		for(int rowIndex =0;rowIndex<totalRows;rowIndex++) {
			for(int colIndex=0;colIndex<totalCols;colIndex++) {
				data[rowIndex][colIndex] = sheet.getRow(rowIndex+1).getCell(colIndex).toString();
			}
		}
		wb.close();
		return data;
	}
}