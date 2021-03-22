package com.cigna.claimsanpuiautomaiton.commonmethods;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cigna.claimsanpuiautomaiton.stepdefinition.Hooks;
import com.cigna.claimsanpuiautomaiton.utilities.PropertiesFileReader;
import com.google.common.base.Function;

/*Created by: Rakhi Bisht 
Created date: 
Class Name: AppPage
Class Description: This class identifies the common actions performed on WebElements as generalized methods which can be called in individual web page classes*/
public class CommonFunctions {

	protected String winTitle;
	public static Logger logger = Logger.getLogger(CommonFunctions.class);
	PropertiesFileReader propertiesFileReader = new PropertiesFileReader();
	public static Properties logProperties;
	public static Properties properties;
	public static WebDriver driver;

//Constructor
	public CommonFunctions() {
		try {
			properties = propertiesFileReader.getProperty("PREREQ");
			logProperties = propertiesFileReader.getProperty("LOG");
			driver = Hooks.driver;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: mouseHover Method
	 * Description: Method to hover over a web element after waiting for the element
	 * to be clickable/Displayed Input Parameters: WebElement, Wait time Return:
	 * Method does not return anything
	 */

	public void mouseHover(WebElement element, long timeOut) {

		PropertyConfigurator.configure(logProperties);

		logger.info("Hovering on Button");
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, timeOut);

		try {
			if (wait.until(ExpectedConditions.elementToBeClickable(element)) != null) {
				if (element.isDisplayed() || element.isEnabled()) {
					action.moveToElement(element).perform();
				}
			}
		} catch (NoSuchElementException e) {
			logger.info("****Unable to hover on element*****" + ", \n " + e.getMessage());
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: maximizeWindow Method
	 * Description: Method to maximize the browser window Input Parameters: Return:
	 * Method does not return anything
	 */
	public static void maximizeWindow(WebDriver driver) {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			logger.info("*****Unable to maximize window*****" + ", \n " + e.getMessage());

		}
	}

	/*
	 * Created by: Sivagami N Created date: Method Name: pageLoadTime Method
	 * Description: Method to implement wait time to load page Input Parameters: Return:
	 * Method does not return anything
	 */
	public static void pageLoadTime(WebDriver driver) {
		try {
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			logger.info("*****Unable to load page*****" + ", \n " + e.getMessage());

		}
	}
	
	/*
	 * Created by: Sivagami N Created date: Method Name: pageImplicitlyWait Method
	 * Description: Method to implement implicit wait time to load page Input Parameters: Return:
	 * Method does not return anything
	 */
	public static void pageImplicitlyWait(WebDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		} catch (Exception e) {
			logger.info("*****Unable to load page*****" + ", \n " + e.getMessage());

		}
	}
	
	/*
	 * Created by: Sivagami N Created date: Method Name: loadApplicationUrl Method
	 * Description: Method to to load the application url Input Parameters: Application URL Return:
	 * Method does not return anything
	 */
	public static void loadApplicationUrl(WebDriver driver,String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			logger.info("*****Unable to load applications*****" + ", \n " + e.getMessage());

		}
	}
	
	/*
	 * Created by: Rakhi Bisht Created date: Method Name: clickButton Method
	 * Description: Method to click on a web element Input Parameters: Webelement,
	 * Wait time Return: Method does not return anything
	 */
	public static void clickButton(WebElement element, long timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		try {
			boolean elementIsDisplayed = element.isDisplayed();
			while (elementIsDisplayed) {
				logger.info(element.getText() + "****Button is clicked*****");
				element.click();
				// log.info("*******Clicked on Button******" + element);
				break;
			}
		} catch (Exception e) {
			logger.error("****Element Not Displayed*****" + element + ", \n " + e.getMessage());
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: rightClick Method
	 * Description: Method to right click on a web element Input Parameters:
	 * WebElement, Wait time Return: Method does not return anything
	 */
	public static void rightClick(WebElement element, long timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		try {
			boolean elementIsDisplayed = element.isDisplayed();
			while (elementIsDisplayed) {

				Actions obj = new Actions(driver);
				obj.contextClick(element).perform();
				logger.info(element.getText() + "**** element is right clicked*****");
				break;
			}
		} catch (Exception e) {
			logger.error("****Element Not Displayed*****" + element + ", \n " + e.getMessage());
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: isElementDisplayed Method
	 * Description: Method to include wait time before checking if the element is
	 * displayed Input Parameters: WebElement, Wait time Return: Method does not
	 * return anything
	 */
	public boolean isElementDisplayed(WebElement element, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		try {
			boolean elementIsDisplayed = element.isDisplayed();
			while (elementIsDisplayed) {
				return true;
			}
		} catch (Exception e) {
			logger.error("****Element Not Displayed*****" + element + ", \n " + e.getMessage());
		}
		return false;
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: getWait Method
	 * Description: Method to include wait time for a web element Input Parameters:
	 * Return: Method returns the maximum waiting time defined with long data type
	 * to handle larger numbers
	 */
	public long getWait() {
		String maxTimeOut = null;

		try {
			maxTimeOut = (properties.getProperty("WAIT"));
		} catch (Exception e) {
			logger.error("*****Maximum time out*****" + ", \n " + e.getMessage());
		}
		return Long.parseLong(maxTimeOut);

	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: getSleepWait Method
	 * Description: Method to include maximum wait time for a web element Input
	 * Parameters: Return: Method does not return anything
	 */
	public void getSleepWait() {
		String maxTimeOut = (properties.getProperty("MAXTIMEOUT"));
		int sleepTime = Integer.parseInt(maxTimeOut);
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			logger.error("*****Maximum time out*****" + ", \n " + e.getMessage());
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: getAverageWait Method
	 * Description: Method to include average wait time for a web element Input
	 * Parameters: Return: Method does not return anything
	 */
	public void getAverageWait() {
		String avgTimeOut = (properties.getProperty("AVGTIMEOUT"));
		int sleepTime = Integer.parseInt(avgTimeOut);
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			logger.error("*****Maximum time out*****" + ", \n " + e.getMessage());
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: switchWindow Method
	 * Description: Method to switch windows in the browser Input Parameters:
	 * Return: Method does not return anything
	 */
	public static void switchWindow() {
		String parent = driver.getWindowHandle();
		try {
			for (String winHandle : driver.getWindowHandles()) {
				if (!winHandle.equals(parent)) {
					driver.switchTo().window(winHandle);
				}
			}
		} catch (Exception e) {
			logger.error("*****Unable to switch to new the window*****" + ", \n " + e.getMessage());
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: switchWindow Method
	 * Description: Method to switch windows in the browser using window name Input
	 * Parameters: WindowName(to be switched to) Return: Method does not return
	 * anything
	 */
	public static void switchWindow(String windowName) {

		String parentWindow = driver.getWindowHandle(), winTitle = null;
		try {

			for (String iWindow : driver.getWindowHandles()) {

				winTitle = driver.switchTo().window(iWindow).getTitle();
				if (winTitle.contains(windowName))
					break;
			}
			if (!winTitle.contains(windowName))
				driver.switchTo().window(parentWindow);
			else
				logger.error("*****Window " + windowName + " is not available*****");
		} catch (Exception e) {

			logger.error("*****Unable to switch to new the window*****" + ", \n " + e.getMessage());
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: switchToMainWindow Method
	 * Description: Method to switch to main window in the browser Input Parameters:
	 * Return: Method does not return anything
	 */
	public static void switchToMainWindow() {
		try {
			ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(windows.get(windows.size() - 1));
			for (int i = windows.size() - 1; i > 0; i--) {

				driver.close();
				driver.switchTo().window(windows.get(i - 1));
			}
		} catch (Exception e) {
			logger.error("*****Unable to switch to main window*****" + ", \n " + e.getMessage());
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: defaultFrame Method
	 * Description: Method to switch to default window in the browser Input
	 * Parameters: Return: Method does not return anything
	 */
	public static void defaultFrame() {
		try {
			driver.switchTo().defaultContent();
			logger.info("*****Switched to default window*****");
		} catch (Exception e) {
			logger.error("*****Unable to switch to default window*****" + ", \n " + e.getMessage());
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: switchTabs Method
	 * Description: Method to switch to other tab in browser Input Parameters:
	 * Return: Method does not return anything
	 */
	public String switchTabs() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		try {
			for (String winHandle : tabs) {

				winTitle = driver.switchTo().window(winHandle).getTitle();
				logger.info("*****Switched to tab*****" + winTitle);
			}
		} catch (Exception e) {
			logger.error("*****Tab is not available*****" + ", \n " + e.getMessage());
		}
		return winTitle;
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: defaultTab Method
	 * Description: Method to switch to default tab in browser Input Parameters:
	 * Return: Method does not return anything
	 */
	public static void defaultTab() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		try {
			driver.switchTo().window(tabs.get(0));
			logger.info("*****Switched to default tab*****");
		} catch (Exception e) {

			logger.error("*****Unable to switch to default tab*****" + ", \n " + e.getMessage());

		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: closeCurrentWindow Method
	 * Description: Method to close the current window Input Parameters: Return:
	 * Method does not return anything
	 */
	public void closeCurrentWindow() {

		driver.close();
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: scrollIntoView Method
	 * Description: Method to scroll through the web page Input Parameters:
	 * WebDriver Return: Method does not return anything
	 */
	public void scrollIntoView(WebDriver driver) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			logger.info("*****Page is scrolled*****");

		} catch (Exception e) {
			logger.error("*****Page can not be scrolled*****" + ", \n " + e.getMessage());
			e.printStackTrace();
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: getText Method
	 * Description: Method to get the text from a web element Input Parameters:
	 * WebElement Return: Method returns the text displayed on the web page for the
	 * given web element
	 */
	public String getText(WebElement object) {
		String objectText = null;
		try {
			objectText = object.getText();
		} catch (Exception e) {
			logger.error("*****Unable to get text*****" + ", \n " + e.getMessage());
		}
		return objectText;
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: toRefresh Method
	 * Description: Method to refresh the web page when the web element is displayed
	 * Input Parameters: WebElement Return: Method does not return anything
	 */
	public void toRefresh(WebElement element) {
		try {
			boolean elementIsDisplayed = element.isDisplayed();
			while (elementIsDisplayed == true) {
				driver.navigate().refresh();
				logger.info("****Page is refreshed*****");
				break;
			}
		} catch (Exception e) {
			logger.error("****Error is Not Displayed*****" + ", \n " + e.getMessage());
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: toRefreshWindow Method
	 * Description: Method to refresh the web page Input Parameters: Return: Method
	 * does not return anything
	 */
	public void toRefreshWindow() {
		try {
			driver.navigate().refresh();
			logger.info("****Page is refreshed*****");
		} catch (Exception e) {
			logger.error("****Page can not be refreshed*****" + ", \n " + e.getMessage());
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: sendKeys Method
	 * Description: Method to enter text in text box Input Parameters:
	 * WebElement(where data needs to be entered ), Data(which needs to entered in
	 * the text box) Return: Method does not return anything
	 */
	public void sendKeys(WebElement element, String inputData) {
		try {
			boolean elementIsDisplayed = element.isDisplayed();
			while (elementIsDisplayed == true) {
				element.sendKeys(inputData);
				logger.info("****Data is entered*****" + inputData);
				break;
			}
		} catch (Exception e) {
			logger.error("****Data is not entered*****" + ", \n " + e.getMessage());
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: switchToFrame Method
	 * Description: Method to switch to other frame based on frame type Input
	 * Parameters: FrameType, Frame, Wait time Return: Method does not return
	 * anything
	 */
	public void switchToFrame(String frameType, String frame, long timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		try {
			switch (frameType) {
			case "integerType":
				int index = Integer.parseInt(frame);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
				driver.switchTo().frame(index);
				break;
			case "stringType":
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
				driver.switchTo().frame(frame);
			}
		} catch (Exception e) {
			logger.error("****Unable to switch to frame*****" + ", \n " + e.getMessage());
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: parentFrame Method
	 * Description: Method to switch to the parent frame Input Parameters: Return:
	 * Method does not return anything
	 */
	public static void parentFrame() {
		try {
			driver.switchTo().parentFrame();
			logger.info("*****Switched to default frame*****");
		} catch (Exception e) {

			logger.error("*****Unable to switch to default frame*****" + ", \n " + e.getMessage());
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: quitBrowser Method
	 * Description: Method to close all the open browsers Input Parameters: Return:
	 * Method does not return anything
	 */
	public void quitBrowser() {
		try {
			driver.quit();
			logger.info("*****Quit the browser*****");
		} catch (Exception e) {

			logger.error("*****Unable to Quit the browser*****" + ", \n " + e.getMessage());
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: clickElements Method
	 * Description: Method to click multiple web elements Input Parameters: List
	 * containing web elements, wait time Return: Method does not return anything
	 */
	public static void clickElements(List<WebElement> elements, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		for (WebElement element : elements) {
			wait.until(ExpectedConditions.visibilityOf(element));
			try {
				boolean elementIsDisplayed = element.isDisplayed();
				while (elementIsDisplayed) {
					element.click();
					logger.info("*******Clicked on Button******" + element);
					break;
				}
			} catch (Exception e) {
				logger.error("****Element Not Displayed*****" + element + ", \n " + e.getMessage());
			}
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: Exist Method Description:
	 * Method to wait for visibility of web element using fluent wait Input
	 * Parameters: Web element, wait time Return: Method returns boolean value of
	 * true if the web element exists else false
	 */
	public boolean Exist(final WebElement element, Integer seconds) {
		try {
			Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(seconds))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
			fWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					if (element.isDisplayed()) {
						return element;
					} else {
						return null;
					}
				}
			});
			System.out.println("EXIST-->" + element);
			return true;
		} catch (Exception e) {
			System.out.println("NOT EXIST-->" + element);
			return false;
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: stringContainsIgnoreCase
	 * Method Description: Method to compare input strings Input Parameters:
	 * String1(to be compared with String2), String2 Return: Method returns boolean
	 * value of true if the first string contains string2 else false
	 */
	public static boolean stringContainsIgnoreCase(String str1, String str2) {

		if (str1.trim().toLowerCase().contains(str2.trim().toLowerCase())) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: enterTextForAuthorisation
	 * Method Description: Method to enter text in text box Input Parameters:
	 * WebElement(where data needs to be entered ), Data(which needs to entered in
	 * the text box) Return: Method does not return anything
	 */

	public String enterTextForAuthorisation(String inputData) {
		Base64.Decoder decoder = Base64.getMimeDecoder();
		String textString = new String(decoder.decode(inputData));
		return textString;
	}

}
