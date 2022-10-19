package dsi.senior.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import request.SmsRequest;


@Service
public class TwilioService {
	private final TwilioSmsSender twilioSmsSender;

    @Autowired
    public TwilioService(TwilioSmsSender twilioSmsSender) {
        this.twilioSmsSender = twilioSmsSender;
    }
    
    public void sendSms(SmsRequest smsRequest) {
    	twilioSmsSender.sendSms(smsRequest);
    }
}
