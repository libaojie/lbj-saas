package com.lbj.saas.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description 基础类
 * @Author libaojie
 * @create 2021/6/15 12:56
 */
@Data
public class BaseEntity {
    protected int inc;

    protected String id;
    protected String delFlag;
    protected String createUser;
    protected Date createTime;
    protected String updateUser;
    protected Date updateTime;
    protected String remark;

}
