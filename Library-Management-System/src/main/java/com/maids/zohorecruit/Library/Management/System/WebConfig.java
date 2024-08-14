package com.maids.zohorecruit.Library.Management.System;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Make sure this does not conflict with your API paths
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("classpath:/static/");
    }
}
