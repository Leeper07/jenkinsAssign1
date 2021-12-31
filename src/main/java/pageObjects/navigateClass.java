package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;

public class navigateClass {

	WebDriver driver;
	public navigateClass(WebDriver driver) {
		this.driver=driver;
	}
	
	public Navigation navigate() {
		return driver.navigate();
	}
}
