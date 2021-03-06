package co.setu.biller_system.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private String errorMessage;
	private String status;

	public ErrorMessage() {
		super();
	}

	public ErrorMessage(String errorMessage, String status) {
		super();
		this.errorMessage = errorMessage;
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String documentation) {
		this.status = documentation;
	}

}