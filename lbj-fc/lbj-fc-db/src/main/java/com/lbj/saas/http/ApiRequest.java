package com.lbj.saas.http;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mysql.jdbc.StringUtils;
import lombok.Data;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.Map;

@Data
public class ApiRequest {


    @SerializedName("body")
    @Expose
    private String body;

    @SerializedName("headers")
    @Expose
    private ApiRequestHeader headers;

    @SerializedName("queryParameters")
    @Expose
    private Map<String, String> queryParameters;

    @SerializedName("pathParameters")
    @Expose
    private Map<String, String> pathParameters;

    @SerializedName("isBase64Encoded")
    @Expose
    private Boolean isBase64Encoded;

    @SerializedName("path")
    @Expose
    private String path;

    /**
     * 对body翻译成对应的实体类
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> T getBodyModel(Class<T> tClass) {
        if (!StringUtils.isNullOrEmpty(this.getBody())){
            byte[] data;
            if (this.getIsBase64Encoded()) {
                data = Base64.getDecoder().decode(this.getBody());
            } else {
                data = this.getBody().getBytes();
            }

            T t = new Gson().fromJson(new InputStreamReader(new ByteArrayInputStream(data)), tClass);
            return t;
        }
        return null;
    }

}
