package com.tjudream.stock.service.impl;

import com.tjudream.stock.service.BalanceSheetService;
import com.tjudream.stock.service.CashFlowStatementService;
import com.tjudream.stock.service.IncomeStatementService;
import com.tjudream.stock.service.ReportFactoryService;
import com.tjudream.stock.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mengxiansen on 2018/10/28.
 */
@Service
public class ReportFactoryImpl implements ReportFactoryService {
    @Autowired
    private BalanceSheetService balanceSheetService;
    @Autowired
    private CashFlowStatementService cashFlowStatementService;
    @Autowired
    private IncomeStatementService incomeStatementService;

    @Override
    public ReportService getReportService(String type) {
        if ("zcfzb".equals(type)) {
            return balanceSheetService;
        } else if ("xjllb".equals(type)) {
            return cashFlowStatementService;
        } else if ("lrb".equals(type)) {
            return incomeStatementService;
        }
        return null;
    }
}
