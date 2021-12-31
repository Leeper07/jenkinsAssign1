package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchClass {
	
	WebDriver driver;
	public searchClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@aria-label='Search']")
	WebElement searchString;
	public WebElement searchbox(){
		return searchString;
	}
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;
	public WebElement searchButton() {
		return searchButton;
	}
}
