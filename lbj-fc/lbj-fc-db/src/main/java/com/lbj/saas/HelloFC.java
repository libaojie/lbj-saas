package com.lbj.saas;


import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.StreamRequestHandler;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.lbj.saas.model.ApiResponse;
import com.lbj.saas.model.ApiResponseBody;
import com.lbj.saas.util.DBUtils;
import com.lbj.saas.util.InputUtils;
import com.lbj.saas.util.OutputUtils;

import java.io.*;
import java.sql.*;
import java.util.HashMap;

/**
 * @Description TODO
 * @Date 2021/5/31 14:03
 * @File HelloFC
 * @Version v1.0
 * @Date 2021/2/5 14:56
 * @Created by libaojie
 */
public class HelloFC implements StreamRequestHandler {

    /**
     * 初级
     *
     * @param inputStream
     * @param outputStream
     * @param context
     * @throws IOException
     */
    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        context.getLogger().info("输入内容10：");

        // 取参数
        JsonObject jsonObject = InputUtils.toJson(inputStream);
        context.getLogger().info(jsonObject.get("headers").toString());

        Connection ct = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            ct = DBUtils.getConnection();
            String sql = "select * from obja";
            st = ct.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                context.getLogger().info(rs.getString("inc"));
                context.getLogger().info(rs.getString("user_id"));
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            DBUtils.release(ct, st, rs);
        }


        // 结果拼装
        context.getLogger().info("输入内容10：");

        String ret = OutputUtils.toGson("Hello world 10");
        context.getLogger().info(ret);
        outputStream.write(ret.getBytes());

    }


}