package com.lbj.saas.config;

import lombok.Data;

/**
 * @Description
 * @Author libaojie
 * @create 2021/6/15 8:58
 */
@Data
public class SystemConfig {

    private String dbDriver = System.getenv("MYSQL_DRIVER");
    private String dbHost = System.getenv("MYSQL_HOST");
    private String dbPort = System.getenv("MYSQL_PORT");
    private String dbName = System.getenv("MYSQL_DBNAME");
    private String dbUser = System.getenv("MYSQL_USER");
    private String dbPasswd = System.getenv("MYSQL_PASSWORD");
    private String dbUrl = String.format("jdbc:mysql://%s:%s/%s?useSSL=false&allowMultiQueries=true&serverTimezone=GMT%%2B8&useUnicode=true&characterEncoding=utf8&rewriteBatchedStatements=true", dbHost, dbPort, dbName);

    private String repHKey = System.getenv("REP_H_KEY");
    private String repHVal = System.getenv("REP_H_VAL");

}
