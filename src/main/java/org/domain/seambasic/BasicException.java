package org.domain.seambasic;

public class BasicException extends Exception {
	private static final long serialVersionUID = -1731200758618246363L;

	public BasicException() {
		super();
	}

	public BasicException(String msg) {
		super(msg);
	}

	public BasicException(String msg, Exception e) {
		super(msg, e);
	}

}
