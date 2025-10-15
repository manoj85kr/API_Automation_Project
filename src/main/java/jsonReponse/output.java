package jsonReponse;

import java.util.ArrayList;

public class output {
	public String query;
	public top_intent top_intent;
	public ArrayList<all_intents> all_intents;
	public ArrayList<faq_response> faq_response;
	public ArrayList<Object> change_log;
	public ArrayList<Object> entities;
	public boolean context_changed;
	public boolean unanswered;
	public ArrayList<Object> debug_logs;
	public skill_response skill_response;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public top_intent getTop_intent() {
		return top_intent;
	}

	public void setTop_intent(top_intent top_intent) {
		this.top_intent = top_intent;
	}

	public ArrayList<all_intents> getAll_intents() {
		return all_intents;
	}

	public void setAll_intents(ArrayList<all_intents> all_intents) {
		this.all_intents = all_intents;
	}

	public ArrayList<faq_response> getFaq_response() {
		return faq_response;
	}

	public void setFaq_response(ArrayList<faq_response> faq_response) {
		this.faq_response = faq_response;
	}

	public ArrayList<Object> getChange_log() {
		return change_log;
	}

	public void setChange_log(ArrayList<Object> change_log) {
		this.change_log = change_log;
	}

	public ArrayList<Object> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Object> entities) {
		this.entities = entities;
	}

	public boolean isContext_changed() {
		return context_changed;
	}

	public void setContext_changed(boolean context_changed) {
		this.context_changed = context_changed;
	}

	public boolean isUnanswered() {
		return unanswered;
	}

	public void setUnanswered(boolean unanswered) {
		this.unanswered = unanswered;
	}

	public ArrayList<Object> getDebug_logs() {
		return debug_logs;
	}

	public void setDebug_logs(ArrayList<Object> debug_logs) {
		this.debug_logs = debug_logs;
	}

	public skill_response getSkill_response() {
		return skill_response;
	}

	public void setSkill_response(skill_response skill_response) {
		this.skill_response = skill_response;
	}
}
