package com.learnbycoding.config;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages="com.learnbycoding.*")
public class AppConfig {

	@Bean
	public ConnectionFactory ConnectionFactory(){	
		ActiveMQConnectionFactory  activeMQConnectionFactory= new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
		return activeMQConnectionFactory;
	}
	
   @Bean
   public Connection connection(ConnectionFactory connectionFactory) throws JMSException{
	   return connectionFactory.createConnection();
   }
   
   @Bean(name="session1")
   public Session session1(Connection connection) throws JMSException{
	   return connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
   }
   
   @Bean(name="session2")
   public Session session2(Connection connection) throws JMSException{
	   return connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
   }
   
   @Bean(name="destination1") 
   public Destination destination1(){
	   Destination destination1= new ActiveMQQueue("string_messageQueue"); 
	   return destination1;
   }
   
   @Bean(name="destination2") 
   public Destination destination2(){
	   Destination destination2= new ActiveMQQueue("employee_messageQueue"); 
	   return destination2;
   }
	
}
