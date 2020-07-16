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

import co.setu.biller_system.database.DatabaseClass;
import co.setu.biller_system.model.Customer;
import co.setu.biller_system.model.ErrorMessage;
import co.setu.biller_system.model.ResponseMessage;
import co.setu.biller_system.service.BillService;

@Path("/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BillResource {

	BillService billService = new BillService();

	@GET
	public String getJsonMessages() {
		return "Bill fetched";
	}

	@Path("/fetch-bill")
	@POST
	public Response fetchBill(Customer cust, @HeaderParam("X-API-KEY") String api_key) {
		if (api_key == null || api_key.isEmpty() || !isValid(api_key)) {
			ErrorMessage statusMessage = new ErrorMessage();
			statusMessage.setStatus("ERROR");
			statusMessage.setErrorMessage("auth-error");
			return Response.status(403).entity(statusMessage).build();
		}

		ResponseMessage res = billService.fetchBill(cust.getMobileNumber());
		return Response.status(Status.OK).entity(res).build();
	}

	@Path("/payment-update")
	@POST
	public Response updatePayment(String mobileNumber, @HeaderParam("X-API-KEY") String api_key) {
		if (api_key == null || api_key.isEmpty() || !isValid(api_key)) {
			ErrorMessage statusMessage = new ErrorMessage();
			statusMessage.setStatus("ERROR");
			statusMessage.setErrorMessage("auth-error");
			return Response.status(403).entity(statusMessage).build();
		}

		return Response.status(Status.OK).build();
	}

	private boolean isValid(String api_key) {
		String apiKey = DatabaseClass.getApiKey();
		if (api_key.equals(apiKey))
			return true;
		return false;
	}
}