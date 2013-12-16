package org.domain.seambasic.api.v1;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.domain.seambasic.BasicException;
import org.domain.seambasic.api.infra.ServiceResponse;
import org.domain.seambasic.customer.Customer;
import org.domain.seambasic.customer.CustomerDAO;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

@Name("customersResource")
@Path("/customers")
public class CustomersResource {
	
	@In(create=true)
	CustomerDAO customerDAO;
	
//	FIXME: Permitir o retorno de xml e json
	
	@GET
	@Path("/{customerId}")
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces("application/json; charset=UTF-8;")
	public ServiceResponse<Customer> getCustomer(@PathParam("customerId") int id) throws BasicException {
		return new ServiceResponse<Customer>(customerDAO.getCustomer(id));
	}
	
	@GET
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces("application/json; charset=UTF-8;")
	public ServiceResponse<List<Customer>> getCustomers() throws BasicException {
		return new ServiceResponse<List<Customer>>(customerDAO.getCustomers());
	}
}