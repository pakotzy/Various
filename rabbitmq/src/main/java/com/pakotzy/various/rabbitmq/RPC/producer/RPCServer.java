package com.pakotzy.various.rabbitmq.RPC.producer;

import com.rabbitmq.client.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class RPCServer {
	private static final String REQ = "rpc";

	public static void main(String[] args) {
		SpringApplication.run(RPCServer.class, args);

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");

		Connection connection = null;
		try {
			connection      = factory.newConnection();
			final Channel channel = connection.createChannel();

			channel.queueDeclare(REQ, false, false, false, null);

			channel.basicQos(1);

			System.out.println(" [x] Awaiting RPC requests");

			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
					AMQP.BasicProperties replyProps = new AMQP.BasicProperties
							.Builder()
							.correlationId(properties.getCorrelationId())
							.build();

					String response = "";

					try {
						String message = new String(body,"UTF-8");
						int n = Integer.parseInt(message);

						System.out.println(" [.] fib(" + message + ")");
						response += n*n;
					}
					catch (RuntimeException e){
						System.out.println(" [.] " + e.toString());
					}
					finally {
						channel.basicPublish( "", properties.getReplyTo(), replyProps, response.getBytes("UTF-8"));

						channel.basicAck(envelope.getDeliveryTag(), false);

						// RabbitMq consumer worker thread notifies the RPC server owner thread
						synchronized(this) {
							this.notify();
						}
					}
				}
			};

			channel.basicConsume(REQ, false, consumer);

			// Wait and be prepared to consume the message from RPC client.
			while (true) {
				synchronized(consumer) {
					try {
						consumer.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (IOException _ignore) {}
		}
	}
}
