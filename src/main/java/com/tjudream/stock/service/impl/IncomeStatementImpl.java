package com.tjudream.stock.service.impl;

import com.tjudream.stock.dto.Stock;
import com.tjudream.stock.service.IncomeStatementService;
import org.springframework.stereotype.Service;

/**
 * Created by mengxiansen on 2018/10/27.
 */
@Service
public class IncomeStatementImpl implements IncomeStatementService {
    @Override
    public void initdata() throws Exception {

    }

    @Override
    public String download(String stockCode) {
        return null;
    }

    @Override
    public void readAndInsert(Stock stock, String filename) {
    }
}
