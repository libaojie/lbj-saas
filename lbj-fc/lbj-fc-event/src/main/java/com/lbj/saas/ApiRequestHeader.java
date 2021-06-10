package com.lbj.saas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Map;

@Data
public class ApiRequestHeader {

    @SerializedName("isBase64Encoded")
    @Expose
    private Boolean isBase64Encoded;

    @SerializedName("path")
    @Expose
    private String path;

    @SerializedName("httpMethod")
    @Expose
    private String httpMethod;

    @SerializedName("headers")
    @Expose
    private Map<String, String> headers;

    @SerializedName("queryParameters")
    @Expose
    private Map<String, String> queryParameters;

    @SerializedName("pathParameters")
    @Expose
    private Map<String, String> pathParameters;

}
