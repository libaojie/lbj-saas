package com.lbj.saas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ApiRequest {


    @SerializedName("body")
    @Expose
    private String body;

    @SerializedName("headers")
    @Expose
    private ApiRequestHeader headers;

}
