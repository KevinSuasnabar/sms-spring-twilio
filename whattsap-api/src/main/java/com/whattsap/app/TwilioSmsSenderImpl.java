package com.whattsap.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

@Service("twilio")
public class TwilioSmsSenderImpl implements SmsSender {
	
	private final static Logger LOOGER=LoggerFactory.getLogger(TwilioSmsSenderImpl.class);

	private final TwilioConfiguration twilioConfiguration;

	@Autowired
	public TwilioSmsSenderImpl(TwilioConfiguration twilioConfiguration) {
		this.twilioConfiguration = twilioConfiguration;
	}

	@Override
	public void sendSms(SmsRequest smsRequest) {

		if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
			PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
			PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
			String message = smsRequest.getMessage();

			MessageCreator creator = Message.creator(to, from, message);

			creator.create();
			
			LOOGER.info("Send sms {}" +smsRequest);
		}else {
			throw new IllegalArgumentException("EL numero de telefono [ "+smsRequest.getPhoneNumber()+" ] no es valido");
			
		}

	}

	private boolean isPhoneNumberValid(String phoneNumber) {
		
		//TODO: implmementar la validacion de telefono
		
		return true;
	}

}
