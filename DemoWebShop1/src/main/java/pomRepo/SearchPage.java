package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//strong[@class='result']")
	private WebElement invalidResult;

	public WebElement getInvalidResult() {
		return invalidResult;
	}

	@FindBy(id = "products-orderby")
	private WebElement sortByDropDown;

	@FindBy(id = "products-pagesize")
	private WebElement displayDropDown;

	@FindBy(id = "products-viewmode")
	private WebElement viewAsDropDown;

	public WebElement getSortByDropDown() {
		return sortByDropDown;
	}

	public WebElement getDisplayDropDown() {
		return displayDropDown;
	}

	public WebElement getViewAsDropDown() {
		return viewAsDropDown;
	}
}
