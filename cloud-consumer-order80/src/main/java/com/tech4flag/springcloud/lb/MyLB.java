package com.tech4flag.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author litianfu
 * @version 1.0
 * @email 1035869369@qq.com
 * @date 2020-03-27 16:23
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获取访问的次数
     * @return
     */
    public final int getAndIncrement() {
        int cur;
        int next;
        do {
            cur = this.atomicInteger.get();
            //0x7fffffff = 2147483647该数值为整形最大值，当cur的值大于它时就归0
            next = cur >= 0x7fffffff ? 0 : cur + 1;
        } while (!this.atomicInteger.compareAndSet(cur,next));
        System.out.println("第"+next+"次访问");
        return next;
    }


    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
