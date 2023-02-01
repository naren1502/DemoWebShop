package dummy;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_Lib.Generic_Method;

public class GettingDataFromExcel {
	@DataProvider
	public Object[][] data() throws EncryptedDocumentException, IOException{
		return Generic_Method.data("data");
	}

	@Test(dataProvider = "data")
	public void read(String[]data) {
		for(String value:data) {
			System.out.println(value);	
		}

	}
}
