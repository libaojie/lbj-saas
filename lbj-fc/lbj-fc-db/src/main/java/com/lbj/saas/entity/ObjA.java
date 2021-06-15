package com.lbj.saas.entity;

import lombok.Data;

/**
 * @Description
 * @Author libaojie
 * @create 2021/6/15 12:31
 */
@Data
public class ObjA {
    // ossts的ID
    private String m5d;
    // 目录ID
    private String userId;
    // 对象的key
    private String okey;
    // 模板介绍
    private String objrId;
    // 模板过期时间
    private int expire;
    private Data cstamp;
}
