package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class namePriceClass {
	
	WebDriver driver;
	public namePriceClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[19]/div/span/div/div/div[2]/div[2]/div/div/div[3]/div[1]/div/div[1]/div[1]/a/span[1]/span[2]/span[2]")
	WebElement price;
	public WebElement modelPrice() {
		return price;
	}
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[19]/div/span/div/div/div[2]/div[2]/div/div/div[3]/div[1]/div/div[1]/div[1]/a/span[1]/span[2]/span[1]")
	WebElement currency;
	public WebElement currentCurrency() {
		return currency;
	}
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[19]/div/span/div")
	WebElement modelName;
	public WebElement modelName() {
		return modelName;
	}
}
