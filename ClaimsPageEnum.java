package com.cigna.claimsanpuiautomaiton.enums;

/*Created by: Suresh Madhasu  
Created date: 11/12/2020
Class Name: ClaimsPageEnum
Class Description: This enum class identifies the strings in the ClaimsPage class and creates constants for it. */

public enum ClaimsPageEnum {

	STRING_DOUBLESLASH("\\n"),
	CLAIM_NUMBER("Claim Number"),
	BILLING_PNAME("Billing Provider Name"),
	RATESHEET("Ratesheet"),
	PROFESSIONAL("P"),
	RECEIVED_DATE("Received Date"),
	PROVIDER_NAME("Provider Name"),
	TOB("Type of Bill"),
	STRING_WITH_EMPTY("Empty"),
	STRING_NULL(""),
	TAX_ID("TaxId"),
	NPI("NPI"),
	BUSSINESS_ADDR("BAddress1"),
	BUSINESS_CITY("BCity"),
	BUSINESS_STATE("BState"),
	BUSINESS_ZIP("BZip"),
	ADMISSION_DATE("Admission Date"),
	STRING_BACKSLASH("/"),
	STRING_DOT("."), 
	STRING_NA("NA"),
	ADMISSION_HOUR("Admission Hour"),
	ADMISSION_TYPE("Admission Type"),
	ADMISSION_SOURCE("Admission Source"),
	STRING_ANY("any"),
	STRING_UNDERSCORE("NA"), 
	STRING_PIPE("|"),
	STRING_CHAR("'"),
	STRING_COLON(":"),
	DISCHARGE_DATE("Discharge Date"),
	DISCHARGE_HOUR("Discharge Hour"),
	DISCHARGE_STATUS("Discharge Status"),
	STRING_INDEX("[i]"),
	OPEN_BRACKET("["),
	CLOSE_BRACKET("]"),
	STATEMENT_FROM("Statement From"),
	STATEMENT_THRU("Statement Through"),
	CLAIM_TYPE("Claim Type"),
	CASE_ACTION("Case Action"),
	STRING_ACTUAL_EMPTY("Empty or Not Found"),
	PRIME_DX("Primary Diagnosis"),
	SECOND_DX("Secondary Diagnosis"),
	THIRD_DX("Third Diagnosis"),
	REV_CODE("Rev Code"),
	SERVICE_FROM("Service From"),
	SERVICE_TO("Service To"),
	POS("POS"),
	PROC_CODE("CPT HCPCS"),
	MOD1("Mod1"),
	MOD2("Mod2"),
	DX1("DX1"),
	CHARGES("Charges"),
	UNITS("Units"),
	IDQUAL("IdQual"),
	REND_NUM("RenderingNumber"),
	ANES_HOURS("AnesHours"),
	ANES_MINS("AnesMinutes"),
	PATIENT_LNAME("Patient LastName"),
	PATIENT_FNAME("Patient FirstName"),
	PATIENT_ADDR("Patient Adress"),
	PATIENT_STATE("Patient State"),
	PATIENT_CITY("Patient City"),
	PATIENT_ZIP("Patient Zip"),
	PATIENT_DOB("Patient DOB"),
	PATIENT_MALE("Patient Male"),
	INSTINSURED_LNAME("InstInsured LastName"),
	INSTINSURED_ID("InstInsured ID"),
	EMPLOYER_NAME("Employer Name"),
	EMPLOYER_GNUM("Employer Group Number"),
	INSURED_LNAME("Insured LastName"),
	INSURED_ID("Insured ID"),
	INSURED_ADDR("Insured Address"),
	INSURED_STATE("Insured State"),
	INSURED_CITY("Insured City"),
	INSURED_ZIP("Insured Zip"),
	INSURED_GNUM("Insured GroupNumber"),
	OUTSIDELAB("OutSideLab"),
	ALLOWED_AMOUNT("Allowed Amount"),
	DISCOUNT("Discount"),
	TERM1("Term1"),
	TERM2("Term2"),
	TERM3("Term3"),
	TERM4("Term4"),
	TERM5("Term5"),
	STRING_SYMBOL("$."),
	STRING_MARK("' ");

	private final String claimsPageConstants;

	/* Constructor */
	ClaimsPageEnum(String claimsPageConstants) {
		this.claimsPageConstants = claimsPageConstants;

	}

	/*
	 * Created by: Suresh M Created date: Method Name: getclaimsPageConstants Method
	 * Description: Method to assign the string value mapped to constants in this
	 * class Input Parameters: Return: Method returns the String mapped to the
	 * constant
	 */
	public String getclaimsPageConstants() {
		return this.claimsPageConstants;
	}

}
