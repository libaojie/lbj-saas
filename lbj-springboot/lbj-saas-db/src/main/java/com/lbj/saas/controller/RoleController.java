package com.lbj.saas.controller;

import com.lbj.saas.dao.RoleMapper;
import com.lbj.saas.model.Role;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Date 2021/6/3 15:52
 * @File RoleController
 * @Version v1.0
 * @Date 2021/2/5 14:56
 * @Created by libaojie
 */
@RestController
@Api(value = "角色", tags = {""})
@RequestMapping("/db/role")
public class RoleController {

    @Resource
    RoleMapper roleMapper;

    @GetMapping()
    private List<Role> get(){
        return roleMapper.find();
    }
}
