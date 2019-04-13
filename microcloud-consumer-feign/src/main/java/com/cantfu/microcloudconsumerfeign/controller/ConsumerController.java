package com.cantfu.microcloudconsumerfeign.controller;

import com.cantfu.microcloudconsumerfeign.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConsumerController
 * 此服务的API
 * @author cantfu
 * @date 2019/4/10
 */
@RestController
public class ConsumerController {

    @Autowired
    ProviderService providerService;

    @RequestMapping(value = "/consume")
    public String consume(@RequestParam("name") String name){
        System.out.println(providerService);
        return providerService.hello("cantfu") + " from Feign Client!";
    }
}
