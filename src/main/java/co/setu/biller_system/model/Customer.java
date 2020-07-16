package co.setu.biller_system.model;

import java.util.Date;

public class Customer {
	private String customerName;
	private double dueAmount;
	private Date dueDate;
	private long mobileNumber;
	private String refID;
	private String ackID;
	private boolean isPaid;

	public Customer() {
		super();
	}

	public Customer(String customerName, double dueAmount, Date dueDate, long mobileNumber, String refID,
			boolean isPaid) {
		super();
		this.customerName = customerName;
		this.dueAmount = dueAmount;
		this.dueDate = dueDate;
		this.mobileNumber = mobileNumber;
		this.refID = refID;
		this.isPaid = isPaid;
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

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
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
		return "customer [customerName=" + customerName + ", dueAmount=" + dueAmount + ", dueDate=" + dueDate
				+ ", mobileNumber=" + mobileNumber + ", refID=" + refID + "]";
	}

}
