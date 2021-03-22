package com.cigna.claimsanpuiautomaiton.stepdefinition;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

import com.cigna.claimsanpuiautomaiton.commonmethods.CommonFunctions;
import com.cigna.claimsanpuiautomaiton.utilities.BrowserUtility;
import com.cigna.claimsanpuiautomaiton.utilities.PropertiesFileReader;
import com.codoid.products.exception.FilloException;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/*Created by: Midhun Eliangod 
Created date: November 2019
Class Name: ReportHelper
Class Description: This class includes methods to perform pre-conditions and post-conditions before/after executing each scenario
*/
public class Hooks {

	public static WebDriver driver;
	PropertiesFileReader propertiesFileReader = new PropertiesFileReader();

	
	/*Created by: Midhun Eliangod 
	Created date: 
	Method Name: beforScenario
	Method Description: Method to perform pre-conditions before executing each scenario; Open the browser and load application URL
	Input Parameters: 
	Return: Method does not return anything*/
	@Before
	public void beforScenario() throws IOException {

		Properties properties = propertiesFileReader.getProperty();
		driver = BrowserUtility.StartApplication(CommonFunctions.driver, properties.getProperty("BROWSER_NAME"),
				properties.getProperty("URL"));
	}

	
	/*Created by: Midhun Eliangod 
	Created date: 
	Method Name: afterScenario
	Method Description: Method to perform after executing each scenario; Update claim ids in test data sheet and close the browser
	Input Parameters: 
	Return: Method does not return anything*/
	@After
	public void afterScenario() throws FilloException {

		if (driver != null)
			driver.quit();
	}
}
