package com.lbj.saas.http;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Map;

@Data
public class ApiRequestHeader {

    @SerializedName("Authorization")
    @Expose
    private String authorization;
}
