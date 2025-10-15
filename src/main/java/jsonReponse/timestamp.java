package jsonReponse;

public class timestamp {
	public String server_time;
	public String server_timezone;
	public float timestamp_epoch;
	public String getServer_time() {
		return server_time;
	}
	public void setServer_time(String server_time) {
		this.server_time = server_time;
	}
	public String getServer_timezone() {
		return server_timezone;
	}
	public void setServer_timezone(String server_timezone) {
		this.server_timezone = server_timezone;
	}
	public float getTimestamp_epoch() {
		return timestamp_epoch;
	}
	public void setTimestamp_epoch(float timestamp_epoch) {
		this.timestamp_epoch = timestamp_epoch;
	}

}
