package com.cigna.claimsanpuiautomaiton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.cigna.claimsanpuiautomaiton.reporterutilities.ExtentReportListner;

/**
 * @author M20589
 * HomePage class contains the methods for creating a new Institutional and Professional Claims in SANP WEBUI
 *
 */
public class HomePage extends ExtentReportListner {
	ExtentTest logInfo = null;
	// Claim lines
	@FindBy(how = How.ID, using = "claims_tab-btnInnerEl")
	WebElement clmTab;

	@FindBy(how = How.XPATH, using = "//span[@id='claim_form_new_btn-btnWrap']/following-sibling::span[1]")
	WebElement newClaimOption;

	@FindBy(how = How.ID, using = "claim_form_institutional-textEl")
	WebElement instClmElement;

	@FindBy(how = How.ID, using = "claim_form_professional-textEl")
	WebElement profClmElement;


	@SuppressWarnings("static-access")
	public HomePage(WebDriver driver, ExtentTest lInfo) {
		this.driver = driver;
		this.logInfo = lInfo;
		PageFactory.initElements(driver, this);

	}

	@SuppressWarnings("static-access")
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/**
	 * feedClaimInfo() method clicks on the claim tab
	 * @return void
	 */
	public void clickOnClmTab() {
		try {

			clickButton(clmTab, getWait());

		}catch(Exception e) {
			logger.fatal("Error while clicking claim tab, Excepiton: " + ", \n "+ e.getMessage());
		}
	}

	/**
	 * @author M20589
	 * createNewProfClm() method click on the new professional claim tab
	 * @return void
	 */
	public void createNewProfClm() {

		try {

			clickButton(newClaimOption, getWait());
			getSleepWait();
			clickButton(profClmElement, getWait());

		}catch (Exception e) {
			logger.fatal("Error while adding creating a new professional claim, Exception: " + ", \n "+ e.getMessage());
		}
	}

	/**
	 * @author M20589
	 *createNewInstClm() method clicks on the new institutional claim tab
	 *@return void
	 */
	public void createNewInstClm() {

		try {

			clickButton(clmTab, getWait());
			clickButton(newClaimOption, getWait());
			getSleepWait();
			clickButton(instClmElement, getWait());


		}catch (Exception e) {
			logger.fatal("Error while adding a new institutional claim, Exception: " + ", \n "+ e.getMessage());
		}
	}


}
