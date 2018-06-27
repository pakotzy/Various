package com.pakotzy.various.rabbitmq.HelloWorld.client;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class ClientApplication {

	private static final String QUEUE_NAME = "hello";

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try (Connection connection = factory.newConnection();
				Channel channel = connection.createChannel()) {

			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String message = "Hello World!";
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println("[x] Sent '" + message + "'");

		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
	}
}
