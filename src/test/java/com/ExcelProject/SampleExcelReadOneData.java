package com.ExcelProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SampleExcelReadOneData {

	private static void ReadOneData() throws IOException {
		File f = new File(".\\Excelfile\\list_of_countries_and_dependencies_by_population_density-2743j.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Countries by population density");
		int PNOR = s.getPhysicalNumberOfRows();
		System.out.println("Number of Rows = " + PNOR);
		for (int i = 0; i < PNOR; i++) {
			Row r = s.getRow(i);
			int PNOC = r.getPhysicalNumberOfCells();
			System.out.println("Number of Cells = " + PNOC);
			for (int j = 0; j < PNOC - 1; j++) {
				Cell cell = r.getCell(j);
				CellType cellType = cell.getCellType(); // string or numeric
				if (cellType.equals(CellType.STRING)) {
					String scv = cell.getStringCellValue();
					System.out.println(scv);
				} else if (cellType.equals(CellType.NUMERIC)) {
					double ncv = cell.getNumericCellValue();
					int n = (int) ncv;
					System.out.println(n);
				}
			}
		}
		wb.close();
	}

	public static void main(String[] args) throws IOException {
		ReadOneData();

	}
}
