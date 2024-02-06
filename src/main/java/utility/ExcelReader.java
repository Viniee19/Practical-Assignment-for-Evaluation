package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static String readData(int sheetNo, int row, int column) throws IOException{
	
		String path= System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx";
        File src = new File(path);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh1 = wb.getSheetAt(sheetNo);
		DataFormatter df = new DataFormatter();		
		String value = df.formatCellValue(sh1.getRow(row).getCell(column));		
//		int numberofrows = sh1.getLastRowNum();	
//		System.out.println("total number of row are :"+numberofrows);				
//		int totalcolumncount = sh1.getRow(0).getLastCellNum();		
//		System.out.println("Total number of column are :"+totalcolumncount);				
		return value;
		
		
	}

}
