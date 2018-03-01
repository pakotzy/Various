package com.pakotzy.various;

import com.pakotzy.various.feature.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebApplication implements CommandLineRunner{
	@Autowired
	SettingsProvider properties;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

	@Override
	public void run(String... strings) {
		System.out.println(properties);
		for (Feature ft : properties.getFeatures()) {
			ft.run();
		}
	}
}