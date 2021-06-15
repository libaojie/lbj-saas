package com.lbj.saas.util;

import com.aliyun.fc.runtime.FunctionComputeLogger;

/**
 * @Description 日志打印
 * @Author libaojie
 * @create 2021/6/15 10:07
 */

public class LogUtils {
    public static FunctionComputeLogger logger = null;

    public static void init(FunctionComputeLogger logger) {
        LogUtils.logger = logger;
    }

    public static void info(String context) {
        context = String.format("【info】：%s\n", context);
        if (logger == null) {
            System.out.print(context);
        } else {
            logger.info(context);
        }
    }

    public static void error(String context) {
        context = String.format("【error】：%s\n", context);
        if (logger == null) {
            System.out.print(context);
        } else {
            logger.error(context);
        }
    }

}
