package org.domain.seambasic.api.infra.exceptionmappers;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.domain.seambasic.BasicException;
import org.domain.seambasic.api.infra.EnumMessageType;
import org.domain.seambasic.api.infra.ServiceMessage;
import org.domain.seambasic.api.infra.ServiceResponse;

@Provider
public class BasicExceptionMapper implements ExceptionMapper<BasicException> {

	@Context
	private HttpHeaders headers;

	public Response toResponse(final BasicException exception) {
		return Response
				.status(Status.BAD_REQUEST)
				.entity(new ServiceResponse<Object>(
						new ServiceMessage(EnumMessageType.ERROR, exception.getMessage()),
						Status.BAD_REQUEST))
				// FIXME: Remover queixo duro
				.header("Content-Type", "application/json;charset=UTF-8")
				.build();
		
//		ResponseBuilder rb = Response.status(Status.BAD_REQUEST).entity(
//				new ServiceResponse<Object>(
//						new ServiceMessage(EnumMessageType.ERROR, e.getMessage()),
//						Status.BAD_REQUEST));
//
//		List<MediaType> accepts = headers.getAcceptableMediaTypes();
//		if (accepts != null && accepts.size() > 0) {
//			MediaType m = accepts.get(0);
//			rb = rb.type(m);
//		} else {
//			rb = rb.type(headers.getMediaType());
//		}
//		return rb.build();
	}
}
