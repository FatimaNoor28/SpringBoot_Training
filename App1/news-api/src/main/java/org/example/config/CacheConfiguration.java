package org.example.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableAsync
@EnableCaching
@EnableScheduling
public class CacheConfiguration {
    @Async
    public void sendEmail(){}

    @Scheduled(fixedDelay = 30000)
    public void reconcile(){}
}
