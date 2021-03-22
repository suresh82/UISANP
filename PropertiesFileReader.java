package com.cigna.claimsanpuiautomaiton.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import com.cigna.claimsanpuiautomaiton.enums.GeneralUtilitiesEnum;

/*Created by: Rajalakshmi Ramesh 
Created date: November 2019
Class Name: PropertiesFileReader
Class Description: This class includes methods to perform settings for the properties file to define input values
*/
public class PropertiesFileReader {

	/*
	 * Created by: Rajalakshmi Ramesh Created date: Method Name: getProperty Method
	 * Description: Method to define properties of input stream Return: Properties
	 * Input Parameters: Return: Method returns the corresponding properties from
	 * the file
	 */
	@SuppressWarnings("unused")
	public Properties getProperty() throws IOException {
		FileInputStream inputStream = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(GeneralUtilitiesEnum.valueOf("PROPERTY_FILE_PATH").getGeneralUtilities()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

	/*
	 * Created by: Rajalakshmi Ramesh Created date: Method Name: getProperty Method
	 * Description: Method to define details of input stream using input
	 * attribute(File Type) Input Parameters: Filetype Return: Method returns the
	 * corresponding properties from the file based on input filetype
	 */
	public Properties getProperty(String strFileType) throws IOException {

		Properties prop = new Properties();
		try {
			if (strFileType == GeneralUtilitiesEnum.valueOf("STRING_FILETYPEPREREQ").getGeneralUtilities()) {
				prop.load(
						new FileInputStream(GeneralUtilitiesEnum.valueOf("PROPERTY_FILE_PATH").getGeneralUtilities()));
			} else if (strFileType == GeneralUtilitiesEnum.valueOf("STRING_FILETYPECONFIG").getGeneralUtilities()) {
				prop.load(new FileInputStream(
						GeneralUtilitiesEnum.valueOf("CONFIGPROPERTY_FILE_PATH").getGeneralUtilities()));
			} else if (strFileType == GeneralUtilitiesEnum.valueOf("STRING_FILETYPELOG").getGeneralUtilities()) {
				prop.load(new FileInputStream(
						GeneralUtilitiesEnum.valueOf("LOGPROPERTY_FILE_PATH").getGeneralUtilities()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
