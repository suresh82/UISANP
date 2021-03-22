package com.cigna.claimsanpuiautomaiton.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import com.cigna.claimsanpuiautomaiton.enums.GeneralUtilitiesEnum;
import com.cigna.claimsanpuiautomaiton.reporterutilities.ExtentReportListner;


/*Created by: Rakhi Bisht 
Created date: November 2019
Class Name: ZipCucumberHTMLReportsUtil
Class Description: This class includes methods to perform operations on the cucumber return generated
*/
public class ZipCucumberHTMLReportsUtil extends ExtentReportListner {

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: zipFiles Method
	 * Description: Method to zip all files and folders Input Parameters: Source and
	 * destination folders Return: Method returns a boolean value of true of the
	 * report is successfully zipped and moved to destination folder from source
	 * folder
	 */
	@SuppressWarnings("finally")
	public boolean zipFiles(String srcFolder, String destZipFile) {
		boolean result = false;
		try {
			logger.info("Program Start zipping the given files");
			zipFolder(srcFolder, destZipFile);
			result = true;
			logger.info("Given files are successfully zipped");
		} catch (Exception e) {
			logger.info("Some Errors happned during the zip process");
		} finally {
			return result;
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: zipFolder Method
	 * Description: Method to zip given source folder and place in the given
	 * destination path Input Parameters: Source folder,destination zipped file
	 * Return: Method does not return anything
	 */
	private void zipFolder(String srcFolder, String destZipFile) throws Exception {
		ZipOutputStream zip = null;
		FileOutputStream fileWriter = null;
		/*
		 * create the output stream to zip file result
		 */
		fileWriter = new FileOutputStream(destZipFile);
		zip = new ZipOutputStream(fileWriter);
		/*
		 * add the folder to the zip
		 */
		addFolderToZip("", srcFolder, zip);
		/*
		 * close the zip objects
		 */
		zip.flush();
		zip.close();
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: addFileToZip Method
	 * Description: Method to recursively add files to the zip files Input
	 * Parameters: Path,Source file,zipped output, Flag Return: Method does not
	 * return anything
	 */
	private void addFileToZip(String path, String srcFile, ZipOutputStream zip, boolean flag) throws Exception {
		/*
		 * create the file object for inputs
		 */
		File folder = new File(srcFile);

		/*
		 * if the folder is empty add empty folder to the Zip file
		 */
		if (flag == true) {
			zip.putNextEntry(new ZipEntry(path + GeneralUtilitiesEnum.valueOf("STRING_BACKSLASH").getGeneralUtilities()
					+ folder.getName() + GeneralUtilitiesEnum.valueOf("STRING_BACKSLASH").getGeneralUtilities()));
		} else { /*
					 * if the current name is directory, recursively traverse it to get the files
					 */
			if (folder.isDirectory()) {
				/*
				 * if folder is not empty
				 */
				addFolderToZip(path, srcFile, zip);
			} else {
				/*
				 * write the file to the output
				 */
				byte[] buf = new byte[1024];
				int len;
				@SuppressWarnings("resource")
				FileInputStream in = new FileInputStream(srcFile);
				zip.putNextEntry(new ZipEntry(path
						+ GeneralUtilitiesEnum.valueOf("STRING_BACKSLASH").getGeneralUtilities() + folder.getName()));
				while ((len = in.read(buf)) > 0) {
					/*
					 * Write the Result
					 */
					zip.write(buf, 0, len);
				}
			}
		}
	}

	/*
	 * Created by: Rakhi Bisht Created date: Method Name: addFolderToZip Method
	 * Description: Method to add folder to the zip file Input Parameters:
	 * Path,Source folder,zipped output Return: Method does not return anything
	 */
	private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip) throws Exception {
		File folder = new File(srcFolder);

		/*
		 * check the empty folder
		 */
		if (folder.list().length == 0) {
			logger.info(folder.getName());
			addFileToZip(path, srcFolder, zip, true);
		} else {
			/*
			 * list the files in the folder
			 */
			for (String fileName : folder.list()) {
				if (path.equals("")) {
					addFileToZip(
							folder.getName(), srcFolder
									+ GeneralUtilitiesEnum.valueOf("STRING_BACKSLASH").getGeneralUtilities() + fileName,
							zip, false);
				} else {
					addFileToZip(
							path + GeneralUtilitiesEnum.valueOf("STRING_BACKSLASH").getGeneralUtilities()
									+ folder.getName(),
							srcFolder + GeneralUtilitiesEnum.valueOf("STRING_BACKSLASH").getGeneralUtilities()
									+ fileName,
							zip, false);
				}
			}
		}
	}
}
