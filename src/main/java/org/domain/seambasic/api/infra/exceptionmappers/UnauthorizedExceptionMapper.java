package org.domain.seambasic.api.infra.exceptionmappers;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.spi.UnauthorizedException;

@Provider
@Produces("application/json; charset=UTF-8;")
public class UnauthorizedExceptionMapper implements
		ExceptionMapper<UnauthorizedException> {

	public Response toResponse(UnauthorizedException e) {
		return Response.status(Status.UNAUTHORIZED).entity(e).build();
	}

}