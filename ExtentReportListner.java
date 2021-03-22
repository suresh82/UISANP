package com.cigna.claimsanpuiautomaiton.reporterutilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cigna.claimsanpuiautomaiton.commonmethods.CommonFunctions;
import com.cigna.claimsanpuiautomaiton.enums.ExtentReportListenerEnum;
import com.cigna.claimsanpuiautomaiton.utilities.PropertiesFileReader;

/*Created by: Rakhi Bisht 
Created date: January 2020
Class Name: ExtentReportListner
Class Description: This class includes methods to perform the initial settings for Extent report
*/
public class ExtentReportListner extends CommonFunctions {
	public static ExtentHtmlReporter report = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;
	public static PropertiesFileReader obj = new PropertiesFileReader();

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: ExtentReports Method
	 * Description: Method to do the general settings for Extent report Input
	 * Parameters: Return: Method returns extent report with the settings performed
	 * in the method and details of scenario executed
	 */
	public static ExtentReports setup() {
		Properties prop = null;
		archieveExtentReports();
		try {
			prop = obj.getProperty();
			String location = prop.getProperty("EXTENT_REPORTS_PATH") + getCurrentDateandTime()
					+ ExtentReportListenerEnum.valueOf("DOCUMENT_TYPE").getReportDetails();
			report = new ExtentHtmlReporter(location);
			report.config().setDocumentTitle(ExtentReportListenerEnum.valueOf("DOCUMENT_TITLE").getReportDetails());
			report.config().setReportName(ExtentReportListenerEnum.valueOf("REPORT_NAME").getReportDetails());
			report.config().setTheme(Theme.STANDARD);
			logger.info("Extent Report Location Initialized..");
			report.start();
			extent = new ExtentReports();
			extent.attachReporter(report);
			extent.setSystemInfo(ExtentReportListenerEnum.valueOf("APPLICATION").getReportDetails(),
					ExtentReportListenerEnum.valueOf("EXECUTE_AUTOMATION").getReportDetails());
			extent.setSystemInfo(ExtentReportListenerEnum.valueOf("OPERATING_SYSTEM").getReportDetails(),
					System.getProperty("os.name"));
			extent.setSystemInfo(ExtentReportListenerEnum.valueOf("USER").getReportDetails(),
					System.getProperty("user.name"));
			logger.info("System Info.set in Extent Report");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return extent;
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: testStepHandle Method
	 * Description: Method to handle the test step status and corresponding settings
	 * Input Parameters: Teststatus(Status of the step executed),
	 * WebDriver,ExtentTest,Throwable(Exception) Return: Method does not return
	 * anything
	 */
	public static void testStepHandle(String teststatus, WebDriver driver, ExtentTest extenttest, Throwable throwable)
			throws IOException {

		switch (teststatus) {

		case "FAIL":
			extenttest.fail(MarkupHelper.createLabel(ExtentReportListenerEnum.valueOf("FAILED_TEXT").getReportDetails(),
					ExtentColor.RED));
			extenttest.fail(MarkupHelper.createLabel(
					ExtentReportListenerEnum.valueOf("FAILED_TEXT_DETAIL").getReportDetails(), ExtentColor.BROWN));
			extenttest.error(throwable.fillInStackTrace());
			if (driver != null) {

				extenttest.addScreenCaptureFromPath(captureScreenShot(driver));
				driver.quit();
			}
			break;
		case "PASS":
			extenttest.pass(MarkupHelper.createLabel(ExtentReportListenerEnum.valueOf("PASSED_TEXT").getReportDetails(),
					ExtentColor.GREEN));
			break;
		default:
			break;
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: captureScreenShot Method
	 * Description: Method to capture the screenshot of the currently open window
	 * Input Parameters:WebDriver Return: Method returns detination folder of the
	 * screenshots captured
	 */
	public static String captureScreenShot(WebDriver driver) throws IOException {

		Properties prop = obj.getProperty();
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + prop.getProperty("SCREENSHOT_PATH") + getCurrentDateandTime()
				+ ExtentReportListenerEnum.valueOf("DOCUMENT_TYPEPNG").getReportDetails();
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: getCurrentDateandTime
	 * Method Description: Method to return current date and time Input Parameters:
	 * Return: Method returns current date and time as string
	 */
	private static String getCurrentDateandTime() {
		String str = null;
		try {
			// DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			DateFormat dateFormat = new SimpleDateFormat(
					ExtentReportListenerEnum.valueOf("DATE_FORMAT").getReportDetails());
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace("", "").replaceAll(ExtentReportListenerEnum.valueOf("BACKSLASH").getReportDetails(), "")
					.replaceAll(ExtentReportListenerEnum.valueOf("COLON").getReportDetails(), "");
		} catch (Exception e) {

		}
		return str;
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: archieveExtentReports
	 * Method Description: Method to Archive the old extent reports file to
	 * ArchieveReports Folder Input Parameters: Return: Method returns boolean value
	 * as true if the older extent reports are archived successfully
	 */
	private static boolean archieveExtentReports() {
		boolean isArchieved = false;
		Properties prop = null;
		try {
			prop = obj.getProperty();
			String archieveReportsSourcePath = prop.getProperty("EXTENT_REPORTS_PATH");
			String archieveReportsDestinationPath = prop.getProperty("EXTENT_REPORTS_ARCHIEVED_PATH");
			String[] listOfReports = new File(archieveReportsSourcePath).list();// listFiles();
			for (String reportName : listOfReports) {
				if (reportName.contains(ExtentReportListenerEnum.valueOf("FILE_TYPE").getReportDetails())) {
					Path sourcePath = Paths.get(archieveReportsSourcePath
							+ ExtentReportListenerEnum.valueOf("BACKSLASH").getReportDetails() + reportName);
					Path destinationPath = Paths.get(archieveReportsDestinationPath
							+ ExtentReportListenerEnum.valueOf("BACKSLASH").getReportDetails() + reportName);
					Files.move(sourcePath, destinationPath);
					isArchieved = true;
				}
			}
		} catch (IOException e) {

			e.printStackTrace();
			isArchieved = false;
		}
		return isArchieved;
	}
}
