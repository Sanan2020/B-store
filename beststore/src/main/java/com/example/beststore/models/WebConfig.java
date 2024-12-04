package com.example.beststore.models;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<HiddenHttpMethodFilter> hiddenHttpMethodFilter() {
        FilterRegistrationBean<HiddenHttpMethodFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new HiddenHttpMethodFilter());
        filterRegistrationBean.addUrlPatterns("/productsAPI/*");  // กำหนดเส้นทางที่ต้องการให้รองรับ method override
        return filterRegistrationBean;
    }
}

