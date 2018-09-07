package com.htht.huoy.module.generator.config;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationFilter {

    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration(){
        FilterRegistrationBean registration=new FilterRegistrationBean();
        registration.setFilter(new SimpleCORSFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("name","alue");
        registration.setName("SimpleCORSFilter");
        registration.setOrder(1);
        return registration;
    }
}
