package com.pakotzy.various.rabbitmq.PublishSubscribe.consumer;

import com.rabbitmq.client.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class RemotePersister {
	private static final String EXCH_N = "replication";

	public static void main(String[] args) {
		SpringApplication.run(RemotePersister.class, args);

		ConnectionFactory factory = new ConnectionFactory();

		try {
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			channel.exchangeDeclare(EXCH_N, "fanout");
			String queueName = channel.queueDeclare().getQueue();
			channel.queueBind(queueName, EXCH_N, "");

			System.out.println("[*] Waiting for data...");

			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
				                           byte[] body) throws IOException {
					String message = new String(body, "UTF-8");

					try {
						TimeUnit.SECONDS.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println("[x] Received message: " + message);
				}
			};

			channel.basicConsume(queueName, true, consumer);

		} catch (TimeoutException | IOException e) {
			e.printStackTrace();
		}

	}
}
