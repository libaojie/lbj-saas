package com.lbj.saas.http;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mysql.jdbc.StringUtils;
import lombok.Data;

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

    public <T> T getBodyModel(Class<T> tClass) {
        if (!StringUtils.isNullOrEmpty(this.body)){
            T t = new Gson().fromJson(this.body, tClass);
            return t;
        }
        return null;
    }

}
