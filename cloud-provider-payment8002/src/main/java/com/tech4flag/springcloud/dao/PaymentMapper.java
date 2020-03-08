package com.tech4flag.springcloud.dao;

import com.tech4flag.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author litianfu
 * @version 1.0
 * @email 1035869369@qq.com
 * @date 2020-03-06 20:41
 */
@Mapper
public interface PaymentMapper {

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
    public Payment getPaymentById(@Param("id") Long id);
}
