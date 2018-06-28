package com.pakotzy.various.rabbitmq.RPC.consumer;

import com.rabbitmq.client.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class RPCClient {
	private static final String REQ = "rpc";

	public static void main(String[] args) {
		SpringApplication.run(RPCClient.class, args);

		ConnectionFactory factory = new ConnectionFactory();
		try {
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();

			String replyQueueName = channel.queueDeclare().getQueue();

			final String corrId = UUID.randomUUID().toString();

			AMQP.BasicProperties props = new AMQP.BasicProperties
					.Builder().correlationId(corrId).replyTo(replyQueueName).build();

			channel.basicPublish("", REQ, props, "72".getBytes());

			final BlockingQueue<String> response = new ArrayBlockingQueue<>(1);

			channel.basicConsume(replyQueueName, true, new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
				                           byte[] body) throws IOException {
					if (properties.getCorrelationId().equals(corrId)) {
						response.offer(new String(body, "UTF-8"));
						System.out.println("Response : " + response);
					}
				}
			});
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
	}
}
