package com.tech4flag.springcloud.alibaba.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import com.tech4flag.springcloud.alibaba.handler.CustomerBlockHandler;
import com.tech4flag.springcloud.entity.CommentResult;
import com.tech4flag.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author ltf
 * @date 2020/3/29 21:42
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handlerException")
    public CommentResult byResource(){
        return new CommentResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }

    /**
     * 自定义的兜底方法
     * @param exception
     * @return
     */
    public CommentResult handlerException(BlockException exception){
        return new CommentResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }

    /**
     * 调用全局的通用兜底方法
     * @return
     */
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommentResult customerBlockHandler(){
        return new CommentResult(200,"按客户自定义",new Payment(2020L,"serial002"));
    }
}