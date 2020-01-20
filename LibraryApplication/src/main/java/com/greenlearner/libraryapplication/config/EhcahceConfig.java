package com.greenlearner.libraryapplication.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @author - GreenLearner(https://www.youtube.com/channel/UCaH2MTg94hrJZTolW01a3ZA)
 */

//@EnableCaching
@Configuration
public class EhcahceConfig {

    @Bean
    CacheManager cacheManager() {
        return new EhCacheCacheManager(cacheManagerFactory().getObject());
    }

    private EhCacheManagerFactoryBean cacheManagerFactory() {
        EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
        bean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        bean.setShared(true);
        System.out.println("ehcache bean");
        return bean;
    }
}
