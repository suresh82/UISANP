package com.cigna.claimsanpuiautomaiton.reporterutilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.cigna.claimsanpuiautomaiton.commonmethods.CommonFunctions;
import com.cigna.claimsanpuiautomaiton.enums.ReportHelperEnum;
import com.cigna.claimsanpuiautomaiton.utilities.ZipCucumberHTMLReportsUtil;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/*Created by: Rakhi Bisht 
Created date: November 2019
Class Name: ReportHelper
Class Description: This class includes methods to perform the initial settings for Cucumber report
*/
public class ReportHelper extends CommonFunctions{

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: generateCucumberReport
	 * Method Description: Method to arrange the features and settings for
	 * generating cucumber report Input Parameters: Return: Method does not return
	 * anything
	 */
	public static void generateCucumberReport() {
		File reportOutputDirectory = new File(ReportHelperEnum.valueOf("NEWFILE").getReportHelperDetails());
		ArrayList<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(ReportHelperEnum.valueOf("JSON_FILE").getReportHelperDetails());
		String projectName = ReportHelperEnum.valueOf("PROJECT_NAME").getReportHelperDetails();
		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		configuration.addClassifications(ReportHelperEnum.valueOf("PLATFORM").getReportHelperDetails(),
				System.getProperty("os.name"));
		configuration.addClassifications(ReportHelperEnum.valueOf("BROWSER").getReportHelperDetails(),
				ReportHelperEnum.valueOf("BROWSER_TYPE").getReportHelperDetails());
		configuration.addClassifications(ReportHelperEnum.valueOf("BRANCH").getReportHelperDetails(),
				ReportHelperEnum.valueOf("RELEASE").getReportHelperDetails());

		// optionally add metadata presented on main page via properties file
		List<String> classificationFiles = new ArrayList<String>();
		classificationFiles.add(ReportHelperEnum.valueOf("REPORT_PROPERTIES").getReportHelperDetails());
		configuration.addClassificationFiles(classificationFiles);
		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();
		File dir = new File(ReportHelperEnum.valueOf("NEWFILEPATH").getReportHelperDetails()
				+ ReportHelperEnum.valueOf("CUCUMBER_REPORT_PATH").getReportHelperDetails());
		dir.mkdir();
		String srcFolder = properties.getProperty("SRCFOLDERTOBEZIPPED");
		String destZipFile = properties.getProperty("DESTINATIONZIPPEDFOLDER")
				+ ReportHelperEnum.valueOf("CUCUMBER_REPORT_ZIPPEDPATH").getReportHelperDetails();
		ZipCucumberHTMLReportsUtil zipFiles = new ZipCucumberHTMLReportsUtil();
		zipFiles.zipFiles(srcFolder, destZipFile);
	}

}
