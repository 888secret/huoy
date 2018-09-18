package com.htht.huoy.module.hyjc.web;

import com.htht.huoy.module.hyjc.service.HyjcService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hyjc")
public class HyjcController{

    @Autowired
    private HyjcService hyjcService;

    @RequestMapping("/saveList")
    public void saveList(){
        hyjcService.saveList();
    }
}
