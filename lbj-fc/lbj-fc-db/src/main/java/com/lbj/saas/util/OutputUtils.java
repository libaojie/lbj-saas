package com.lbj.saas.util;

import com.google.gson.Gson;
import com.lbj.saas.config.SystemConfig;
import com.lbj.saas.http.ApiResponse;
import com.lbj.saas.http.ApiResponseBody;

import java.util.HashMap;

/**
 * @Description 输出结果工具
 * @Author libaojie
 * @create 2021/6/10 15:06
 */

public class OutputUtils {

    /**
     * 转发json
     *
     * @param reason
     * @return
     */
    public static String toGson(String reason, HashMap<String, Object> result) {
        ApiResponse response = new ApiResponse();
        response.setIsBase64Encoded(false);
        response.setStatusCode(200);
        HashMap headers = new HashMap<String, String>();
        SystemConfig systemConfig = new SystemConfig();
        headers.put(systemConfig.getRepHKey(), systemConfig.getRepHVal());
        response.setHeaders(headers);
        ApiResponseBody apiResponseBody = new ApiResponseBody();
        apiResponseBody.setReason(reason);
        apiResponseBody.setResult(result);
        response.setBody(apiResponseBody);
        return new Gson().toJson(response);
    }
}
