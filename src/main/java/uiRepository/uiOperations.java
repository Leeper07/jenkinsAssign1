package uiRepository;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pageObjects.comparePrintClass;
import pageObjects.namePriceClass;
import pageObjects.navigateClass;
import pageObjects.searchClass;
import resusableComponents.dataDriven;
import resusableComponents.driverConfig;

import static org.testng.Assert.assertFalse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class uiOperations extends driverConfig{
	public ExtentReports reporte;
	
	public ExtentTest logger;
	public ExtentHtmlReporter extent;
	
	public WebDriver driver;
	private static Logger log = Logger.getLogger(uiOperations.class);
	
	public void navigateSite(ExtentReports rep) throws IOException{
		this.reporte=rep;
		PropertyConfigurator.configure(".//src//main//java//utilities//Properties//log4j.properties");
		logger=reporte.createTest("Navigation to site");
		driver=driverConfiguration();
		//Navigation to site
		navigateClass nc=new navigateClass(driver);
		nc.navigate().to(prop.getProperty("URL"));
		//Extentreports method
		logger.pass("Navigated to site");
		//Log4jMethod
		log.info("Navigated to site");
	}
	
	public void searchModel() throws IOException {
		dataDriven data=new dataDriven();
		ArrayList<String> array= data.getData("searchstring");
		logger=reporte.createTest("Search refrigerator in search bar");
		//Text in search bar and search
		searchClass sc=new searchClass(driver);
		sc.searchbox().sendKeys(array.get(1));
		sc.searchButton().click();
		//Extentreports method
		logger.pass("Search successfull");
		//Log4jMethod
		log.info("Search successfull");
	}
public static WebElement d=null,s=null,cur=null;
	
	public void getModelPrice() throws IOException {
		//Search for particular model from results and extract the price of that model
		namePriceClass npc=new namePriceClass(driver);
		 d= npc.modelName();
		 s=npc.modelPrice();
		 cur=npc.currentCurrency();
		System.out.println("The model selected is:"+d.getText());
		
	}
	
	public void modelExtractDetails() throws IOException {
		logger=reporte.createTest("Search for Samsung 198 L 4 model and acquire price");
		if(d.getText().startsWith("Samsung 198 L 4")) {
			String str=cur.getText()+""+s.getText();
			d.click();
			
			//Moving to new window and getting the price of the model
			//Get handles of the windows
	        String mainWindowHandle = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = allWindowHandles.iterator();
	        
	        while (iterator.hasNext()) {
	            String ChildWindow = iterator.next();
	                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	                comparePrintClass cpc=new comparePrintClass(driver);
	                WebElement nd= cpc.modelPrice();
	                logger=reporte.createTest("Compare the old price with the acquired price"); 
	                
	                //Comaparing the stored price and acquired price
	                System.out.println("\nPrice before the window changes:"+str);
	                String cstr=nd.getText();
	                cstr=cstr.contains(".") ? cstr.replaceAll("0*$","").replaceAll("\\.$",""):cstr;
	                System.out.println("\nPrice after the window changes:"+cstr);
	        		if(str.equals(cstr)) {
	        			System.out.println("\nBoth the prices are matching");
	        		}else {
	        			System.out.println("\nBoth the prices are not matching");
	        		}
	        		logger.pass("Compared successfully");
	        		//Log4jMethod
	        		log.info("Compared successfully");
	        		
	        		//Printing the capacity of the refrigerator
	        		logger=reporte.createTest("Print the capacity of refrigerator");
	        		WebElement capacity=cpc.modelCapacity();
	        		System.out.println("\nThe capacity of this model is:"+capacity.getText());
	        		logger.pass("Capacity printed successfully");
	        		//Log4jMethod
	        		log.info("Acquired capacity successfully");
	        		
	        		//Printing the item weights from comparison table
	        		logger=reporte.createTest("Print the item weights from comparison table");
	        		System.out.println("\nItem Weights:");
	        		System.out.println("The weight of selected model:"+cpc.selectedModelWeight().getText());
	        		
	        		System.out.println("The weight of comparision model 1:"+cpc.comapareModelWeight1().getText());
	        		
	        		System.out.println("The weight of comparision model 2:"+cpc.comapareModelWeight2().getText());
	        		
	        		System.out.println("The weight of comparision model 3:"+cpc.comapareModelWeight3().getText());
	        		
	        		System.out.println("The weight of comparision model 4:"+cpc.comapareModelWeight4().getText());	
	        		logger.pass("Item weights printed");
	        		//Log4jMethod
	        		log.info("Acquired item weights successfully");
	            }
	        }
	        //Extent Reports method
	        logger.pass("Search successfull and price acquired");
	        //Log4jMethod
			log.info("Search successfull and price acquired");
	        reporte.flush();
        }else {
        	logger.fail("Search unsuccessfull");
        	//Log4jMethod
    		log.error("Search model did not meet the criteria");
        	reporte.flush();
        	assertFalse(true);
        }
	}
}