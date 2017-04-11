package com.learnbycoding.service.messageProducer;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.learnbycoding.model.Employee;

@Service(value ="notifyService")
public class NotifyServiceImpl implements NotifyService {

	@Autowired
	@Qualifier("session1")
	private Session session1;
	
	@Autowired
	@Qualifier("destination1")
	private Destination destination1;
	
	@Autowired
    @Qualifier("destination2")
	private Destination destination2;
	
	
	@Override
	public void notifyString(String message) throws JMSException {
      Message stringMessage= session1.createTextMessage(message);
      MessageProducer messageProducer= session1.createProducer(destination1);
      messageProducer.send(stringMessage);
     // session.close();
	}

	@Override
	public void notifyEmployee(Employee employee) throws JMSException {
		 ObjectMessage employeeMessage= session1.createObjectMessage();
		 employeeMessage.setObject(employee);
	     MessageProducer messageProducer= session1.createProducer(destination2);
	     messageProducer.send(employeeMessage); 
	    session1.close();
	}

}
