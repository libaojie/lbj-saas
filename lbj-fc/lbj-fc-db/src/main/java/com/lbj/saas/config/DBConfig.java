package com.lbj.saas.config;

import lombok.Data;

/**
 * @Description
 * @Author libaojie
 * @create 2021/6/15 8:58
 */
@Data
public class DBConfig {

    private String driver = System.getenv("MYSQL_DRIVER");
    private String host = System.getenv("MYSQL_HOST");
    private String port = System.getenv("MYSQL_PORT");
    private String dbName = System.getenv("MYSQL_DBNAME");
    private String user = System.getenv("MYSQL_USER");
    private String passwd = System.getenv("MYSQL_PASSWORD");
    private String url = String.format("jdbc:mysql://%s:%s/%s?allowMultiQueries=true&serverTimezone=GMT%%2B8&useUnicode=true&characterEncoding=utf8&rewriteBatchedStatements=true", host, port, dbName);
}
