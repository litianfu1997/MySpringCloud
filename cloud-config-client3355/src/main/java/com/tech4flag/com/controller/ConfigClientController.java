package com.tech4flag.com.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author litianfu
 * @date 2020/3/25 22:15
 */
@RestController
@RefreshScope
public class ConfigClientController {

    /**
     *要访问的github上配置文件的信息
     */
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}