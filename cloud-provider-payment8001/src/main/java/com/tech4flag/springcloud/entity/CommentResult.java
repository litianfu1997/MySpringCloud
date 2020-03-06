package com.tech4flag.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author litianfu
 * @version 1.0
 * @email 1035869369@qq.com
 * @date 2020-03-06 20:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResult<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public CommentResult(Integer code,String message){
        this(code,message,null);
    }

}
