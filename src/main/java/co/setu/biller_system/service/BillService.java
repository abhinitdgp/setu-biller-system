package co.setu.biller_system.service;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import co.setu.biller_system.constant.APIStatus;
import co.setu.biller_system.constant.Statuses;
import co.setu.biller_system.database.DatabaseClass;
import co.setu.biller_system.model.*;

public class BillService {

	private Map<Long, Customer> customers = DatabaseClass.getCustomers();
	private Map<String, BillDetails> bills = DatabaseClass.getBills();
	private Map<String, Transaction> transactions = DatabaseClass.getTransactions();

	public BillService() {
		System.out.println("Bill Service created");
		createCustomersData();
		createBillingDetails();
		createTransactionDetails();
		// bills.put(9898000012L, new Customer("Ashok Kumar", 2000, "2020-06-05",
		// 9898000012L, "AX0812878", false));
	}

	private void createTransactionDetails() {
		// TODO Auto-generated method stub

	}

	private void createBillingDetails() {
		bills.put("AX0812878", new BillDetails(2000, "2020-06-05", "AX0812878"));
		bills.put("AX0812831", new BillDetails(3532, "2020-07-15", "AX0812831"));
		bills.put("AX0373873", new BillDetails(9824, "2020-10-08", "AX0373873"));
		bills.put("AX0299382", new BillDetails(1679, "2020-11-22", "AX0299382"));
		bills.put("AX0728945", new BillDetails(6523, "2020-08-11", "AX0728945"));
		bills.put("AX0126783", new BillDetails(7736, "2020-12-28", "AX0126783"));
	}

	private void createCustomersData() {
		customers.put(9898000012L, new Customer("Ashok Kumar", "9898000012", "AX0812878"));
		customers.put(9898623839L, new Customer("Abhishek", "9898623839", "AX0812831"));
		customers.put(8727743878L, new Customer("Aakash Singh", "8727743878", "AX0373873"));
		customers.put(6387337483L, new Customer("Manjunath", "6387337483", "AX0299382"));
		customers.put(9887726352L, new Customer("Aishwarya", "9887726352", "AX0728945"));
		customers.put(7846736436L, new Customer("Sourabh Verma", "7846736436", "AX0126783"));

	}

	public ResponseMessage fetchBill(Long mobileNumber) {
		if (customers.containsKey(mobileNumber)) {
			String refId = customers.get(mobileNumber).getRefID();
			FetchBillResponse response = new FetchBillResponse();
			response.setCustomerName(customers.get(mobileNumber).getCustomerName());
			response.setDueAmount(bills.get(refId).getDueAmount());
			response.setDueDate(bills.get(refId).getDueDate());
			response.setRefId(refId);
			ResponseMessage res = new ResponseMessage();
			res.setStatus(Statuses.SUCCESS);
			res.setData(response);
			return res;
		}
		return null;

	}

	public Response updatePayment(PaymentRequest payReq) {
		if (payReq != null) {
			String refId = payReq.getRefID();
			if (bills.containsKey(refId)) {
				BillDetails bill = bills.get(refId);
				if (bill != null && (bill.getAckId() == null || bill.getAckId().isEmpty())) {
					double paidAmount = payReq.getTransaction().getAmountPaid();
					if (bill.getDueAmount() == paidAmount) {
						String ackId = getAlphaNumericString();
						transactions.put(ackId, payReq.getTransaction());
						bill.setAckId(ackId);
						bill.setDueAmount(0);
						// bills.put(refId, bill);

						PaymentResponse payRes = new PaymentResponse(ackId);
						ResponseMessage res = new ResponseMessage();
						res.setStatus(Statuses.SUCCESS);
						res.setData(payRes);
						return Response.status(Status.OK).entity(res).build();
					} else {
						ErrorMessage errorMsg = new ErrorMessage("amount-mismatch", Statuses.ERROR);
						return Response.status(400).entity(errorMsg).build();
					}
				} else {
					String ackId = bill.getAckId();
					String transId = transactions.get(ackId).getId();
					if (!payReq.getTransaction().getId().equals(transId)) {
						ErrorMessage errorMsg = new ErrorMessage("invalid-ref-id", Statuses.ERROR);
						return Response.status(404).entity(errorMsg).build();
					} else {
						PaymentResponse payRes = new PaymentResponse(ackId);
						ResponseMessage res = new ResponseMessage();
						res.setStatus("SUCCESS");
						res.setData(payRes);
						return Response.status(Status.OK).entity(res).build();
					}
				}

			}
		}
		return Response.status(Status.OK).build();

	}

	private String getAlphaNumericString() {

		int uniqueId = (int) (System.currentTimeMillis() & 0xfffffff);
		String id = "AX" + uniqueId;
		return id.toString();
	}
}
