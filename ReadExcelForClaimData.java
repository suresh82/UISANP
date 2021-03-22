package com.cigna.claimsanpuiautomaiton.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.cigna.claimsanpuiautomaiton.enums.GeneralUtilitiesEnum;
import com.cigna.claimsanpuiautomaiton.reporterutilities.ExtentReportListner;
import com.cigna.claimsanpuiautomaiton.utilities.PropertiesFileReader;

/**
 * @author M20589
 * ReadExcelForClaimData class contains the methods for reading input claim data from excel
 */
public class ReadExcelForClaimData extends ExtentReportListner {
	
	public static PropertiesFileReader obj = new PropertiesFileReader();
	XSSFSheet sheet;
	int noOfColumns;
	int rows;

	//Constructor
	@SuppressWarnings({ })
	public ReadExcelForClaimData() {
		try {
			String claimDataFilePath = properties.getProperty("CLAIM_Data_File_PATH");
			FileInputStream file = new FileInputStream(claimDataFilePath); 
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheetAt(0);
			noOfColumns = sheet.getRow(0).getLastCellNum();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	ArrayList<String> claimDataList;
	ArrayList<String> claimLineList;

	/**
	 * @author M20589
	 * claimData() Method reads the claim data against row count from excel
	 * @param rowCnt
	 * @return ArrayList<String>
	 */
	public ArrayList<String> claimData(int rowCnt){

		claimDataList = new ArrayList<String>();
		String temp=null;
		rows=rowCnt;

		for (int col=0;col<5;col++) {
			temp=sheet.getRow(rows).getCell(col).getStringCellValue();
			claimDataList.add(temp);
		}

		return claimDataList;

	}


	/**
	 * @author M20589
	 * claimLineData() method reads the claim line level data from claim data excel sheet
	 * @return ArrayList<String>
	 * @throws IOException
	 * @return ArrayList<String>
	 */
	public ArrayList<String> claimLineData() throws IOException {

		claimLineList = new ArrayList<String>();

		String clmLineDetails=null;

		for (int col=4;col<noOfColumns;col++) {

			clmLineDetails = sheet.getRow(rows).getCell(col).getStringCellValue();
			if(!clmLineDetails.equalsIgnoreCase(GeneralUtilitiesEnum.valueOf("STRING_NA").getGeneralUtilities()))
				claimLineList.add(clmLineDetails);
			else {
				break;
			}

		}
		return claimLineList;

	}


}
