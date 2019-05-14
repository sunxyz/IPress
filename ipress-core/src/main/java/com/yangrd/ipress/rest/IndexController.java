package com.yangrd.ipress.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IndexController
 *
 * @author yangrd
 * @date 2019/04/20
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public String hello(){
        return "hello";
    }
}
