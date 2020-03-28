package com.tech4flag.springcloud.service.impl;

import com.tech4flag.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author litianfu
 * @version 1.0
 * @email 1035869369@qq.com
 * @date 2020-03-28 12:37
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfoOK(Integer id) {
        return "***********paymentInfoOK************";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "***********paymentInfoTimeout***********";
    }
}
