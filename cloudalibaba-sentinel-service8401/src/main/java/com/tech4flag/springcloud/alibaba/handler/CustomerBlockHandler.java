package com.tech4flag.springcloud.alibaba.handler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tech4flag.springcloud.entity.CommentResult;
import com.tech4flag.springcloud.entity.Payment;
/**
 * @author ltf
 * @date 2020/3/29 22:04
 */
public class CustomerBlockHandler {

    public static CommentResult handlerException(BlockException exception){
        return new CommentResult(4444,"按客户自定义，global handlerException-----1");
    }
    public static CommentResult handlerException2(BlockException exception){
        return new CommentResult(4444,"按客户自定义，global handlerException-----2");
    }
}