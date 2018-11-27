package com.tjudream.stock.controller;

import com.tjudream.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述:
 * <p>
 * Created by mengxiansen on 2018-11-27 16:37
 *
 * @author mengxs@lenovocloud.com
 */
@Controller
@RequestMapping("/stockview")
public class StockViewController {
    @Autowired
    private StockService stockService;

    @RequestMapping("/list")
    public String hello(Model model) throws Exception {
        model.addAttribute("stocklist", stockService.list());
        return "stocklist";
    }
}
