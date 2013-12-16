package org.domain.seambasic.api.infra;

import java.util.ArrayList;
import java.util.List;

public class ServiceMessage {
	private EnumMessageType messageType;
	private String messageText;
	private List<String> fields = new ArrayList<String>();
	
	public ServiceMessage(){
	}
	
	public ServiceMessage(EnumMessageType messageType, String messageText){
		this.messageType = messageType;
		this.messageText = messageText;
	}

	public EnumMessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(EnumMessageType messageType) {
		this.messageType = messageType;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}
}
