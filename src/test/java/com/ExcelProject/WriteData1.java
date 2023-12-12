package com.ExcelProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData1 {

	private static void WriteData() throws IOException {
		File f = new File("C:\\Users\\Admin\\Desktop\\file_example_XLSX_50.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		wb.createSheet("My data").createRow(0).createCell(0).setCellValue("Id");
		wb.getSheet("My data").getRow(0).createCell(1).setCellValue("Name");
		wb.getSheet("My data").getRow(0).createCell(2).setCellValue("Password");

		wb.getSheet("My data").createRow(1).createCell(0).setCellValue(1);
		wb.getSheet("My data").getRow(1).createCell(1).setCellValue("Dinesh");
		wb.getSheet("My data").getRow(1).createCell(2).setCellValue(12345);

		wb.getSheet("My data").createRow(2).createCell(0).setCellValue(2);
		wb.getSheet("My data").getRow(2).createCell(1).setCellValue("sankar");
		wb.getSheet("My data").getRow(2).createCell(2).setCellValue(54321);

		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

		System.out.println("Written successfully");
		
		wb.close();

	}
	public static void main(String[] args) throws IOException {
		WriteData();
	}

}
