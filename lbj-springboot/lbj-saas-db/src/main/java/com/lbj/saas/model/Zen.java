package com.lbj.saas.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Date 2021/6/3 16:12
 * @File Zen
 * @Version v1.0
 * @Date 2021/2/5 14:56
 * @Created by libaojie
 */
@Data
public class Zen {
    private int inc;
    private String attr;
    private String code;
    private String name;
    private String node;
    private Date cstamp;
    private Date ustamp;
}
