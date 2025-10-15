package api.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataWriteUtils {

	// ✅ Creates the file and parent directories if they don't exist
	public static File createFile(String path) throws IOException {
		File file = new File(path);
		file.getParentFile().mkdirs();
		if (!file.exists()) {
			file.createNewFile();
		}
		return file;
	}

	// ✅ Opens existing workbook or creates new one if file is empty
	public static Workbook createWorkbook(File file) throws IOException {
		if (file.length() == 0) {
			return new XSSFWorkbook(); // New workbook
		} else {
			try (FileInputStream fis = new FileInputStream(file)) {
				return new XSSFWorkbook(fis); // Existing workbook
			}
		}
	}

	// ✅ Create sheet or return existing one
	public static Sheet getOrCreateSheet(Workbook workbook, String sheetName) {
		Sheet sheet = workbook.getSheet(sheetName);
		if (sheet == null) {
			sheet = workbook.createSheet(sheetName);
		}
		return sheet;
	}

	// ✅ Create header row if sheet is empty
	public static void createHeaderIfEmpty(Sheet sheet) {
		if (sheet.getLastRowNum() == 0 && sheet.getPhysicalNumberOfRows() == 0) {
			Row headerRow = sheet.createRow(0);
			headerRow.createCell(0).setCellValue("S.No");
			headerRow.createCell(1).setCellValue("Input");
			headerRow.createCell(2).setCellValue("Intent");
			headerRow.createCell(3).setCellValue("Response");
		}
	}

	// ✅ Append a single test result row
	public static void excelTestResultFileHeader(Sheet sheet, String S_No, String Input, String Actual_Intent,
			String Expected_Intent, String Actual_Response, String Expected_Response, String Status) {
		int lastRow = sheet.getLastRowNum() + 1; // Next empty row
		Row row = sheet.createRow(lastRow);
		row.createCell(0).setCellValue(S_No);
		row.createCell(1).setCellValue(Input);
		row.createCell(2).setCellValue(Actual_Intent);
		row.createCell(3).setCellValue(Expected_Intent);
		row.createCell(4).setCellValue(Actual_Response);
		row.createCell(5).setCellValue(Expected_Response);
		row.createCell(6).setCellValue(Status);
	}

	public static void appendTestResults(Sheet sheet, Object[] rowData) {
		int lastRow = sheet.getLastRowNum() + 1; // Next empty row
		Row row = sheet.createRow(lastRow);
		for (int i = 0; i < rowData.length; i++) {
			if (rowData[i] != null) {
				row.createCell(i).setCellValue(rowData[i].toString());
			} else {
				row.createCell(i).setCellValue(""); // write empty string if null
			}
		}
	}

	// ✅ Save workbook back to file
	public static void saveWorkbook(Workbook workbook, File file) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(file)) {
			workbook.write(fos);
		}
		workbook.close();
	}

	// ✅ Main method to write sample data
	public static void writeDataInTheExcel() throws IOException {
		File file = createFile("E:\\Automation\\Automation\\testresult\\Result.xlsx");
		Workbook workbook = createWorkbook(file);
		Sheet sheet = getOrCreateSheet(workbook, "TestResultFile");
		createHeaderIfEmpty(sheet);
		// Example: Append new test result
		// appendTestResult(sheet, sheet.getLastRowNum(), "Hello", "GreetingIntent", "Hi
		// there!");
		saveWorkbook(workbook, file);
		System.out.println("✅ Excel file updated successfully at: " + file.getAbsolutePath());
	}

	// ✅ Optional: Read data as 2D Object array
	public static Object[][] readInputData(Sheet sheet) {
		int rows = sheet.getLastRowNum();
		int columns = sheet.getRow(0).getLastCellNum();
		Object[][] setData = new Object[rows][columns];

		for (int i = 1; i <= rows; i++) { // Start from 1 to skip header
			for (int j = 0; j < columns; j++) {
				setData[i - 1][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return setData;
	}
}
