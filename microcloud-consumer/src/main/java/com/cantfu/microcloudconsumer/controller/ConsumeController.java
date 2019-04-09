package com.cantfu.microcloudconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * ConsumeController
 *
 * @author cantfu
 * @date 2019/4/9
 */
@RestController
public class ConsumeController {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/consume")
    public String consume(String name){
        RestTemplate restTemplate = restTemplateBuilder.build();

        // 根据服务名获取 服务集群
        List<ServiceInstance> instances = discoveryClient.getInstances("provider");
        ServiceInstance serviceInstance = instances.get(0);

        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String url = "http://" + host + ":" + port + "/hello/" + name;
        return restTemplate.getForObject(url, String.class);

    }
}
