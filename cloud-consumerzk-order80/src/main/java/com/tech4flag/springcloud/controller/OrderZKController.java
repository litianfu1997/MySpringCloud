package com.tech4flag.springcloud.controller;

import com.tech4flag.springcloud.entity.CommentResult;
import com.tech4flag.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author litianfu
 * @version 1.0
 * @email 1035869369@qq.com
 * @date 2020-03-27 11:14
 */
@RestController
@Slf4j
public class OrderZKController {
    public static final String PAYMENT_URL = "http://cloud-provider-payment";

    /**
     * RestTemplate用于项目中其他微服务模块进行通信
     */
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentInfo(){
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
        return result;
    }
}
