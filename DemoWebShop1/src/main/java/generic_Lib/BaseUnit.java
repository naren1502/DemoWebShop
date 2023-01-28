package generic_Lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import generic_Lib.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepo.CommonPage;
import pomRepo.LoginPage;

public class BaseUnit {
	public WebDriver driver;
	public CommonPage comp;
	public WebDriverWait explicitWait;
	@Parameters("browsername")
	@BeforeTest(groups = "launch")
	public void launchBrowser(@Optional("chrome") String bname) {
		String url=ReadData.fromProperty("Url");
		// Launching empty browser and maximize the window
		if(bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(bname.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
			Reporter.log("pass the valid data",true);
		Reporter.log("Empty browser is launched",true);
		driver.manage().window().maximize();
		Reporter.log("browser is maximized",true);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		comp=new CommonPage(driver);
		explicitWait=new WebDriverWait(driver, 15);

		//navigate to the application
		driver.get(url);
		Assert.assertEquals(driver.getCurrentUrl(),url,"Home page is not displayed");

	}
	@BeforeTest(groups = "login" ,dependsOnGroups = "launch")
	public void login() {
		String email = ReadData.fromProperty("Email");
		String password=ReadData.fromProperty("Password");
		LoginPage login=new LoginPage(driver);
		login.login(email, password);
	}

	@AfterTest()
	public void logoutAndCloseTheBrowser()
	{
		comp.getLogoutLink().click();
		driver.quit();
	}

}
