package com.tjudream.stock.service.impl;

import com.alibaba.fastjson.JSON;
import com.csvreader.CsvReader;
import com.tjudream.stock.dto.BalanceSheet;
import com.tjudream.stock.dto.Stock;
import com.tjudream.stock.repositories.BalanceSheetRepository;
import com.tjudream.stock.service.BalanceSheetService;
import com.tjudream.stock.service.StockService;
import com.tjudream.stock.util.Constant;
import com.tjudream.stock.util.HttpUtils;
import com.tjudream.stock.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengxiansen on 2018/10/27.
 */
@Service
public class BalanceSheetServiceImpl implements BalanceSheetService {

    @Autowired
    private StockService stockService;
    @Autowired
    private BalanceSheetRepository balanceSheetRepository;


    @Override
    public void initdata() throws Exception {
        List<Stock> stockList = stockService.list();
        stockList.forEach(stock -> {
            String filename = download(stock.getCode());
            readAndInsert(stock, filename);
        });
    }

    @Override
    public String download(String stockCode) {
        String url = Constant.STOCK_PREFIX_URL + "zcfzb_" + stockCode + ".html";
        String filename = Constant.BALANCESHEET_PATH + stockCode + ".csv";
        try {
            InputStream inputStream = HttpUtils.doGetForFile(url);
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            byte[] temp = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(temp)) != -1) {
                // 目标文件写入一部分内容
                fileOutputStream.write(temp, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return filename;
    }

    @Override
    public void readAndInsert(Stock stock, String filename) {
        List<BalanceSheet> balanceSheetList = new ArrayList<>();
        try {
            ArrayList<String[]> csvList = new ArrayList<String[]>();
            CsvReader reader = new CsvReader(filename, ',', Charset.forName("GBK"));
            //reader.readHeaders();
            while(reader.readRecord()){
                csvList.add(reader.getValues()); //按行读取，并把每一行的数据添加到list集合
            }
            reader.close();
            System.out.println("读取的行数："+csvList.size());
            String[] arrStrs = csvList.get(0);
            for (int i = 1; i < arrStrs.length; i++) {
                if (StringUtils.isEmpty(csvList.get(0)[i])) {
                    continue;
                }
                BalanceSheet balanceSheet = new BalanceSheet();
                balanceSheet.setType(1);
                balanceSheet.setCode(stock.getCode());
                balanceSheet.setName(stock.getName());
                balanceSheet.setIpoTime(stock.getIpoTime());
                Timestamp reportDate = Timestamp.valueOf(csvList.get(0)[i] + " 00:00:00");
                balanceSheet.setReportDate(reportDate);
                balanceSheet.setMonetaryFunds(Utils.parseData(csvList.get(1)[i]));
                balanceSheet.setDepositReservation(Utils.parseData(csvList.get(2)[i]));
                balanceSheet.setLendingFunds(Utils.parseData(csvList.get(3)[i]));
                balanceSheet.setTradingFinancialAssets(Utils.parseData(csvList.get(4)[i]));
                balanceSheet.setDerivativeFinancialAssets(Utils.parseData(csvList.get(5)[i]));
                balanceSheet.setNotesReceivable(Utils.parseData(csvList.get(6)[i]));
                balanceSheet.setAccountReceivable(Utils.parseData(csvList.get(7)[i]));
                balanceSheet.setAdvancePayment(Utils.parseData(csvList.get(8)[i]));
                balanceSheet.setReceivablePremium(Utils.parseData(csvList.get(9)[i]));
                balanceSheet.setReinsuranceAccountsReceivable(Utils.parseData(csvList.get(10)[i]));
                balanceSheet.setProvisionOfCessionReceivable(Utils.parseData(csvList.get(11)[i]));
                balanceSheet.setInterestReceivable(Utils.parseData(csvList.get(12)[i]));
                balanceSheet.setDividendReceivable(Utils.parseData(csvList.get(13)[i]));
                balanceSheet.setOtherReceivable(Utils.parseData(csvList.get(14)[i]));
                balanceSheet.setExportDrawbackReceivable(Utils.parseData(csvList.get(15)[i]));
                balanceSheet.setSubsidiesReceivable(Utils.parseData(csvList.get(16)[i]));
                balanceSheet.setReceivableDeposit(Utils.parseData(csvList.get(17)[i]));
                balanceSheet.setInsiderReceivable(Utils.parseData(csvList.get(18)[i]));
                balanceSheet.setBuyBackResaleFinancialAssets(Utils.parseData(csvList.get(19)[i]));
                balanceSheet.setInventories(Utils.parseData(csvList.get(20)[i]));
                balanceSheet.setPrepaidExpenses(Utils.parseData(csvList.get(21)[i]));
                balanceSheet.setPendingLiquidAssetsProfitAndLoss(Utils.parseData(csvList.get(22)[i]));
                balanceSheet.setNonCurrentAssetsDueWithinOneYear(Utils.parseData(csvList.get(23)[i]));
                balanceSheet.setOtherCurrentAssets(Utils.parseData(csvList.get(24)[i]));
                balanceSheet.setSubTotalOfCurrentAssets(Utils.parseData(csvList.get(25)[i]));
                balanceSheet.setLoansAndAdvances(Utils.parseData(csvList.get(26)[i]));
                balanceSheet.setAvailableForSaleFinancialAssets(Utils.parseData(csvList.get(27)[i]));
                balanceSheet.setHeldToMaturityInvestments(Utils.parseData(csvList.get(28)[i]));
                balanceSheet.setLongTermReceivables(Utils.parseData(csvList.get(29)[i]));
                balanceSheet.setLongTermEquityInvestment(Utils.parseData(csvList.get(30)[i]));
                balanceSheet.setOtherLongTermInvestments(Utils.parseData(csvList.get(31)[i]));
                balanceSheet.setInvestmentRealEstate(Utils.parseData(csvList.get(32)[i]));
                balanceSheet.setOriginalValueOfFixedAssets(Utils.parseData(csvList.get(33)[i]));
                balanceSheet.setAccumulatedDepreciation(Utils.parseData(csvList.get(34)[i]));
                balanceSheet.setFixedAssets(Utils.parseData(csvList.get(35)[i]));
                balanceSheet.setProvisionForImpairmentOffixedAssets(Utils.parseData(csvList.get(36)[i]));
                balanceSheet.setFixedAssets(Utils.parseData(csvList.get(37)[i]));
                balanceSheet.setConstructionInProgress(Utils.parseData(csvList.get(38)[i]));
                balanceSheet.setConstructionMaterials(Utils.parseData(csvList.get(39)[i]));
                balanceSheet.setDisposalOfFixedAssets(Utils.parseData(csvList.get(40)[i]));
                balanceSheet.setProductiveBiologicalAssets(Utils.parseData(csvList.get(41)[i]));
                balanceSheet.setPublicWelfareBiologicalAssets(Utils.parseData(csvList.get(42)[i]));
                balanceSheet.setOilAndGasAssets(Utils.parseData(csvList.get(43)[i]));
                balanceSheet.setIntangibleAssets(Utils.parseData(csvList.get(44)[i]));
                balanceSheet.setDevelopmentExpenditure(Utils.parseData(csvList.get(45)[i]));
                balanceSheet.setGoodwill(Utils.parseData(csvList.get(46)[i]));
                balanceSheet.setLongTermPrepaidExpenses(Utils.parseData(csvList.get(47)[i]));
                balanceSheet.setEquitySplittingAndCirculationRights(Utils.parseData(csvList.get(48)[i]));
                balanceSheet.setDeferredTaxAssets(Utils.parseData(csvList.get(49)[i]));
                balanceSheet.setOtherNonCurrentAssets(Utils.parseData(csvList.get(50)[i]));
                balanceSheet.setTotalaNonCurrentAssets(Utils.parseData(csvList.get(51)[i]));
                balanceSheet.setTotalAssets(Utils.parseData(csvList.get(52)[i]));
                balanceSheet.setShortTermLoans(Utils.parseData(csvList.get(53)[i]));
                balanceSheet.setBorrowingFromTheCentralBank(Utils.parseData(csvList.get(54)[i]));
                balanceSheet.setDepositsAndDeposits(Utils.parseData(csvList.get(55)[i]));
                balanceSheet.setUnpackingFunds(Utils.parseData(csvList.get(56)[i]));
                balanceSheet.setTransactionalFinancialLiabilities(Utils.parseData(csvList.get(57)[i]));
                balanceSheet.setDerivativeFinancialLiabilities(Utils.parseData(csvList.get(58)[i]));
                balanceSheet.setNotesPayable(Utils.parseData(csvList.get(59)[i]));
                balanceSheet.setAccountsPayable(Utils.parseData(csvList.get(60)[i]));
                balanceSheet.setAdvancesFromCustomers(Utils.parseData(csvList.get(61)[i]));
                balanceSheet.setSellingRepurchasedFinancialAssets(Utils.parseData(csvList.get(62)[i]));
                balanceSheet.setFeesAndCommissions(Utils.parseData(csvList.get(63)[i]));
                balanceSheet.setPayrollPayable(Utils.parseData(csvList.get(64)[i]));
                balanceSheet.setTaxesPayable(Utils.parseData(csvList.get(65)[i]));
                balanceSheet.setInterestPayable(Utils.parseData(csvList.get(66)[i]));
                balanceSheet.setDividendPayable(Utils.parseData(csvList.get(67)[i]));
                balanceSheet.setOtherPayables(Utils.parseData(csvList.get(68)[i]));
                balanceSheet.setPayableMargin(Utils.parseData(csvList.get(69)[i]));
                balanceSheet.setInternalPayables(Utils.parseData(csvList.get(70)[i]));
                balanceSheet.setOtherAmountsPayable(Utils.parseData(csvList.get(71)[i]));
                balanceSheet.setAccruedExpenses(Utils.parseData(csvList.get(72)[i]));
                balanceSheet.setCurrentLiabilities(Utils.parseData(csvList.get(73)[i]));
                balanceSheet.setCopingWithReinsurance(Utils.parseData(csvList.get(74)[i]));
                balanceSheet.setInsuranceContractReserve(Utils.parseData(csvList.get(75)[i]));
                balanceSheet.setAgentTradingSecurities(Utils.parseData(csvList.get(76)[i]));
                balanceSheet.setAgencyUnderwritingSecurities(Utils.parseData(csvList.get(77)[i]));
                balanceSheet.setInternationalTicketSettlement(Utils.parseData(csvList.get(78)[i]));
                balanceSheet.setDomesticTicketSettlement(Utils.parseData(csvList.get(79)[i]));
                balanceSheet.setDeferredIncome(Utils.parseData(csvList.get(80)[i]));
                balanceSheet.setCopingWithShortTermBonds(Utils.parseData(csvList.get(81)[i]));
                balanceSheet.setNonCurrentLiabilitiesDueWithinOneYear(Utils.parseData(csvList.get(82)[i]));
                balanceSheet.setOtherCurrentLiabilities(Utils.parseData(csvList.get(83)[i]));
                balanceSheet.setSubTotalOfCurrentLiabilities(Utils.parseData(csvList.get(84)[i]));
                balanceSheet.setLongTermBorrowings(Utils.parseData(csvList.get(85)[i]));
                balanceSheet.setBondsPayable(Utils.parseData(csvList.get(86)[i]));
                balanceSheet.setLongTermPayables(Utils.parseData(csvList.get(87)[i]));
                balanceSheet.setSpecialPayables(Utils.parseData(csvList.get(88)[i]));
                balanceSheet.setNonCurrentLiabilities(Utils.parseData(csvList.get(89)[i]));
                balanceSheet.setLongTermDeferredIncome(Utils.parseData(csvList.get(90)[i]));
                balanceSheet.setDeferredIncomeTaxLiabilities(Utils.parseData(csvList.get(91)[i]));
                balanceSheet.setOtherNonCurrentLiabilities(Utils.parseData(csvList.get(92)[i]));
                balanceSheet.setTotalaNonCurrentLiabilities(Utils.parseData(csvList.get(93)[i]));
                balanceSheet.setTotalLiability(Utils.parseData(csvList.get(94)[i]));
                balanceSheet.setPaidInCapital(Utils.parseData(csvList.get(95)[i]));
                balanceSheet.setCapitalSurplus(Utils.parseData(csvList.get(96)[i]));
                balanceSheet.setTreasuryStock(Utils.parseData(csvList.get(97)[i]));
                balanceSheet.setSpecialReserves(Utils.parseData(csvList.get(98)[i]));
                balanceSheet.setSurplusReserve(Utils.parseData(csvList.get(99)[i]));
                balanceSheet.setGeneralRiskPreparation(Utils.parseData(csvList.get(100)[i]));
                balanceSheet.setUndeterminedInvestmentLoss(Utils.parseData(csvList.get(101)[i]));
                balanceSheet.setUndistributedProfit(Utils.parseData(csvList.get(102)[i]));
                balanceSheet.setProposedDistributionOfCashDividends(Utils.parseData(csvList.get(103)[i]));
                balanceSheet.setForeignCurrencyStatementTranslationDifference(Utils.parseData(csvList.get(104)[i]));
                balanceSheet.setTotalEquityAttributableToTheParentCompany(Utils.parseData(csvList.get(105)[i]));
                balanceSheet.setMinorityShareholdersEquity(Utils.parseData(csvList.get(106)[i]));
                balanceSheet.setOwnerEquity(Utils.parseData(csvList.get(107)[i]));
                balanceSheet.setLiabilitiesAndOwnerEquity(Utils.parseData(csvList.get(108)[i]));
                balanceSheetList.add(balanceSheet);
                System.out.println(JSON.toJSONString(balanceSheet));
                balanceSheetRepository.save(balanceSheet);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BalanceSheetServiceImpl balanceSheetReport = new BalanceSheetServiceImpl();
//        String filename = balanceSheetReport.download("600000");
//        System.out.println(filename);
        String filename = "/Users/mengxiansen/job/study/stock/doc/balancesheet/600000.csv";
        Stock stock = new Stock();
        balanceSheetReport.readAndInsert(stock, filename);

    }
}
