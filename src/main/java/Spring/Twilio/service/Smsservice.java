package Spring.Twilio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import Spring.Twilio.Smsrequest;

@Service
public class Smsservice {

	private final Twilioproperties twilioproperties;
	
	@Autowired
	public Smsservice(Twilioproperties twilioproperties)
	{
		this.twilioproperties=twilioproperties;
	}
	
	//send message to number
	public String sendsms(Smsrequest smsrequest)
	{
        //note: 1. if you want to send normal text sms remove string ("whatsapp:") in below message creator
		//      2. if you want to send whatsapp message "whatsapp:" string to be added before the numbers
		Message message=Message.creator(new PhoneNumber("whatsapp:"+smsrequest.getNumber()), new PhoneNumber("whatsapp:"+twilioproperties.getFromNumber()), smsrequest.getMessage()).create();
        return message.getStatus().toString();
        
	
	}
}
