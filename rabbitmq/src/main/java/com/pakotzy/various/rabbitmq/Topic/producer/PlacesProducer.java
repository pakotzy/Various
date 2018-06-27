package com.pakotzy.various.rabbitmq.Topic.producer;

import com.pakotzy.various.rabbitmq.Topic.Feature;
import com.pakotzy.various.rabbitmq.Topic.Location;
import com.pakotzy.various.rabbitmq.Topic.Type;
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
public class PlacesProducer {
	private static final String EXCH_N = "places";

	private static Type getRandomType() {
		Type type;

		switch (ThreadLocalRandom.current().nextInt(1, 4)) {
			case 1 : type = Type.APARTMENT;
				break;
			case 2: type = Type.STORE;
				break;
			case 3:
			default: type = Type.ENTERTAINMENT;
		}

		return type;
	}

	private static Location getRandomLocation() {
		Location location;

		switch (ThreadLocalRandom.current().nextInt(1, 4)) {
			case 1 : location = Location.LA;
				break;
			case 2 : location = Location.NY;
				break;
			case 3 :
			default: location = Location.LV;
		}

		return location;
	}

	private static Feature getRandomFeature() {
		Feature feature;

		switch (ThreadLocalRandom.current().nextInt(1, 4)) {
			case 1 : feature = Feature.CLOSE;
				break;
			case 2 : feature = Feature.CHEAP;
				break;
			case 3 :
			default: feature = Feature.LUXURY;
		}

		return feature;
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
		SpringApplication.run(PlacesProducer.class, args);

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.newConnection();
		     Channel channel = connection.createChannel()) {

			channel.exchangeDeclare(EXCH_N, "topic");

			for (String message : generateMessages(10)) {
				String topic = getRandomType() + "." + getRandomLocation() + "." + getRandomFeature();
				channel.basicPublish(EXCH_N, topic, null, message.getBytes());
				System.out.println("[x] Produced : " + topic + ":" + message);
				TimeUnit.SECONDS.sleep(3);
			}

			channel.basicPublish(EXCH_N, "STORE.NY.CLOSE.LUXURY", null, "666".getBytes());

		} catch (TimeoutException | IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
