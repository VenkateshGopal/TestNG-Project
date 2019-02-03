package net.docprep.commonfunctions;


import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ExcelUtility {
	
	@SuppressWarnings("unused")
	public static String getcellvalue(String columnName, int rowNum, XSSFSheet sheet) {
		
		try {
		
			DataFormatter formatter = new DataFormatter();
			Row row = sheet.getRow(0);
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell Currentcell = cellIterator.next();
				if(Currentcell.getStringCellValue().equalsIgnoreCase(columnName)) {
					int columnNum = Currentcell.getColumnIndex();
					if(Currentcell == null) {
						Currentcell=sheet.getRow(rowNum).getCell(columnNum, MissingCellPolicy.CREATE_NULL_AS_BLANK);
						return formatter.formatCellValue(Currentcell);
					} else {
						return (sheet.getRow(rowNum).getCell(columnNum).getStringCellValue());
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
			return columnName+" --Column not Found";
	}

}
