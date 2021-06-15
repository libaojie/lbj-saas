package com.lbj.saas;


import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.FunctionComputeLogger;
import com.aliyun.fc.runtime.StreamRequestHandler;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.lbj.saas.model.ApiRequest;
import com.lbj.saas.model.TestModel;
import com.lbj.saas.util.DBUtils;
import com.lbj.saas.util.InputUtils;
import com.lbj.saas.util.LogUtils;
import com.lbj.saas.util.OutputUtils;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Description TODO
 * @Date 2021/5/31 14:03
 * @File HelloFC
 * @Version v1.0
 * @Date 2021/2/5 14:56
 * @Created by libaojie
 */
public class HelloFC implements StreamRequestHandler {

    // 版本
    private int version = 2;

    /**
     * 初始化
     * @param context
     * @throws IOException
     */
    public void initialize(Context context) throws IOException {
        LogUtils.init(context.getLogger());
        LogUtils.info("初始化完成");
    }

    /**
     * 函数入口
     *
     * @param inputStream
     * @param outputStream
     * @param context
     * @throws IOException
     */
    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        LogUtils.info("------------");
        LogUtils.info(String.format("version:【%s】, time:【%s】", version, new Date().toString()));
        LogUtils.info("开始处理");

//        // 取参数
//        JsonObject jsonObject = InputUtils.toJson(inputStream);
//        LogUtils.info(jsonObject.get("headers").toString());
        ApiRequest request = new Gson().fromJson(new InputStreamReader(inputStream), ApiRequest.class);
        if (request == null || request.getBody() == null) {
            LogUtils.error("Request payload decode failed (is null)");
            return;
        }

        LogUtils.info("body:"+request.getBody());
        TestModel test = request.getBodyModel(TestModel.class);
        LogUtils.info("T:"+test.getText());

        List data = DBUtils.find("select * from obja where inc = 15");
        HashMap map = new HashMap<>();
        map.put("list", data);

        // 结果拼装
        LogUtils.info("输入内容12：");

        String ret = OutputUtils.toGson("Hello world 12", map);
        LogUtils.info(ret);
        outputStream.write(ret.getBytes());

    }


}