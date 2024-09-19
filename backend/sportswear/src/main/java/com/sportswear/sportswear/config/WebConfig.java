package com.sportswear.sportswear.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value(value = "${image.path}")
    private String imagePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Serve files from the filesystem location
        registry.addResourceHandler("/images/**")
//                .addResourceLocations("file:/home/vlad/IdeaProjects/sports_wear/backend/sportswear/src/main/resources/images/");
                .addResourceLocations("file:" + imagePath);
    }
}
