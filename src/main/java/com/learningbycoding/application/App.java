package com.learningbycoding.application;

import java.util.Date;

import javax.jms.JMSException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learnbycoding.config.AppConfig;
import com.learnbycoding.model.Employee;
import com.learnbycoding.service.messageConsumer.ReceiveNotification;
import com.learnbycoding.service.messageProducer.NotifyService;

public class App {
	public static void main(String[] args) throws JMSException {

		ApplicationContext ctxt = new AnnotationConfigApplicationContext(AppConfig.class);
		
		NotifyService notify= (NotifyService)ctxt.getBean("notifyService");
		
		notify.notifyString("Hi Non Spring JMS");
		notify.notifyEmployee(new Employee(100, "sandeep", "verma" , new Date()));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	
		ReceiveNotification receiveNotification= (ReceiveNotification)ctxt.getBean("receiveNotification");
		
		//System.out.println("Receiving notification");
		receiveNotification.receiveNotification();
		receiveNotification.receiveNotificationEmployee();
		
		
		
	}
}
