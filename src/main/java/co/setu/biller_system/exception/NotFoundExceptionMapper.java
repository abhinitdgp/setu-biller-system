package co.setu.biller_system.exception;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import co.setu.biller_system.model.ErrorMessage;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

	@Override
	public Response toResponse(NotFoundException exception) {
		ErrorMessage errMsg = new ErrorMessage("path-not-found", "ERROR");
		return Response.status(404).entity(errMsg).build();
	}

}
