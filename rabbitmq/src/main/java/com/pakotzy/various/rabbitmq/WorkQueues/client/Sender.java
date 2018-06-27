package com.pakotzy.various.rabbitmq.WorkQueues.client;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class Sender {
	private static final String QUEUE_NAME ="WorkQueues";

	private static List<String> generateMessages(int quantity) {
		List<String> messages = new ArrayList<>(quantity);

		while (quantity >= 0) {
			quantity--;

			messages.add(String.valueOf(ThreadLocalRandom.current().nextInt(0, 10000)));
		}

		return messages;
	}

	public static void main(String[] args) {
		SpringApplication.run(Sender.class, args);

		List<String> messages = generateMessages(10);

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");

		try (Connection connection = factory.newConnection();
		     Channel channel = connection.createChannel()) {

			channel.queueDeclare(QUEUE_NAME, true, false, false, null);

			for (String message : messages) {
				channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
				System.out.println("[x] Sent: " + message);
				TimeUnit.SECONDS.sleep(1);
			}

		} catch (IOException | TimeoutException | InterruptedException e) {
			e.printStackTrace();
		}
	}


}
