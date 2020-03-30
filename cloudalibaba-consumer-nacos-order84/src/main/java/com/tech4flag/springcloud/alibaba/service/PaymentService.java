package com.tech4flag.springcloud.alibaba.service;

import com.tech4flag.springcloud.entity.CommentResult;
import com.tech4flag.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * @author ltf
 * @date 2020/3/29 9:02
 * openfeign服务调用与服务降级
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/paymentSQL/{id}")
    public CommentResult<Payment> paymentSQL(@PathVariable("id") Long id);
}

