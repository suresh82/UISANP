package com.cigna.claimsanpuiautomaiton.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.cigna.claimsanpuiautomaiton.reporterutilities.ExtentReportListner;

/**
 * @author M20589
 * LoginPage class contains the method for Log into Claim SANP thru credentials
 */
public class LoginPage extends ExtentReportListner {               
	ExtentTest logInfo = null;

	@FindBy(how= How.XPATH,  using = "//tbody/tr[@class='m']/td[@class='c']/div[1]/input[2]")
	WebElement usernamePlaceHolder;

	@FindBy(how= How.XPATH,  using = "//tbody/tr[@class='m']/td[@class='c']/div[2]/input[2]")
	WebElement passwordPlaceHolder;

	@FindBy(how= How.XPATH,  using = "//input[@name='username']")
	WebElement username;

	@FindBy(how= How.XPATH, using ="(//input[@name='password']/following-sibling::input)[2]")
	WebElement password;

	@FindBy(how= How.XPATH,  using = "(//div[@class='login-button'])[2]")
	WebElement btnLogin;

	@SuppressWarnings("static-access")
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * @author M20589
	 * login() Method makes user to get log into claim sanp application
	 * @return void
	 */
	public void login() {                          

		try {

			getSleepWait();       			
			String password = enterTextForAuthorisation(properties.getProperty("PASSWORD"));
			Actions act = new Actions(driver);
			String username= properties.getProperty("USERNAME");
			act.moveToElement(usernamePlaceHolder).click();
			getSleepWait();
			act.sendKeys(Keys.chord(username));
			act.sendKeys(password);
			act.moveToElement(btnLogin).click();
			act.click();
			act.perform();

		}
		catch (Exception e) {
			logger.fatal("Object Not Found" + ", \n "+ e.getMessage());
		}
	}
}

