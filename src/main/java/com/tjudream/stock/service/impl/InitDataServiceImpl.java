package com.tjudream.stock.service.impl;

import com.tjudream.stock.service.InitDataService;
import com.tjudream.stock.service.ReportFactoryService;
import com.tjudream.stock.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mengxiansen on 2018/10/28.
 */
@Service
public class InitDataServiceImpl implements InitDataService {
    @Autowired
    private ReportFactoryService reportFactoryService;
    @Override
    public void initReport(String type) throws Exception {
        ReportService reportService = reportFactoryService.getReportService(type);
        reportService.initdata();
    }
}
