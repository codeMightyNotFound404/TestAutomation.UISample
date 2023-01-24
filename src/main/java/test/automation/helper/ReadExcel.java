package test.automation.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class ReadExcel {

	FileInputStream fis=null;
	XSSFWorkbook workbook=null;
	Sheet sheet=null;

	public HashMap<Integer,List<String>> getExcelData(String sheetName,String excelPath)
	{
		HashMap<Integer,List<String>> testdata=new LinkedHashMap<Integer,List<String>>();
		try {
			fis=new FileInputStream(excelPath);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheet(sheetName);
			
			Iterator<Row> rows=sheet.rowIterator();
			while(rows.hasNext())
			{   List<String> tempList=new ArrayList<String>();
				Row row=rows.next();
				Iterator<Cell> cells=row.cellIterator();
				while(cells.hasNext())
				{
					
					Cell cell=cells.next();
					try {
						tempList.add(cellconvertor(cell));
					}
					catch(NullPointerException e)
					{

					}
				}
				testdata.put(row.getRowNum(), tempList);
			}
			
			return testdata;

		} catch (IOException e) {

			return null;

		}
		finally
		{
		try {
			fis.close();
			workbook.close();
			
		} catch (IOException e) {
			
		}

		}
	}

	public List<String> getExcelRow(String sheetName,String excelPath,int rowNumber)
	{
		List<String> testdata=new ArrayList<String>();
		try {
			fis=new FileInputStream(excelPath);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheet(sheetName);
			Row row=sheet.getRow(rowNumber);
			Iterator<Cell> cells=row.cellIterator();
			while(cells.hasNext())
			{
				Cell cell=cells.next();
				try {
					testdata.add(cellconvertor(cell));
				}
				catch(NullPointerException e)
				{

				}
			}
			return testdata;

		} catch (IOException e) {

			return null;

		}
		finally
		{
		try {
			fis.close();
			workbook.close();
			
		} catch (IOException e) {
			
		}

		}
	}

	public List<String> getExcelColumn(String sheetName,String excelPath,int columnNumber)
	{
		List<String> testdata=new ArrayList<String>();
		try {
			fis=new FileInputStream(excelPath);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheet(sheetName);
			Iterator<Row> rows=sheet.rowIterator();
			while(rows.hasNext())
			{
				Row row=rows.next();
				Cell cell=row.getCell(columnNumber);
				try {
					testdata.add(cellconvertor(cell));
				}
				catch(NullPointerException e)
				{

				}
			}
			return testdata;

		} catch (IOException e) {

			return null;

		}
		finally
		{
		try {
			fis.close();
			workbook.close();
			
		} catch (IOException e) {
			
		}

		}
	}

	public int getExcelRowCount(String sheetName,String excelPath)
	{
		try {
		fis=new FileInputStream(excelPath);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		return sheet.getLastRowNum();
		}
		catch(IOException e)
		{
			return 0;
		}
	}

	public int getExcelColumnCount(String sheetName,String excelPath)
	{
		try {
		fis=new FileInputStream(excelPath);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		Row row=sheet.getRow(1);
		Iterator<Cell> cells=row.cellIterator();
		int colcount=0;
		while(cells.hasNext())
		{
			cells.next();
			colcount++;
		}
		return colcount;
		}
		catch(IOException e)
		{
			return 0;
		}
	

	}

	public String cellconvertor(Cell cell)
	{
		try {
			String cellvalue=null;
			if(cell.getCellType().equals(CellType.STRING))
			{
				cellvalue= cell.getStringCellValue();
			}
			else if (cell.getCellType().equals(CellType.NUMERIC ))
			{

				if(HSSFDateUtil.isCellDateFormatted(cell))
				{
					cellvalue=String.valueOf(cell.getDateCellValue());
				}
				else
				{
					cellvalue= String.valueOf(cell.getNumericCellValue());	
				}		
			}
			return cellvalue;
		}

		catch(NullPointerException e)
		{
			throw new NullPointerException();
		}
	}
	
	
	public String[][] getExcel2D (String excelPath, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			fis=new FileInputStream(excelPath);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheet(sheetName);
            
			int totalNoOfCols = sheet.getRow(1).getLastCellNum();
			int totalNoOfRows = sheet.getLastRowNum();
			
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					try {
					Cell cell=sheet.getRow(i).getCell(j);
					arrayExcelData[i-1][j] = cellconvertor(cell);
					}
					catch(Exception e)
					{
						//System.out.println("\n"+e.getMessage());
					}
					
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} 
		return arrayExcelData;
	}
	
	
}
