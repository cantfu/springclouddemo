package com.cantfu.microcloudconsumerfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * ProviderService
 * provider 服务的调用
 * @author cantfu
 * @date 2019/4/10
 */
@FeignClient(name="provider")
public interface ProviderService {
// @FeignClient 的name指向对应的服务名,没有用服务发现功能（Eureka）的话需要指定 url

    /** 调用 provider 服务的 hello接口，必须和 provider 中一致*/
    @RequestMapping(value = "/hello/{name}")
    String hello(@PathVariable("name") String name);
}

