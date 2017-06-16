package com.ferrero;

import com.ferrero.controller.HomeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
/*
    Tells Spring Boot to go and look for a main configuration class (one with @SpringBootApplication for instance),
    and use that to start a Spring application context.
    Spring Boot provides a @SpringBootTest annotation which can be used as an alternative to the standard
    spring-test @ContextConfiguration annotation when you need Spring Boot feature.
*/
@SpringBootTest
//It’s used to denote that the ApplicationContext which is bootstrapped for the test should be an instance of WebApplicationContext
@WebAppConfiguration
public class ReadinglistApplicationTests {

    @Autowired
    private HomeController controller;

    /*
        Test that the application context loads successfully and the context is creating your controller.
    */
	@Test
	public void contextLoads() {
        assertThat(controller).isNotNull();
	}

}
