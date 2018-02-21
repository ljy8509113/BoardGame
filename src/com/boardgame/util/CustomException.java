package com.boardgame.util;

public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorLog = "";
	
	public CustomException(String msg, String errorLog) {
		super(msg);
		this.errorLog = errorLog;
	}
	
	public String getLog() {
		return errorLog;
	}

}
