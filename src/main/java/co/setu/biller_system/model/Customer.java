package co.setu.biller_system.model;

public class Customer {
	private String customerName;
	private String mobileNumber;
	private String refID;

	public Customer() {
		super();
	}

	public Customer(String customerName, String mobileNumber, String refID) {
		super();
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.refID = refID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

//	public double getDueAmount() {
//		return dueAmount;
//	}
//
//	public void setDueAmount(double dueAmount) {
//		this.dueAmount = dueAmount;
//	}
//
//	public String getDueDate() {
//		return dueDate;
//	}
//
//	public void setDueDate(String dueDate) {
//		this.dueDate = dueDate;
//	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {

		this.mobileNumber = mobileNumber;
	}

	public String getRefID() {
		return refID;
	}

	public void setRefID(String refID) {
		this.refID = refID;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", mobileNumber=" + mobileNumber + ", refID=" + refID + "]";
	}

}
