package com.whattsap.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class TwilioInitiazer {
	
	//para probar
	private final static Logger LOOGER=LoggerFactory.getLogger(TwilioInitiazer.class);
	
	
	private final TwilioConfiguration twilioConfiguration;

	@Autowired
	public TwilioInitiazer(TwilioConfiguration twilioConfiguration) {
		this.twilioConfiguration=twilioConfiguration;
		Twilio.init(
				twilioConfiguration.getAccountSid(), 
				twilioConfiguration.getAuthToken());
		
		
		LOOGER.info("Twilio initialized ... with account sid {} ", twilioConfiguration.getAccountSid());
	}
	
	
	
	
	
}
