package com.cantfu.microcloudprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author cantfu
 * @date 2019/4/9
 */
@RestController
public class HelloController {
    @Value("${server.port}")
    int port = 0;

    @RequestMapping(value = "/hello/{name}")
    public String hello(@PathVariable("name") String name){
        return "Hello "+name+" --provider port:"+port;
    }
}
