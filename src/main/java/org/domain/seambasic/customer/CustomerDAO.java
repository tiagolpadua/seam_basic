package org.domain.seambasic.customer;

import java.util.ArrayList;
import java.util.List;

import org.domain.seambasic.BasicException;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Name("customerDAO")
@Scope(ScopeType.APPLICATION)
public class CustomerDAO {
	
	private List<Customer> customers;
	
	public CustomerDAO(){
		customers = new ArrayList<Customer>();
		
		Customer c;
		
		c = new Customer(1, "Marcos Augusto");
		customers.add(c);
		
		c = new Customer(2, "João Augusto");
		customers.add(c);
		
		c = new Customer(3, "Pedro Paulo");
		customers.add(c);
	}
	
	public List<Customer> getCustomers(){
		return customers;
	}
	
	public Customer getCustomer(int id) throws BasicException{
		if(id == 666){
			throw new RuntimeException("Número da besta - RuntimeException");
		}
		
		for(Customer c : customers){
			if(c.getId() == id){
				return c;
			}
		}
		
		throw new BasicException("Record not found - BasicException");
	}
}
