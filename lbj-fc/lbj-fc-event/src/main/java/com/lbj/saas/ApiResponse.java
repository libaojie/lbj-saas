package com.lbj.saas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Map;

@Data
public class ApiResponse {
    @SerializedName("isBase64Encoded")
    @Expose
    private Boolean isBase64Encoded;
    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("headers")
    @Expose
    private Map<String, String> headers;
    @SerializedName("body")
    @Expose
    private ApiResponseBody body;

    /**
     * No args constructor for use in serialization
     *
     */
    public ApiResponse() {
    }

//    /**
//     *
//     * @param headers
//     * @param statusCode
//     * @param body
//     * @param isBase64Encoded
//     */
//    public ApiResponse(Boolean isBase64Encoded, Integer statusCode, Map<String, String> headers, ApiResponseBody body) {
//        super();
//        this.isBase64Encoded = isBase64Encoded;
//        this.statusCode = statusCode;
//        this.headers = headers;
//        this.body = body;
//    }
//
//    public Boolean getIsBase64Encoded() {
//        return isBase64Encoded;
//    }
//
//    public void setIsBase64Encoded(Boolean isBase64Encoded) {
//        this.isBase64Encoded = isBase64Encoded;
//    }
//
//    public ApiResponse withIsBase64Encoded(Boolean isBase64Encoded) {
//        this.isBase64Encoded = isBase64Encoded;
//        return this;
//    }
//
//    public Integer getStatusCode() {
//        return statusCode;
//    }
//
//    public void setStatusCode(Integer statusCode) {
//        this.statusCode = statusCode;
//    }
//
//    public ApiResponse withStatusCode(Integer statusCode) {
//        this.statusCode = statusCode;
//        return this;
//    }
//
//    public Map<String, String> getHeaders() {
//        return headers;
//    }
//
//    public void setHeaders(Map<String, String> headers) {
//        this.headers = headers;
//    }
//
//    public ApiResponse withHeaders(Map<String, String> headers) {
//        this.headers = headers;
//        return this;
//    }
//
//    public ApiResponseBody getBody() {
//        return body;
//    }
//
//    public void setBody(ApiResponseBody body) {
//        this.body = body;
//    }
//
//    public ApiResponse withBody(ApiResponseBody body) {
//        this.body = body;
//        return this;
//    }

}
