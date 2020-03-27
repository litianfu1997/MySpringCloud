package com.tech4flag.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author litianfu
 * @version 1.0
 * @email 1035869369@qq.com
 * @date 2020-03-27 12:25
 */
@RestController
@Slf4j
public class OrderConsulController {
    public static final String PAYMENT_URL = "http://consul-provider-payment";

    /**
     * RestTemplate用于项目中其他微服务模块进行通信
     */
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo(){
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
        return result;
    }
}
