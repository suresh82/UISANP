package com.cigna.claimsanpuiautomaiton.enums;

/*Created by: Sivagami N 
Created date: 
Class Name: ExtentReportListenerEnum
Class Description: This enum class identifies the strings in the ExtentReportListener class and creates constants for it. */

public enum ExtentReportListenerEnum {

	DOCUMENT_TITLE("Execute Automation Report"),
	DOCUMENT_TYPE(".html"),
	DOCUMENT_TYPEPNG(".png"),
	REPORT_NAME("Execute Automation Report"),
	APPLICATION("Application"), 
	EXECUTE_AUTOMATION("Execute Automation"),
	OPERATING_SYSTEM("Operating System"),
	USER("User"), 
	FAILED_TEXT("Test Case is Failed"),
	FAILED_TEXT_DETAIL("Control is not found"), 
	PASSED_TEXT("Test Case is Passed :"), 
	FILE_TYPE(".html"),
	DATE_FORMAT("MM/dd/yyyy HH:mm:ss"), 
	BACKSLASH("/"), 
	COLON(":");

	private final String reportDetails;

	/* Constructor */
	ExtentReportListenerEnum(String reportDetails) {
		this.reportDetails = reportDetails;

	}

	/*
	 * Created by: Sivagami N Created date: Method Name: getReportDetails Method
	 * Description: Method to assign the string value mapped to constants in this
	 * class Input Parameters: Return: Method returns the String mapped to the
	 * constant
	 */
	public String getReportDetails() {
		return this.reportDetails;
	}

}
