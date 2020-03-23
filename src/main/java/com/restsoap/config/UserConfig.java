package com.restsoap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.restsoap.cliente.UserCliente;


@Configuration
public class UserConfig {

	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.restsoap.wsdl");
		return marshaller;
	}
	

	@Bean
	public UserCliente userCliente(Jaxb2Marshaller marshaller) {
		UserCliente client = new UserCliente();
		client.setDefaultUri("http://localhost:8180/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}