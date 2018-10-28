package com.tjudream.stock.service;

import com.tjudream.stock.dto.Stock;

/**
 * Created by mengxiansen on 2018/10/28.
 */
public interface ReportService {
    public void initdata() throws Exception;
    public String download(String stockCode);
    public void readAndInsert(Stock stock, String filename);
}
