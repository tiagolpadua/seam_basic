package org.domain.seambasic.api.infra.exceptionmappers;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;

import org.domain.seambasic.api.infra.EnumMessageType;
import org.domain.seambasic.api.infra.ServiceMessage;
import org.domain.seambasic.api.infra.ServiceResponse;

@Provider
@Produces("application/json; charset=UTF-8;")
public class RuntimeExceptionMapper implements
		ExceptionMapper<RuntimeException> {

	private @Context
	Providers providers;

	@SuppressWarnings("unchecked")
	public Response toResponse(RuntimeException exception) {
		if (exception.getCause() == null) {
			return Response
					.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new ServiceResponse<Object>(
							new ServiceMessage(EnumMessageType.ERROR, exception.getMessage()),
							Status.INTERNAL_SERVER_ERROR))
					// FIXME: Remover queixo duro
					.header("Content-Type", "application/json;charset=UTF-8")
					.build();
		}
		@SuppressWarnings("rawtypes")
		Class cause = exception.getCause().getClass();

		@SuppressWarnings("rawtypes")
		ExceptionMapper mapper = null;
		try {
			mapper = providers.getExceptionMapper(cause);
		} catch (Exception e) {
			System.out.println(e);
		}

		if (mapper == null) {
			return Response.serverError().build();
		} else {
			return mapper.toResponse(exception.getCause());
		}
	}

}