package com.cantfu.microcloudprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicrocloudProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrocloudProviderApplication.class, args);
    }

}
