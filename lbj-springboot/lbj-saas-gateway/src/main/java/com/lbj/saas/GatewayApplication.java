package com.lbj.saas;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description TODO
 * @Date 2021/6/2 14:12
 * @File GatewayApplication
 * @Version v1.0
 * @Date 2021/2/5 14:56
 * @Created by libaojie
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
        log.info("---------------网关 系统启动成功------------------");
    }
}
