package api.Automation;

import java.io.File;
import java.io.IOException;
import java.util.Map;

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

public class apiExecutor {

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
		dataWriteUtils.appendTestResult(sheet);
	}

	@Test
	public void apiExecution() throws IOException {
		for (Map.Entry<Integer, Map<String, String>> entry : dataReaderUtils.readExcelUtils().entrySet()) {
			for (Map.Entry<String, String> entries : entry.getValue().entrySet()) {

				// 3️⃣ Call API
				utilities.httpClientConnection(utilities.curlUrlConstruct(), "POST",
						utilities.requestBodyConstructor(entries.getValue()));

				// 4️⃣ Process JSON response and get row data
				Object[] rowData = utilities.processingJsonResponse(entry.getKey());

				// 5️⃣ Append row to Excel sheet
				dataWriteUtils.appendTestResults(sheet, rowData);
			}
		}
	}

	@AfterSuite
	public void closingDataFile() throws IOException {
		// 6️⃣ Save Excel workbook
		dataWriteUtils.saveWorkbook(workbook, excelFile);
		System.out.println("✅ All test results written successfully to Excel.");
	}

}
