package com.tech4flag.springcloud.controller;

import com.tech4flag.springcloud.entity.CommentResult;
import com.tech4flag.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author litianfu
 * @version 1.0
 * @email 1035869369@qq.com
 * @date 2020-03-27 18:22
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommentResult getPaymentById(@PathVariable("id") Long id){
       return paymentService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/timeout")
    public String getTimeOut(){
        return paymentService.getTimeOut();
    }

}
