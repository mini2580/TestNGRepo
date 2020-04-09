package Utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utility {

	private static XSSFWorkbook excelWB;
	private static XSSFSheet excelWS;
	
	
	public static void setUpExcelFile(String path , String sheetName) {
		
		try{
		//open the excel file 
		
		FileInputStream excelFile = new FileInputStream(path);
		
		//Access the excel data sheet
		
		excelWB = new XSSFWorkbook(excelFile);
		excelWS = excelWB.getSheet(sheetName);
		
		}catch(Exception e){
			System.out.println("Exception Occured" + e);
		}
		
		
	}
	
	public static String[][] getTestData(String tableName){
		String[][] testData = null;
		try {
			// Handle numbers and strings
			DataFormatter formatter = new DataFormatter();
			XSSFCell[] boundaryCells = findCells(tableName);
			System.out.println("Print the value of BoundaryCells: " + boundaryCells);
			XSSFCell startCell = boundaryCells[0];
			System.out.println("Print the value of StartCell : " + startCell);
			
			XSSFCell endCell = boundaryCells[1];
			
			System.out.println("Print the value of endCell : " + endCell);
			
			int startRow = startCell.getRowIndex() + 1;
			System.out.println("Print the value of startRow : " + startRow);	
			
			int endRow = endCell.getRowIndex() - 1;
			System.out.println("Print the value of endRow : " + endRow);
			int startCol = startCell.getColumnIndex() + 1;
			System.out.println("Print the value of startCol : " + startCol);
			int endCol = endCell.getColumnIndex() - 1;
			System.out.println("Print the value of endCol : " + endCol);
			
			testData = new String[endRow - startRow + 1][endCol - startCol + 1];

			for (int i=startRow; i<endRow+1; i++) {
				for (int j=startCol; j<endCol+1; j++) {
					// testData[i-startRow][j-startCol] = ExcelWSheet.getRow(i).getCell(j).getStringCellValue();
					Cell cell = excelWS.getRow(i).getCell(j);
					testData[i - startRow][j - startCol] = formatter.formatCellValue(cell);
					System.out.println("Print the value of testData : " + testData[i - startRow][j - startCol]);	
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return testData;
	}
	
	public static XSSFCell[] findCells(String tableName) {
		DataFormatter formatter = new DataFormatter();
		String pos = "begin";
		XSSFCell[] cells = new XSSFCell[2];

		for (Row row : excelWS) {
			for (Cell cell : row) {
				// if (tableName.equals(cell.getStringCellValue())) {
				System.out.println("Formatted cell value is " + formatter.formatCellValue(cell));
				if (tableName.equals(formatter.formatCellValue(cell))) {
					if (pos.equalsIgnoreCase("begin")) {
						cells[0] = (XSSFCell) cell;
						System.out.println("Print the cell value : " + cells[0]);
						pos = "end";
					} else {
						cells[1] = (XSSFCell) cell;
						System.out.println("Print the cell value Else: " + cells[1]);
					}
				}
			}
		}
		return cells;
	}
}
