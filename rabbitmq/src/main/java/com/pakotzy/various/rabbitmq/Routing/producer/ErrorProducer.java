package com.pakotzy.various.rabbitmq.Routing.producer;

import com.pakotzy.various.rabbitmq.Routing.SeverityLevel;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class ErrorProducer {
	private static final String EXCH_N = "log";

	private static SeverityLevel randomSeverity() {
		SeverityLevel level;

		switch (ThreadLocalRandom.current().nextInt(1, 5)) {
			case 1 : level = SeverityLevel.WARNING;
				break;
			case 2: level = SeverityLevel.EXCEPTION;
				break;
			case 3: level = SeverityLevel.ERROR;
				break;
			default: level = SeverityLevel.VERBOSE;
		}

		return level;
	}

	private static List<String> generateMessages(int quantity) {
		List<String> messages = new ArrayList<>(quantity);

		while (quantity >= 0) {
			quantity--;

			messages.add(String.valueOf(ThreadLocalRandom.current().nextInt(0, 10000)));
		}

		return messages;
	}

	public static void main(String[] args) {
		SpringApplication.run(ErrorProducer.class, args);

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.newConnection();
		     Channel channel = connection.createChannel()) {

			channel.exchangeDeclare(EXCH_N, "direct");

			for (String message : generateMessages(10)) {
				String severity = randomSeverity().name();
				channel.basicPublish(EXCH_N, severity, null, message.getBytes());
				System.out.println("[x] Sent : " + message + " with level " + severity);
				TimeUnit.SECONDS.sleep(5);
			}

		} catch (IOException | TimeoutException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
