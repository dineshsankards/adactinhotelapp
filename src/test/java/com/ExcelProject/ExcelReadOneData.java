package com.ExcelProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadOneData {
	private  void readOneData() throws IOException{
		// data driven from excel.
		//locating file.
		File f = new File(".\\Excelfile\\list_of_countries_and_dependencies_by_population_density-2743j.xlsx");
		//reading file from excel.
		FileInputStream fis = new FileInputStream(f);
		//workbook.
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(0);  //wb.getSheet("Sheet1")
		
		int pnor = sheet.getPhysicalNumberOfRows();
		System.out.println(pnor);
		for(int i=0; i<=pnor-2; i++) {
			Row row = sheet.getRow(i);
			int pnoc = row.getPhysicalNumberOfCells();
			System.out.println(pnoc);
			for(int j=0; j<=7; j++) {
				Cell cell = row.getCell(j);
				CellType ct = cell.getCellType();
				if(ct.equals(CellType.STRING)) {
					String scv = cell.getStringCellValue();
					System.out.println(scv);
				}
				else if(ct.equals(CellType.NUMERIC)) {
					double ncv = cell.getNumericCellValue();
					System.out.println(ncv);
				}
				
			}
			
		}
		
//		CellType ctype = cell.getCellType();
//		System.out.println(ctype);
//		String stringCellValue = cell.getStringCellValue();
//		System.out.println(stringCellValue);
		
		}
		

	
	public static void main(String[] args) throws IOException {
		ExcelReadOneData read = new ExcelReadOneData();
		read.readOneData();
		
	}
}

//Row row = sheet.getRow(34);
//Cell cell = row.getCell(1);
//CellType Ct = cell.getCellType();
//System.out.println(Ct);
//if(Ct.equals(CellType.STRING)) {
//	String scv = cell.getStringCellValue();
//	System.out.println(scv);
//}
//else if(Ct.equals(CellType.NUMERIC)) {
//	double ncv = cell.getNumericCellValue();
//	int value = (int)ncv;
//	System.out.println(value);
//	
//}

