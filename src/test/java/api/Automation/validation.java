package api.Automation;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import api.Utility.dataReaderUtils;
import api.Utility.dataWriteUtils;
import api.Utility.utilities;

public class validation {

	public static void main(String[] args) throws IOException {

		// 1️⃣ Create or open Excel file & sheet
		File excelFile = dataWriteUtils.createFile("E:\\Automation\\Automation\\testresult\\Result.xlsx");
		Workbook workbook = dataWriteUtils.createWorkbook(excelFile);
		Sheet sheet = dataWriteUtils.getOrCreateSheet(workbook, "TestResultFile");
		dataWriteUtils.createHeaderIfEmpty(sheet);

		// 2️⃣ Loop over your input data from Excel
		for (Map.Entry<Integer, Map<String, String>> entry : dataReaderUtils.readExcelUtils().entrySet()) {
			for (Map.Entry<String, String> entries : entry.getValue().entrySet()) {

				// 3️⃣ Call API
				utilities.httpClientConnection(utilities.curlUrlConstruct(), "POST",
						utilities.requestBodyConstructor(entries.getValue()));

				// 4️⃣ Process JSON response and get row data
				Object[] rowData = utilities.processingJsonResponse(entry.getKey());

				dataWriteUtils.appendTestResult(sheet);
				// 5️⃣ Append row to Excel sheet
				dataWriteUtils.appendTestResults(sheet, rowData);
			}
		}

		// 6️⃣ Save Excel workbook
		dataWriteUtils.saveWorkbook(workbook, excelFile);
		System.out.println("✅ All test results written successfully to Excel.");
	}

}
