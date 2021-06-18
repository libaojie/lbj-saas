package com.lbj.saas.controller;

import com.lbj.saas.dao.ZenMapper;
import com.lbj.saas.model.Zen;
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
@RequestMapping("/db/zen")
public class ZenController {

    @Resource
    ZenMapper zenMapper;

    @GetMapping()
    private List<Zen> get() {
        return zenMapper.find();
    }
}
