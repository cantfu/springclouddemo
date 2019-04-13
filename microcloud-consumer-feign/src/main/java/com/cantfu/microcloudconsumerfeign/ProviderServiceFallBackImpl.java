package com.cantfu.microcloudconsumerfeign;

import org.springframework.stereotype.Component;

/**
 * ProviderServiceFallBack
 * ProviderService 的 fallback 处理
 * @author cantfu
 * @date 2019/4/13
 */
@Component
public class ProviderServiceFallBackImpl implements ProviderService {

    @Override
    public String hello(String name) {
        return "服务请求出错，我是客户端 fallback !";
    }
}
