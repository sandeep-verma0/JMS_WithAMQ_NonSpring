package com.learnbycoding.service.messageConsumer;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.learnbycoding.model.Employee;

@Service(value="receiveNotification")
public class ReceiveNotificationImpl implements ReceiveNotification {

	@Autowired
	@Qualifier("session2")
	private Session session2;
	
	@Autowired
	private Connection connection;
	
	@Autowired
	@Qualifier("destination1")
	private Destination destination1;
	
	@Autowired
    @Qualifier("destination2")
	private Destination destination2;
	
	@Override
	public void receiveNotification() {
		 try {
			MessageConsumer stringMessageConsumer = session2.createConsumer(destination1);
			connection.start();
			TextMessage textMessage = (TextMessage)stringMessageConsumer.receive();
			System.out.println("Received text Message : " + textMessage);
			//session.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}   
	}

	@Override
	public void receiveNotificationEmployee() {
		try {
			
			MessageConsumer employeeMessageConsumer = session2.createConsumer(destination2);
			//connection.start();
			ObjectMessage objectMessage = (ObjectMessage)employeeMessageConsumer.receive();
			System.out.println("Received Employee  : " + ((Employee)objectMessage.getObject()));
			session2.close();
			connection.close();
		
	} catch (JMSException e) {
		e.printStackTrace();
	}
}
}