package api.Automation;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import api.Utility.dataReaderUtils;
import api.Utility.dataWriteUtils;
import api.Utility.utilities;

public class apiExecutorForFAQ {

	public Workbook workbook;
	public Sheet sheet;
	public File excelFile;

	@BeforeSuite
	public void dataInitializing() throws IOException {
		// 1️⃣ Create or open Excel file & sheet
		String time = "Result" + utilities.currentDataTime().replaceAll("[:\\s]", "_") + ".xlsx";
		System.out.println("Time:" + time);
		excelFile = dataWriteUtils.createFile("E:\\Automation\\Automation\\testresult\\" + time + "");
		workbook = dataWriteUtils.createWorkbook(excelFile);
		sheet = dataWriteUtils.getOrCreateSheet(workbook, "TestResultFile");
		dataWriteUtils.excelTestResultFileHeader(sheet, "S.No", "Input", "Actual Intent", "Expected Intent",
				"Actual Response", "Expected Response", "Status");
	}

//	@Test
//	public void apiExecution() throws IOException {
//		for (Map.Entry<Integer, Map<String, String>> entry : dataReaderUtils.readExcelUtils().entrySet()) {
//			for (Map.Entry<String, String> entries : entry.getValue().entrySet()) {
//
//				System.out.println("****************Test Inprogress" + entry.getKey() + "*****************");
//				// 3️⃣ Call API
//				utilities.httpClientConnection(utilities.curlUrlConstruct(), "POST",
//						utilities.requestBodyConstructor(entries.getValue()));
//
//				// 4️⃣ Process JSON response and get row data
//				Object[] rowData = utilities.processingJsonResponse(entry.getKey());
//
//				// 5️⃣ Append row to Excel sheet
//				dataWriteUtils.appendTestResults(sheet, rowData);
//			}
//		}
//	}

	@Test
	public void apiExecution() throws IOException {
		int rowNumber;
		String ToRun = "";
		String Input = "";
		String Expected_Intent = "";
		String Expected_Response = "";
		for (Entry<Integer, Map<Map<String, String>, Map<String, String>>> entry : dataReaderUtils.readExcelUtils()
				.entrySet()) {
			rowNumber = entry.getKey();
			for (Map.Entry<Map<String, String>, Map<String, String>> entry1 : entry.getValue().entrySet()) {
				for (Map.Entry<String, String> entry2 : entry1.getKey().entrySet()) {
					ToRun = entry2.getKey();
					Input = entry2.getValue();
				}
				for (Map.Entry<String, String> entry3 : entry1.getValue().entrySet()) {
					Expected_Intent = entry3.getKey();
					Expected_Response = entry3.getValue();
				}
			}
			System.out.println("****************Test Inprogress" + rowNumber + "*****************");
			// 3️⃣ Call API
			utilities.httpClientConnection(utilities.curlUrlConstruct(), "POST",
					utilities.requestBodyConstructor(Input));

			// 4️⃣ Process JSON response and get row data
			Object[] rowData = utilities.processingJsonResponse(rowNumber, Expected_Intent, Expected_Response);

			// 5️⃣ Append row to Excel sheet
			dataWriteUtils.appendTestResults(sheet, rowData);
		}
	}

	@AfterSuite
	public void closingDataFile() throws IOException {
		// 6️⃣ Save Excel workbook
		dataWriteUtils.saveWorkbook(workbook, excelFile);
		System.out.println("✅ All test results written successfully to Excel.");
	}

}
