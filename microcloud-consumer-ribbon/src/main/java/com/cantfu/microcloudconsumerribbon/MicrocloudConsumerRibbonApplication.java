package com.cantfu.microcloudconsumerribbon;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class MicrocloudConsumerRibbonApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(MicrocloudConsumerRibbonApplication.class);

    @Bean(value = "restTemplate")
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @RequestMapping("/consume")
    public String comsume(String name){
        // 负载均衡选择一个实例
        ServiceInstance provider = loadBalancerClient.choose("provider");
        LOGGER.info("{}:{}:{}",provider.getServiceId(),provider.getHost(),provider.getPort());

        return restTemplate.getForObject("http://provider/hello/"+name, String.class);

    }


    public static void main(String[] args) {
        SpringApplication.run(MicrocloudConsumerRibbonApplication.class, args);
    }

}
