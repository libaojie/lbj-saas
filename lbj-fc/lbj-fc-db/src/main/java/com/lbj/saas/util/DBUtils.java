package com.lbj.saas.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Description 数据库操作工具
 * @Author 李宝杰
 * @create 2021/6/10 14:57
 */

public class DBUtils {
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://rm-2ze58u393z05wod06po.mysql.rds.aliyuncs.com:3306/duadb2?allowMultiQueries=true&serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&rewriteBatchedStatements=true";
    static String username = "duadb2";
    static String password = "hello2Duadb2";

    static {
        try {
            // 加载驱动
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 建立连接
     *
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * 释放资源
     * @param conn
     * @param st
     * @param rs
     */
    public static void release(Connection conn, Statement st, ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;

        }
        if (st != null) {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
