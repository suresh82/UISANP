package com.cigna.claimsanpuiautomaiton.enums;

/*Created by: Rakhi Bisht  
Created date: 
Class Name: GeneralUtilitiesEnum
Class Description: This enum class identifies the strings in the GeneralUtilities class and creates constants for it. */

public enum GeneralUtilitiesEnum {

	STRING_WITH_EMPTY("Empty"),
	STRING_NULL(""), 
	STRING_BACKSLASH("/"),
	STRING_DOT("."),
	STRING_NA("NA"),
	STRING_ANY("any"), 
	STRING_UNDERSCORE("NA"),
	STRING_PIPE("|"),
	STRING_CHAR("'"),
	STRING_COLON(":"),
	STRING_INDEX("[i]"),
	OPEN_BRACKET("["),
	CLOSE_BRACKET("]"),
	CLAIM_TYPE("Claim type"),
	CASE_ACTION("Case Action"),
	STRING_ACTUAL_EMPTY("Empty or Not Found"),
	STRING_SYMBOL("$."),
	STRING_MARK("' "),
	NEW_LINE("\n"), 
	FEATURE_FILE_PATH("src/test/resources/Features/"),
	FEATURE_FILE_FORMAT(".feature"),
	BROWSER_CHROME("chrome"),
	BROWSER_FIREFOX("FireFox"),
	BROWSER_IE("IE"),
	BROWSER_EDGE("Edge"),
	STRING_FILETYPEPREREQ("PREREQ"),
	STRING_FILETYPECONFIG("CONFIG"), 
	STRING_FILETYPELOG("LOG"),
	PROPERTY_FILE_PATH("resources/PropertyFiles/Prerequisites.properties"),
	CONFIGPROPERTY_FILE_PATH("resources/PropertyFiles/config.properties"),
	LOGPROPERTY_FILE_PATH("resources/PropertyFiles/log4j.properties"),
	OPTIONS_EXPERIMENTAL("useAutomationExtension"),
	OPTIONS_DIMENSION("--window-size=1920,1200"), 
	OPTIONS_EXPERIMENTALSWITCH("excludeSwitches"),
	OPTIONS_EXPERIMENTALSWITCHNEW("enable-automation"), 
	OPTIONS_AUTOMATIONEXTENSION("useAutomationExtension"),
	OPTIONS_HEADLESS("headless"), 
	CHROME_PROPERTY("webdriver.chrome.driver"),
	FIREFOX_PROPERTY("webdriver.gecko.driver"), 
	IE_PROPERTY("webdriver.ie.driver"),
	EDGE_PROPERTY("webdriver.edge.driver");

	private final String generalUtilities;

	/* Constructor */
	GeneralUtilitiesEnum(String generalUtilities) {
		this.generalUtilities = generalUtilities;

	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: getGeneralUtilities Method
	 * Description: Method to assign the string value mapped to constants in this
	 * class Input Parameters: Return: Method returns the String mapped to the
	 * constant
	 */
	public String getGeneralUtilities() {
		return this.generalUtilities;
	}

}
