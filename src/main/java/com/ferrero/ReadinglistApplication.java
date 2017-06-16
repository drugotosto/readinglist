package com.ferrero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
    The application’s bootstrap class and primary Spring configuration class.
    It serves two purposes in a Spring Boot application
        - configuration
        - bootstrapping
*/

/*
    Enable component-scanning and auto-configuration.
    Combines three other useful annotations:
        - @Configuration: Designates a class as a configuration class using Spring’s Java-based configuration
        - @ComponentScan: Enables component-scanning so that the web controller classes and other components you write will be automatically discovered and registered as beans in the Spring application context
        - @EnableAutoConfiguration: it’s the one line of configuration that enables the magic of Spring Boot auto-configuration (eliminate all the boilercode)

    Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically
    when it sees spring-webmvc on the classpath. This flags the application as a web application and
    activates key behaviors such as setting up a DispatcherServlet
*/
@SpringBootApplication
public class ReadinglistApplication {

	public static void main(String[] args) {
	    //Bootstrap the application
		SpringApplication.run(ReadinglistApplication.class, args);
	}
}
