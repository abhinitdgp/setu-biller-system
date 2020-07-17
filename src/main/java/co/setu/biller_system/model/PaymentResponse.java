package co.setu.biller_system.model;

public class PaymentResponse {
	private String ackId;

	public PaymentResponse() {
		super();
	}

	public PaymentResponse(String ackId) {
		super();
		this.ackId = ackId;
	}

	public String getAckId() {
		return ackId;
	}

	public void setAckId(String ackId) {
		this.ackId = ackId;
	}

}
