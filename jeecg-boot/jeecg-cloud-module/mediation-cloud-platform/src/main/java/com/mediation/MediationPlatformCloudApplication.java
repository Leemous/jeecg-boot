package com.mediation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableFeignClients(basePackages = {"com.mediation"})
@SpringBootApplication(scanBasePackages = "com.mediation")
public class MediationPlatformCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediationPlatformCloudApplication.class, args);
    }
}
