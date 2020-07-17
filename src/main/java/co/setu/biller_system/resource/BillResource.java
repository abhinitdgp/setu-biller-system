package co.setu.biller_system.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import co.setu.biller_system.constant.Statuses;
import co.setu.biller_system.database.DatabaseClass;
import co.setu.biller_system.model.*;
import co.setu.biller_system.service.BillService;

@Path("/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BillResource {

	static BillService billService = new BillService();

	@GET
	public String getJsonMessages() throws Exception {
		return "Biller System";
	}

	@Path("/fetch-bill")
	@POST
	public Response fetchBill(Customer customer, @HeaderParam("X-API-KEY") String api_key) {
		if (api_key == null || api_key.isEmpty() || !isValid(api_key)) {
			ErrorMessage errorMessage = new ErrorMessage("auth-error", Statuses.ERROR);
			return Response.status(403).entity(errorMessage).build();
		}
		if (customer == null || customer.getMobileNumber() == null || customer.getMobileNumber().isEmpty()) {
			ErrorMessage errorMsg = new ErrorMessage("invalid-api-parameters", Statuses.ERROR);
			return Response.status(400).entity(errorMsg).build();
		}

		ResponseMessage response = billService.fetchBill(Long.parseLong(customer.getMobileNumber()));
		if (response == null) {
			ErrorMessage errorMessage = new ErrorMessage("customer-not-found", "ERROR");
			return Response.status(404).entity(errorMessage).build();
		}
		return Response.status(Status.OK).entity(response).build();
	}

	@Path("/payment-update")
	@POST
	public Response updatePayment(PaymentRequest payReq, @HeaderParam("X-API-KEY") String api_key) {
		if (api_key == null || api_key.isEmpty() || !isValid(api_key)) {
			ErrorMessage errorMessage = new ErrorMessage("auth-error", Statuses.ERROR);
			return Response.status(403).entity(errorMessage).build();
		}
		if (payReq == null || payReq.getRefID().isEmpty()) {
			ErrorMessage errorMsg = new ErrorMessage("invalid-api-parameters", Statuses.ERROR);
			return Response.status(400).entity(errorMsg).build();
		}
//		ResponseMessage response = billService.updatePayment(payReq);
//		if (response == null) {
//			ErrorMessage errorMessage = new ErrorMessage("customer-not-found", "ERROR");
//			return Response.status(404).entity(errorMessage).build();
//		}
		// return Response.status(Status.OK).build();
		Response res = billService.updatePayment(payReq);
		return res;
	}

	private boolean isValid(String api_key) {
		String apiKey = DatabaseClass.getApiKey();
		if (api_key.equals(apiKey))
			return true;
		return false;
	}
}