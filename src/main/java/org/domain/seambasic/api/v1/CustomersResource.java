package org.domain.seambasic.api.v1;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

@Name("customersResource")
@Path("/customers")
public class CustomersResource {
	
	@In(create=true)
	CustomerDAO customerDAO;
	
	@GET
	@Path("/{customerId}")
	@Produces("application/json; charset=UTF-8;")
	public List<Customer> getCustomer(@PathParam("customerId") int id) {
		return customerDAO.getCustomers();
	}

}