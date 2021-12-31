package stepDefinations;


import java.io.File;
import java.io.IOException;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import resusableComponents.driverConfig;
import uiRepository.uiOperations;
import utilities.Helper;

public class stepDefination extends driverConfig{
	public ExtentReports report;
	
	public ExtentTest logger;
	public ExtentHtmlReporter extent;
	public uiOperations optest=new uiOperations();
	
	@BeforeSuite
	public ExtentReports beforeSuite() {
		extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/amazonTest_"+Helper.getCurrentDateTime()+".html"));
		report =new ExtentReports();
		report.attachReporter(extent);
		return report;
	}
	
	@Given("^user launches amazon website$")
    public void user_launches_amazon_website() throws IOException  {
		ExtentReports rep=beforeSuite();
		optest.navigateSite(rep);
    }

    @When("^user searches for a product and clicks on search button$")
    public void user_searches_for_a_product_and_clicks_on_search_button() throws Throwable {
        optest.searchModel();
    }

    @Then("^result set should contain that particular model$")
    public void result_set_should_contain_that_particular_model() throws Throwable {
        optest.getModelPrice();
    }

    @And("^user must be able to extract the details$")
    public void user_must_be_able_to_extract_the_details() throws Throwable {
        optest.modelExtractDetails();
    }
    
    @After
	public void teardown() throws IOException {
		driver.quit();
	}

}
