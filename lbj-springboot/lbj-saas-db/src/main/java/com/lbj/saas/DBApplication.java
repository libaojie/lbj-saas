package com.lbj.saas;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description TODO
 * @Date 2021/6/1 10:27
 * @File SaasApplication
 * @Version v1.0
 * @Date 2021/2/5 14:56
 * @Created by libaojie
 */
@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class DBApplication {
    public static void main(String[] args) {
        SpringApplication.run(DBApplication.class, args);
        log.info("---------------生产者 系统启动成功------------------");
    }
}
