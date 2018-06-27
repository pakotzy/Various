package com.pakotzy.various.rabbitmq.Routing.consumer;

import com.pakotzy.various.rabbitmq.Routing.SeverityLevel;
import com.rabbitmq.client.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class ErrorLogger {
	private static final String EXCH_N = "log";

	public static void main(String[] args) {
		SpringApplication.run(ErrorLogger.class, args);

		ConnectionFactory factory = new ConnectionFactory();
		try {
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();

			channel.exchangeDeclare(EXCH_N, "direct");

			String queueName = channel.queueDeclare().getQueue();

			for (SeverityLevel severity : SeverityLevel.values()) {
				channel.queueBind(queueName, EXCH_N, severity.name());
			}

			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
				                           byte[] body) throws IOException {
					String message = new String(body, "UTF-8");

					System.out.println("[x] Consumed : " + envelope.getRoutingKey() + ":" + message);
				}
			};

			System.out.println("[*] Waiting for messages");
			channel.basicConsume(queueName, true, consumer);

		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
	}
}
