package com.tjudream.stock;

import com.tjudream.stock.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mengxiansen on 2018/9/19.
 */
public class StockApp {
    @Autowired
    StockRepository stockRepository;
    public static void main(String[] args) {
        StockApp stockApp = new StockApp();
        stockApp.test();
    }
    public void test() {
    }
}
