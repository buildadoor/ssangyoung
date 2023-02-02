package a01_diexp.z01_vo;

import java.util.Map;

public class Monitor {
	private Map<String, Integer> config;
	public Monitor() {
	}
	public Monitor(Map<String, Integer> config) {
		this.config = config;
	}
	public Map<String, Integer> getConfig() {
		return config;
	}
	public void setConfig(Map<String, Integer> config) {
		this.config = config;
	}
	
}
