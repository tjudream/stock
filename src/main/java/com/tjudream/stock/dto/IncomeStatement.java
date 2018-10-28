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
 * Created by mengxiansen on 2018/10/20.
 * 利润表
 */
@Entity(name = "income")
@DynamicInsert
@DynamicUpdate
public class IncomeStatement {
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
     * 营业总收入(万元)
     */
    @Column(name = "total_operating_income")
    private long totalOperatingIncome;
    /**
     * 营业收入(万元)
     */
    @Column(name = "operating_income")
    private long operatingIncome;
    /**
     * 利息收入(万元)
     */
    @Column(name = "interest_income")
    private long interestIncome;
    /**
     * 已赚保费(万元)
     */
    @Column(name = "earned_premium")
    private long earnedPremium;
    /**
     * 手续费及佣金收入(万元)
     */
    @Column(name = "fee_and_commission_income")
    private long feeAndCommissionIncome;
    /**
     * 房地产销售收入(万元)
     */
    @Column(name = "real_estate_sales_income")
    private long realEstateSalesIncome;
    /**
     * 其他业务收入(万元)
     */
    @Column(name = "other_operating_income")
    private long otherOperatingIncome;
    /**
     * 营业总成本(万元)
     */
    @Column(name = "total_operating_costs")
    private long totalOperatingCosts;
    /**
     * 营业成本(万元)
     */
    @Column(name = "operating_cost")
    private long operatingCost;
    /**
     * 利息支出(万元)
     */
    @Column(name = "interest_expense")
    private long interestExpense;
    /**
     * 手续费及佣金支出(万元)
     */
    @Column(name = "fee_and_commission_expenses")
    private long feeAndCommissionExpenses;
    /**
     * 房地产销售成本(万元)
     */
    @Column(name = "real_estate_sales_cost")
    private long realEstateSalesCost;
    /**
     * 研发费用(万元)
     */
    @Column(name = "research_and_development_costs")
    private long researchAndDevelopmentCosts;
    /**
     * 退保金(万元)
     */
    @Column(name = "surrender_value")
    private long surrenderValue;
    /**
     * 赔付支出净额(万元)
     */
    @Column(name = "net_loss_of_expenditure")
    private long netLossOfExpenditure;
    /**
     * 提取保险合同准备金净额(万元)
     */
    @Column(name = "withdrawal_of_insurance_contract_reserve_net")
    private long withdrawalOfInsuranceContractReserveNet;
    /**
     * 保单红利支出(万元)
     */
    @Column(name = "dividend_payment_policy")
    private long dividendPaymentPolicy;
    /**
     * 分保费用(万元)
     */
    @Column(name = "reinsurance_costs")
    private long reinsuranceCosts;
    /**
     * 其他业务成本(万元)
     */
    @Column(name = "other_operating_costs")
    private long otherOperatingCosts;
    /**
     * 营业税金及附加(万元)
     */
    @Column(name = "business_tax_and_surcharges")
    private long businessTaxAndSurcharges;
    /**
     * 销售费用(万元)
     */
    @Column(name = "sales_expense")
    private long salesExpense;
    /**
     * 管理费用(万元)
     */
    @Column(name = "management_costs")
    private long managementCosts;
    /**
     * 财务费用(万元)
     */
    @Column(name = "financial_expenses")
    private long financialExpenses;
    /**
     * 资产减值损失(万元)
     */
    @Column(name = "asset_impairment_loss")
    private long assetImpairmentLoss;
    /**
     * 公允价值变动收益(万元)
     */
    @Column(name = "fair_value_change_income")
    private long fairValueChangeIncome;
    /**
     * 投资收益(万元)
     */
    @Column(name = "investment_income")
    private long investmentIncome;
    /**
     * 对联营企业和合营企业的投资收益(万元)
     */
    @Column(name = "investment_income_in_associates_and_joint_ventures")
    private long investmentIncomeInAssociatesAndJointVentures;
    /**
     * 汇兑收益(万元)
     */
    @Column(name = "exchange_gains")
    private long exchangeGains;
    /**
     * 期货损益(万元)
     */
    @Column(name = "futures_profit_and_loss")
    private long futuresProfitAndLoss;
    /**
     * 托管收益(万元)
     */
    @Column(name = "managed_income")
    private long managedIncome;
    /**
     * 补贴收入(万元)
     */
    @Column(name = "subsidy_income")
    private long subsidyIncome;
    /**
     * 其他业务利润(万元)
     */
    @Column(name = "other_business_profits")
    private long otherBusinessProfits;
    /**
     * 营业利润(万元)
     */
    @Column(name = "operating_profit")
    private long operatingProfit;
    /**
     * 营业外收入(万元)
     */
    @Column(name = "non_operating_income")
    private long nonOperatingIncome;
    /**
     * 营业外支出(万元)
     */
    @Column(name = "operating_expenses")
    private long operatingExpenses;
    /**
     * 非流动资产处置损失(万元)
     */
    @Column(name = "loss_on_disposal_of_non_current_assets")
    private long lossOnDisposalOfNonCurrentAssets;
    /**
     * 利润总额(万元)
     */
    @Column(name = "total_profit")
    private long totalProfit;
    /**
     * 所得税费用(万元)
     */
    @Column(name = "income_tax_expense")
    private long incomeTaxExpense;
    /**
     * 未确认投资损失(万元)
     */
    @Column(name = "unconfirmed_investment_loss")
    private long unconfirmedInvestmentLoss;
    /**
     * 净利润(万元)
     */
    @Column(name = "net_profit")
    private long netProfit;
    /**
     * 归属于母公司所有者的净利润(万元)
     */
    @Column(name = "the_retained_profits_belong_to_the_parent_company_owner")
    private long theRetainedProfitsBelongToTheParentCompanyOwner;
    /**
     * 被合并方在合并前实现净利润(万元)
     */
    @Column(name = "the_merged_party_realizes_net_profit_before_the_merger")
    private long theMergedPartyRealizesNetProfitBeforeTheMerger;
    /**
     * 少数股东损益(万元)
     */
    @Column(name = "minority_shareholder_gains_and_losses")
    private long minorityShareholderGainsAndLosses;
    /**
     * 基本每股收益
     */
    @Column(name = "basic_earnings_per_share")
    private long basicEarningsPerShare;
    /**
     * 稀释每股收益
     */
    @Column(name = "diluted_earnings_per_share")
    private long dilutedEarningsPerShare;

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

    public long getTotalOperatingIncome() {
        return totalOperatingIncome;
    }

    public void setTotalOperatingIncome(long totalOperatingIncome) {
        this.totalOperatingIncome = totalOperatingIncome;
    }

    public long getOperatingIncome() {
        return operatingIncome;
    }

    public void setOperatingIncome(long operatingIncome) {
        this.operatingIncome = operatingIncome;
    }

    public long getInterestIncome() {
        return interestIncome;
    }

    public void setInterestIncome(long interestIncome) {
        this.interestIncome = interestIncome;
    }

    public long getEarnedPremium() {
        return earnedPremium;
    }

    public void setEarnedPremium(long earnedPremium) {
        this.earnedPremium = earnedPremium;
    }

    public long getFeeAndCommissionIncome() {
        return feeAndCommissionIncome;
    }

    public void setFeeAndCommissionIncome(long feeAndCommissionIncome) {
        this.feeAndCommissionIncome = feeAndCommissionIncome;
    }

    public long getRealEstateSalesIncome() {
        return realEstateSalesIncome;
    }

    public void setRealEstateSalesIncome(long realEstateSalesIncome) {
        this.realEstateSalesIncome = realEstateSalesIncome;
    }

    public long getOtherOperatingIncome() {
        return otherOperatingIncome;
    }

    public void setOtherOperatingIncome(long otherOperatingIncome) {
        this.otherOperatingIncome = otherOperatingIncome;
    }

    public long getTotalOperatingCosts() {
        return totalOperatingCosts;
    }

    public void setTotalOperatingCosts(long totalOperatingCosts) {
        this.totalOperatingCosts = totalOperatingCosts;
    }

    public long getOperatingCost() {
        return operatingCost;
    }

    public void setOperatingCost(long operatingCost) {
        this.operatingCost = operatingCost;
    }

    public long getInterestExpense() {
        return interestExpense;
    }

    public void setInterestExpense(long interestExpense) {
        this.interestExpense = interestExpense;
    }

    public long getFeeAndCommissionExpenses() {
        return feeAndCommissionExpenses;
    }

    public void setFeeAndCommissionExpenses(long feeAndCommissionExpenses) {
        this.feeAndCommissionExpenses = feeAndCommissionExpenses;
    }

    public long getRealEstateSalesCost() {
        return realEstateSalesCost;
    }

    public void setRealEstateSalesCost(long realEstateSalesCost) {
        this.realEstateSalesCost = realEstateSalesCost;
    }

    public long getResearchAndDevelopmentCosts() {
        return researchAndDevelopmentCosts;
    }

    public void setResearchAndDevelopmentCosts(long researchAndDevelopmentCosts) {
        this.researchAndDevelopmentCosts = researchAndDevelopmentCosts;
    }

    public long getSurrenderValue() {
        return surrenderValue;
    }

    public void setSurrenderValue(long surrenderValue) {
        this.surrenderValue = surrenderValue;
    }

    public long getNetLossOfExpenditure() {
        return netLossOfExpenditure;
    }

    public void setNetLossOfExpenditure(long netLossOfExpenditure) {
        this.netLossOfExpenditure = netLossOfExpenditure;
    }

    public long getWithdrawalOfInsuranceContractReserveNet() {
        return withdrawalOfInsuranceContractReserveNet;
    }

    public void setWithdrawalOfInsuranceContractReserveNet(long withdrawalOfInsuranceContractReserveNet) {
        this.withdrawalOfInsuranceContractReserveNet = withdrawalOfInsuranceContractReserveNet;
    }

    public long getDividendPaymentPolicy() {
        return dividendPaymentPolicy;
    }

    public void setDividendPaymentPolicy(long dividendPaymentPolicy) {
        this.dividendPaymentPolicy = dividendPaymentPolicy;
    }

    public long getReinsuranceCosts() {
        return reinsuranceCosts;
    }

    public void setReinsuranceCosts(long reinsuranceCosts) {
        this.reinsuranceCosts = reinsuranceCosts;
    }

    public long getOtherOperatingCosts() {
        return otherOperatingCosts;
    }

    public void setOtherOperatingCosts(long otherOperatingCosts) {
        this.otherOperatingCosts = otherOperatingCosts;
    }

    public long getBusinessTaxAndSurcharges() {
        return businessTaxAndSurcharges;
    }

    public void setBusinessTaxAndSurcharges(long businessTaxAndSurcharges) {
        this.businessTaxAndSurcharges = businessTaxAndSurcharges;
    }

    public long getSalesExpense() {
        return salesExpense;
    }

    public void setSalesExpense(long salesExpense) {
        this.salesExpense = salesExpense;
    }

    public long getManagementCosts() {
        return managementCosts;
    }

    public void setManagementCosts(long managementCosts) {
        this.managementCosts = managementCosts;
    }

    public long getFinancialExpenses() {
        return financialExpenses;
    }

    public void setFinancialExpenses(long financialExpenses) {
        this.financialExpenses = financialExpenses;
    }

    public long getAssetImpairmentLoss() {
        return assetImpairmentLoss;
    }

    public void setAssetImpairmentLoss(long assetImpairmentLoss) {
        this.assetImpairmentLoss = assetImpairmentLoss;
    }

    public long getFairValueChangeIncome() {
        return fairValueChangeIncome;
    }

    public void setFairValueChangeIncome(long fairValueChangeIncome) {
        this.fairValueChangeIncome = fairValueChangeIncome;
    }

    public long getInvestmentIncome() {
        return investmentIncome;
    }

    public void setInvestmentIncome(long investmentIncome) {
        this.investmentIncome = investmentIncome;
    }

    public long getInvestmentIncomeInAssociatesAndJointVentures() {
        return investmentIncomeInAssociatesAndJointVentures;
    }

    public void setInvestmentIncomeInAssociatesAndJointVentures(long investmentIncomeInAssociatesAndJointVentures) {
        this.investmentIncomeInAssociatesAndJointVentures = investmentIncomeInAssociatesAndJointVentures;
    }

    public long getExchangeGains() {
        return exchangeGains;
    }

    public void setExchangeGains(long exchangeGains) {
        this.exchangeGains = exchangeGains;
    }

    public long getFuturesProfitAndLoss() {
        return futuresProfitAndLoss;
    }

    public void setFuturesProfitAndLoss(long futuresProfitAndLoss) {
        this.futuresProfitAndLoss = futuresProfitAndLoss;
    }

    public long getManagedIncome() {
        return managedIncome;
    }

    public void setManagedIncome(long managedIncome) {
        this.managedIncome = managedIncome;
    }

    public long getSubsidyIncome() {
        return subsidyIncome;
    }

    public void setSubsidyIncome(long subsidyIncome) {
        this.subsidyIncome = subsidyIncome;
    }

    public long getOtherBusinessProfits() {
        return otherBusinessProfits;
    }

    public void setOtherBusinessProfits(long otherBusinessProfits) {
        this.otherBusinessProfits = otherBusinessProfits;
    }

    public long getOperatingProfit() {
        return operatingProfit;
    }

    public void setOperatingProfit(long operatingProfit) {
        this.operatingProfit = operatingProfit;
    }

    public long getNonOperatingIncome() {
        return nonOperatingIncome;
    }

    public void setNonOperatingIncome(long nonOperatingIncome) {
        this.nonOperatingIncome = nonOperatingIncome;
    }

    public long getOperatingExpenses() {
        return operatingExpenses;
    }

    public void setOperatingExpenses(long operatingExpenses) {
        this.operatingExpenses = operatingExpenses;
    }

    public long getLossOnDisposalOfNonCurrentAssets() {
        return lossOnDisposalOfNonCurrentAssets;
    }

    public void setLossOnDisposalOfNonCurrentAssets(long lossOnDisposalOfNonCurrentAssets) {
        this.lossOnDisposalOfNonCurrentAssets = lossOnDisposalOfNonCurrentAssets;
    }

    public long getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(long totalProfit) {
        this.totalProfit = totalProfit;
    }

    public long getIncomeTaxExpense() {
        return incomeTaxExpense;
    }

    public void setIncomeTaxExpense(long incomeTaxExpense) {
        this.incomeTaxExpense = incomeTaxExpense;
    }

    public long getUnconfirmedInvestmentLoss() {
        return unconfirmedInvestmentLoss;
    }

    public void setUnconfirmedInvestmentLoss(long unconfirmedInvestmentLoss) {
        this.unconfirmedInvestmentLoss = unconfirmedInvestmentLoss;
    }

    public long getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(long netProfit) {
        this.netProfit = netProfit;
    }

    public long getTheRetainedProfitsBelongToTheParentCompanyOwner() {
        return theRetainedProfitsBelongToTheParentCompanyOwner;
    }

    public void setTheRetainedProfitsBelongToTheParentCompanyOwner(
            long theRetainedProfitsBelongToTheParentCompanyOwner) {
        this.theRetainedProfitsBelongToTheParentCompanyOwner = theRetainedProfitsBelongToTheParentCompanyOwner;
    }

    public long getTheMergedPartyRealizesNetProfitBeforeTheMerger() {
        return theMergedPartyRealizesNetProfitBeforeTheMerger;
    }

    public void setTheMergedPartyRealizesNetProfitBeforeTheMerger(long theMergedPartyRealizesNetProfitBeforeTheMerger) {
        this.theMergedPartyRealizesNetProfitBeforeTheMerger = theMergedPartyRealizesNetProfitBeforeTheMerger;
    }

    public long getMinorityShareholderGainsAndLosses() {
        return minorityShareholderGainsAndLosses;
    }

    public void setMinorityShareholderGainsAndLosses(long minorityShareholderGainsAndLosses) {
        this.minorityShareholderGainsAndLosses = minorityShareholderGainsAndLosses;
    }

    public long getBasicEarningsPerShare() {
        return basicEarningsPerShare;
    }

    public void setBasicEarningsPerShare(long basicEarningsPerShare) {
        this.basicEarningsPerShare = basicEarningsPerShare;
    }

    public long getDilutedEarningsPerShare() {
        return dilutedEarningsPerShare;
    }

    public void setDilutedEarningsPerShare(long dilutedEarningsPerShare) {
        this.dilutedEarningsPerShare = dilutedEarningsPerShare;
    }
}
