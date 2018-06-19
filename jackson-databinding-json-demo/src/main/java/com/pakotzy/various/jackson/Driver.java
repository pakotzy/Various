package com.pakotzy.various.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
	public static void main(String[] args) {
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();

			// read JDON file to POJO
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);

			// print data
			System.out.println(student);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
