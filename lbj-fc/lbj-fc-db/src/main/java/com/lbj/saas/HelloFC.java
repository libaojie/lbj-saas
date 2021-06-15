package com.lbj.saas;


import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.FunctionComputeLogger;
import com.aliyun.fc.runtime.StreamRequestHandler;
import com.google.gson.JsonObject;
import com.lbj.saas.util.DBUtils;
import com.lbj.saas.util.InputUtils;
import com.lbj.saas.util.LogUtils;
import com.lbj.saas.util.OutputUtils;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

    public void initialize(Context context) throws IOException {
        LogUtils.init(context.getLogger());
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
        LogUtils.info("输入内容12：");

        // 取参数
        JsonObject jsonObject = InputUtils.toJson(inputStream);
        LogUtils.info(jsonObject.get("headers").toString());

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