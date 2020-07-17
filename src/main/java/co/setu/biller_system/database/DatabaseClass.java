package co.setu.biller_system.database;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import co.setu.biller_system.model.*;

public class DatabaseClass {
	private static Map<Long, Customer> customers = new ConcurrentHashMap<Long, Customer>();
	private static Map<String, BillDetails> bills = new ConcurrentHashMap<String, BillDetails>();
	private static Map<String, Transaction> transactions = new ConcurrentHashMap<String, Transaction>();
	private static String api_key = "8034bc7a-df76-4f55-af31-71f61ff9b2a2";


	public static Map<Long, Customer> getCustomers() {
		return customers;
	}

	public static Map<String, BillDetails> getBills() {
		return bills;
	}

	public static Map<String, Transaction> getTransactions() {
		return transactions;
	}

	public static String getApiKey() {
		return api_key;
	}

}
