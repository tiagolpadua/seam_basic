package org.domain.seambasic.api.infra;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceResponse<T> {
	private Status status = Status.OK; 
	private List<ServiceMessage> messages = new ArrayList<ServiceMessage>();
	private T data;

	public ServiceResponse(){
	}
	
	public ServiceResponse(T data){
		this.data = data;
	}
	
	public ServiceResponse(T data, List<ServiceMessage> messages){
		this.data = data;
		this.messages = messages;
	}
	
	public ServiceResponse(List<ServiceMessage> messages){
		this.messages = messages;
	}
	
	public ServiceResponse(List<ServiceMessage> messages, Status status){
		this.status = status;
		this.messages = messages;
	}
	
	public ServiceResponse(ServiceMessage message){
		this.messages = new ArrayList<ServiceMessage>();
		messages.add(message);
	}
	
	public ServiceResponse(ServiceMessage message, Status status){
		this.status = status;
		this.messages = new ArrayList<ServiceMessage>();
		messages.add(message);
	}
	
	public ServiceResponse(T data, List<ServiceMessage> messages, Status status){
		this.status = status;
		this.messages = messages;
		this.data = data;
	}
	
	public List<ServiceMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<ServiceMessage> messages) {
		this.messages = messages;
	}

	public Object getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
