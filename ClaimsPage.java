package com.cigna.claimsanpuiautomaiton.pages;

import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.cigna.claimsanpuiautomaiton.enums.ClaimsPageEnum;
import com.cigna.claimsanpuiautomaiton.reporterutilities.ExtentReportListner;

/**
 * @author M20589
 * ClaimsPage Class consists of methods for feeding professional and institutional claim data 
 * And Claim pricing validations
 */
public class ClaimsPage extends ExtentReportListner {

	ExtentTest logInfo = null;

	//ClaimInformation Section Xpaths
	@FindBy(how = How.XPATH, using = "	//div[@class='tz-notification-close-btn']")
	WebElement popupCancel;

	@FindBy(how = How.XPATH, using = "//input[@name='SubmitterClaimNumber']")
	WebElement submitterClaimNumber;

	@FindBy(how = How.XPATH, using = "//input[@name='TypeOfBill']")
	WebElement typeOfBill;

	@FindBy(how = How.XPATH, using = "//input[@id='instiRatesheetCode-inputEl']")
	WebElement instRS;

	@FindBy(how = How.XPATH, using = "//input[@id='profRatesheetCode-inputEl']")
	WebElement profRS;


	@FindBy(how = How.XPATH, using = "//input[@name='ReceivedDate']")
	WebElement receivedDate;

	@FindBy(how = How.XPATH, using = "//input[@name='AdmissionDate']")
	WebElement admissionDate;

	@FindBy(how = How.XPATH, using = "//input[@name='AdmissionHour']")
	WebElement admissionHour;

	// PVE
	@FindBy(how = How.XPATH, using = "//input[@name='AdmissionType']")
	WebElement admissionType;

	@FindBy(how = How.XPATH, using = "//input[@name='AdmissionSource']")
	WebElement AdmissionSource;

	@FindBy(how = How.XPATH, using = "//input[@name='DischargeDate']")
	WebElement DischargeDate;

	@FindBy(how = How.XPATH, using = "//input[@name='DischargeHour']")
	WebElement DischargeHour;

	@FindBy(how = How.XPATH, using = "//input[@name='DischargeStatus']")
	WebElement DischargeStatus;

	@FindBy(how = How.XPATH, using = "//input[@name='StatementFromDate']")
	WebElement StatementFromDate;

	@FindBy(how = How.XPATH, using = "//input[@name='StatementToDate']")
	WebElement StatementToDate;

	@FindBy(how = How.XPATH, using = "//input[@name='Provider.GroupName']")
	WebElement providerGroupName;

	@FindBy(how = How.XPATH, using = "//input[@name='Provider.TaxId']")
	WebElement providerTaxId;

	@FindBy(how = How.XPATH, using = "//input[@name='ProviderReferringNpi']")
	WebElement providerReferringNpi;

	@FindBy(how = How.XPATH, using = "//input[@name='Provider.BillingNpi']")
	WebElement providerBillingNPI;

	@FindBy(how = How.XPATH, using = "//input[@name='Provider.BillingName']")
	WebElement providerBillingName;

	@FindBy(how = How.XPATH, using = "//input[@name='Provider.BillingAddress.City']")
	WebElement providerBillingAddrCity;

	@FindBy(how = How.XPATH, using = "//input[@name='Provider.BillingAddress.Line1']")
	WebElement providerBillingAddr1;

	@FindBy(how = How.XPATH, using = "//input[@name='Provider.BillingAddress.State']")
	WebElement providerBillingAddrState;

	@FindBy(how = How.XPATH, using = "//input[@name='Provider.BillingAddress.Zip']")
	WebElement providerBillingAddrZip;


	//Diagnosis Section Xpaths	
	@FindBy(how = How.XPATH, using = "//div[text()='Diagnosis']")
	WebElement diagnosisTab;

	@FindBy(how = How.XPATH, using = "//div[text()='DIAGNOSIS']")
	WebElement InstDiagnosisTab;

	@FindAll(@FindBy(how = How.XPATH, using = "//input[contains(@name,'Diagnoses.Code')]"))
	List<WebElement> primaryDiagnosesCode;

	@FindAll(@FindBy(how = How.XPATH, using = "//input[contains(@name,'diagnoses-0.Code')]"))
	List<WebElement> InstprimaryDiagnosesCode;	

	//LineItem Section Xpaths
	@FindBy(how = How.XPATH, using = "//div[text()='Line Items']")
	WebElement lineItemsTab;

	@FindBy(how = How.XPATH, using = "//div[text()='LINE ITEMS']")
	WebElement InstlineItemsTab;

	@FindBy(how = How.XPATH, using = "(//*[text()='Add']/ancestor::a//following-sibling::span)[4]")
	WebElement addClmLine;

	@FindBy(how = How.XPATH, using = "//input[@name='RevenueCode']")
	WebElement revenueCode;

	@FindBy(how = How.XPATH, using = "//input[@name='ServiceFromDate']")
	WebElement serviceFromDate;

	@FindBy(how = How.XPATH, using = "//input[@name='ServiceToDate']")
	WebElement serviceToDate;

	@FindBy(how = How.XPATH, using = "//input[@name='DiagnosisPointer1']")
	WebElement dx1;

	@FindBy(how = How.XPATH, using = "//input[@name='Modifier1']")
	WebElement mod1;

	@FindBy(how = How.XPATH, using = "//input[@name='Modifier2']")
	WebElement mod2;

	@FindBy(how = How.XPATH, using = "//input[@name='IdQualifier']")
	WebElement idQual;

	@FindBy(how = How.XPATH, using = "//input[@name='RenderingProviderNumber']")
	WebElement renderingPN;

	@FindBy(how = How.XPATH, using = "//input[@name='RenderingProviderNpi']")
	WebElement NPI;

	@FindBy(how = How.XPATH, using = "//input[@name='PlaceOfService']")
	WebElement pos;	

	@FindBy(how = How.XPATH, using = "//input[@name='ProcedureCode']")
	WebElement procedureCode;

	@FindBy(how = How.XPATH, using = "//input[@name='UnitsOfService']")
	WebElement unitsOfService;

	@FindBy(how = How.XPATH, using = "//input[@name='TotalCharges']")
	WebElement totalCharges;

	@FindBy(how = How.XPATH, using = "//input[@name='AnesthesiaHours']")
	WebElement anesHours;

	@FindBy(how = How.XPATH, using = "//input[@name='AnesthesiaMinutes']")
	WebElement anesMinutes;

	@FindBy(how = How.XPATH, using = "//span[text()='Update']/ancestor::a")
	WebElement update;


	//PatientMisc Section Xpaths

	@FindBy(how = How.XPATH, using = "//div[text()='Patient']")
	WebElement patientTab;

	@FindBy(how = How.XPATH, using = "	//div[text()='PATIENT']")
	WebElement instPatientTab;

	@FindBy(how = How.XPATH, using = "//input[@name='Patient.LastName']")
	WebElement patientLastName;

	@FindBy(how = How.XPATH, using = "//input[@name='Patient.FirstName']")
	WebElement patientFirstName;

	@FindBy(how = How.XPATH, using = "//input[@name='Patient.Address.Line1']")
	WebElement patientAddr1;

	@FindBy(how = How.XPATH, using = "//input[@name='Patient.Address.State']")
	WebElement patientAddrState;

	@FindBy(how = How.XPATH, using = "//input[@name='Patient.Address.Zip']")
	WebElement patientAddrZip;

	@FindBy(how = How.XPATH, using = "//input[@name='Patient.BirthDate']")
	WebElement patientBirthdate;

	@FindBy(how = How.XPATH, using = "//input[@name='Patient.Gender']")
	WebElement patientGender;

	@FindBy(how = How.XPATH, using = "//input[@name='Patient.Address.City']")
	WebElement patientAddrCity;

	@FindBy(how = How.XPATH, using = "//input[@name='Employers-0.Name']")
	WebElement empLastName;

	@FindBy(how = How.XPATH, using = "//input[@name='Employers-0.GroupNumber']")
	WebElement empGroupNumber;

	@FindBy(how = How.XPATH, using = "//input[@name='Insureds-0.MemberNumber']")
	WebElement instInsuredNumber;

	@FindBy(how = How.XPATH, using = "//input[@name='Insureds-0.LastName']")
	WebElement instInsuredLastName;

	@FindBy(how = How.XPATH, using = "//input[@name='Insureds.LastName']")
	WebElement insuredsMemberNumber;

	@FindBy(how = How.XPATH, using = "//input[@name='Insureds.MemberNumber']")
	WebElement insuredLastName;

	@FindBy(how = How.XPATH, using = "//input[@name='Insureds.Address.Line1']")
	WebElement insuredAddr;

	@FindBy(how = How.XPATH, using = "//input[@name='Insureds.Address.City']")
	WebElement insuredAddrCity;

	@FindBy(how = How.XPATH, using = "//input[@name='Insureds.Address.State']")
	WebElement insuredAddrState;

	@FindBy(how = How.XPATH, using = "//input[@name='Insureds.Address.Zip']")
	WebElement insuredAddrZip;

	@FindBy(how = How.XPATH, using = "//input[@name='Employers.GroupNumber']")
	WebElement insuredGroupNumber;

	@FindBy(how = How.XPATH, using = "//div[text()='Miscellaneous']")
	WebElement miscTab;

	@FindBy(how = How.XPATH, using = "//span[text()='Price & Save']/ancestor::a")
	WebElement clickPriceSave;

	//PricingDetailsValidation Section Xpaths

	@FindBy(how = How.XPATH, using = "//div[text()='Pricing Errors']")
	WebElement pricingErrorsTab;

	@FindBy(how = How.XPATH, using = "//div[text()='Pricing Details']")
	WebElement pricingDetailsTab;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'claim_pricingerrorsgrid-')]//table//td[1]/div")
	WebElement errorCode;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'claim_pricingerrorsgrid-')]//table//td[2]/div")
	WebElement errorDescription;	

	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='test-price-summary-subtitle']"))
	List<WebElement> claimLineLevel;

	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='test-price-summary-collapser collapser-clickable-area collapsed']"))
	List<WebElement> claimLineClick;

	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='value test-price-summary-bold test-price-header-numeric-value']"))
	List<WebElement> allowedAmount;


	String[] temporaryArray;

	@SuppressWarnings("static-access")
	public ClaimsPage(WebDriver driver, ExtentTest lInfo) {
		this.driver = driver;
		this.logInfo = lInfo;
		PageFactory.initElements(driver, this);

	}

	@SuppressWarnings("static-access")
	public ClaimsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/**
	 * @author M20589
	 * feedClaimInfo() method feeds the claim information into the claim form
	 * @param claimInfoDetails
	 * @return String
	 */
	public String feedClaimInfo(String claimInfoDetails) {
		String clmType=null;
		try {

			temporaryArray=null;			
			String data=null;			

			clickButton(popupCancel, getWait());

			temporaryArray=claimInfoDetails.split(ClaimsPageEnum.valueOf("STRING_DOUBLESLASH").getclaimsPageConstants());

			for(int j=0;j<temporaryArray.length;j++) {

				data=temporaryArray[j];

				if(data.contains(ClaimsPageEnum.valueOf("CLAIM_TYPE").getclaimsPageConstants())) {

					clmType = data.substring(ClaimsPageEnum.valueOf("CLAIM_TYPE").getclaimsPageConstants().length()+1).trim();
					logInfo.pass("Claim Type: "+clmType);
					logger.info("Claim Type: "+clmType);
				}

				else if(data.contains(ClaimsPageEnum.valueOf("CLAIM_NUMBER").getclaimsPageConstants())) {
					sendKeys(submitterClaimNumber, data.substring(ClaimsPageEnum.valueOf("CLAIM_NUMBER").getclaimsPageConstants().length()+1).trim());
					logInfo.pass("Claim Number: "+data.substring(ClaimsPageEnum.valueOf("CLAIM_NUMBER").getclaimsPageConstants().length()+1).trim());
					logger.info("Claim Number: "+data.substring(ClaimsPageEnum.valueOf("CLAIM_NUMBER").getclaimsPageConstants().length()+1).trim());
				}
				else if(data.contains(ClaimsPageEnum.valueOf("BILLING_PNAME").getclaimsPageConstants())) {
					sendKeys(providerBillingName, data.substring(ClaimsPageEnum.valueOf("BILLING_PNAME").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("RATESHEET").getclaimsPageConstants())) {
					if(clmType.equalsIgnoreCase(ClaimsPageEnum.valueOf("PROFESSIONAL").getclaimsPageConstants())) {
						sendKeys(profRS, data.substring(ClaimsPageEnum.valueOf("RATESHEET").getclaimsPageConstants().length()+1).trim());
						logInfo.pass("Rate sheet: "+data.substring(ClaimsPageEnum.valueOf("RATESHEET").getclaimsPageConstants().length()+1).trim());
						logger.info("Rate sheet: "+data.substring(ClaimsPageEnum.valueOf("RATESHEET").getclaimsPageConstants().length()+1).trim());
						getSleepWait();
					}
					else {
						sendKeys(instRS, data.substring(ClaimsPageEnum.valueOf("RATESHEET").getclaimsPageConstants().length()+1).trim());
						getSleepWait();
					}
				}
				else if(data.contains(ClaimsPageEnum.valueOf("RECEIVED_DATE").getclaimsPageConstants())) {
					receivedDate.clear();
					sendKeys(receivedDate, data.substring(ClaimsPageEnum.valueOf("RECEIVED_DATE").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("PROVIDER_NAME").getclaimsPageConstants())) {
					sendKeys(providerGroupName, data.substring(ClaimsPageEnum.valueOf("PROVIDER_NAME").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("TOB").getclaimsPageConstants())) {
					sendKeys(typeOfBill, data.substring(ClaimsPageEnum.valueOf("TOB").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("TAX_ID").getclaimsPageConstants())) {
					sendKeys(providerTaxId, data.substring(ClaimsPageEnum.valueOf("TAX_ID").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("NPI").getclaimsPageConstants())) {
					sendKeys(providerReferringNpi, data.substring(ClaimsPageEnum.valueOf("NPI").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("BUSSINESS_ADDR").getclaimsPageConstants())) {
					sendKeys(providerBillingAddr1, data.substring(ClaimsPageEnum.valueOf("BUSSINESS_ADDR").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("BUSINESS_CITY").getclaimsPageConstants())) {
					sendKeys(providerBillingAddrCity, data.substring(ClaimsPageEnum.valueOf("BUSINESS_CITY").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("BUSINESS_STATE").getclaimsPageConstants())) {
					sendKeys(providerBillingAddrState, data.substring("BState".length()+1).trim());
				}
				else if(data.contains(ClaimsPageEnum.valueOf("BUSINESS_ZIP").getclaimsPageConstants())) {
					sendKeys(providerBillingAddrZip, data.substring(ClaimsPageEnum.valueOf("BUSINESS_ZIP").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("ADMISSION_DATE").getclaimsPageConstants())) {
					sendKeys(admissionDate, data.substring("Admission Date".length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("ADMISSION_HOUR").getclaimsPageConstants())) {
					sendKeys(admissionHour, data.substring(ClaimsPageEnum.valueOf("ADMISSION_HOUR").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("ADMISSION_TYPE").getclaimsPageConstants())) {
					sendKeys(admissionType, data.substring(ClaimsPageEnum.valueOf("ADMISSION_TYPE").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("ADMISSION_SOURCE").getclaimsPageConstants())) {
					sendKeys(AdmissionSource, data.substring(ClaimsPageEnum.valueOf("ADMISSION_TYPE").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("DISCHARGE_DATE").getclaimsPageConstants())) {
					sendKeys(DischargeDate, data.substring(ClaimsPageEnum.valueOf("DISCHARGE_DATE").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("DISCHARGE_HOUR").getclaimsPageConstants())) {
					sendKeys(DischargeHour, data.substring(ClaimsPageEnum.valueOf("DISCHARGE_HOUR").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("DISCHARGE_STATUS").getclaimsPageConstants())) {
					sendKeys(DischargeStatus, data.substring(ClaimsPageEnum.valueOf("DISCHARGE_STATUS").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("STATEMENT_FROM").getclaimsPageConstants())) {
					sendKeys(StatementFromDate, data.substring(ClaimsPageEnum.valueOf("STATEMENT_FROM").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("STATEMENT_THRU").getclaimsPageConstants())) {
					sendKeys(StatementToDate, data.substring(ClaimsPageEnum.valueOf("STATEMENT_THRU").getclaimsPageConstants().length()+1).trim());

				}

			}

		}catch(Exception e) {
			logger.fatal("Error while adding claim information deatils , Exception: " + ", \n "+ e.getMessage());
		}
		return clmType;

	}

	/**
	 * @author M20589
	 * feedDiagnosesInfo() method feeds the diagnoses data in claim form
	 * @param diagnosesInfoDetails
	 * @param clmType
	 * @return void
	 */
	public void feedDiagnosesInfo(String diagnosesInfoDetails,String clmType) {

		try {

			temporaryArray=null;			
			String data=null;

			temporaryArray=diagnosesInfoDetails.split(ClaimsPageEnum.valueOf("STRING_DOUBLESLASH").getclaimsPageConstants());
			for(int j=0;j<temporaryArray.length;j++) {
				data=temporaryArray[j];

				if(clmType.equalsIgnoreCase(ClaimsPageEnum.valueOf("PROFESSIONAL").getclaimsPageConstants())) {

					clickButton(diagnosisTab, getWait());

					if(data.contains(ClaimsPageEnum.valueOf("PRIME_DX").getclaimsPageConstants())) {
						sendKeys(primaryDiagnosesCode.get(0), diagnosesInfoDetails.substring(ClaimsPageEnum.valueOf("PRIME_DX").getclaimsPageConstants().length()+1).trim());
						logInfo.pass("Primary Diagnosis Code: "+diagnosesInfoDetails.substring(ClaimsPageEnum.valueOf("PRIME_DX").getclaimsPageConstants().length()+1).trim());
						logger.info("Primary Diagnosis Code: "+diagnosesInfoDetails.substring(ClaimsPageEnum.valueOf("PRIME_DX").getclaimsPageConstants().length()+1).trim());
					}
					else if(data.contains(ClaimsPageEnum.valueOf("SECOND_DX").getclaimsPageConstants())) {
						sendKeys(primaryDiagnosesCode.get(1), diagnosesInfoDetails.substring(ClaimsPageEnum.valueOf("SECOND_DX").getclaimsPageConstants().length()+1).trim());
						logInfo.pass("2nd Diagnosis Code: "+diagnosesInfoDetails.substring(ClaimsPageEnum.valueOf("SECOND_DX").getclaimsPageConstants().length()+1).trim());
						logger.info("2nd Diagnosis Code: "+diagnosesInfoDetails.substring(ClaimsPageEnum.valueOf("SECOND_DX").getclaimsPageConstants().length()+1).trim());
					}
					else if(data.contains(ClaimsPageEnum.valueOf("THIRD_DX").getclaimsPageConstants())) {
						sendKeys(primaryDiagnosesCode.get(2), diagnosesInfoDetails.substring(ClaimsPageEnum.valueOf("THIRD_DX").getclaimsPageConstants().length()+1).trim());
						logInfo.pass("3rd Diagnosis Code: "+diagnosesInfoDetails.substring(ClaimsPageEnum.valueOf("THIRD_DX").getclaimsPageConstants().length()+1).trim());
						logger.info("3rd Diagnosis Code: "+diagnosesInfoDetails.substring(ClaimsPageEnum.valueOf("THIRD_DX").getclaimsPageConstants().length()+1).trim());
					}
				}

				else {

					clickButton(InstDiagnosisTab, getWait());

					if(data.contains(ClaimsPageEnum.valueOf("PRIME_DX").getclaimsPageConstants())) {
						sendKeys(InstprimaryDiagnosesCode.get(0), diagnosesInfoDetails.substring(ClaimsPageEnum.valueOf("PRIME_DX").getclaimsPageConstants().length()+1).trim());
						logInfo.pass("Primary Diagnosis Code: "+diagnosesInfoDetails.substring(ClaimsPageEnum.valueOf("PRIME_DX").getclaimsPageConstants().length()+1).trim());
						logger.info("Primary Diagnosis Code: "+diagnosesInfoDetails.substring(ClaimsPageEnum.valueOf("PRIME_DX").getclaimsPageConstants().length()+1).trim());
					}
					else if(data.contains(ClaimsPageEnum.valueOf("SECOND_DX").getclaimsPageConstants())) {
						sendKeys(InstprimaryDiagnosesCode.get(1), diagnosesInfoDetails.substring(ClaimsPageEnum.valueOf("SECOND_DX").getclaimsPageConstants().length()+1).trim());
						logInfo.pass("2nd Diagnosis Code: "+diagnosesInfoDetails.substring(ClaimsPageEnum.valueOf("SECOND_DX").getclaimsPageConstants().length()+1).trim());
						logger.info("2nd Diagnosis Code: "+diagnosesInfoDetails.substring(ClaimsPageEnum.valueOf("SECOND_DX").getclaimsPageConstants().length()+1).trim());
					}
					else if(data.contains(ClaimsPageEnum.valueOf("THIRD_DX").getclaimsPageConstants())) {
						sendKeys(InstprimaryDiagnosesCode.get(1), diagnosesInfoDetails.substring(ClaimsPageEnum.valueOf("THIRD_DX").getclaimsPageConstants().length()+1).trim());
						logInfo.pass("3rd Diagnosis Code: "+diagnosesInfoDetails.substring(ClaimsPageEnum.valueOf("THIRD_DX").getclaimsPageConstants().length()+1).trim());
						logger.info("3rd Diagnosis Code: "+diagnosesInfoDetails.substring(ClaimsPageEnum.valueOf("THIRD_DX").getclaimsPageConstants().length()+1).trim());
					}
				}
			}
		}catch(Exception e) {
			logger.fatal("Error while adding diagnosis code, Exception: " + ", \n "+ e.getMessage());
		}
	}

	/**
	 * @author M20589
	 * feedLineDetailsInfo() method feeds the line level claim details in claim form
	 * @param ClmLineData
	 * @param cnt
	 * @param clmType
	 * @return void
	 */
	public void feedLineDetailsInfo(ArrayList<String> ClmLineData,int cnt,String clmType) {

		try {

			if(clmType.equalsIgnoreCase(ClaimsPageEnum.valueOf("PROFESSIONAL").getclaimsPageConstants()))
				clickButton(lineItemsTab,getWait());
			else
				clickButton(InstlineItemsTab,getWait());

			for(int i=0;i<cnt;i++) {

				String tempLine=null;
				temporaryArray = null;

				clickButton(addClmLine, getWait());

				tempLine=ClmLineData.get(i);
				temporaryArray=tempLine.split(ClaimsPageEnum.valueOf("STRING_DOUBLESLASH").getclaimsPageConstants());

				String data=null;

				for(int j=0;j<temporaryArray.length;j++) {

					data=temporaryArray[j];

					if(data.contains(ClaimsPageEnum.valueOf("REV_CODE").getclaimsPageConstants())) {
						sendKeys(revenueCode, data.substring(ClaimsPageEnum.valueOf("REV_CODE").getclaimsPageConstants().length()+1).trim());						
					}

					else if(data.contains(ClaimsPageEnum.valueOf("SERVICE_FROM").getclaimsPageConstants())) {
						sendKeys(serviceFromDate, data.substring(ClaimsPageEnum.valueOf("SERVICE_FROM").getclaimsPageConstants().length()+1).trim());
					}
					else if(data.contains(ClaimsPageEnum.valueOf("SERVICE_TO").getclaimsPageConstants())) {
						sendKeys(serviceToDate, data.substring(ClaimsPageEnum.valueOf("SERVICE_TO").getclaimsPageConstants().length()+1).trim());

					}
					else if(data.contains(ClaimsPageEnum.valueOf("POS").getclaimsPageConstants())) {
						sendKeys(pos, data.substring(ClaimsPageEnum.valueOf("POS").getclaimsPageConstants().length()+1).trim());

					}
					else if(data.contains(ClaimsPageEnum.valueOf("PROC_CODE").getclaimsPageConstants())) {
						sendKeys(procedureCode, data.substring(ClaimsPageEnum.valueOf("PROC_CODE").getclaimsPageConstants().length()+1).trim());

					}
					else if(data.contains(ClaimsPageEnum.valueOf("MOD1").getclaimsPageConstants())) {
						sendKeys(mod1, data.substring(ClaimsPageEnum.valueOf("MOD1").getclaimsPageConstants().length()+1).trim());

					}
					else if(data.contains(ClaimsPageEnum.valueOf("MOD2").getclaimsPageConstants())) {
						sendKeys(mod2, data.substring(ClaimsPageEnum.valueOf("MOD2").getclaimsPageConstants().length()+1).trim());

					}
					else if(data.contains(ClaimsPageEnum.valueOf("DX1").getclaimsPageConstants())) {
						sendKeys(dx1, data.substring(ClaimsPageEnum.valueOf("DX1").getclaimsPageConstants().length()+1).trim());

					}
					else if(data.contains(ClaimsPageEnum.valueOf("CHARGES").getclaimsPageConstants())) {
						sendKeys(totalCharges, data.substring(ClaimsPageEnum.valueOf("CHARGES").getclaimsPageConstants().length()+1).trim());

					}
					else if(data.contains(ClaimsPageEnum.valueOf("UNITS").getclaimsPageConstants())) {
						sendKeys(unitsOfService, data.substring(ClaimsPageEnum.valueOf("UNITS").getclaimsPageConstants().length()+1).trim());
					}
					else if(data.contains(ClaimsPageEnum.valueOf("IDQUAL").getclaimsPageConstants())) {
						sendKeys(idQual, data.substring(ClaimsPageEnum.valueOf("IDQUAL").getclaimsPageConstants().length()+1).trim());
					}
					else if(data.contains(ClaimsPageEnum.valueOf("REND_NUM").getclaimsPageConstants())) {
						sendKeys(renderingPN, data.substring(ClaimsPageEnum.valueOf("REND_NUM").getclaimsPageConstants().length()+1).trim());
					}
					else if(data.contains(ClaimsPageEnum.valueOf("NPI").getclaimsPageConstants())) {
						sendKeys(NPI, data.substring(ClaimsPageEnum.valueOf("NPI").getclaimsPageConstants().length()+1).trim());
					}
					else if(data.contains(ClaimsPageEnum.valueOf("ANES_HOURS").getclaimsPageConstants())) {
						sendKeys(anesHours, data.substring(ClaimsPageEnum.valueOf("ANES_HOURS").getclaimsPageConstants().length()+1).trim());
					}
					else if(data.contains(ClaimsPageEnum.valueOf("ANES_MINS").getclaimsPageConstants())) {
						sendKeys(anesMinutes, data.substring(ClaimsPageEnum.valueOf("ANES_MINS").getclaimsPageConstants().length()+1).trim());
					}

				}
				clickButton(update, getWait());

			}


		}catch(Exception e) {
			logger.fatal("Error while adding claim line details, Exception: " + ", \n "+ e.getMessage());
		}
	}

	/**
	 * @author M20589
	 * feedPatientInsured() method feeds patient insured data in claims form
	 * @param patientInsuredDetails
	 * @param clmType
	 * @return void
	 */
	public void feedPatientInsured(String patientInsuredDetails,String clmType) {
		try {

			temporaryArray=null;			
			String data=null;

			if(clmType.equalsIgnoreCase(ClaimsPageEnum.valueOf("PROFESSIONAL").getclaimsPageConstants()))
				clickButton(patientTab, getWait());
			else
				clickButton(instPatientTab, getWait());

			temporaryArray=patientInsuredDetails.split(ClaimsPageEnum.valueOf("STRING_DOUBLESLASH").getclaimsPageConstants());

			for(int j=0;j<temporaryArray.length;j++) {
				data=temporaryArray[j];

				if(data.contains(ClaimsPageEnum.valueOf("PATIENT_LNAME").getclaimsPageConstants())) {
					sendKeys(patientLastName, data.substring(ClaimsPageEnum.valueOf("PATIENT_LNAME").getclaimsPageConstants().length()+1).trim());
				}
				else if(data.contains(ClaimsPageEnum.valueOf("PATIENT_FNAME").getclaimsPageConstants())) {
					sendKeys(patientFirstName, data.substring(ClaimsPageEnum.valueOf("PATIENT_FNAME").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("PATIENT_ADDR").getclaimsPageConstants())) {
					sendKeys(patientAddr1, data.substring(ClaimsPageEnum.valueOf("PATIENT_ADDR").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("PATIENT_STATE").getclaimsPageConstants())) {
					sendKeys(patientAddrState, data.substring(ClaimsPageEnum.valueOf("PATIENT_STATE").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("PATIENT_CITY").getclaimsPageConstants())) {
					sendKeys(patientAddrCity, data.substring(ClaimsPageEnum.valueOf("PATIENT_CITY").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("PATIENT_ZIP").getclaimsPageConstants())) {
					sendKeys(patientAddrZip, data.substring(ClaimsPageEnum.valueOf("PATIENT_ZIP").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("PATIENT_DOB").getclaimsPageConstants())) {
					sendKeys(patientBirthdate, data.substring(ClaimsPageEnum.valueOf("PATIENT_DOB").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("PATIENT_MALE").getclaimsPageConstants())) {
					sendKeys(patientGender, data.substring(ClaimsPageEnum.valueOf("PATIENT_MALE").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("INSTINSURED_LNAME").getclaimsPageConstants())) {
					sendKeys(instInsuredLastName, data.substring(ClaimsPageEnum.valueOf("INSTINSURED_LNAME").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("INSTINSURED_ID").getclaimsPageConstants())) {
					sendKeys(instInsuredNumber, data.substring(ClaimsPageEnum.valueOf("INSTINSURED_ID").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("EMPLOYER_NAME").getclaimsPageConstants())) {
					sendKeys(empLastName, data.substring(ClaimsPageEnum.valueOf("EMPLOYER_NAME").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("EMPLOYER_GNUM").getclaimsPageConstants())) {
					sendKeys(empGroupNumber, data.substring(ClaimsPageEnum.valueOf("EMPLOYER_GNUM").getclaimsPageConstants().length()+1).trim());

				}

				else if(data.contains(ClaimsPageEnum.valueOf("INSURED_LNAME").getclaimsPageConstants())) {
					sendKeys(insuredLastName, data.substring(ClaimsPageEnum.valueOf("INSURED_LNAME").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("INSURED_ID").getclaimsPageConstants())) {
					sendKeys(insuredsMemberNumber, data.substring(ClaimsPageEnum.valueOf("INSURED_ID").getclaimsPageConstants().length()+1).trim());
				}
				else if(data.contains(ClaimsPageEnum.valueOf("INSURED_ADDR").getclaimsPageConstants())) {
					sendKeys(insuredAddr, data.substring(ClaimsPageEnum.valueOf("INSURED_ADDR").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("INSURED_STATE").getclaimsPageConstants())) {
					sendKeys(insuredAddrState, data.substring(ClaimsPageEnum.valueOf("INSURED_STATE").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("INSURED_CITY").getclaimsPageConstants())) {
					sendKeys(insuredAddrCity, data.substring(ClaimsPageEnum.valueOf("INSURED_CITY").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("INSURED_ZIP").getclaimsPageConstants())) {
					sendKeys(insuredAddrZip, data.substring(ClaimsPageEnum.valueOf("INSURED_ZIP").getclaimsPageConstants().length()+1).trim());

				}
				else if(data.contains(ClaimsPageEnum.valueOf("INSURED_GNUM").getclaimsPageConstants())) {
					sendKeys(insuredGroupNumber, data.substring(ClaimsPageEnum.valueOf("INSURED_GNUM").getclaimsPageConstants().length()+1).trim());

				}

			}

		}catch(Exception e) {
			logger.fatal("Error while adding Patient Details, Exception: " + ", \n "+ e.getMessage());
		}
	}

	/**
	 * @author M20589
	 * feedMiscInfo() Method feeds data miscellaneous information in claim form
	 * @param miscInfoDetails
	 * @return void
	 */
	public void feedMiscInfo(String miscInfoDetails) {
		try {

			temporaryArray=null;			
			String data=null;

			clickButton(miscTab, getWait());

			temporaryArray=miscInfoDetails.split(ClaimsPageEnum.valueOf("STRING_DOUBLESLASH").getclaimsPageConstants());

			for(int j=0;j<temporaryArray.length;j++) {
				data=temporaryArray[j];

				if(data.contains(ClaimsPageEnum.valueOf("OUTSIDELAB").getclaimsPageConstants())) {
					logger.info(data.substring(ClaimsPageEnum.valueOf("OUTSIDELAB").getclaimsPageConstants().length()));
				}

			}


		}catch(Exception e) {
			logger.fatal("Error while adding Misc details, Exception: " + ", \n "+ e.getMessage());
		}
	}

	/**
	 * @author M20589
	 * clickOnPriceSave() method clicks on the price save button
	 * @return Void
	 */
	public void clickOnPriceSave() {
		try {

			clickButton(clickPriceSave, getWait());
			getSleepWait();

		}catch(Exception e) {
			logger.fatal("Error while clicking the Price and Save button, Exception: " + ", \n "+ e.getMessage());
		}

	}

	/**
	 * @author M20589
	 * validateclmPrice() Method Validate the Claim pricing details
	 * @param expectedResultInfo
	 * @return void
	 */
	public void validateclmPrice(String expectedResultInfo) {

		try {

			if(driver.findElements(By.xpath("//div[text()='Pricing Errors']")).size()>0){
				String errCode=getText(errorCode);
				String errDesc=getText(errorDescription);
				logInfo.fail("Claim not priced succ, Error Code: "+errCode+" and Error Description: "+errDesc);
			}
			else if (isElementDisplayed(pricingDetailsTab, getWait())) {
				getSleepWait();
				String allAmount= getText(allowedAmount.get(2));
				String discount = getText(allowedAmount.get(1));

				for(int i=claimLineClick.size()-1;i>=0;i--) {
					//scrollIntoView(driver);
					claimLineClick.get(i).click();				
				}

				temporaryArray=null;			
				String data=null;

				temporaryArray=expectedResultInfo.split(ClaimsPageEnum.valueOf("STRING_DOUBLESLASH").getclaimsPageConstants());

				for(int j=0;j<temporaryArray.length;j++) {
					data=temporaryArray[j];

					if(data.contains(ClaimsPageEnum.valueOf("ALLOWED_AMOUNT").getclaimsPageConstants())) {
						assertEquals(allAmount.trim(),data.substring(ClaimsPageEnum.valueOf("ALLOWED_AMOUNT").getclaimsPageConstants().length()+1).trim());
						logInfo.pass("Allowed amount in UI: "+allAmount+" and Allowed amount Expected: "+data.substring(ClaimsPageEnum.valueOf("ALLOWED_AMOUNT").getclaimsPageConstants().length()+1).trim());
						logger.info("Allowed amount in UI: "+allAmount+" and Allowed amount Expected: "+data.substring(ClaimsPageEnum.valueOf("ALLOWED_AMOUNT").getclaimsPageConstants().length()+1).trim());
					}
					else if (data.contains(ClaimsPageEnum.valueOf("DISCOUNT").getclaimsPageConstants())) {
						assertEquals(discount.trim(),data.substring(ClaimsPageEnum.valueOf("DISCOUNT").getclaimsPageConstants().length()+1).trim());
						logInfo.pass("Discount amount in UI: "+discount+" and Discount amount in Expected: "+data.substring(ClaimsPageEnum.valueOf("DISCOUNT").getclaimsPageConstants().length()+1).trim());
						logger.info("Discount amount in UI: "+discount+" and Discount amount in Expected: "+data.substring(ClaimsPageEnum.valueOf("DISCOUNT").getclaimsPageConstants().length()+1).trim());
					}
					else if (data.contains(ClaimsPageEnum.valueOf("TERM1").getclaimsPageConstants())) {
						boolean termFlag=false;
						for(int i=0;i<claimLineLevel.size();i++) {

							if(getText(claimLineLevel.get(i)).contains(data.substring(ClaimsPageEnum.valueOf("TERM1").getclaimsPageConstants().length()+1).trim())){
								termFlag=true;
								String termUI=getText(claimLineLevel.get(i));
								logInfo.pass("Term hit in UI: "+termUI+" matches with the expected term to be hit: "+data.substring(ClaimsPageEnum.valueOf("TERM1").getclaimsPageConstants().length()+1).trim());
								logger.info("Term hit in UI: "+termUI+" matches with the expected term to be hit: "+data.substring(ClaimsPageEnum.valueOf("TERM1").getclaimsPageConstants().length()+1).trim());
							}
						}
						if(termFlag==false) {
							logInfo.fail("Term hit in UI doesn't have exepct term to be hit, Term: "+data.substring(ClaimsPageEnum.valueOf("TERM1").getclaimsPageConstants().length()+1).trim());
						}

					}
					else if (data.contains(ClaimsPageEnum.valueOf("TERM2").getclaimsPageConstants())) {
						boolean termFlag=false;
						for(int i=0;i<claimLineLevel.size();i++) {

							if(getText(claimLineLevel.get(i)).contains(data.substring(ClaimsPageEnum.valueOf("TERM2").getclaimsPageConstants().length()+1).trim())){
								termFlag=true;
								String termUI=getText(claimLineLevel.get(i));
								logInfo.pass("Term hit in UI: "+termUI+" matches with the expected term to be hit: "+data.substring(ClaimsPageEnum.valueOf("TERM2").getclaimsPageConstants().length()+1).trim());
								logger.info("Term hit in UI: "+termUI+" matches with the expected term to be hit: "+data.substring(ClaimsPageEnum.valueOf("TERM2").getclaimsPageConstants().length()+1).trim());
							}
						}
						if(termFlag==false) {
							logInfo.fail("Term hit in UI doesn't have exepct term to be hit, Term: "+data.substring(ClaimsPageEnum.valueOf("TERM2").getclaimsPageConstants().length()+1).trim());
						}
					}
					else if (data.contains(ClaimsPageEnum.valueOf("TERM3").getclaimsPageConstants())) {
						boolean termFlag=false;
						for(int i=0;i<claimLineLevel.size();i++) {

							if(getText(claimLineLevel.get(i)).contains(data.substring(ClaimsPageEnum.valueOf("TERM3").getclaimsPageConstants().length()+1).trim())){
								termFlag=true;
								String termUI=getText(claimLineLevel.get(i));
								logInfo.pass("Term hit in UI: "+termUI+" matches with the expected term to be hit: "+data.substring(ClaimsPageEnum.valueOf("TERM3").getclaimsPageConstants().length()+1).trim());
								logger.info("Term hit in UI: "+termUI+" matches with the expected term to be hit: "+data.substring(ClaimsPageEnum.valueOf("TERM3").getclaimsPageConstants().length()+1).trim());
							}
						}
						if(termFlag==false) {
							logInfo.fail("Term hit in UI doesn't have exepct term to be hit, Term: "+data.substring(ClaimsPageEnum.valueOf("TERM3").getclaimsPageConstants().length()+1).trim());
						}
					}
					else if (data.contains(ClaimsPageEnum.valueOf("TERM4").getclaimsPageConstants())) {
						boolean termFlag=false;
						for(int i=0;i<claimLineLevel.size();i++) {
							if(getText(claimLineLevel.get(i)).contains(data.substring(ClaimsPageEnum.valueOf("TERM4").getclaimsPageConstants().length()+1).trim())){
								termFlag=true;
								String termUI=getText(claimLineLevel.get(i));
								logInfo.pass("Term hit in UI: "+termUI+" matches with the expected term to be hit: "+data.substring(ClaimsPageEnum.valueOf("TERM4").getclaimsPageConstants().length()+1).trim());
								logger.info("Term hit in UI: "+termUI+" matches with the expected term to be hit: "+data.substring(ClaimsPageEnum.valueOf("TERM4").getclaimsPageConstants().length()+1).trim());
							}
						}
						if(termFlag==false) {
							logInfo.fail("Term hit in UI doesn't have exepct term to be hit, Term: "+data.substring(ClaimsPageEnum.valueOf("TERM4").getclaimsPageConstants().length()+1).trim());
						}
					}
					else if (data.contains(ClaimsPageEnum.valueOf("TERM5").getclaimsPageConstants())) {
						boolean termFlag=false;
						for(int i=0;i<claimLineLevel.size();i++) {
							if(getText(claimLineLevel.get(i)).contains(data.substring(ClaimsPageEnum.valueOf("TERM5").getclaimsPageConstants().length()+1).trim())){
								termFlag=true;
								String termUI=getText(claimLineLevel.get(i));
								logInfo.pass("Term hit in UI: "+termUI+" matches with the expected term to be hit: "+data.substring(ClaimsPageEnum.valueOf("TERM5").getclaimsPageConstants().length()+1).trim());
								logger.info("Term hit in UI: "+termUI+" matches with the expected term to be hit: "+data.substring(ClaimsPageEnum.valueOf("TERM5").getclaimsPageConstants().length()+1).trim());
							}
						}
						if(termFlag==false) {
							logInfo.fail("Term hit in UI doesn't have exepct term to be hit, Term: "+data.substring(ClaimsPageEnum.valueOf("TERM5").getclaimsPageConstants().length()+1).trim());
						}
					}

				}
			}

		}catch(AssertionError | Exception e) {
			logger.fatal("Error while validating the pricing details, Excpetion: " + ", \n "+ e.getMessage());
		}
	}

}
