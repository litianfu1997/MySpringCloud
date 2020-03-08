package com.tech4flag.springcloud.service;

import com.tech4flag.springcloud.entity.Payment;

/**
 * @author litianfu
 * @version 1.0
 * @email 1035869369@qq.com
 * @date 2020-03-06 21:20
 */
public interface PaymentService {
    /**
     * 插入订单
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 通过订单id获取订单
     * @param id
     * @return
     */
    public Payment getPaymentById(Long id);
}
