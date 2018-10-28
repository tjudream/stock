package com.tjudream.stock.service;

import com.tjudream.stock.dto.Stock;

import java.util.List;

/**
 * Created by mengxiansen on 2018/9/19.
 */
public interface StockService {
    public Stock addsh() throws Exception;
    public Stock addsz() throws Exception;
    public List<Stock> list() throws Exception;
}
