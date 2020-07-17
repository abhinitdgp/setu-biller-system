package co.setu.biller_system.model;

public class Transaction {
	private double amountPaid;
	private String date;
	private String id;

	public Transaction() {
		super();
	}

	public Transaction(double amountPaid, String date, String id) {
		super();
		this.amountPaid = amountPaid;
		this.date = date;
		this.id = id;
	}

	// Getter Methods

	public double getAmountPaid() {
		return amountPaid;
	}

	public String getDate() {
		return date;
	}

	public String getId() {
		return id;
	}

	// Setter Methods

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Transaction [amountPaid=" + amountPaid + ", date=" + date + ", id=" + id + "]";
	}

}
