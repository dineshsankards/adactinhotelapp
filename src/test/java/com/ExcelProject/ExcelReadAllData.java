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

public class ExcelReadAllData {
	
	private static void allData() throws IOException {
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\Admin\\eclipse-workspace\\MavenProject\\Excelfile\\list_of_countries_and_dependencies_by_population_density-2743j.xlsx"));
		Workbook wb = new XSSFWorkbook(fis);
		DataFormatter df = new DataFormatter();
	
		Iterator<Sheet> sheet = wb.sheetIterator();
		while(sheet.hasNext()) {
			Sheet sh = sheet.next();
			System.out.println("Sheet name is: "+sh.getSheetName());
			Iterator<Row> row = sh.iterator();
			while(row.hasNext()) {
				Row r = row.next();
				Iterator<Cell> cell = r.iterator();
				while(cell.hasNext()) {
					Cell c = cell.next();
//					String cellvalue = dataformatter.formatCellValue(c);
				}
			}
		}
		
		
		
		
//		File file_path = new File(".\\Excelfile\\list_of_countries_and_dependencies_by_population_density-2743j.xlsx");
//		FileInputStream file_read = new FileInputStream(file_path);
//		Workbook book = new XSSFWorkbook(file_read);
//		Sheet sheet_name = book.getSheet("Countries by population density");
//		int Numberofrows = sheet_name.getPhysicalNumberOfRows();
//		System.out.println(Numberofrows);
//		Row row = sheet_name.getRow(0);
//		System.out.println(row);
//		Cell cell = row.getCell(0);
		
		
		
		
//		int i=1;
//		while(i<Numberofrows-1) {
//			Row row = sheet_name.getRow(i);
//			int Numberofcells = row.getPhysicalNumberOfCells();	
//			int j=1;
//			while(j<Numberofcells-1){
//				
//			Cell cell = row.getCell(j);
//			System.out.println(cell);
//			
//			CellType cellType = cell.getCellType();
//			if(cellType.equals(cellType.STRING)) {
//				String stringCellValue = cell.getStringCellValue();
//				System.out.println(stringCellValue);
//			}
//			else if(cellType.equals(cellType.NUMERIC)) {
//				double numericCellValue = cell.getNumericCellValue();
//				long b = (long)numericCellValue;
//				System.out.println(b);
//				
//				}
//			j++;
//			}
//			i++;
//		}
		
//		for(int i=1; i<Numberofrows-1; i++)
//		{
//			Row row = sheet_name.getRow(i);
//			int Numberofcells = row.getPhysicalNumberOfCells();
//			System.out.println(Numberofcells);
//			for(int j=0; j<Numberofcells-1; j++)
//			{
//				Cell cell = row.getCell(j);
//				System.out.println(cell);
//				CellType cellType = cell.getCellType();
//				if(cellType.equals(CellType.STRING)) {
//					String String_value = cell.getStringCellValue();
//					System.out.println(String_value);
//				}
//				else if(cellType.equals(CellType.NUMERIC)) {
//					double numericCellValue = cell.getNumericCellValue();
//					int a = (int)numericCellValue;
//					System.out.println(a);
//				}
//			}
//		}
//		book.close();
		
	}
	
	public static void main(String[] args) throws IOException {
		allData();
		
	}

}
