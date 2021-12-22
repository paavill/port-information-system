package ru.rsreu.RonzhinChistyakov09.datalayer.data;

public class Port {
	
	private String portName;
	private Integer piarCount;
	private Integer freePiarCount;

	public Port(String portName, Integer piarCount, Integer freePiarCount) {
		super();
		this.portName = portName;
		this.piarCount = piarCount;
		this.freePiarCount = freePiarCount;
	}

	public String getPortName() {
		return portName;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}

	public Integer getPiarCount() {
		return piarCount;
	}

	public void setPiarCount(Integer piarCount) {
		this.piarCount = piarCount;
	}

	public Integer getFreePiarCount() {
		return freePiarCount;
	}

	public void setFreePiarCount(Integer freePiarCount) {
		this.freePiarCount = freePiarCount;
	}
}
