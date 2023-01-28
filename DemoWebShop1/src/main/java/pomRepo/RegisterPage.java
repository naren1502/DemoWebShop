package pomRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import generic_Lib.ReadData;

public class RegisterPage {
	public WebDriver driver;
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(id = "FirstName")
	private WebElement firstNameTextField;

	@FindBy(id = "LastName")
	private WebElement lastNameTextField;

	@FindBy(id = "Email")
	private WebElement emailTextField;

	@FindBy(id = "Password")
	private WebElement passwordTextField;

	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextField;

	@FindBy(id = "register-button")
	private WebElement registerButton;

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getConfirmPasswordTextField() {
		return confirmPasswordTextField;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}
	public void register(String[] userData) {
		RegisterPage rp=new RegisterPage(driver);
		CommonPage cp=new CommonPage(driver);
		cp.getRegisterLink().click();
		String expectedTitle = ReadData.fromProperty("RegisterPageTitle");
		driver.getTitle();
		Assert.assertEquals(driver.getTitle(), expectedTitle,"Register page is not displayed");

		//Step 2:clicking on gender button
		WebElement gender = driver.findElement(By.id("gender-"+userData[0]+""));
		gender.click();
		if(gender.isSelected())
			Reporter.log(userData[0]+" is selected");

		//Step 3:enter the firstname
		rp.getFirstNameTextField().sendKeys(userData[1]);
		Assert.assertEquals(rp.getFirstNameTextField().getAttribute("value"),userData[1],"user name is not entered properly");

		//Step 4:enter the lastname
		rp.getLastNameTextField().sendKeys(userData[2]);
		Assert.assertEquals(rp.getLastNameTextField().getAttribute("value"),userData[2],"last name is not entered properly");

		//Step 5:enter the email address
		rp.getEmailTextField().sendKeys(userData[3]);
		Assert.assertEquals(rp.getEmailTextField().getAttribute("value"),userData[3],"email address is not entered properly");

		//Step 6:enter the password
		rp.getPasswordTextField().sendKeys(userData[4]);
		Assert.assertEquals(rp.getPasswordTextField().getAttribute("value"),userData[4],"password is not entered properly");

		//Step 7: enter the confirm password
		rp.getConfirmPasswordTextField().sendKeys(userData[5]);
		Assert.assertEquals(rp.getConfirmPasswordTextField().getAttribute("value"),userData[5],"password is not entered properly");

		//Step 8:click on login button
		rp.getRegisterButton().click();
	}

}
