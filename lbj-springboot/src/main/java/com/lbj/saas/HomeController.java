package com.lbj.saas;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "")
@Slf4j
public class HomeController {

    @RequestMapping("/hi")
    public String hi(HttpServletRequest request) {
        log.info("Success");
        return "Success";
    }

}

