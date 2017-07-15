package com.build.oa.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xzhang on 7/15/2017.
 */
@Controller
@RequestMapping(value = "logger")
@ResponseBody
public class LoggerController {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "log")
    public String logger(){
        logger.error("log");
        return "log";
    }
}
