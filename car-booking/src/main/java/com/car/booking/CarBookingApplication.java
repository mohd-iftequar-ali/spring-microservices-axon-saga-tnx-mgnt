package com.car.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

@EnableDiscoveryClient
@SpringBootApplication
public class CarBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarBookingApplication.class, args);
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
