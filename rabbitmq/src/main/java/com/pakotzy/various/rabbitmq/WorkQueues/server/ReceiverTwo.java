package com.pakotzy.various.rabbitmq.WorkQueues.server;

import com.rabbitmq.client.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class ReceiverTwo {
	private static final String QUEUE_NAME ="WorkQueues";

	public static void main(String[] args) {
		SpringApplication.run(ReceiverTwo.class, args);

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");

		try {
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();

			channel.queueDeclare(QUEUE_NAME, true, false, false, null);
			channel.basicQos(1);

			System.out.println("[*] Waiting for response!");

			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
				                           byte[] body) throws IOException {
					String message = new String(body, "UTF-8");
					System.out.println("[x] Receiver #2: " + message);
					try {
						TimeUnit.SECONDS.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						channel.basicAck(envelope.getDeliveryTag(), false);
					}
				}
			};

			channel.basicConsume(QUEUE_NAME, false, consumer);

		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
	}
}
