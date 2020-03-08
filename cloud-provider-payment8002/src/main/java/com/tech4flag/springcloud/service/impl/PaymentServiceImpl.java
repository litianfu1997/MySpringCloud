package com.tech4flag.springcloud.service.impl;

import com.tech4flag.springcloud.dao.PaymentMapper;
import com.tech4flag.springcloud.entity.Payment;
import com.tech4flag.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author litianfu
 * @version 1.0
 * @email 1035869369@qq.com
 * @date 2020-03-06 21:22
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    /**
     * 插入订单
     *
     * @param payment
     * @return
     */
    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    /**
     * 通过订单id获取订单
     *
     * @param id
     * @return
     */
    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
