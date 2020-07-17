package co.setu.biller_system.model;

public class Transaction {
	private String amountPaid;
	private String date;
	private String id;

	public Transaction() {
		super();
	}

	public Transaction(String amountPaid, String date, String id) {
		super();
		this.amountPaid = amountPaid;
		this.date = date;
		this.id = id;
	}

	// Getter Methods

	public String getAmountPaid() {
		return amountPaid;
	}

	public String getDate() {
		return date;
	}

	public String getId() {
		return id;
	}

	// Setter Methods

	public void setAmountPaid(String amountPaid) {
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
