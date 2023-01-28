package search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_Lib.BaseUnit;
import generic_Lib.ReadData;
import pomRepo.SearchPage;

public class TC_003 extends BaseUnit {
	@DataProvider(name="TC_003")
	public String[][] data() {
		return ReadData.readDataExcel("testData", 2);
	}
	@Test(dataProvider = "TC_003")
	public void sortByDropDown(String data[]) {  
		SearchPage seap=new SearchPage(driver);
		String product=data[0];
		WebDriverWait explicitWait=new WebDriverWait(driver, 15);
		//Step1:enter the product name in the searchbar
		explicitWait.until(ExpectedConditions.elementToBeClickable(comp.getLogoutLink()));
		comp.getSearchBar().clear();
		comp.getSearchBar().sendKeys(product);
		Assert.assertEquals(comp.getSearchBar().getAttribute("value"), product,"the given product is not entered properly");
		
		//Step 2:click on search button
		
		
		driver.findElement(By.xpath("//form/input[@value='Search']")).click();
		
		//Step 3:Check the sortBy dropdown and values
		Select dropDown=new Select(seap.getSortByDropDown());
		List<WebElement> options = dropDown.getOptions();
		boolean alloptions=true;
		for(int i=1;i<data.length;i++) {
			for(WebElement dropdownData : options) {
				if(dropdownData.getText().equalsIgnoreCase(data[i])) {
					alloptions=true;
					break;
				}
				else 
					alloptions=false;
			}
		}
		Assert.assertEquals(alloptions,true,"All options are not displayed");	
	}
}
