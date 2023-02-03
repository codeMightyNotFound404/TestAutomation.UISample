package test.automation.helper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class WriteExcel {
	FileInputStream fis=null;
	XSSFWorkbook workbook=null; 
	FileOutputStream fos=null;
	Sheet sheet=null;
	Row row=null;
	Cell cell=null;

	/**
	 *
	 * @param sheetName
	 * @param excelPath
	 * @param outdata
	 * @return
	 */
	public boolean setExcelData(String sheetName,String excelPath, HashMap<Integer ,List<String>> outdata)
	{

		try {
			fis=new FileInputStream(excelPath);
			workbook =new XSSFWorkbook(fis);
			try {
				if (workbook.getSheet(sheetName).getSheetName()!=null)
				{
					sheet=workbook.getSheet(sheetName);

				}
			}
			catch(NullPointerException e)
			{
				sheet=workbook.createSheet(sheetName);
			}

			outdata.forEach((k,v)->{
				row=sheet.createRow(k);
				int count=0;
				for(String str:v)
				{
					row.createCell(count).setCellValue(str);
					count++;
				}
			});

			fos=new FileOutputStream(excelPath);
			workbook.write(fos);
			return true;
		}
		catch(IOException e)
		{
			return false;
		}
		finally {
			try {
				workbook.close();
				fos.close();
				fis.close();
			} catch (IOException e1) {
			}
		}
	}

	/**
	 *
	 * @param sheetName
	 * @param excelPath
	 * @param rowNumber
	 * @param outdata
	 * @return
	 */
	public boolean setExcelRow(String sheetName,String excelPath,int rowNumber,List<String> outdata)
	{
		try {
			fis=new FileInputStream(excelPath);
			workbook =new XSSFWorkbook(fis);
			try {
				if (workbook.getSheet(sheetName).getSheetName()!=null)
				{
					sheet=workbook.getSheet(sheetName);

				}
			}
			catch(NullPointerException e)
			{
				sheet=workbook.createSheet(sheetName);
			}
			int count =0;
			try {
				if(sheet.getRow(rowNumber)!=null)
				{
					row=sheet.getRow(rowNumber);
				}
			}
			catch(NullPointerException e)
			{
				row=sheet.createRow(rowNumber);
			} 
			for(String str: outdata) {
				try {
					if(row.getCell(count)!=null)
					{
						row.getCell(count).setCellValue(str);
					}
				}
				catch(NullPointerException e)
				{ 
					row.createCell(count).setCellValue(str);
				}
				count++;

			}
			fos=new FileOutputStream(excelPath);
			workbook.write(fos);
			return true;
		}
		catch(IOException e)
		{
			return false;
		}
		finally {
			try {
				workbook.close();
				fos.close();
				fis.close();
			} catch (IOException e1) {
			}
		}

	}

	/**
	 *
	 * @param sheetName
	 * @param excelPath
	 * @param columnNumber
	 * @param outdata
	 * @return
	 */
	public boolean setExcelColumn(String sheetName,String excelPath,int columnNumber ,List<String> outdata)
	{
		try {
			fis=new FileInputStream(excelPath);
			workbook =new XSSFWorkbook(fis);
			try {
				if (workbook.getSheet(sheetName).getSheetName()!=null)
				{
					sheet=workbook.getSheet(sheetName);

				}
			}
			catch(NullPointerException e)
			{
				sheet=workbook.createSheet(sheetName);
			}
			int count =0;

			for(String str: outdata) {
				try {

					if(sheet.getRow(count)!=null)
					{
						row=sheet.getRow(count);
					}
				}
				catch(NullPointerException e)
				{
					row=sheet.createRow(count);
				} 

				try {
					if(row.getCell(columnNumber)!=null)
					{
						row.getCell(columnNumber).setCellValue(str);
					}
				}
				catch(NullPointerException e)
				{ 
					row.createCell(columnNumber).setCellValue(str);
				}
				count++;

			}
			fos=new FileOutputStream(excelPath);
			workbook.write(fos);
			return true;
		}
		catch(IOException e)
		{
			return false;
		}
		finally {
			try {
				workbook.close();
				fos.close();
				fis.close();
			} catch (IOException e1) {
			}
		}

	}


}
