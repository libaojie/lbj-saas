package com.lbj.saas;


import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.StreamRequestHandler;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

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
        context.getLogger().info("输入内容7：");
        /**
         * 如下代码为把inputStream转换为StringBuilder类型
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        context.getLogger().info(new String(sb));

        Gson request =  new Gson().fromJson(new InputStreamReader(inputStream), Gson.class);
        if (request == null ) {
            context.getLogger().warn("Request payload decode failed (is null)");
        }

//        Type type = new TypeToken<Map<String, String>>() {}.getType();
//        Map<String, String> map2 = new Gson().fromJson(new String(sb), type);




//        outputStream.write(new String("hello world2").getBytes());
        ApiResponse response = new ApiResponse();
        response.setIsBase64Encoded(false);
        response.setStatusCode(200);
        HashMap headers = new HashMap<String, String>();
        headers.put("xdua-api-iss", "xdua.com");
        response.setHeaders(headers);
        ApiResponseBody apiResponseBody = new ApiResponseBody();
        apiResponseBody.setMessage(new String(sb));
        apiResponseBody.setReason("hello, world7！");
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