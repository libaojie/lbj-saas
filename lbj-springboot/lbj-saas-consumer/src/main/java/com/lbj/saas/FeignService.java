package com.lbj.saas;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description TODO
 * @Date 2021/6/1 16:02
 * @File FeignService
 * @Version v1.0
 * @Date 2021/2/5 14:56
 * @Created by libaojie
 */
@FeignClient(name = "lbj-saas-provider")
public interface FeignService {
    @RequestMapping(value = "/provider/hi/{str}", method = RequestMethod.GET)
    String hi(@PathVariable("str") String str);
}
