/**
 * 
 */
package com.example.challenge;

/**
 * @author lfhernandez
 *
 */
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.example.challenge")
public class SpringTestConfig {
	@Bean
	public RestTemplateBuilder restTemplateBuilder() {
	   // Do any additional configuration here
	   return new RestTemplateBuilder();
	}

}