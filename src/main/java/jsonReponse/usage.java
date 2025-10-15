package jsonReponse;

public class usage {

	public String model;
	public int total_tokens;
	public int prompt_tokens;
	public int completion_tokens;
	public String task_name;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getTotal_tokens() {
		return total_tokens;
	}

	public void setTotal_tokens(int total_tokens) {
		this.total_tokens = total_tokens;
	}

	public int getPrompt_tokens() {
		return prompt_tokens;
	}

	public void setPrompt_tokens(int prompt_tokens) {
		this.prompt_tokens = prompt_tokens;
	}

	public int getCompletion_tokens() {
		return completion_tokens;
	}

	public void setCompletion_tokens(int completion_tokens) {
		this.completion_tokens = completion_tokens;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
}
