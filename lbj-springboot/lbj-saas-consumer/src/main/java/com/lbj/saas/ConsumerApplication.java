package com.lbj.saas;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description TODO
 * @Date 2021/6/1 15:58
 * @File ConsumerApplication
 * @Version v1.0
 * @Date 2021/2/5 14:56
 * @Created by libaojie
 */
@Slf4j
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
        log.info("---------------消费者 系统启动成功------------------");
    }
}
