package com.learnbycoding.embeddedBroker;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JmsBroker {

	private static final Logger logger = LoggerFactory.getLogger(JmsBroker.class);
	/* This class starts an embedded broker on localhost, listening at 61616.
	 * If you have ActiveMQ installed on your pc, then you don't need to run this activeMQ embedded broker class
	 */
	public static void main(String[] args) throws URISyntaxException, Exception {
	
		BrokerService broker = BrokerFactory.createBroker(new URI("broker:(tcp://localhost:61616)"));
		
		System.out.println(broker.getBrokerName());
		broker.start();
	}

}
