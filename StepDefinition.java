package com.cigna.claimsanpuiautomaiton.stepdefinition;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.cigna.claimsanpuiautomaiton.pages.ClaimsPage;
import com.cigna.claimsanpuiautomaiton.pages.HomePage;
import com.cigna.claimsanpuiautomaiton.pages.LoginPage;
import com.cigna.claimsanpuiautomaiton.reporterutilities.ExtentReportListner;
import com.cigna.claimsanpuiautomaiton.utilities.ReadExcelForClaimData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends ExtentReportListner {

	LoginPage loginPage;
	HomePage homePage;
	ClaimsPage claimsPage;
	ReadExcelForClaimData readExcelclaimData;
	int rowCount;
	String claimType;
	ArrayList<String> claimData=new ArrayList<String>();
	ArrayList<String> claimLineData=new ArrayList<String>();

	public StepDefinition() {
		logger = Logger.getLogger(StepDefinition.class);
		PropertyConfigurator.configure(logProperties);
	}

	@Given("^User access the PAR SANP application and successfully logs into SANP$")
	public void user_access_the_PAR_SANP_application_and_successfully_logs_into_SANP() throws Throwable {

		ExtentTest logInfo = null;
		test = extent.createTest(Feature.class, "This Feature File Explains the Claim Price and Validation in PAR SANP");
		test = test.createNode(Scenario.class, "Price and Validate the Claims in PAR SANP");

		try {

			logInfo = test.createNode(new GherkinKeyword("Given"), "Open browser and login into SANP LoginPage");
			loginPage = new LoginPage(Hooks.driver);
			loginPage.login();
			readExcelclaimData = new ReadExcelForClaimData();
			logger.info("***************************Launching Browser*********************");
			logInfo.pass("USER ACTION ---> Browser Has Been Launched Successfully.");

		} catch (AssertionError | Exception e) {
			logInfo.addScreenCaptureFromPath(captureScreenShot(Hooks.driver));
			testStepHandle("FAIL", Hooks.driver, logInfo, e);
		}

	}

	@When("^User navigates to Claims Page$")
	public void user_navigates_to_Claims_Page() throws Throwable {
		ExtentTest logInfo = null;

		try {
			logInfo = test.createNode(new GherkinKeyword("When"), "User navigates to Claims Page");
			homePage = new HomePage(driver, logInfo);
			homePage.clickOnClmTab();
			//log.info("***************************Launching Browser*********************");
			logInfo.pass("USER ACTION ---> User navigated to Claims Page successfuly.");

		} catch (AssertionError | Exception e) {
			logInfo.addScreenCaptureFromPath(captureScreenShot(Hooks.driver));
			testStepHandle("FAIL", Hooks.driver, logInfo, e);
		}

	}

	@Then("^User creates new Professional Claim \"([^\"]*)\"$")
	public void user_creates_new_Professional_Claim(String rowCount) throws Throwable {
		ExtentTest logInfo = null;

		try {
			logInfo = test.createNode(new GherkinKeyword("Then"), "User creates new Professional Claim");
			this.rowCount = Integer.parseInt(rowCount);
			claimData = readExcelclaimData.claimData(this.rowCount);
			claimLineData = readExcelclaimData.claimLineData();
			homePage.createNewProfClm();
			//log.info("***************************Launching Browser*********************");
			logInfo.pass("USER ACTION ---> A new professional claims page has been selected successfully.");

		} catch (AssertionError | Exception e) {
			logInfo.addScreenCaptureFromPath(captureScreenShot(Hooks.driver));
			testStepHandle("FAIL", Hooks.driver, logInfo, e);
		}

	}

	@Then("^User creates new Institutional Claim \"([^\"]*)\"$")
	public void user_creates_new_Institutional_Claim(String rowCount) throws Throwable {
		ExtentTest logInfo = null;

		try {
			logInfo = test.createNode(new GherkinKeyword("Then"), "User creates new Institutional Claim");
			this.rowCount = Integer.parseInt(rowCount);
			claimData = readExcelclaimData.claimData(this.rowCount);
			claimLineData = readExcelclaimData.claimLineData();
			homePage.createNewInstClm();
			//log.info("***************************Launching Browser*********************");
			logInfo.pass("USER ACTION ---> A new Institutional claims page has been selected successfully.");

		} catch (AssertionError | Exception e) {
			logInfo.addScreenCaptureFromPath(captureScreenShot(Hooks.driver));
			testStepHandle("FAIL", Hooks.driver, logInfo, e);
		}

	}


	@Then("^User enters the Claim Information details$")
	public void user_enters_the_Claim_Information_details() throws Throwable {
		ExtentTest logInfo = null;

		try {
			logInfo = test.createNode(new GherkinKeyword("Then"), "User enters the Claim Information details");

			claimsPage = new ClaimsPage(driver,logInfo);
			claimType=claimsPage.feedClaimInfo(claimData.get(0));

			//log.info("***************************Launching Browser*********************");
			logInfo.pass("USER ACTION ---> User entered the claim information successfully.");

		} catch (AssertionError | Exception e) {
			logInfo.addScreenCaptureFromPath(captureScreenShot(Hooks.driver));
			testStepHandle("FAIL", Hooks.driver, logInfo, e);
		}

	}

	@Then("^User enters the Diagnosis details$")
	public void user_enters_the_Diagnosis_details() throws Throwable {
		ExtentTest logInfo = null;

		try {
			logInfo = test.createNode(new GherkinKeyword("Then"), "User enters the Diagnosis details");
			claimsPage = new ClaimsPage(driver,logInfo);
			claimsPage.feedDiagnosesInfo(claimData.get(1),claimType);
			//log.info("***************************Launching Browser*********************");
			logInfo.pass("USER ACTION ---> User entered the diagnosis details successfully.");

		} catch (AssertionError | Exception e) {
			logInfo.addScreenCaptureFromPath(captureScreenShot(Hooks.driver));
			testStepHandle("FAIL", Hooks.driver, logInfo, e);
		}

	}

	@Then("^User enters the LineItem details$")
	public void user_enters_the_LineItem_details() throws Throwable {
		ExtentTest logInfo = null;

		try {
			logInfo = test.createNode(new GherkinKeyword("Then"), "User enters the LineItem details");
			claimsPage = new ClaimsPage(driver,logInfo);
			claimsPage.feedLineDetailsInfo(claimLineData,claimLineData.size(),claimType);
			//log.info("***************************Launching Browser*********************");
			logInfo.pass("USER ACTION ---> User entered the line item details successfully.");

		} catch (AssertionError | Exception e) {
			logInfo.addScreenCaptureFromPath(captureScreenShot(Hooks.driver));
			testStepHandle("FAIL", Hooks.driver, logInfo, e);
		}

	}

	@Then("^User enters the Patient Insured details$")
	public void user_enters_the_Patient_Insured_details() throws Throwable {
		ExtentTest logInfo = null;

		try {
			logInfo = test.createNode(new GherkinKeyword("Then"), "User enters the Patient Insured details");
			claimsPage = new ClaimsPage(driver,logInfo);
			claimsPage.feedPatientInsured(claimData.get(2),claimType);
			//log.info("***************************Launching Browser*********************");
			logInfo.pass("USER ACTION ---> User entered the patient insured details successfully.");

		} catch (AssertionError | Exception e) {
			logInfo.addScreenCaptureFromPath(captureScreenShot(Hooks.driver));
			testStepHandle("FAIL", Hooks.driver, logInfo, e);
		}

	}

	@Then("^User enters the Miscellaneous details$")
	public void user_enters_the_Miscellaneous_details() throws Throwable {
		ExtentTest logInfo = null;

		try {
			logInfo = test.createNode(new GherkinKeyword("Then"), "User enters the Miscellaneous details");
			claimsPage = new ClaimsPage(driver,logInfo);
			claimsPage.feedMiscInfo(claimData.get(3));
			//log.info("***************************Launching Browser*********************");
			logInfo.pass("USER ACTION ---> User entered the miscellaneous details successfully.");

		} catch (AssertionError | Exception e) {
			logInfo.addScreenCaptureFromPath(captureScreenShot(Hooks.driver));
			testStepHandle("FAIL", Hooks.driver, logInfo, e);
		}

	}

	@Then("^User clicks on Price and Save$")
	public void click_on_Price_and_Save() throws Throwable {
		ExtentTest logInfo = null;

		try {
			logInfo = test.createNode(new GherkinKeyword("And"), "User clicks on Price and Save");
			claimsPage = new ClaimsPage(driver,logInfo);
			claimsPage.clickOnPriceSave();
			//log.info("***************************Launching Browser*********************");
			logInfo.pass("USER ACTION ---> User clicked on price and save successfully.");

		} catch (AssertionError | Exception e) {
			logInfo.addScreenCaptureFromPath(captureScreenShot(Hooks.driver));
			testStepHandle("FAIL", Hooks.driver, logInfo, e);
		}

	}

	@Then("^User Validates the Pricing details$")
	public void user_Validates_the_Pricing_details() throws Throwable {
		ExtentTest logInfo = null;

		try {
			logInfo = test.createNode(new GherkinKeyword("Then"), "User Validates the Pricing details");
			claimsPage = new ClaimsPage(driver,logInfo);
			claimsPage.validateclmPrice(claimData.get(4));
			//log.info("***************************Launching Browser*********************");
			logInfo.pass("USER ACTION ---> User validates the pricing details successfully.");

		} catch (AssertionError | Exception e) {
			logInfo.addScreenCaptureFromPath(captureScreenShot(Hooks.driver));
			testStepHandle("FAIL", Hooks.driver, logInfo, e);
		}

	}
}
