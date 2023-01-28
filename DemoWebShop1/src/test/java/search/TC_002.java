package search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic_Lib.BaseUnit;
import generic_Lib.ReadData;
import pomRepo.SearchPage;

public class TC_002 extends BaseUnit {
	@Test
	public void addToTheProductToCart() {
		
		String product=ReadData.fromProperty("NullProduct");
		String expectedResult=ReadData.fromExcel("result", 1, 0);
		WebDriverWait explicitWait=new WebDriverWait(driver, 15);
		//Step 1:enter the product name in the searchbar
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log out")));
		SearchPage sp=new SearchPage(driver);
		comp.getSearchBar().clear();
		comp.getSearchBar().sendKeys(product);
		Assert.assertEquals(comp.getSearchBar().getAttribute("value"), product, product);
		
		//step 2:click on search button
		comp.getSearchButton().click();
		
		String actualResult=sp.getInvalidResult().getText(
				);
		
		//step 3:verify the product is displayed or not
		Assert.assertEquals(actualResult, expectedResult,"invalid product is visible in the search area");
		Reporter.log("Invalid products are not displayed",true);
		
		
	}
}
