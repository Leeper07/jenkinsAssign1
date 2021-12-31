package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class comparePrintClass {

	WebDriver driver;
	public comparePrintClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="span#priceblock_ourprice")
	WebElement price;
	public WebElement modelPrice() {
		return price;
	}
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div[5]/div[14]/div/div/div/div[1]/div[1]/div/div[2]/div/div/table/tbody/tr[4]/td")
	WebElement capacity;
	public WebElement modelCapacity() {
		return capacity;
	}
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div[5]/div[25]/div/table/tbody/tr[20]/td[1]")
	WebElement modelWeight1;
	public WebElement selectedModelWeight() {
		return modelWeight1;
	}
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div[5]/div[25]/div/table/tbody/tr[20]/td[2]")
	WebElement modelWeight2;
	public WebElement comapareModelWeight1() {
		return modelWeight2;
	}
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div[5]/div[25]/div/table/tbody/tr[20]/td[3]")
	WebElement modelWeight3;
	public WebElement comapareModelWeight2() {
		return modelWeight3;
	}
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div[5]/div[25]/div/table/tbody/tr[20]/td[4]")
	WebElement modelWeight4;
	public WebElement comapareModelWeight3() {
		return modelWeight4;
	}
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div[5]/div[25]/div/table/tbody/tr[20]/td[5]")
	WebElement modelWeight5;
	public WebElement comapareModelWeight4() {
		return modelWeight5;
	}
}
