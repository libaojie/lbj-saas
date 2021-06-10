package com.lbj.saas;


import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.StreamRequestHandler;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
        context.getLogger().info("输入内容9：");
        // 可以
//        /**
//         * 如下代码为把inputStream转换为StringBuilder类型
//         */
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//        StringBuilder sb = new StringBuilder();
//        String line = null;
//        try {
//            while ((line = reader.readLine()) != null) {
//                sb.append(line + "\n");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        context.getLogger().info(new String(sb));


        // 可以
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(new InputStreamReader(inputStream), JsonObject.class);
        context.getLogger().info(jsonObject.get("headers").toString());
//
//        Type type = new TypeToken<Map<String, String>>() {}.getType();
//        Map<String, String> map2 = new Gson().fromJson(new String(sb), type);


        // 访问数据库
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://rm-2ze58u393z05wod06po.mysql.rds.aliyuncs.com:3306/duadb2?allowMultiQueries=true&serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&rewriteBatchedStatements=true";
        String username = "duadb2";
        String password = "hello2Duadb2";

        //定义需要的对象
//        PreparedStatement ps=null;
        Connection ct = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            //初始化对象
            //1.加载驱动
            Class.forName(driver);
            //2.得到连接(1433表示sql server的默认端口)
            ct = DriverManager.getConnection(url, username, password);
            //3.创建Preparestatement,创建数据
//            ps=ct.prepareStatement("create database vvv");
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
            //关闭资源
            try {
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

                if (ct != null) {
                    try {
                        ct.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            } catch (Exception e2) {
                // TODO: handle exception
            }


            // 结果拼装
            context.getLogger().info("输入内容9：");

//        outputStream.write(new String("hello world2").getBytes());
            ApiResponse response = new ApiResponse();
            response.setIsBase64Encoded(false);
            response.setStatusCode(200);
            HashMap headers = new HashMap<String, String>();
            headers.put("xdua-api-iss", "xdua.com");
            response.setHeaders(headers);
            ApiResponseBody apiResponseBody = new ApiResponseBody();
//        apiResponseBody.setMessage(new String(sb));
            apiResponseBody.setReason("hello, world8！");
            response.setBody(apiResponseBody);
            context.getLogger().info(new Gson().toJson(response));
            outputStream.write(new Gson().toJson(response).getBytes());
//
//        /**
//         * String转换为json，必须先把原来的StringBuilder先toString了
//         */
//        JSONObject json = JSONObject.fromObject(sb.toString());
//
//        outputStream.write(new String(json.getString("key") + "\n").getBytes());

//        JSONObject json = JSONObject.fromObject(sb.toString());
        }

//    @Override
//    public void handleRequest(
//            InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
//
//        String endpoint = "oss-cn-shanghai.aliyuncs.com";
//        String bucketName = "my-bucket";
//
//        Credentials creds = context.getExecutionCredentials();
//        OSSClient client = new OSSClient(
//                endpoint, creds.getAccessKeyId(), creds.getAccessKeySecret(), creds.getSecurityToken());
//        client.putObject(bucketName, "my-object", new ByteArrayInputStream(new String("hello").getBytes()));
//        outputStream.write(new String("done").getBytes());
//    }
    }

}