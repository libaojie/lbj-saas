package com.lbj.saas;

import com.lbj.saas.util.DBUtils;

import java.util.List;

/**
 * @Description
 * @Author libaojie
 * @create 2021/6/15 9:36
 */

public class Test {
    public static void main(String[] args) {
        List data = DBUtils.find("select * from obja", null);
    }
}
