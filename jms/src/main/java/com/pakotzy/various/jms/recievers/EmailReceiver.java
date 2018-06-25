package com.pakotzy.various.jms.recievers;

import com.pakotzy.various.jms.entities.Email;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class EmailReceiver {
	@JmsListener(destination = "mailbox", containerFactory = "myFactory")
	public void receiveMessage(Email email) {
		System.out.println("Message received - " + email);
	}
}
