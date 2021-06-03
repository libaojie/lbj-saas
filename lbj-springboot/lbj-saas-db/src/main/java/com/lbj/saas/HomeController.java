package com.lbj.saas;


import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
@Slf4j
public class HomeController {

    @RequestMapping(value = "/db/hi/{name}", method = RequestMethod.GET)
    public String hi(@PathVariable String name) {
        log.info("Success");
        return "(provider)Hi," + name;
    }

}

