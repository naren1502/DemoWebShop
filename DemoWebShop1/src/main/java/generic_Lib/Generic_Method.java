package generic_Lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Generic_Method {
	
	public static Object[][] data(String sheetName) throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream(new File("./src/test/resources/testData/testData.xlsx"));
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int row = sheet.getPhysicalNumberOfRows()-1;
		int col = sheet.getRow(0).getPhysicalNumberOfCells();
		Object data[][]=new Object[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
}
