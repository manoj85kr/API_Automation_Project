package jsonReponse;

import java.util.ArrayList;

public class faq_response {
	public String message;
	public float confidence;
	public ArrayList<String> context_urls;
	public faq_context faq_context;
	public ArrayList<String> categories;
	public additional_response_data additional_response_data;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public float getConfidence() {
		return confidence;
	}

	public void setConfidence(float confidence) {
		this.confidence = confidence;
	}

	public ArrayList<String> getContext_urls() {
		return context_urls;
	}

	public void setContext_urls(ArrayList<String> context_urls) {
		this.context_urls = context_urls;
	}

	public faq_context getFaq_context() {
		return faq_context;
	}

	public void setFaq_context(faq_context faq_context) {
		this.faq_context = faq_context;
	}

	public ArrayList<String> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<String> categories) {
		this.categories = categories;
	}

	public additional_response_data getAdditional_response_data() {
		return additional_response_data;
	}

	public void setAdditional_response_data(additional_response_data additional_response_data) {
		this.additional_response_data = additional_response_data;
	}
}
