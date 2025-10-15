package api.Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Time;
import java.util.Date;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import configManager.configurationManager;
import jsonReponse.jsonResponseMessage;

public class utilities {

	static ObjectMapper jsonMap = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
			false);
	public static String jsonResponseFromAPI = "";

	public static String curlUrlConstruct() {
		StringBuilder urlString = new StringBuilder();
		urlString.append(configurationManager.pro.get("protocol")).append(configurationManager.pro.get("domain_name"))
				.append(configurationManager.pro.get("path_version")).append(configurationManager.pro.get("app_id"))
				.append(configurationManager.pro.get("path_workspace"))
				.append(configurationManager.pro.get("workspace_id")).append(configurationManager.pro.get("path_End"));
		return urlString.toString();
	}

	public static String requestBodyConstructor(String inputValue) {
		JSONObject json = new JSONObject();
		json.put("input", inputValue);
		json.put("lang", "en");
		return json.toString();
	}

	public static void httpClientConnection(String urls, String Method, String body) throws IOException {
		URL url = new URL(urls);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(Method);
		conn.setRequestProperty("accept", "application/json");
		conn.setRequestProperty("accept-language", "en-IN,en-GB;q=0.9,en-US;q=0.8,en;q=0.7");
		conn.setRequestProperty("api-key", configurationManager.pro.getProperty("api_key"));
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Host", configurationManager.pro.getProperty("host"));
		conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
		conn.setRequestProperty("Connection", "keep-alive");
		conn.setRequestProperty("Content-Length", "86");
		conn.setDoOutput(true);
		try (OutputStream os = conn.getOutputStream()) {
			byte[] input = body.getBytes("utf-8");
			os.write(input, 0, input.length);
		}
		int responseCode = conn.getResponseCode();
		System.out.println("Response Code: " + responseCode);
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
		StringBuilder response = new StringBuilder();
		String responseLine;
		while ((responseLine = br.readLine()) != null) {
			response.append(responseLine.trim());
		}
		// System.out.println("Response: " + response.toString());
		conn.disconnect();
		jsonResponseFromAPI = response.toString();
	}

	public static Object[] processingJsonResponse(Integer rowNumber, String Expected_intent, String Expected_Response)
			throws JsonMappingException, JsonProcessingException {

		// Parse JSON response
		jsonResponseMessage jsonrsp = jsonMap.readValue(jsonResponseFromAPI, jsonResponseMessage.class);
		String input = jsonrsp.getQuery_processor().getInput();
		String Actual_intent = jsonrsp.getOutput().get(0).getAll_intents().get(0).name;
		String Actual_response = jsonrsp.getOutput().get(0).getFaq_response().get(0).getMessage();
		String Status = "";
		if (Actual_intent.equalsIgnoreCase(Expected_intent)) {
			Status = "Pass";
		} else {
			Status = "Fail";
		}
		// Return as a single row (1D array)
		Object[] rowData = new Object[7];
		rowData[0] = rowNumber;
		rowData[1] = input;
		rowData[2] = Actual_intent;
		rowData[3] = Expected_intent;
		rowData[4] = Actual_response;
		rowData[5] = Expected_Response;
		rowData[6] = Status;
		return rowData;
	}

	public static String currentDataTime() {
		Date date = new Date();
		Time time = new Time(System.currentTimeMillis());
		return time.toString();
	}

}
