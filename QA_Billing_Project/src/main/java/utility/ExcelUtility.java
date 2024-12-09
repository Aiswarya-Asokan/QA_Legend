package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelUtility {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;

	public static String getStringData(int a,int b,String sheetname) throws IOException
	{
		f=new FileInputStream(Constants.TESTDATAFILE);
		w=new XSSFWorkbook(f);
		sh=w.getSheet(sheetname);
		Row r=sh.getRow(a);
		Cell c=r.getCell(b);
		return c.getStringCellValue();
		
	}
	
	public static String getIntegerData(int a,int b,String sheetname) throws IOException
	{
		f=new FileInputStream(Constants.TESTDATAFILE);
		w=new XSSFWorkbook(f);
		sh=w.getSheet(sheetname);
		Row r=sh.getRow(a);
		Cell c=r.getCell(b);
		int x=   (int) c.getNumericCellValue();
		return String.valueOf(x);
	}
	
}
