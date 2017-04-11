package com.learnbycoding.service.messageProducer;

import javax.jms.JMSException;

import com.learnbycoding.model.Employee;

public interface NotifyService {

	void notifyString(String message) throws JMSException;
	void notifyEmployee(Employee employee) throws JMSException; 
	
}
