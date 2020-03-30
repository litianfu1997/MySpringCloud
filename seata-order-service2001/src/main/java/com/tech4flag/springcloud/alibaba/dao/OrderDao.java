package com.tech4flag.springcloud.alibaba.dao;

import com.tech4flag.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * @author ltf
 * @date 2020/3/30 20:41
 */
@Mapper
public interface OrderDao {
    //1 新建订单
    void createOrder(Order order);

    //2 修改订单状态 从0改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}