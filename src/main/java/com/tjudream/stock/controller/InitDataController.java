package com.tjudream.stock.controller;

import com.tjudream.stock.service.InitDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mengxiansen on 2018/10/20.
 */
@RestController
@RequestMapping("/initdata")
public class InitDataController {

    @Autowired
    private InitDataService initDataService;

    @RequestMapping("/zcfzb")
    public void zcfzb() throws Exception {
        initDataService.initReport("zcfzb");
    }

    @RequestMapping("/xjllb")
    public void xjllb() throws Exception {
        initDataService.initReport("xjllb");
    }

    @RequestMapping("/lrb")
    public void lrb() throws Exception {
        initDataService.initReport("lrb");
    }
}
