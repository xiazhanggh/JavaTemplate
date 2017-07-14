package com.build.oa.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by xzhang on 7/14/2017.
 */
@Controller
@RequestMapping(value = "template")
public class ThymeleafController {

    @RequestMapping(value = "{lvl1}")
    public String index(@RequestParam(name = "msg",required = false) String msg,
                        @PathVariable(name = "lvl1")String pageName, Map<String,Object> map){
        map.put("msg",msg);
        return pageName;
    }

}
