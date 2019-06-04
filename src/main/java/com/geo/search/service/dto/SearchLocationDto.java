package com.geo.search.service.dto;

public class SearchLocationDto {

	private String errorCode;
    private String errorMessage;
    private String debugMessage;
    private Boolean status =true;
    private Object[] data;
    
    public SearchLocationDto(String errorCode, String errorMessage, String debugMessage, Boolean status,
			Object[] data) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.debugMessage = debugMessage;
		this.status = status;
		this.data = data;
	}

		public SearchLocationDto(Object[] data) {
			this.status =true;
			this.data = data;
		}



		public SearchLocationDto(boolean status) {
			this.status = status;
		}
    
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getDebugMessage() {
		return debugMessage;
	}
	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Object[] getData() {
		return data;
	}
	public void setData(Object[] data) {
		this.data = data;
	}
    
    
}
