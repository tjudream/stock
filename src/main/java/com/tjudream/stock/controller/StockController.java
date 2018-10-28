package com.tjudream.stock.controller;

import com.tjudream.stock.dto.Stock;
import com.tjudream.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mengxiansen on 2018/9/19.
 */
@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;
    /**
     * 初始化数据
     */
    @RequestMapping("/addsh")
    public Stock index() throws Exception {
        Stock stock = stockService.addsh();
        return stock;
    }


    @RequestMapping("/addsz")
    public Stock addsz() throws Exception {
        Stock stock = stockService.addsz();
        return stock;
    }

    @RequestMapping("/list")
    public List<Stock> list() throws Exception {
        return stockService.list();
    }
}
