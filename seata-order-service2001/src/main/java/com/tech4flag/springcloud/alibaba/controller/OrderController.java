package com.tech4flag.springcloud.alibaba.controller;


import com.oracle.tools.packager.Log;
import com.tech4flag.springcloud.alibaba.domain.CommonResult;
import com.tech4flag.springcloud.alibaba.domain.Order;
import com.tech4flag.springcloud.alibaba.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author ltf
 * @date 2020/3/30 21:24
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        log.info("******"+order.toString());
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
