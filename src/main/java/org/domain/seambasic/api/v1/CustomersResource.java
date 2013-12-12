package org.domain.seambasic.api.v1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Name("customersResource")
@Scope(ScopeType.PAGE)
@Path("/customers")
public class CustomersResource {
	
	private String nome = "teste123";

	@GET
	@Path("/{customerId}")
	@Produces("text/plain")
	public String getCustomer(@PathParam("customerId") int id) {
		return "teste: " + id;
	}
	
	@GET
	@Path("/nome")
	@Produces("text/plain")
	public String getNomeRest() {
		return getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}