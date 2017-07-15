package com.build.oa.web;

import com.build.oa.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Cacheable;
import java.util.List;

/**
 * Created by xzhang on 7/14/2017.
 */
@Controller
@RequestMapping(value = "cache")
@ResponseBody
@Cacheable
public class CacheController {

/*  Generic
    JCache (JSR-107)
    EhCache 2.x
    Hazelcast
    Infinispan
    Redis
    Guava
    Simple

    use @EnableCaching  spring boot will find CacheManager order by above items

    */

    @Autowired
    CacheManager cacheManager;

    @Autowired
    UserRepo userRepo;

    @RequestMapping(value = "cachemanager")
    public String cacheManager(){
        return cacheManager.toString();
    }


    @RequestMapping(value = "findUsers")
    public List findUsers(@RequestParam(name = "name") String name){
        return userRepo.findByName(name);
    }

}
