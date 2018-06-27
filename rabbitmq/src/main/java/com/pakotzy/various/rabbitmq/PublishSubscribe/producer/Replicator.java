package com.pakotzy.various.rabbitmq.PublishSubscribe.producer;

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
public class Replicator {
	private static final String EXCH_N = "replication";

	private static List<String> generateMessages(int quantity) {
		List<String> messages = new ArrayList<>(quantity);

		while (quantity >= 0) {
			quantity--;

			messages.add(String.valueOf(ThreadLocalRandom.current().nextInt(0, 10000)));
		}

		return messages;
	}

	public static void main(String[] args) {
		SpringApplication.run(Replicator.class, args);

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.newConnection();
		     Channel channel = connection.createChannel()) {

			channel.exchangeDeclare(EXCH_N, "fanout");

			for (String message : generateMessages(ThreadLocalRandom.current().nextInt(10, 100))) {
				channel.basicPublish(EXCH_N, "", null, message.getBytes());
				System.out.println("[x] Sent message: " + message);

				TimeUnit.SECONDS.sleep(1);
			}

		} catch (IOException | TimeoutException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
