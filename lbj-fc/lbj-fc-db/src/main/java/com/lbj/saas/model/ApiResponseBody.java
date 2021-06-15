package com.lbj.saas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Map;

@Data
public class ApiResponseBody {
    @SerializedName("apid")
    @Expose
    private String apid;

    @SerializedName("apis")
    @Expose
    private String apis;

    @SerializedName("error")
    @Expose
    private int error;

    @SerializedName("reason")
    @Expose
    private String reason;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("result")
    @Expose
    private Map<String, Object>  result;

    @SerializedName("event")
    @Expose
    private String event;

    @SerializedName("debug")
    @Expose
    private Map<String, String>  debug;

    @SerializedName("fault")
    @Expose
    private String fault;

    /**
     * No args constructor for use in serialization
     */
    public ApiResponseBody() {
    }



}
