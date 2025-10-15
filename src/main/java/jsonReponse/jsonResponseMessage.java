package jsonReponse;

import java.util.ArrayList;

public class jsonResponseMessage {

	public boolean error;
	public String langCode;
	public ArrayList<usage> usage;
	public String ai_system;
	public String ai_system_version;
	public query_processor query_processor;
	public ArrayList<output> output;
	public String session_id;
	public String workspace_id;
	public String message_id;
	public String data_id;
	public String timestamp_epoch;
	public timestamp timestamp;
	public double server_response_time_ms;

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public ArrayList<usage> getUsage() {
		return usage;
	}

	public void setUsage(ArrayList<usage> usage) {
		this.usage = usage;
	}

	public String getAi_system() {
		return ai_system;
	}

	public void setAi_system(String ai_system) {
		this.ai_system = ai_system;
	}

	public String getAi_system_version() {
		return ai_system_version;
	}

	public void setAi_system_version(String ai_system_version) {
		this.ai_system_version = ai_system_version;
	}

	public query_processor getQuery_processor() {
		return query_processor;
	}

	public void setQuery_processor(query_processor query_processor) {
		this.query_processor = query_processor;
	}

	public ArrayList<output> getOutput() {
		return output;
	}

	public void setOutput(ArrayList<output> output) {
		this.output = output;
	}

	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public String getWorkspace_id() {
		return workspace_id;
	}

	public void setWorkspace_id(String workspace_id) {
		this.workspace_id = workspace_id;
	}

	public String getMessage_id() {
		return message_id;
	}

	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}

	public String getData_id() {
		return data_id;
	}

	public void setData_id(String data_id) {
		this.data_id = data_id;
	}

	public String getTimestamp_epoch() {
		return timestamp_epoch;
	}

	public void setTimestamp_epoch(String timestamp_epoch) {
		this.timestamp_epoch = timestamp_epoch;
	}

	public timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public double getServer_response_time_ms() {
		return server_response_time_ms;
	}

	public void setServer_response_time_ms(double server_response_time_ms) {
		this.server_response_time_ms = server_response_time_ms;
	}

}
