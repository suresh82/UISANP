package com.cigna.claimsanpuiautomaiton.enums;

/*Created by: Sivagami N 
Created date: 
Class Name: ReportHelperEnum
Class Description: This enum class identifies the strings in the Report Helper class and creates constants for it. */

public enum ReportHelperEnum {

	JSON_FILE("target/cucumber-reports/CucumberTestReport.json"),
	PROJECT_NAME("testng-cucumber"), 
	PLATFORM("Platform"),
	BROWSER("Browser"), 
	BROWSER_TYPE("Chrome"),
	BRANCH("Branch"),
	RELEASE("release/1.0"),
	REPORT_PROPERTIES("resources/PropertyFiles/report.properties"), 
	NEWFILE("target"),
	NEWFILEPATH("./target"),
	CUCUMBER_REPORT_PATH("/CucumberReports"), 
	CUCUMBER_REPORT_ZIPPEDPATH("\\CucumberHTMLReports.zip");

	private final String reportHelperDetails;

	/* Constructor */
	ReportHelperEnum(String reportHelperDetails) {
		this.reportHelperDetails = reportHelperDetails;

	}

	/*
	 * Created by: Sivagami N Created date: Method Name: getReportHelperDetails
	 * Method Description: Method to assign the string value mapped to constants in
	 * this class Input Parameters: Return: Method returns the String mapped to the
	 * constant
	 */
	public String getReportHelperDetails() {
		return this.reportHelperDetails;
	}

}
