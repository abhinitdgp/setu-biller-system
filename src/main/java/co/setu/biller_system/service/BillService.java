package co.setu.biller_system.service;

import java.util.Map;

import co.setu.biller_system.database.DatabaseClass;
import co.setu.biller_system.model.Customer;
import co.setu.biller_system.model.ResponseMessage;

public class BillService {

	private Map<Long, Customer> bills = DatabaseClass.getBills();

	public BillService() {
		bills.put(9898000012L, new Customer("Ashok Kumar", 2000, "2020-06-05", 9898000012L, "AX0812878", false));
	}

	public ResponseMessage fetchBill(Long mobileNumber) {
		if (bills.containsKey(mobileNumber)) {
			ResponseMessage res = new ResponseMessage();
			res.setStatus("SUCCESS");
			res.setData(bills.get(mobileNumber));
			return res;
		}
		return null;

	}
}
