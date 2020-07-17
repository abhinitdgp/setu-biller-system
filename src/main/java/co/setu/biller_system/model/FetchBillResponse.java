package co.setu.biller_system.model;

public class FetchBillResponse {
	private String customerName;
	private double dueAmount;
	private String dueDate;
	private String refId;

	public FetchBillResponse() {
		super();
	}

	public FetchBillResponse(String customerName, double dueAmount, String dueDate, String refId) {
		super();
		this.customerName = customerName;
		this.dueAmount = dueAmount;
		this.dueDate = dueDate;
		this.refId = refId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	@Override
	public String toString() {
		return "FetchBillResponse [customerName=" + customerName + ", dueAmount=" + dueAmount + ", dueDate=" + dueDate
				+ ", refId=" + refId + "]";
	}

}
