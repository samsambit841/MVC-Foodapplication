package com.jsp.foodapp.helper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan(basePackages = "com.jsp")
@Configuration
@EnableAsync
public class config  {

    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver ir = new InternalResourceViewResolver();
        ir.setPrefix("/");
        ir.setSuffix(".jsp");
        return ir;
    }

    


    @Bean
    public EntityManagerFactory entityManagerFactory() {
        try {
            return Persistence.createEntityManagerFactory("sambit");
        } catch (PersistenceException e) {
            throw new RuntimeException("Failed to create EntityManagerFactory", e);
        }
    }
}
