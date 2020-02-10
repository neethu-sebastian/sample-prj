package com.hrm.utilities;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static XSSFWorkbook wb;
	
	//Initializing Excel file object and tracing to workbook. 
	public ExcelUtils()
	{
		File src = new File("./TestData/TestData.xlsx"); 
	
		try {
			FileInputStream fis = new FileInputStream(src);
				wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
		
			System.out.println("The Excel File cannobe be read --> " + e.getMessage());
		}
	}

	
	public String getStringData(int sheetnumber, int row, int column)
	{
	return wb.getSheetAt(sheetnumber).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String sheetname, int row, int column)
	{
	return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(int sheetnumber,int row, int column)
	{
		return wb.getSheetAt(sheetnumber).getRow(row).getCell(column).getNumericCellValue();
	}
	
	public double getNumericData(String sheetname,int row, int column)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
	}
	
	
	
	
	
	
}
