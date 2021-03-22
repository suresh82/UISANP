package com.cigna.claimsanpuiautomaiton.utilities;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.cigna.claimsanpuiautomaiton.commonmethods.CommonFunctions;
import com.cigna.claimsanpuiautomaiton.enums.GeneralUtilitiesEnum;

import io.github.bonigarcia.wdm.WebDriverManager;

/*Created by: Rakhi Bisht 
Created date: November 2019
Class Name: BrowserUtility
Class Description: This class includes methods to perform operations to load browser based on user preference
 */
public class BrowserUtility {
	
	public static PropertiesFileReader obj = new PropertiesFileReader();
	static CommonFunctions commonFunctions= new CommonFunctions();
	
	/*Created by: Rakhi Bisht 
	Created date: 
	Method Name: StartApplication
	Method Description: Method to load the browser based on user preference 
	Input Parameters: WebDriver, BrowserName(to be loaded),Application URL
	Return: Method returns the webdriver with corresponding browser loaded*/
	public static WebDriver StartApplication(WebDriver driver, String browserName, String appURL) throws IOException {
		Properties prop = obj.getProperty();
		
		if (browserName.equals(GeneralUtilitiesEnum.valueOf("BROWSER_CHROME").getGeneralUtilities()))

		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption(GeneralUtilitiesEnum.valueOf("OPTIONS_AUTOMATIONEXTENSION").getGeneralUtilities(), false);
			driver = new ChromeDriver(options);
		} else if (browserName.equals(GeneralUtilitiesEnum.valueOf("BROWSER_FIREFOX").getGeneralUtilities())) {

			System.setProperty(GeneralUtilitiesEnum.valueOf("FIREFOX_PROPERTY").getGeneralUtilities(),
					prop.getProperty("FIREFOX_DRIVER"));

			driver = new FirefoxDriver();
		}

		else if (browserName.equals(GeneralUtilitiesEnum.valueOf("BROWSER_IE").getGeneralUtilities())) {
			System.setProperty(GeneralUtilitiesEnum.valueOf("IE_PROPERTY").getGeneralUtilities(),
					prop.getProperty("IE_DRIVER"));

			driver = new InternetExplorerDriver();
		}

		else if (browserName.equals(GeneralUtilitiesEnum.valueOf("BROWSER_EDGE").getGeneralUtilities())) {
			System.setProperty(GeneralUtilitiesEnum.valueOf("EDGE_PROPERTY").getGeneralUtilities(),
					prop.getProperty("EDGE_DRIVER"));

			driver = new EdgeDriver();
		} else {
			throw new NullPointerException("Unable to CreateDriver Instance for Browser Type");
		}
		
		CommonFunctions.pageLoadTime(driver);
		CommonFunctions.maximizeWindow(driver);
		CommonFunctions.loadApplicationUrl(driver,appURL);
		CommonFunctions.pageImplicitlyWait(driver);
		return driver;
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: QuitBrowser Method
	 * Description: Method to close the browser Input Parameters: WebDriver Return:
	 * Method does not return anything
	 */
	public static void QuitBrowser(WebDriver driver) {
		new CommonFunctions().quitBrowser();

	}
}
