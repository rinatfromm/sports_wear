package com.sportswear.sportswear.config;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.OncePerRequestFilter;

public class HibernateConfig {
    @Bean
    public OncePerRequestFilter openEntityManagerInViewFilter() {
        return new OpenEntityManagerInViewFilter();
    }
}
