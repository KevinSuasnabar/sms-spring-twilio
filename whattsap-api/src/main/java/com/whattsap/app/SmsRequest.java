package com.whattsap.app;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmsRequest {

	@NotBlank
	private final String phoneNumber;// numero de destino del mensaje
	
	@NotBlank
	private final String message;// mensaje en si

	public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber, 
					  @JsonProperty("message") String message) {

		this.phoneNumber = phoneNumber;
		this.message = message;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "SmsRequest [phoneNumber=" + phoneNumber + ", message=" + message + "]";
	}
	
	

}
