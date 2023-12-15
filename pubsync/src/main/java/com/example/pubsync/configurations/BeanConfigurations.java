package com.example.pubsync.configurations;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class to define beans used across the application.
 * This class is annotated with @Configuration to indicate that it provides bean definitions.
 */
@Configuration
public class BeanConfigurations {

    /**
     * Creates and provides a Gson bean for JSON parsing.
     * This bean can be autowired into other components that require JSON processing.
     * @return A new instance of Gson.
     */
    @Bean
    public Gson getGson() {return new Gson(); }
}
