package com.tech4flag.ribbonrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author litianfu
 * @version 1.0
 * @email 1035869369@qq.com
 * @date 2020-03-27 15:24
 * 定义ribbon的轮询规则
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        //定义为随机轮询
        return new RandomRule();
    }
}
