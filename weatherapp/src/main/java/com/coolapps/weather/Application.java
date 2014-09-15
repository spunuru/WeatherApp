package com.coolapps.weather;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This class starts up the application using Spring Boot.
 * 
 * @author spunuru
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
        logBeanNames(ctx);
    }
    
    /**
     * Logs interesting info about beans configured by Sprint Boot
     * @param ctx
     */
    private static void logBeanNames(ApplicationContext ctx) {
        logger.debug("Here are beans provided by Spring Boot:");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            logger.debug(beanName);
        }

    }

}