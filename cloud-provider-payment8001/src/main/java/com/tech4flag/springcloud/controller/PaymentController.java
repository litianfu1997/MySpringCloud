package com.tech4flag.springcloud.controller;

import com.tech4flag.springcloud.entity.CommentResult;
import com.tech4flag.springcloud.entity.Payment;
import com.tech4flag.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @author litianfu
 * @version 1.0
 * @email 1035869369@qq.com
 * @date 2020-03-06 21:24
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommentResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("****************结果是：" + result);
        if (result > 0) {
            return new CommentResult(200, "操纵成功", result);
        } else {
            return new CommentResult(444, "操纵失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommentResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****************结果是：" + payment);
        int i = 10;
        if (payment != null) {
            return new CommentResult(200, "操纵成功", payment);
        } else {
            return new CommentResult(444, "操纵失败", null);
        }
    }
}
