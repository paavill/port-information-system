package ru.rsreu.RonzhinChistyakov09;

public class Port {
	
	private String portName;
	private Integer piarCount;
	private Integer freePiarCount;
	private Integer pilotCount;
	private Integer freePilotCount;

	public Port(String portName, Integer piarCount, Integer freePiarCount, Integer pilotCount, Integer freePilotCount) {
		super();
		this.portName = portName;
		this.piarCount = piarCount;
		this.freePiarCount = freePiarCount;
		this.pilotCount = pilotCount;
		this.freePilotCount = freePilotCount;
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

	public Integer getPilotCount() {
		return pilotCount;
	}

	public void setPilotCount(Integer pilotCount) {
		this.pilotCount = pilotCount;
	}

	public Integer getFreePilotCount() {
		return freePilotCount;
	}

	public void setFreePilotCount(Integer freePilotCount) {
		this.freePilotCount = freePilotCount;
	}
	
}
