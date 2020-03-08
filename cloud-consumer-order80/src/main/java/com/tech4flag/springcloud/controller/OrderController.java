package com.tech4flag.springcloud.controller;

import com.tech4flag.springcloud.entity.CommentResult;
import com.tech4flag.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author litianfu
 * @version 1.0
 * @email 1035869369@qq.com
 * @date 2020-03-07 20:27
 * consumer模块与支付模块进行通信
 */
@RestController
@Slf4j
public class OrderController {


    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    /**
     * RestTemplate用于项目中其他微服务模块进行通信
     */
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommentResult<Payment> create(Payment payment) {
        log.info("*********进行插入操作*********");
        CommentResult commentResult = restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommentResult.class);
        return  commentResult;
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommentResult<Payment> getPayment(@PathVariable("id")Long id){
        log.info("*********获取订单中*********");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommentResult.class);
    }
}
