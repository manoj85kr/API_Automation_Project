package api.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataReaderUtils {

	public static FileInputStream createFile(String path) throws FileNotFoundException {
		File files = new File(path);
		FileInputStream file = new FileInputStream(files);
		return file;
	}

	public static Workbook createWorkbook(FileInputStream file) throws IOException {
		Workbook workbook = new XSSFWorkbook(file);
		return workbook;
	}

	public static Sheet getSheet(Workbook workbook) {
		Sheet sheet = workbook.getSheetAt(0);
		return sheet;
	}

	public static void workbookClose() throws FileNotFoundException, IOException {
		createWorkbook(createFile("E:\\Automation\\Automation\\src\\test\\resource\\DataFile.xlsx")).close();
		createFile("E:\\Automation\\Automation\\src\\test\\resource\\DataFile.xlsx").close();
	}

//	public static Map<Integer, Map<String, String>> readExcelUtils() throws IOException {
//		Map<Integer, Map<String, String>> dataMaps = new HashMap<>();
//		Workbook workbook = createWorkbook(
//				createFile("E:\\Automation\\Automation\\src\\test\\resource\\DataFile.xlsx"));
//		Sheet sheet = getSheet(workbook);
//		for (int i = 1; i <= sheet.getLastRowNum(); i++) { // skip header row
//			Row row = sheet.getRow(i);
//			if (row == null)
//				continue;
//			int serialNumber = (int) row.getCell(0).getNumericCellValue();
//			String key = row.getCell(1).getStringCellValue();
//			String value = row.getCell(2).getStringCellValue();
//			Map<String, String> dataMap = new HashMap<>();
//			dataMap.put(key, value);
//			dataMaps.put(serialNumber, dataMap);
//		}
//		workbook.close();
//		return dataMaps;
//	}

	public static Map<Integer, Map<Map<String, String>, Map<String, String>>> readExcelUtils() throws IOException {
		Map<Integer, Map<Map<String, String>, Map<String, String>>> returnValues = new HashMap<>();
		Map<Map<String, String>, Map<String, String>> dataMap = new HashMap<>();
		Map<String, String> data1 = new HashMap<>();
		Map<String, String> data2 = new HashMap<>();
		Workbook workbook = createWorkbook(
				createFile("E:\\Automation\\Automation\\src\\test\\resource\\DataFile.xlsx"));
		Sheet sheet = getSheet(workbook);
		for (int i = 1; i <= sheet.getLastRowNum(); i++) { // skip header row
			Row row = sheet.getRow(i);
			if (row == null)
				continue;
			int serialNumber = (int) row.getCell(0).getNumericCellValue();
			String ToRun = row.getCell(1).getStringCellValue();
			String Input = row.getCell(2).getStringCellValue();
			String Expected_Intent = row.getCell(3).getStringCellValue();
			String Expected_Response = row.getCell(4).getStringCellValue();
			data1.put(ToRun, Input);
			data2.put(Expected_Intent, Expected_Response);
			dataMap.put(data1, data2);
			returnValues.put(serialNumber, dataMap);
		}
		workbook.close();
		return returnValues;
	}

}
