package co.setu.biller_system.model;

public class PaymentRequest {
	private String refID;
	Transaction TransactionObject;

	// Getter Methods

	public String getRefID() {
		return refID;
	}

	public Transaction getTransaction() {
		return TransactionObject;
	}

	// Setter Methods

	public void setRefID(String refID) {
		this.refID = refID;
	}

	public void setTransaction(Transaction transactionObject) {
		this.TransactionObject = transactionObject;
	}
}
