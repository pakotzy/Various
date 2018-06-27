package com.pakotzy.various.rabbitmq.Topic.consumer;

import com.pakotzy.various.rabbitmq.Topic.Feature;
import com.pakotzy.various.rabbitmq.Topic.Location;
import com.pakotzy.various.rabbitmq.Topic.Type;
import com.rabbitmq.client.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class BrokeStudentConsumer {
	private static final String EXCH_N = "places";

	public static void main(String[] args) {
		SpringApplication.run(BrokeStudentConsumer.class, args);

		ConnectionFactory factory = new ConnectionFactory();
		try {
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();

			channel.exchangeDeclare(EXCH_N, "topic");

			String queueName = channel.queueDeclare().getQueue();
			channel.queueBind(queueName, EXCH_N, Type.APARTMENT + "." + Location.NY + "." + Feature.CHEAP);
			channel.queueBind(queueName, EXCH_N, Type.STORE + "." + Location.NY + "." + Feature.CLOSE + ".#");

			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
				                           byte[] body) throws IOException {
					String message = new String(body, "UTF-8");

					System.out.println("[x] Received : " + envelope.getRoutingKey() + ":" + message);
				}
			};

			System.out.println("[*] Waiting for messages");
			channel.basicConsume(queueName, true, consumer);
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
	}
}
