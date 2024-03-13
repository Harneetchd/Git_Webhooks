package com.training.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel 
{
	static XSSFWorkbook excelworkbook;
	static XSSFSheet  excelworksheet;
	public static void main(String[] args) throws IOException
	{
		//Get the path of the file :returns String
		 String filepath= "/Users/harneetkaur/eclipse-workspace/jan_2023//SeleniumPractice.xlsx";
	
		 //Add File to FileInputStream Object
		 FileInputStream excelfile=new  FileInputStream(filepath);
		 
		 //Convert the POI sheet ...Readable by Java ; poi-ooxml dependency  
		 //Assign one File Input Stream to workbook- xssf workbook
		 XSSFWorkbook excelworkbook = new XSSFWorkbook(excelfile);
		 
		 //Get the sheet from the book
		 excelworksheet = excelworkbook.getSheet("Login"); // name of the particular sheet is login
		 
		 //To print one cell data
		 System.out.println(excelworksheet.getRow(1).getCell(0));
		 System.out.println();
		 //To Print entire table
		 int totalrows= 4;
		 int totalcolumns=3;
		 for(int i=1;i<=totalrows;i++)
		 {
			 for(int j=0;j<totalcolumns;j++)
			 {
				 System.out.print(excelworksheet.getRow(i).getCell(j));
				 System.out.print("  ");
			 }
			 System.out.println("");
		 }
		 
	}
}
