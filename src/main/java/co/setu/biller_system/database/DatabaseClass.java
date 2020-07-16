package co.setu.biller_system.database;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import co.setu.biller_system.model.Customer;

public class DatabaseClass {

	private static Map<Long, Customer> bills = new ConcurrentHashMap<Long, Customer>();
	private static String api_key = "8034bc7a-df76-4f55-af31-71f61ff9b2a2";

//	public DatabaseClass() {
//		bills = new HashMap<String, Customer>();
//	}

	public static Map<Long, Customer> getBills() {
		return bills;
	}

	public static String getApiKey() {
		return api_key;
	}

}
