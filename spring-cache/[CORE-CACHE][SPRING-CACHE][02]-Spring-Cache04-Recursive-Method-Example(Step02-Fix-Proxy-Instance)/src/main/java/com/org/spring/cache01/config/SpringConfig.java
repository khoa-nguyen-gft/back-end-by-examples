package com.org.spring.cache01.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
@ComponentScan(basePackages = {"com.org.spring.cache02.beans"})
public class SpringConfig  {
	
    @Bean
    public CacheManager cacheManager() {
    	return new ConcurrentMapCacheManager("fibonacci");
    }

}
