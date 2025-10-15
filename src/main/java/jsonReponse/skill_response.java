package jsonReponse;

import java.util.ArrayList;

public class skill_response {
	public String message;
	public journey_data journey_data;
	public boolean aiagent_conversation_timeout;
	public boolean human_agent_transfer;
	public boolean aiagent_skillobjective_completion;
	public ArrayList<Object> tool_details;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public journey_data getJourney_data() {
		return journey_data;
	}

	public void setJourney_data(journey_data journey_data) {
		this.journey_data = journey_data;
	}

	public boolean isAiagent_conversation_timeout() {
		return aiagent_conversation_timeout;
	}

	public void setAiagent_conversation_timeout(boolean aiagent_conversation_timeout) {
		this.aiagent_conversation_timeout = aiagent_conversation_timeout;
	}

	public boolean isHuman_agent_transfer() {
		return human_agent_transfer;
	}

	public void setHuman_agent_transfer(boolean human_agent_transfer) {
		this.human_agent_transfer = human_agent_transfer;
	}

	public boolean isAiagent_skillobjective_completion() {
		return aiagent_skillobjective_completion;
	}

	public void setAiagent_skillobjective_completion(boolean aiagent_skillobjective_completion) {
		this.aiagent_skillobjective_completion = aiagent_skillobjective_completion;
	}

	public ArrayList<Object> getTool_details() {
		return tool_details;
	}

	public void setTool_details(ArrayList<Object> tool_details) {
		this.tool_details = tool_details;
	}
}
