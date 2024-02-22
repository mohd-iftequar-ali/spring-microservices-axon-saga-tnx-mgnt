package com.car.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

@SpringBootApplication
public class CarInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarInventoryApplication.class, args);
	}

	
	@Configuration
	public class AxonXstreamConfig {
	    @Bean
	    public XStream xStream() {
	        XStream xStream = new XStream();
	        xStream.addPermission(AnyTypePermission.ANY);
	        return xStream;
	    }
	}
	
}
