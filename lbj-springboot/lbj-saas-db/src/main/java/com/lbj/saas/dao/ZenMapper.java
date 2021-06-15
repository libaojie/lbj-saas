package com.lbj.saas.dao;

import com.lbj.saas.entity.Zen;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description TODO
 * @Date 2021/6/3 15:54
 * @File RoleMapper
 * @Version v1.0
 * @Date 2021/2/5 14:56
 * @Created by libaojie
 */
@Mapper
public interface ZenMapper {
    List<Zen> find();
}
