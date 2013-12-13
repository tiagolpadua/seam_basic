package org.domain.seambasic.api.v1;

import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Name("customerDAO")
@Scope(ScopeType.APPLICATION)
public class CustomerDAO {
	public List<Customer> getCustomers(){
		List<Customer> retorno = new ArrayList<Customer>();
		
		Customer c;
		
		c = new Customer(1, "Marcos Augusto");
		retorno.add(c);
		
		c = new Customer(2, "João Augusto");
		retorno.add(c);
		
		c = new Customer(3, "Pedro Paulo");
		retorno.add(c);
		
		return retorno;
	}
}
