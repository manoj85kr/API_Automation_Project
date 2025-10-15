package jsonReponse;

public class all_intents {
	public String name;
	public Object confidence;
	public Object sub_intent;
	public Object match_text;
	public Object override;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getConfidence() {
		return confidence;
	}

	public void setConfidence(Object confidence) {
		this.confidence = confidence;
	}

	public Object getSub_intent() {
		return sub_intent;
	}

	public void setSub_intent(Object sub_intent) {
		this.sub_intent = sub_intent;
	}

	public Object getMatch_text() {
		return match_text;
	}

	public void setMatch_text(Object match_text) {
		this.match_text = match_text;
	}

	public Object getOverride() {
		return override;
	}

	public void setOverride(Object override) {
		this.override = override;
	}

}
