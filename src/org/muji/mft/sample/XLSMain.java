package org.muji.mft.sample;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class XLSMain {

	public static void main(String[] args) throws IOException {
		XLSMain xlsMain = new XLSMain();

		xlsMain.readXls();
	}

	private void readXls() throws IOException {
		InputStream is = new FileInputStream("/Users/gaolexiang/Development/resources/Muji/samco_data.xls");
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);

		// 循环工作表Sheet
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}

			// 循环行Row
			for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow == null) {
					continue;
				}

				// 循环列Cell
				for (int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++) {
					HSSFCell hssfCell = hssfRow.getCell(cellNum);
					if (hssfCell == null) {
						continue;
					}

					System.out.print("    " + getValue(hssfCell));
				}
				System.out.println();
			}
		}
	}

	@SuppressWarnings("static-access")
	private String getValue(HSSFCell hssfCell) {
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			System.out.print("  Col<"+hssfCell.getColumnIndex()+">Row<"+hssfCell.getRowIndex()+">  ");
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			System.out.print("  Col<"+hssfCell.getColumnIndex()+">Row<"+hssfCell.getRowIndex()+">  ");
			return String.valueOf(hssfCell.getNumericCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_FORMULA){
			System.out.print("  F<"+hssfCell.getCellFormula()+">  ");
			String strCell;
			try {  
			       strCell = String.valueOf(hssfCell.getStringCellValue());  
			} catch (IllegalStateException e) {  
			       strCell = String.valueOf(hssfCell.getNumericCellValue());  
			}  
			System.out.print("  S<"+strCell+">  ");
			System.out.print("  C<"+hssfCell.getCachedFormulaResultType()+">  ");
			System.out.print("  Col<"+hssfCell.getColumnIndex()+">Row<"+hssfCell.getRowIndex()+">  ");
			return new String("0");
		} else {
			System.out.print("  Col<"+hssfCell.getColumnIndex()+">Row<"+hssfCell.getRowIndex()+">  ");
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}

}