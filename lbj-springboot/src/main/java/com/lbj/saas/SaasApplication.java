package com.lbj.saas;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Description TODO
 * @Date 2021/6/1 10:27
 * @File SaasApplication
 * @Version v1.0
 * @Date 2021/2/5 14:56
 * @Created by libaojie
 */
@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SaasApplication {
    public static void main(String[] args) {
        SpringApplication.run(SaasApplication.class, args);
//        log.info("---------------客户端 系统启动成功------------------");
    }
}
