package resusableComponents;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverConfig {
	public static WebDriver driver=null;
	public static FileInputStream file=null;
	public static Properties prop=null;
	public static WebDriver driverConfiguration() throws IOException{
		//Data Driving using properties
		prop=new Properties();
		file = new FileInputStream(".//src//main//java//utilities//Properties//dataDriven.properties");
		prop.load(file);
		if(prop.getProperty("browser").contains("chrome")) {
		driver=new ChromeDriver();
		} else if(prop.getProperty("browser").contains("firefox")) {
			driver=new FirefoxDriver();
		} else if(prop.getProperty("browser").contains("Edge")) {
			driver=new EdgeDriver();
		} else {
			System.out.println("Invalid Browser");
		}
		return driver;
	}		
}
