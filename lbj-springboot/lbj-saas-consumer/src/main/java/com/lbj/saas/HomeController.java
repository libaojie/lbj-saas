package com.lbj.saas;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "")
@Slf4j
public class HomeController {

    @Autowired
    FeignService feignService;

    @RequestMapping(value = "/hi1/{name}", method = RequestMethod.GET)
    public String hi1(@PathVariable String name) {
        log.info("Success");
        return "Say:" + feignService.hi(name);
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/hi2/{name}", method = RequestMethod.GET)
    public String hi2(@PathVariable String name) {
        log.info("Success");

        return "Say:" + restTemplate.getForObject("http://lbj-saas-provider/hi/" + name,
                String.class);
    }
}

