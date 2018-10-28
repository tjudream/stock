package com.tjudream.stock.dto;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by mengxiansen on 2018/9/26.
 * 资产负债表
 */
@Entity(name = "balance_sheet")
@DynamicInsert
@DynamicUpdate
public class BalanceSheet {
    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * 股票代码
     */
    @Column(name = "code", columnDefinition = "varchar(16)", unique = true)
    private String code;

    @Column(name = "name", columnDefinition = "varchar(128)")
    private String name;

    private Timestamp ipoTime;
    @Column(columnDefinition="datetime default current_timestamp")
    private Timestamp ctime;
    @Column(columnDefinition="datetime default current_timestamp ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp mtime;
    /**
     * 报告日期
     */
    @Column(name = "report_date", columnDefinition = "datetime")
    private Timestamp reportDate;
    /**
     * 报告类型：1：一季度报（3、4月），2：半年报（6、7、8月），3：三季度报（9、10月），4：年报（12、1、2、3、4月）
     */
    private int type;
    /**
     * 货币资金
     */
    @Column(name = "monetary_funds")
    private long monetaryFunds = 0;
    /**
     * 结算备付金
     */
    @Column(name = "deposit_reservation")
    private long depositReservation = 0;
    /**
     * 拆出资金
     */
    @Column(name = "lending_funds")
    private long lendingFunds = 0;
    /**
     * 交易性金融资产(万元)
     */
    @Column(name = "trading_financial_assets")
    private long tradingFinancialAssets = 0;
    /**
     * 衍生金融资产(万元)
     */
    @Column(name = "derivative_financial_assets")
    private long derivativeFinancialAssets = 0;
    /**
     * 应收票据(万元)
     */
    @Column(name = "notes_receivable")
    private long notesReceivable = 0;
    /**
     * 应收账款(万元)
     */
    @Column(name = "account_receivable")
    private long accountReceivable = 0;
    /**
     * 预付款项(万元)
     */
    @Column(name = "advance_payment")
    private long advancePayment = 0;
    /**
     * 应收保费(万元)
     */
    @Column(name = "receivable_premium")
    private long receivablePremium = 0;
    /**
     * 应收分保账款(万元)
     */
    @Column(name = "reinsurance_accounts_receivable")
    private long reinsuranceAccountsReceivable = 0;
    /**
     * 应收分保合同准备金(万元)
     */
    @Column(name = "provision_of_cession_receivable")
    private long provisionOfCessionReceivable = 0;
    /**
     * 应收利息(万元)
     */
    @Column(name = "interest_receivable")
    private long interestReceivable;
    /**
     * 应收股利(万元)
     */
    @Column(name = "dividend_receivable")
    private long dividendReceivable;
    /**
     * 其他应收款(万元)
     */
    @Column(name = "other_receivable")
    private long otherReceivable;
    /**
     * 应收出口退税(万元)
     */
    @Column(name = "export_drawback_receivable")
    private long exportDrawbackReceivable;
    /**
     * 应收补贴款(万元)
     */
    @Column(name = "subsidies_receivable")
    private long subsidiesReceivable;
    /**
     * 应收保证金(万元)
     */
    @Column(name = "receivable_deposit")
    private long receivableDeposit;
    /**
     * 内部应收款(万元)
     */
    @Column(name = "insider_receivable")
    private long  insiderReceivable;
    /**
     * 买入返售金融资产(万元)
     */
    @Column(name = "buy_back_resale_financial_assets")
    private long buyBackResaleFinancialAssets;
    /**
     * 存货(万元) 20
     */
    @Column(name = "inventories")
    private long inventories;
    /**
     * 待摊费用(万元)
     */
    @Column(name = "prepaid_expenses")
    private long prepaidExpenses;
    /**
     * 待处理流动资产损益(万元)
     */
    @Column(name = "pending_liquid_assets_profit_and_loss")
    private long pendingLiquidAssetsProfitAndLoss;
    /**
     * 一年内到期的非流动资产(万元)
     */
    @Column(name = "non_current_assets_due_within_one_year")
    private long nonCurrentAssetsDueWithinOneYear;
    /**
     * 其他流动资产(万元)
     */
    @Column(name = "other_current_assets")
    private long otherCurrentAssets;
    /**
     * 流动资产合计(万元)
     */
    @Column(name = "sub_total_of_current_assets")
    private long subTotalOfCurrentAssets;
    /**
     * 发放贷款及垫款(万元)
     */
    @Column(name = "loans_and_advances")
    private long loansAndAdvances;
    /**
     * 可供出售金融资产(万元)
     */
    @Column(name = "available_for_sale_financial_assets")
    private long availableForSaleFinancialAssets;
    /**
     * 持有至到期投资(万元)
     */
    @Column(name = "held_to_maturity_investments")
    private long heldToMaturityInvestments;
    /**
     * 长期应收款(万元)
     */
    @Column(name = "long_term_receivables")
    private long longTermReceivables;
    /**
     * 长期股权投资(万元) 30
     */
    @Column(name = "long_term_equity_investment")
    private long longTermEquityInvestment;
    /**
     * 其他长期投资(万元)
     */
    @Column(name = "other_long_term_investments")
    private long otherLongTermInvestments;
    /**
     * 投资性房地产(万元)
     */
    @Column(name = "investment_real_estate")
    private long investmentRealEstate;
    /**
     * 固定资产原值(万元)
     */
    @Column(name = "original_value_of_fixed_assets")
    private long originalValueOfFixedAssets;
    /**
     * 累计折旧(万元)
     */
    @Column(name = "accumulated_depreciation")
    private long accumulatedDepreciation;
    /**
     * 固定资产净值(万元)
     */
    @Column(name = "fixed_assets_nbv")
    private long fixedAssetsNbv;
    /**
     * 固定资产减值准备(万元)
     */
    @Column(name = "provision_for_impairment_offixed_assets")
    private long provisionForImpairmentOffixedAssets;
    /**
     * 固定资产(万元)
     */
    @Column(name = "fixed_assets")
    private long fixedAssets;
    /**
     * 在建工程(万元)
     */
    @Column(name = "construction_in_progress")
    private long constructionInProgress;
    /**
     * 工程物资(万元)
     */
    @Column(name = "construction_materials")
    private long constructionMaterials;
    /**
     * 固定资产清理(万元) 40
     */
    @Column(name = "disposal_of_fixed_assets")
    private long disposalOfFixedAssets;
    /**
     * 生产性生物资产(万元)
     */
    @Column(name = "productive_biological_assets")
    private long productiveBiologicalAssets;
    /**
     * 公益性生物资产(万元)
     */
    @Column(name = "public_welfare_biological_assets")
    private long publicWelfareBiologicalAssets;
    /**
     * 油气资产(万元)
     */
    @Column(name = "oil_and_gas_assets")
    private long oilAndGasAssets;
    /**
     * 无形资产(万元)
     */
    @Column(name = "intangible_assets")
    private long intangibleAssets;
    /**
     * 开发支出(万元)
     */
    @Column(name = "development_expenditure")
    private long developmentExpenditure;
    /**
     * 商誉(万元)
     */
    @Column(name = "goodwill")
    private long goodwill;
    /**
     * 长期待摊费用(万元)
     */
    @Column(name = "long_term_prepaid_expenses")
    private long longTermPrepaidExpenses;
    /**
     * 股权分置流通权(万元)
     */
    @Column(name = "equity_splitting_and_circulation_rights")
    private long equitySplittingAndCirculationRights;
    /**
     * 递延所得税资产(万元)
     */
    @Column(name = "deferred_tax_assets")
    private long deferredTaxAssets;
    /**
     * 其他非流动资产(万元) 50
     */
    @Column(name = "other_non_current_assets")
    private long otherNonCurrentAssets;
    /**
     * 非流动资产合计(万元)
     */
    @Column(name = "totala_non_current_assets")
    private long totalaNonCurrentAssets;
    /**
     * 资产总计(万元)
     */
    @Column(name = "total_assets")
    private long totalAssets;
    /**
     * 短期借款(万元)
     */
    @Column(name = "short_term_loans")
    private long shortTermLoans;
    /**
     * 向中央银行借款(万元)
     */
    @Column(name = "borrowing_from_the_central_bank")
    private long borrowingFromTheCentralBank;
    /**
     * 吸收存款及同业存放(万元)
     */
    @Column(name = "deposits_and_deposits")
    private long depositsAndDeposits;
    /**
     * 拆入资金(万元)
     */
    @Column(name = "unpacking_funds")
    private long unpackingFunds;
    /**
     * 交易性金融负债(万元)
     */
    @Column(name = "transactional_financial_liabilities")
    private long transactionalFinancialLiabilities;
    /**
     * 衍生金融负债(万元)
     */
    @Column(name = "derivative_financial_liabilities")
    private long derivativeFinancialLiabilities;
    /**
     * 应付票据(万元)
     */
    @Column(name = "notes_payable")
    private long notesPayable;
    /**
     * 应付账款(万元) 60
     */
    @Column(name = "accounts_payable")
    private long accountsPayable;
    /**
     * 预收账款(万元)
     */
    @Column(name = "advances_from_customers")
    private long advancesFromCustomers;
    /**
     * 卖出回购金融资产款(万元)
     */
    @Column(name = "selling_repurchased_financial_assets")
    private long sellingRepurchasedFinancialAssets;
    /**
     * 应付手续费及佣金(万元)
     */
    @Column(name = "fees_and_commissions")
    private long feesAndCommissions;
    /**
     * 应付职工薪酬(万元)
     */
    @Column(name = "payroll_payable")
    private long payrollPayable;
    /**
     * 应交税费(万元)
     */
    @Column(name = "taxes_payable")
    private long taxesPayable;
    /**
     * 应付利息(万元)
     */
    @Column(name = "interest_payable")
    private long interestPayable;
    /**
     * 应付股利(万元)
     */
    @Column(name = "dividend_payable")
    private long dividendPayable;
    /**
     * 其他应交款(万元)
     */
    @Column(name = "other_payables")
    private long otherPayables;
    /**
     * 应付保证金(万元)
     */
    @Column(name = "payable_margin")
    private long payableMargin;
    /**
     * 内部应付款(万元) 70
     */
    @Column(name = "internal_payables")
    private long internalPayables;
    /**
     * 其他应付款(万元)
     */
    @Column(name = "otherAmountsPayable")
    private long otherAmountsPayable;
    /**
     * 预提费用(万元)
     */
    @Column(name = "accrued_expenses")
    private long accruedExpenses;
    /**
     * 预计流动负债(万元)
     */
    @Column(name = "current_liabilities")
    private long currentLiabilities;
    /**
     * 应付分保账款(万元)
     */
    @Column(name = "coping_with_reinsurance")
    private long copingWithReinsurance;
    /**
     * 保险合同准备金(万元)
     */
    @Column(name = "insurance_contract_reserve")
    private long insuranceContractReserve;
    /**
     * 代理买卖证券款(万元)
     */
    @Column(name = "agent_trading_securities")
    private long agentTradingSecurities;
    /**
     * 代理承销证券款(万元)
     */
    @Column(name = "agency_underwriting_securities")
    private long agencyUnderwritingSecurities;
    /**
     * 国际票证结算(万元)
     */
    @Column(name = "international_ticket_settlement")
    private long internationalTicketSettlement;
    /**
     * 国内票证结算(万元)
     */
    @Column(name = "domestic_ticket_settlement")
    private long domesticTicketSettlement;
    /**
     * 递延收益(万元) 80
     */
    @Column(name = "deferred_income")
    private long deferredIncome;
    /**
     * 应付短期债券(万元)
     */
    @Column(name = "coping_with_short_term_bonds")
    private long copingWithShortTermBonds;
    /**
     * 一年内到期的非流动负债(万元)
     */
    @Column(name = "non_current_liabilities_due_within_one_year")
    private long nonCurrentLiabilitiesDueWithinOneYear;
    /**
     * 其他流动负债(万元)
     */
    @Column(name = "other_current_liabilities")
    private long otherCurrentLiabilities;
    /**
     * 流动负债合计(万元)
     */
    @Column(name = "sub_total_of_current_liabilities")
    private long subTotalOfCurrentLiabilities;
    /**
     * 长期借款(万元)
     */
    @Column(name = "long_term_borrowings")
    private long longTermBorrowings;
    /**
     * 应付债券(万元)
     */
    @Column(name = "bonds_payable")
    private long bondsPayable;
    /**
     * 长期应付款(万元)
     */
    @Column(name = "long_term_payables")
    private long longTermPayables;
    /**
     * 专项应付款(万元)
     */
    @Column(name = "special_payables")
    private long specialPayables;
    /**
     * 预计非流动负债(万元)
     */
    @Column(name = "non_current_liabilities")
    private long nonCurrentLiabilities;
    /**
     * 长期递延收益(万元) 90
     */
    @Column(name = "long_term_deferred_income")
    private long longTermDeferredIncome;
    /**
     * 递延所得税负债(万元)
     */
    @Column(name = "deferred_income_tax_liabilities")
    private long deferredIncomeTaxLiabilities;
    /**
     * 其他非流动负债(万元)
     */
    @Column(name = "other_non_current_liabilities", columnDefinition = "int(10)")
    private long otherNonCurrentLiabilities;
    /**
     * 非流动负债合计(万元)
     */
    @Column(name = "totala_non_current_liabilities", columnDefinition = "int(10)")
    private long totalaNonCurrentLiabilities;
    /**
     * 负债合计(万元)
     */
    @Column(name = "abc", columnDefinition = "int(10)")
    private long totalLiability;
    /**
     * 实收资本(或股本)(万元)
     */
    @Column(name = "paid_in_capital")
    private long paidInCapital;
    /**
     * 资本公积(万元)
     */
    @Column(name = "capital_surplus")
    private long capitalSurplus;
    /**
     * 减:库存股(万元)
     */
    @Column(name = "treasury_stock")
    private long treasuryStock;
    /**
     * 专项储备(万元)
     */
    @Column(name = "special_reserves")
    private long specialReserves;
    /**
     * 盈余公积(万元)
     */
    @Column(name = "surplus_reserve")
    private long surplusReserve;
    /**
     * 一般风险准备(万元) 100
     */
    @Column(name = "general_risk_preparation")
    private long generalRiskPreparation;
    /**
     * 未确定的投资损失(万元)
     */
    @Column(name = "undetermined_investment_loss")
    private long undeterminedInvestmentLoss;
    /**
     * 未分配利润(万元)
     */
    @Column(name = "undistributed_profit")
    private long undistributedProfit;
    /**
     * 拟分配现金股利(万元)
     */
    @Column(name = "proposed_distribution_of_cash_dividends")
    private long proposedDistributionOfCashDividends;
    /**
     * 外币报表折算差额(万元)
     */
    @Column(name = "foreign_currency_statement_translation_difference")
    private long foreignCurrencyStatementTranslationDifference;
    /**
     * 归属于母公司股东权益合计(万元)
     */
    @Column(name = "Total equity attributable to the parent company")
    private long totalEquityAttributableToTheParentCompany;
    /**
     * 少数股东权益(万元)
     */
    @Column(name = "minority_shareholders_equity")
    private long minorityShareholdersEquity;
    /**
     * 所有者权益(或股东权益)合计(万元)
     */
    @Column(name = "owner_equity")
    private long ownerEquity;
    /**
     * 负债和所有者权益(或股东权益)总计(万元) 108
     */
    @Column(name = "liabilities_and_owner_equity")
    private long liabilitiesAndOwnerEquity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Timestamp getIpoTime() {
        return ipoTime;
    }

    public void setIpoTime(Timestamp ipoTime) {
        this.ipoTime = ipoTime;
    }

    public Timestamp getCtime() {
        return ctime;
    }

    public void setCtime(Timestamp ctime) {
        this.ctime = ctime;
    }

    public Timestamp getMtime() {
        return mtime;
    }

    public void setMtime(Timestamp mtime) {
        this.mtime = mtime;
    }

    public Timestamp getReportDate() {
        return reportDate;
    }

    public void setReportDate(Timestamp reportDate) {
        this.reportDate = reportDate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getMonetaryFunds() {
        return monetaryFunds;
    }

    public void setMonetaryFunds(long monetaryFunds) {
        this.monetaryFunds = monetaryFunds;
    }

    public long getDepositReservation() {
        return depositReservation;
    }

    public void setDepositReservation(long depositReservation) {
        this.depositReservation = depositReservation;
    }

    public long getLendingFunds() {
        return lendingFunds;
    }

    public void setLendingFunds(long lendingFunds) {
        this.lendingFunds = lendingFunds;
    }

    public long getTradingFinancialAssets() {
        return tradingFinancialAssets;
    }

    public void setTradingFinancialAssets(long tradingFinancialAssets) {
        this.tradingFinancialAssets = tradingFinancialAssets;
    }

    public long getDerivativeFinancialAssets() {
        return derivativeFinancialAssets;
    }

    public void setDerivativeFinancialAssets(long derivativeFinancialAssets) {
        this.derivativeFinancialAssets = derivativeFinancialAssets;
    }

    public long getNotesReceivable() {
        return notesReceivable;
    }

    public void setNotesReceivable(long notesReceivable) {
        this.notesReceivable = notesReceivable;
    }

    public long getAccountReceivable() {
        return accountReceivable;
    }

    public void setAccountReceivable(long accountReceivable) {
        this.accountReceivable = accountReceivable;
    }

    public long getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(long advancePayment) {
        this.advancePayment = advancePayment;
    }

    public long getReceivablePremium() {
        return receivablePremium;
    }

    public void setReceivablePremium(long receivablePremium) {
        this.receivablePremium = receivablePremium;
    }

    public long getReinsuranceAccountsReceivable() {
        return reinsuranceAccountsReceivable;
    }

    public void setReinsuranceAccountsReceivable(long reinsuranceAccountsReceivable) {
        this.reinsuranceAccountsReceivable = reinsuranceAccountsReceivable;
    }

    public long getProvisionOfCessionReceivable() {
        return provisionOfCessionReceivable;
    }

    public void setProvisionOfCessionReceivable(long provisionOfCessionReceivable) {
        this.provisionOfCessionReceivable = provisionOfCessionReceivable;
    }

    public long getInterestReceivable() {
        return interestReceivable;
    }

    public void setInterestReceivable(long interestReceivable) {
        this.interestReceivable = interestReceivable;
    }

    public long getDividendReceivable() {
        return dividendReceivable;
    }

    public void setDividendReceivable(long dividendReceivable) {
        this.dividendReceivable = dividendReceivable;
    }

    public long getOtherReceivable() {
        return otherReceivable;
    }

    public void setOtherReceivable(long otherReceivable) {
        this.otherReceivable = otherReceivable;
    }

    public long getExportDrawbackReceivable() {
        return exportDrawbackReceivable;
    }

    public void setExportDrawbackReceivable(long exportDrawbackReceivable) {
        this.exportDrawbackReceivable = exportDrawbackReceivable;
    }

    public long getSubsidiesReceivable() {
        return subsidiesReceivable;
    }

    public void setSubsidiesReceivable(long subsidiesReceivable) {
        this.subsidiesReceivable = subsidiesReceivable;
    }

    public long getReceivableDeposit() {
        return receivableDeposit;
    }

    public void setReceivableDeposit(long receivableDeposit) {
        this.receivableDeposit = receivableDeposit;
    }

    public long getInsiderReceivable() {
        return insiderReceivable;
    }

    public void setInsiderReceivable(long insiderReceivable) {
        this.insiderReceivable = insiderReceivable;
    }

    public long getBuyBackResaleFinancialAssets() {
        return buyBackResaleFinancialAssets;
    }

    public void setBuyBackResaleFinancialAssets(long buyBackResaleFinancialAssets) {
        this.buyBackResaleFinancialAssets = buyBackResaleFinancialAssets;
    }

    public long getInventories() {
        return inventories;
    }

    public void setInventories(long inventories) {
        this.inventories = inventories;
    }

    public long getPrepaidExpenses() {
        return prepaidExpenses;
    }

    public void setPrepaidExpenses(long prepaidExpenses) {
        this.prepaidExpenses = prepaidExpenses;
    }

    public long getPendingLiquidAssetsProfitAndLoss() {
        return pendingLiquidAssetsProfitAndLoss;
    }

    public void setPendingLiquidAssetsProfitAndLoss(long pendingLiquidAssetsProfitAndLoss) {
        this.pendingLiquidAssetsProfitAndLoss = pendingLiquidAssetsProfitAndLoss;
    }

    public long getNonCurrentAssetsDueWithinOneYear() {
        return nonCurrentAssetsDueWithinOneYear;
    }

    public void setNonCurrentAssetsDueWithinOneYear(long nonCurrentAssetsDueWithinOneYear) {
        this.nonCurrentAssetsDueWithinOneYear = nonCurrentAssetsDueWithinOneYear;
    }

    public long getOtherCurrentAssets() {
        return otherCurrentAssets;
    }

    public void setOtherCurrentAssets(long otherCurrentAssets) {
        this.otherCurrentAssets = otherCurrentAssets;
    }

    public long getSubTotalOfCurrentAssets() {
        return subTotalOfCurrentAssets;
    }

    public void setSubTotalOfCurrentAssets(long subTotalOfCurrentAssets) {
        this.subTotalOfCurrentAssets = subTotalOfCurrentAssets;
    }

    public long getLoansAndAdvances() {
        return loansAndAdvances;
    }

    public void setLoansAndAdvances(long loansAndAdvances) {
        this.loansAndAdvances = loansAndAdvances;
    }

    public long getAvailableForSaleFinancialAssets() {
        return availableForSaleFinancialAssets;
    }

    public void setAvailableForSaleFinancialAssets(long availableForSaleFinancialAssets) {
        this.availableForSaleFinancialAssets = availableForSaleFinancialAssets;
    }

    public long getHeldToMaturityInvestments() {
        return heldToMaturityInvestments;
    }

    public void setHeldToMaturityInvestments(long heldToMaturityInvestments) {
        this.heldToMaturityInvestments = heldToMaturityInvestments;
    }

    public long getLongTermReceivables() {
        return longTermReceivables;
    }

    public void setLongTermReceivables(long longTermReceivables) {
        this.longTermReceivables = longTermReceivables;
    }

    public long getLongTermEquityInvestment() {
        return longTermEquityInvestment;
    }

    public void setLongTermEquityInvestment(long longTermEquityInvestment) {
        this.longTermEquityInvestment = longTermEquityInvestment;
    }

    public long getOtherLongTermInvestments() {
        return otherLongTermInvestments;
    }

    public void setOtherLongTermInvestments(long otherLongTermInvestments) {
        this.otherLongTermInvestments = otherLongTermInvestments;
    }

    public long getInvestmentRealEstate() {
        return investmentRealEstate;
    }

    public void setInvestmentRealEstate(long investmentRealEstate) {
        this.investmentRealEstate = investmentRealEstate;
    }

    public long getOriginalValueOfFixedAssets() {
        return originalValueOfFixedAssets;
    }

    public void setOriginalValueOfFixedAssets(long originalValueOfFixedAssets) {
        this.originalValueOfFixedAssets = originalValueOfFixedAssets;
    }

    public long getAccumulatedDepreciation() {
        return accumulatedDepreciation;
    }

    public void setAccumulatedDepreciation(long accumulatedDepreciation) {
        this.accumulatedDepreciation = accumulatedDepreciation;
    }

    public long getFixedAssetsNbv() {
        return fixedAssetsNbv;
    }

    public void setFixedAssetsNbv(long fixedAssetsNbv) {
        this.fixedAssetsNbv = fixedAssetsNbv;
    }

    public long getProvisionForImpairmentOffixedAssets() {
        return provisionForImpairmentOffixedAssets;
    }

    public void setProvisionForImpairmentOffixedAssets(long provisionForImpairmentOffixedAssets) {
        this.provisionForImpairmentOffixedAssets = provisionForImpairmentOffixedAssets;
    }

    public long getFixedAssets() {
        return fixedAssets;
    }

    public void setFixedAssets(long fixedAssets) {
        this.fixedAssets = fixedAssets;
    }

    public long getConstructionInProgress() {
        return constructionInProgress;
    }

    public void setConstructionInProgress(long constructionInProgress) {
        this.constructionInProgress = constructionInProgress;
    }

    public long getConstructionMaterials() {
        return constructionMaterials;
    }

    public void setConstructionMaterials(long constructionMaterials) {
        this.constructionMaterials = constructionMaterials;
    }

    public long getDisposalOfFixedAssets() {
        return disposalOfFixedAssets;
    }

    public void setDisposalOfFixedAssets(long disposalOfFixedAssets) {
        this.disposalOfFixedAssets = disposalOfFixedAssets;
    }

    public long getProductiveBiologicalAssets() {
        return productiveBiologicalAssets;
    }

    public void setProductiveBiologicalAssets(long productiveBiologicalAssets) {
        this.productiveBiologicalAssets = productiveBiologicalAssets;
    }

    public long getPublicWelfareBiologicalAssets() {
        return publicWelfareBiologicalAssets;
    }

    public void setPublicWelfareBiologicalAssets(long publicWelfareBiologicalAssets) {
        this.publicWelfareBiologicalAssets = publicWelfareBiologicalAssets;
    }

    public long getOilAndGasAssets() {
        return oilAndGasAssets;
    }

    public void setOilAndGasAssets(long oilAndGasAssets) {
        this.oilAndGasAssets = oilAndGasAssets;
    }

    public long getIntangibleAssets() {
        return intangibleAssets;
    }

    public void setIntangibleAssets(long intangibleAssets) {
        this.intangibleAssets = intangibleAssets;
    }

    public long getDevelopmentExpenditure() {
        return developmentExpenditure;
    }

    public void setDevelopmentExpenditure(long developmentExpenditure) {
        this.developmentExpenditure = developmentExpenditure;
    }

    public long getGoodwill() {
        return goodwill;
    }

    public void setGoodwill(long goodwill) {
        this.goodwill = goodwill;
    }

    public long getLongTermPrepaidExpenses() {
        return longTermPrepaidExpenses;
    }

    public void setLongTermPrepaidExpenses(long longTermPrepaidExpenses) {
        this.longTermPrepaidExpenses = longTermPrepaidExpenses;
    }

    public long getEquitySplittingAndCirculationRights() {
        return equitySplittingAndCirculationRights;
    }

    public void setEquitySplittingAndCirculationRights(long equitySplittingAndCirculationRights) {
        this.equitySplittingAndCirculationRights = equitySplittingAndCirculationRights;
    }

    public long getDeferredTaxAssets() {
        return deferredTaxAssets;
    }

    public void setDeferredTaxAssets(long deferredTaxAssets) {
        this.deferredTaxAssets = deferredTaxAssets;
    }

    public long getOtherNonCurrentAssets() {
        return otherNonCurrentAssets;
    }

    public void setOtherNonCurrentAssets(long otherNonCurrentAssets) {
        this.otherNonCurrentAssets = otherNonCurrentAssets;
    }

    public long getTotalaNonCurrentAssets() {
        return totalaNonCurrentAssets;
    }

    public void setTotalaNonCurrentAssets(long totalaNonCurrentAssets) {
        this.totalaNonCurrentAssets = totalaNonCurrentAssets;
    }

    public long getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(long totalAssets) {
        this.totalAssets = totalAssets;
    }

    public long getShortTermLoans() {
        return shortTermLoans;
    }

    public void setShortTermLoans(long shortTermLoans) {
        this.shortTermLoans = shortTermLoans;
    }

    public long getBorrowingFromTheCentralBank() {
        return borrowingFromTheCentralBank;
    }

    public void setBorrowingFromTheCentralBank(long borrowingFromTheCentralBank) {
        this.borrowingFromTheCentralBank = borrowingFromTheCentralBank;
    }

    public long getDepositsAndDeposits() {
        return depositsAndDeposits;
    }

    public void setDepositsAndDeposits(long depositsAndDeposits) {
        this.depositsAndDeposits = depositsAndDeposits;
    }

    public long getUnpackingFunds() {
        return unpackingFunds;
    }

    public void setUnpackingFunds(long unpackingFunds) {
        this.unpackingFunds = unpackingFunds;
    }

    public long getTransactionalFinancialLiabilities() {
        return transactionalFinancialLiabilities;
    }

    public void setTransactionalFinancialLiabilities(long transactionalFinancialLiabilities) {
        this.transactionalFinancialLiabilities = transactionalFinancialLiabilities;
    }

    public long getDerivativeFinancialLiabilities() {
        return derivativeFinancialLiabilities;
    }

    public void setDerivativeFinancialLiabilities(long derivativeFinancialLiabilities) {
        this.derivativeFinancialLiabilities = derivativeFinancialLiabilities;
    }

    public long getNotesPayable() {
        return notesPayable;
    }

    public void setNotesPayable(long notesPayable) {
        this.notesPayable = notesPayable;
    }

    public long getAccountsPayable() {
        return accountsPayable;
    }

    public void setAccountsPayable(long accountsPayable) {
        this.accountsPayable = accountsPayable;
    }

    public long getAdvancesFromCustomers() {
        return advancesFromCustomers;
    }

    public void setAdvancesFromCustomers(long advancesFromCustomers) {
        this.advancesFromCustomers = advancesFromCustomers;
    }

    public long getSellingRepurchasedFinancialAssets() {
        return sellingRepurchasedFinancialAssets;
    }

    public void setSellingRepurchasedFinancialAssets(long sellingRepurchasedFinancialAssets) {
        this.sellingRepurchasedFinancialAssets = sellingRepurchasedFinancialAssets;
    }

    public long getFeesAndCommissions() {
        return feesAndCommissions;
    }

    public void setFeesAndCommissions(long feesAndCommissions) {
        this.feesAndCommissions = feesAndCommissions;
    }

    public long getPayrollPayable() {
        return payrollPayable;
    }

    public void setPayrollPayable(long payrollPayable) {
        this.payrollPayable = payrollPayable;
    }

    public long getTaxesPayable() {
        return taxesPayable;
    }

    public void setTaxesPayable(long taxesPayable) {
        this.taxesPayable = taxesPayable;
    }

    public long getInterestPayable() {
        return interestPayable;
    }

    public void setInterestPayable(long interestPayable) {
        this.interestPayable = interestPayable;
    }

    public long getDividendPayable() {
        return dividendPayable;
    }

    public void setDividendPayable(long dividendPayable) {
        this.dividendPayable = dividendPayable;
    }

    public long getOtherPayables() {
        return otherPayables;
    }

    public void setOtherPayables(long otherPayables) {
        this.otherPayables = otherPayables;
    }

    public long getPayableMargin() {
        return payableMargin;
    }

    public void setPayableMargin(long payableMargin) {
        this.payableMargin = payableMargin;
    }

    public long getInternalPayables() {
        return internalPayables;
    }

    public void setInternalPayables(long internalPayables) {
        this.internalPayables = internalPayables;
    }

    public long getOtherAmountsPayable() {
        return otherAmountsPayable;
    }

    public void setOtherAmountsPayable(long otherAmountsPayable) {
        this.otherAmountsPayable = otherAmountsPayable;
    }

    public long getAccruedExpenses() {
        return accruedExpenses;
    }

    public void setAccruedExpenses(long accruedExpenses) {
        this.accruedExpenses = accruedExpenses;
    }

    public long getCurrentLiabilities() {
        return currentLiabilities;
    }

    public void setCurrentLiabilities(long currentLiabilities) {
        this.currentLiabilities = currentLiabilities;
    }

    public long getCopingWithReinsurance() {
        return copingWithReinsurance;
    }

    public void setCopingWithReinsurance(long copingWithReinsurance) {
        this.copingWithReinsurance = copingWithReinsurance;
    }

    public long getInsuranceContractReserve() {
        return insuranceContractReserve;
    }

    public void setInsuranceContractReserve(long insuranceContractReserve) {
        this.insuranceContractReserve = insuranceContractReserve;
    }

    public long getAgentTradingSecurities() {
        return agentTradingSecurities;
    }

    public void setAgentTradingSecurities(long agentTradingSecurities) {
        this.agentTradingSecurities = agentTradingSecurities;
    }

    public long getAgencyUnderwritingSecurities() {
        return agencyUnderwritingSecurities;
    }

    public void setAgencyUnderwritingSecurities(long agencyUnderwritingSecurities) {
        this.agencyUnderwritingSecurities = agencyUnderwritingSecurities;
    }

    public long getInternationalTicketSettlement() {
        return internationalTicketSettlement;
    }

    public void setInternationalTicketSettlement(long internationalTicketSettlement) {
        this.internationalTicketSettlement = internationalTicketSettlement;
    }

    public long getDomesticTicketSettlement() {
        return domesticTicketSettlement;
    }

    public void setDomesticTicketSettlement(long domesticTicketSettlement) {
        this.domesticTicketSettlement = domesticTicketSettlement;
    }

    public long getDeferredIncome() {
        return deferredIncome;
    }

    public void setDeferredIncome(long deferredIncome) {
        this.deferredIncome = deferredIncome;
    }

    public long getCopingWithShortTermBonds() {
        return copingWithShortTermBonds;
    }

    public void setCopingWithShortTermBonds(long copingWithShortTermBonds) {
        this.copingWithShortTermBonds = copingWithShortTermBonds;
    }

    public long getNonCurrentLiabilitiesDueWithinOneYear() {
        return nonCurrentLiabilitiesDueWithinOneYear;
    }

    public void setNonCurrentLiabilitiesDueWithinOneYear(long nonCurrentLiabilitiesDueWithinOneYear) {
        this.nonCurrentLiabilitiesDueWithinOneYear = nonCurrentLiabilitiesDueWithinOneYear;
    }

    public long getOtherCurrentLiabilities() {
        return otherCurrentLiabilities;
    }

    public void setOtherCurrentLiabilities(long otherCurrentLiabilities) {
        this.otherCurrentLiabilities = otherCurrentLiabilities;
    }

    public long getSubTotalOfCurrentLiabilities() {
        return subTotalOfCurrentLiabilities;
    }

    public void setSubTotalOfCurrentLiabilities(long subTotalOfCurrentLiabilities) {
        this.subTotalOfCurrentLiabilities = subTotalOfCurrentLiabilities;
    }

    public long getLongTermBorrowings() {
        return longTermBorrowings;
    }

    public void setLongTermBorrowings(long longTermBorrowings) {
        this.longTermBorrowings = longTermBorrowings;
    }

    public long getBondsPayable() {
        return bondsPayable;
    }

    public void setBondsPayable(long bondsPayable) {
        this.bondsPayable = bondsPayable;
    }

    public long getLongTermPayables() {
        return longTermPayables;
    }

    public void setLongTermPayables(long longTermPayables) {
        this.longTermPayables = longTermPayables;
    }

    public long getSpecialPayables() {
        return specialPayables;
    }

    public void setSpecialPayables(long specialPayables) {
        this.specialPayables = specialPayables;
    }

    public long getNonCurrentLiabilities() {
        return nonCurrentLiabilities;
    }

    public void setNonCurrentLiabilities(long nonCurrentLiabilities) {
        this.nonCurrentLiabilities = nonCurrentLiabilities;
    }

    public long getLongTermDeferredIncome() {
        return longTermDeferredIncome;
    }

    public void setLongTermDeferredIncome(long longTermDeferredIncome) {
        this.longTermDeferredIncome = longTermDeferredIncome;
    }

    public long getDeferredIncomeTaxLiabilities() {
        return deferredIncomeTaxLiabilities;
    }

    public void setDeferredIncomeTaxLiabilities(long deferredIncomeTaxLiabilities) {
        this.deferredIncomeTaxLiabilities = deferredIncomeTaxLiabilities;
    }

    public long getOtherNonCurrentLiabilities() {
        return otherNonCurrentLiabilities;
    }

    public void setOtherNonCurrentLiabilities(long otherNonCurrentLiabilities) {
        this.otherNonCurrentLiabilities = otherNonCurrentLiabilities;
    }

    public long getTotalaNonCurrentLiabilities() {
        return totalaNonCurrentLiabilities;
    }

    public void setTotalaNonCurrentLiabilities(long totalaNonCurrentLiabilities) {
        this.totalaNonCurrentLiabilities = totalaNonCurrentLiabilities;
    }

    public long getTotalLiability() {
        return totalLiability;
    }

    public void setTotalLiability(long totalLiability) {
        this.totalLiability = totalLiability;
    }

    public long getPaidInCapital() {
        return paidInCapital;
    }

    public void setPaidInCapital(long paidInCapital) {
        this.paidInCapital = paidInCapital;
    }

    public long getCapitalSurplus() {
        return capitalSurplus;
    }

    public void setCapitalSurplus(long capitalSurplus) {
        this.capitalSurplus = capitalSurplus;
    }

    public long getTreasuryStock() {
        return treasuryStock;
    }

    public void setTreasuryStock(long treasuryStock) {
        this.treasuryStock = treasuryStock;
    }

    public long getSpecialReserves() {
        return specialReserves;
    }

    public void setSpecialReserves(long specialReserves) {
        this.specialReserves = specialReserves;
    }

    public long getSurplusReserve() {
        return surplusReserve;
    }

    public void setSurplusReserve(long surplusReserve) {
        this.surplusReserve = surplusReserve;
    }

    public long getGeneralRiskPreparation() {
        return generalRiskPreparation;
    }

    public void setGeneralRiskPreparation(long generalRiskPreparation) {
        this.generalRiskPreparation = generalRiskPreparation;
    }

    public long getUndeterminedInvestmentLoss() {
        return undeterminedInvestmentLoss;
    }

    public void setUndeterminedInvestmentLoss(long undeterminedInvestmentLoss) {
        this.undeterminedInvestmentLoss = undeterminedInvestmentLoss;
    }

    public long getUndistributedProfit() {
        return undistributedProfit;
    }

    public void setUndistributedProfit(long undistributedProfit) {
        this.undistributedProfit = undistributedProfit;
    }

    public long getProposedDistributionOfCashDividends() {
        return proposedDistributionOfCashDividends;
    }

    public void setProposedDistributionOfCashDividends(long proposedDistributionOfCashDividends) {
        this.proposedDistributionOfCashDividends = proposedDistributionOfCashDividends;
    }

    public long getForeignCurrencyStatementTranslationDifference() {
        return foreignCurrencyStatementTranslationDifference;
    }

    public void setForeignCurrencyStatementTranslationDifference(long foreignCurrencyStatementTranslationDifference) {
        this.foreignCurrencyStatementTranslationDifference = foreignCurrencyStatementTranslationDifference;
    }

    public long getTotalEquityAttributableToTheParentCompany() {
        return totalEquityAttributableToTheParentCompany;
    }

    public void setTotalEquityAttributableToTheParentCompany(long totalEquityAttributableToTheParentCompany) {
        this.totalEquityAttributableToTheParentCompany = totalEquityAttributableToTheParentCompany;
    }

    public long getMinorityShareholdersEquity() {
        return minorityShareholdersEquity;
    }

    public void setMinorityShareholdersEquity(long minorityShareholdersEquity) {
        this.minorityShareholdersEquity = minorityShareholdersEquity;
    }

    public long getOwnerEquity() {
        return ownerEquity;
    }

    public void setOwnerEquity(long ownerEquity) {
        this.ownerEquity = ownerEquity;
    }

    public long getLiabilitiesAndOwnerEquity() {
        return liabilitiesAndOwnerEquity;
    }

    public void setLiabilitiesAndOwnerEquity(long liabilitiesAndOwnerEquity) {
        this.liabilitiesAndOwnerEquity = liabilitiesAndOwnerEquity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
