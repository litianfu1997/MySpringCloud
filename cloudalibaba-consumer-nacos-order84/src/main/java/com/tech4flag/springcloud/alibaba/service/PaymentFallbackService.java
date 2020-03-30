package com.tech4flag.springcloud.alibaba.service;

import com.tech4flag.springcloud.entity.CommentResult;
import com.tech4flag.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @author ltf
 * @date 2020/3/29 9:06
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommentResult<Payment> paymentSQL(Long id) {
        return new CommentResult<>(444,"服务降级返回，------------PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
