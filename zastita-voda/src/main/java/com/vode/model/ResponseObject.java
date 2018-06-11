package com.vode.model;

import java.io.Serializable;

public class ResponseObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Status koji ce biti predstavljen u json odgovoru
	 */
	private int status;
	
	/**
	 * Poruka koja ce biti u json odgovoru
	 */
	private String message;
	
	/**
	 * Objekat koji ce biti u json odgovoru pod kljucem "response"
	 */
	private Serializable response;
	
	public ResponseObject(String message) {
		this.status = 200;
		this.message = message;
	}
	
	public ResponseObject(String message, int status) {
		this(message);
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setResponse(Serializable ser) {
		response = ser;
	}
	
	public Serializable getResponse() {
		return response;
	}
}
