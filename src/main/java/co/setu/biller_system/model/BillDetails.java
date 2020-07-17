package co.setu.biller_system.model;

public class BillDetails {
	private double dueAmount;
	private String dueDate;
	private String refId;
	private String ackId;

	public BillDetails() {
		super();
	}

	public BillDetails(double dueAmount, String dueDate, String refId) {
		super();
		this.dueAmount = dueAmount;
		this.dueDate = dueDate;
		this.refId = refId;
	}

	public double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getAckId() {
		return ackId;
	}

	public void setAckId(String ackId) {
		this.ackId = ackId;
	}

	@Override
	public String toString() {
		return "BillDetails [dueAmount=" + dueAmount + ", dueDate=" + dueDate + ", refId=" + refId + ", ackId=" + ackId
				+ "]";
	}

}
