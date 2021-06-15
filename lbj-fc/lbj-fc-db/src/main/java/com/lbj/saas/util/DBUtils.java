package com.lbj.saas.util;

import com.aliyun.fc.runtime.FunctionComputeLogger;
import com.lbj.saas.config.DBConfig;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 数据库操作工具
 * @Author libaojie
 * @create 2021/6/10 14:57
 */

public class DBUtils {

    private static DBConfig dbConfig;

    static {
        try {
            dbConfig = new DBConfig();
            // 加载驱动
            Class.forName(dbConfig.getDriver());
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
        return DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUser(), dbConfig.getPasswd());
    }

    /**
     * 释放资源
     *
     * @param conn
     * @param st
     * @param rs
     */
    public static void release(Connection conn, Statement st, PreparedStatement pstmt, ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }

        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            pstmt = null;
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

    /**
     * 映射
     *
     * @param rs
     * @param clazz
     * @return
     */
    public static List<Object> handler(ResultSet rs, Class<?> clazz) {
        List<Object> list = new ArrayList<>();
        Object obj = null;
        try {
            while (rs.next()) {
                // 创建一个clazz对象实例并将其赋给要返回的那个返回值。
                obj = clazz.newInstance();
                // 获取结果集的数据源
                ResultSetMetaData rsmeta = rs.getMetaData();

                // 获取结果集中的字段数
                int count = rsmeta.getColumnCount();

                // 循环取出个字段的名字以及他们的值并将其作为值赋给对应的实体对象的属性
                for (int i = 0; i < count; i++) {
                    // 获取字段名
                    String name = rsmeta.getColumnName(i + 1);
                    // 利用反射将结果集中的字段名与实体对象中的属性名相对应，由于
                    // 对象的属性都是私有的所以要想访问必须加上getDeclaredField(name)和
                    Field f = obj.getClass().getDeclaredField(name);
                    f.setAccessible(true);
                    // 将结果集中的值赋给相应的对象实体的属性
                    f.set(obj, rs.getObject(name));
                }
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查找
     *
     * @param sql
     * @return
     */
    public static List<Map> find(String sql) {
        List list = new ArrayList<>();

        Connection ct = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            ct = DBUtils.getConnection();
            pstmt = ct.prepareStatement(sql);
            rs = pstmt.executeQuery();
            // 结构信息
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();//获取列数
            int rowCount = rs.getRow();
//            log(logger, "列量1：" + colCount);
//            log(logger, "行量2：" + rowCount);
            while (rs.next()) {

                Map map = new HashMap<>();
                for (int i = 1; i <= colCount; i++) {
                    map.put(rsmd.getColumnName(i), rs.getObject(i));
                }
//                log(logger, "列量3：" + map);
                list.add(map);
            }
        } catch (Exception e) {
            // TODO: handle exception
            LogUtils.info(e.toString());
        } finally {
            DBUtils.release(ct, null, pstmt, rs);
        }
        return list;
    }



}
