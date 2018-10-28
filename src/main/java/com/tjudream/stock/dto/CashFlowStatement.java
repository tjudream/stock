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
 * 现金流量表
 */
@Entity(name = "cash_flow")
@DynamicInsert
@DynamicUpdate
public class CashFlowStatement {
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
     * 销售商品、提供劳务收到的现金(万元)
     */
    @Column(name = "cash_received_for_the_sale_of_goods_and_services")
    private long cashReceivedForTheSaleOfGoodsAndServices;
    /**
     * 客户存款和同业存放款项净增加额(万元)
     */
    @Column(name = "net_increase_in_customer_deposits_and_interbank_deposits")
    private long netIncreaseInCustomerDepositsAndInterbankDeposits;
    /**
     * 向中央银行借款净增加额(万元
     */
    @Column(name = "net_increase_in_borrowing_from_central_bank")
    private long netIncreaseInBorrowingFromCentralBank;
    /**
     * 向其他金融机构拆入资金净增加额(万元)
     */
    @Column(name = "net_increase_in_funds_disbursed_to_other_financial_institutions")
    private long netIncreaseInFundsDisbursedToOtherFinancialInstitutions;
    /**
     * 收到原保险合同保费取得的现金(万元)
     */
    @Column(name = "cash_received_from_the_original_insurance_contract_premium")
    private long cashReceivedFromTheOriginalInsuranceContractPremium;
    /**
     * 收到再保险业务现金净额(万元)
     */
    @Column(name = "net_cash_received_from_reinsurance_business")
    private long netCashReceivedFromReinsuranceBusiness;
    /**
     * 保户储金及投资款净增加额(万元)
     */
    @Column(name = "net_increase_in_policyholders_deposits_and_investment_funds")
    private long netIncreaseInPolicyholdersDepositsAndInvestmentFunds;
    /**
     * 处置交易性金融资产净增加额(万元)
     */
    @Column(name = "disposal_of_net_increase_in_trading_financial_assets")
    private long disposalOfNetIncreaseInTradingFinancialAssets;
    /**
     * 收取利息、手续费及佣金的现金(万元)
     */
    @Column(name = "cash_for_interest_commission_and_commission")
    private long cashForInterestCommissionAndCommission;
    /**
     * 拆入资金净增加额(万元)
     */
    @Column(name = "net_increase_in_funds_disbursed")
    private long netIncreaseInFundsDisbursed;
    /**
     * 回购业务资金净增加额(万元)
     */
    @Column(name = "net_increase_in_repurchase_business_funds")
    private long netIncreaseInRepurchaseBusinessFunds;
    /**
     * 收到的税费返还(万元)
     */
    @Column(name = "tax_refund")
    private long taxRefund;
    /**
     * 收到的其他与经营活动有关的现金(万元)
     */
    @Column(name = "other_cash_received_related_to_operating_activities")
    private long otherCashReceivedRelatedToOperatingActivities;
    /**
     * 经营活动现金流入小计(万元)
     */
    @Column(name = "subtotal_of_cash_inflow_from_operating_activities")
    private long subtotalOfCashInflowFromOperatingActivities;

    /**
     * 购买商品、接受劳务支付的现金(万元)
     */
    @Column(name = "cash_paid_for_the_purchase_of_goods_and_services")
    private long cashPaidForThePurchaseOfGoodsAndServices;
    /**
     * 客户贷款及垫款净增加额(万元)
     */
    @Column(name = "net_increase_in_customer_loans_and_advances")
    private long netIncreaseInCustomerLoansAndAdvances;
    /**
     * 存放中央银行和同业款项净增加额(万元)
     */
    @Column(name = "deposit_of_net_increase_in_central_bank_and_interbank_payments")
    private long depositOfNetIncreaseInCentralBankAndInterbankPayments;
    /**
     * 支付原保险合同赔付款项的现金(万元)
     */
    @Column(name = "pay_the_cash_of_the_original_insurance_contract_payment")
    private long payTheCashOfTheOriginalInsuranceContractPayment;
    /**
     * 支付利息、手续费及佣金的现金(万元)
     */
    @Column(name = "pay_interest_commission_and_commission_cash")
    private long payInterestCommissionAndCommissionCash;
    /**
     * 支付保单红利的现金(万元)
     */
    @Column(name = "cash_paid_for_policy_dividends")
    private long cashPaidForPolicyDividends;
    /**
     * 支付给职工以及为职工支付的现金(万元)
     */
    @Column(name = "cash_paid_to_employees_and_paid_to_employees")
    private long cashPaidToEmployeesAndPaidToEmployees;
    /**
     * 支付的各项税费(万元)
     */
    @Column(name = "various_taxes_paid")
    private long variousTaxesPaid;
    /**
     * 支付的其他与经营活动有关的现金(万元)
     */
    @Column(name = "other_cash_paid_in_connection_with_operating_activities")
    private long otherCashPaidInConnectionWithOperatingActivities;
    /**
     * 经营活动现金流出小计(万元)
     */
    @Column(name = "subtotal_of_cash_outflow_from_operating_activities")
    private long subtotalOfCashOutflowFromOperatingActivities;
    /**
     * 经营活动产生的现金流量净额(万元)
     */
    @Column(name = "net_cash_flow_from_operating_activities")
    private long netCashFlowFromOperatingActivities;
    /**
     * 收回投资所收到的现金(万元)
     */
    @Column(name = "cash_received_from_the_investment")
    private long cashReceivedFromTheInvestment;
    /**
     * 取得投资收益所收到的现金(万元)
     */
    @Column(name = "cash_received_from_investment_income")
    private long cashReceivedFromInvestmentIncome;
    /**
     * 处置固定资产、无形资产和其他长期资产所收回的现金净额(万元)
     */
    @Column(name = "net_cash_assets")
    private long netCashAssets;
    /**
     * 处置子公司及其他营业单位收到的现金净额(万元)
     */
    @Column(name = "net_cash_other_business_units")
    private long netCashOtherBusinessUnits;
    /**
     * 收到的其他与投资活动有关的现金(万元)
     */
    @Column(name = "other_cash_received_related_to_investment_activities")
    private long otherCashReceivedRelatedToInvestmentActivities;
    /**
     * 减少质押和定期存款所收到的现金(万元)
     */
    @Column(name = "reduce_cash_received_from_pledges_and_time_deposits")
    private long reduceCashReceivedFromPledgesAndTimeDeposits;
    /**
     * 投资活动现金流入小计(万元)
     */
    @Column(name = "subtotal_of_cash_inflows_from_investment_activities")
    private long subtotalOfCashInflowsFromInvestmentActivities;
    /**
     * 购建固定资产、无形资产和其他长期资产所支付的现金(万元)
     */
    @Column(name = "cash_paid_for_the_purchase_and_construction_of_assets")
    private long cashPaidForThePurchaseAndConstructionOfAssets;
    /**
     * 投资所支付的现金(万元)
     */
    @Column(name = "cash_paid_by_the_investment")
    private long cashPaidByTheInvestment;
    /**
     * 质押贷款净增加额(万元)
     */
    @Column(name = "net_increase_in_pledge_loans")
    private long netIncreaseInPledgeLoans;
    /**
     * 取得子公司及其他营业单位支付的现金净额(万元)
     */
    @Column(name = "net_cash_paid_by_subsidiaries_and_other_business_units")
    private long netCashPaidBySubsidiariesAndOtherBusinessUnits;
    /**
     * 支付的其他与投资活动有关的现金(万元)
     */
    @Column(name = "other_cash_paid_for_investment_activities")
    private long otherCashPaidForInvestmentActivities;
    /**
     * 增加质押和定期存款所支付的现金(万元)
     */
    @Column(name = "increase_cash_paid_for_pledges_and_time_deposits")
    private long increaseCashPaidForPledgesAndTimeDeposits;
    /**
     * 投资活动现金流出小计(万元)
     */
    @Column(name = "subtotal_of_cash_outflows_from_investment_activities")
    private long subtotalOfCashOutflowsFromInvestmentActivities;
    /**
     * 投资活动产生的现金流量净额(万元)
     */
    @Column(name = "net_cash_flows_from_investing_activities")
    private long netCashFlowsFromInvestingActivities;
    /**
     * 吸收投资收到的现金(万元)
     */
    @Column(name = "absorb_cash_received_from_investment")
    private long absorbCashReceivedFromInvestment;
    /**
     * 其中：子公司吸收少数股东投资收到的现金(万元)
     */
    @Column(name = "subsidiaries_investments")
    private long subsidiariesInvestments;
    /**
     * 取得借款收到的现金(万元)
     */
    @Column(name = "cash_received_from_the_loan")
    private long cashReceivedFromTheLoan;
    /**
     * 发行债券收到的现金(万元)
     */
    @Column(name = "cashReceivedFromTheIssuanceOfBonds")
    private long cashReceivedFromTheIssuanceOfBonds;
    /**
     * 收到其他与筹资活动有关的现金(万元)
     */
    @Column(name = "received_other_cash_related_to_fundraising_activities")
    private long receivedOtherCashRelatedToFundraisingActivities;
    /**
     * 筹资活动现金流入小计(万元)
     */
    @Column(name = "subtotal_of_cash_inflows_from_financing_activities")
    private long subtotalOfCashInflowsFromFinancingActivities;
    /**
     * 偿还债务支付的现金(万元)
     */
    @Column(name = "cash_paid_for_debt_repayment")
    private long cashPaidForDebtRepayment;
    /**
     * 分配股利、利润或偿付利息所支付的现金(万元)
     */
    @Column(name = "cash_paid_for_dividends_profits_or_interest_payments")
    private long cashPaidForDividendsProfitsOrInterestPayments;
    /**
     * 其中：子公司支付给少数股东的股利、利润(万元)
     */
    @Column(name = "dividends_paid_by_subsidiaries")
    private long dividendsPaidBySubsidiaries;
    /**
     * 支付其他与筹资活动有关的现金(万元)
     */
    @Column(name = "pay_other_cash_related_to_fundraising_activities")
    private long payOtherCashRelatedToFundraisingActivities;
    /**
     * 筹资活动现金流出小计(万元)
     */
    @Column(name = "subtotal_of_cash_outflows_from_financing_activities")
    private long subtotalOfCashOutflowsFromFinancingActivities;
    /**
     * 筹资活动产生的现金流量净额(万元)
     */
    @Column(name = "net_cash_flow_from_financing_activities")
    private long netCashFlowFromFinancingActivities;
    /**
     * 汇率变动对现金及现金等价物的影响(万元)
     */
    @Column(name = "effect_changes_cash_equivalents")
    private long effectChangesCashEquivalents;
    /**
     * 现金及现金等价物净增加额(万元)
     */
    @Column(name = "net_increase_in_cash_and_cash_equivalents")
    private long netIncreaseInCashAndCashEquivalents;
    /**
     * 加:期初现金及现金等价物余额(万元)
     */
    @Column(name = "cash_and_cash_equivalents_at_the_beginning_of_the_period")
    private long cashAndCashEquivalentsAtTheBeginningOfThePeriod;
    /**
     * 期末现金及现金等价物余额(万元)
     */
    @Column(name = "final_cash_and_cash_equivalent_balance")
    private long finalCashAndCashEquivalentBalance;
    /**
     * 净利润(万元)
     */
    @Column(name = "net_profit")
    private long netProfit;
    /**
     * 少数股东损益(万元)
     */
    @Column(name = "minority_shareholder_gains_and_losses")
    private long minorityShareholderGainsAndLosses;
    /**
     * 未确认的投资损失(万元)
     */
    @Column(name = "unconfirmed_investment_loss")
    private long unconfirmedInvestmentLoss;
    /**
     * 资产减值准备(万元)
     */
    @Column(name = "impairment_of_assets")
    private long impairmentOfAssets;
    /**
     * 固定资产折旧、油气资产折耗、生产性物资折旧(万元)
     */
    @Column(name = "depreciation_of_fixed_assets")
    private long depreciationOfFixedAssets;
    /**
     * 无形资产摊销(万元)
     */
    @Column(name = "amortization_of_intangible_assets")
    private long amortizationOfIntangibleAssets;
    /**
     * 长期待摊费用摊销(万元)
     */
    @Column(name = "long_term_deferred_expenses_amortization")
    private long longTermDeferredExpensesAmortization;
    /**
     * 待摊费用的减少(万元)
     */
    @Column(name = "reduction_of_deferred_expenses")
    private long reductionOfDeferredExpenses;
    /**
     * 预提费用的增加(万元)
     */
    @Column(name = "increase_in_accrued_expenses")
    private long increaseInAccruedExpenses;
    /**
     * 处置固定资产、无形资产和其他长期资产的损失(万元)
     */
    @Column(name = "disposal_of_fixed_assets")
    private long disposalOfFixedAssets;
    /**
     * 固定资产报废损失(万元)
     */
    @Column(name = "fixed_asset_retirement_loss")
    private long fixedAssetRetirementLoss;
    /**
     * 公允价值变动损失(万元)
     */
    @Column(name = "loss_of_fair_value")
    private long lossOfFairValue;
    /**
     * 递延收益增加(减：减少)(万元)
     */
    @Column(name = "deferred_income_increase")
    private long deferredIncomeIncrease;
    /**
     * 预计负债(万元)
     */
    @Column(name = "estimated_liabilities")
    private long estimatedLiabilities;
    /**
     * 财务费用(万元)
     */
    @Column(name = "financial_expenses")
    private long financialExpenses;
    /**
     * 投资损失(万元)
     */
    @Column(name = "investment_loss")
    private long investmentLoss;
    /**
     * 递延所得税资产减少(万元)
     */
    @Column(name = "deferred_income_tax_assets_decreased")
    private long deferredIncomeTaxAssetsDecreased;
    /**
     * 递延所得税负债增加(万元)
     */
    @Column(name = "deferred_income_tax_liabilities_increased")
    private long deferredIncomeTaxLiabilitiesIncreased;
    /**
     * 存货的减少(万元)
     */
    @Column(name = "reduction_in_inventory")
    private long reductionInInventory;
    /**
     * 经营性应收项目的减少(万元)
     */
    @Column(name = "reduction_of_operational_receivables")
    private long reductionOfOperationalReceivables;
    /**
     * 经营性应付项目的增加(万元)
     */
    @Column(name = "increase_in_operational_payables")
    private long increaseInOperationalPayables;
    /**
     * 已完工尚未结算款的减少(减:增加)(万元)
     */
    @Column(name = "reduced_outstanding_settlements")
    private long reducedOutstandingSettlements;
    /**
     * 已结算尚未完工款的增加(减:减少)(万元)
     */
    @Column(name = "increased_settlement_of_outstanding_work")
    private long increasedSettlementOfOutstandingWork;
    /**
     * 其他(万元)
     */
    @Column(name = "other")
    private long other;
    /**
     * 经营活动产生现金流量净额(万元)
     */
    @Column(name = "net_cash_flow_from_operating_activities_2")
    private long netCashFlowFromOperatingActivities2;
    /**
     * 债务转为资本(万元)
     */
    @Column(name = "conversion_of_debt_into_capital")
    private long conversionOfDebtIntoCapital;
    /**
     * 一年内到期的可转换公司债券(万元)
     */
    @Column(name = "convertible_corporate_bonds_due_within_one_year")
    private long convertibleCorporateBondsDueWithinOneYear;
    /**
     * 融资租入固定资产(万元)
     */
    @Column(name = "financing_leased_fixed_assets")
    private long financingLeasedFixedAssets;
    /**
     * 现金的期末余额(万元)
     */
    @Column(name = "ending_balance_of_cash")
    private long endingBalanceOfCash;
    /**
     * 现金的期初余额(万元)
     */
    @Column(name = "cash_beginning_balance")
    private long cashBeginningBalance;
    /**
     * 现金等价物的期末余额(万元)
     */
    @Column(name = "ending_balance_of_cash_equivalents")
    private long endingBalanceOfCashEquivalents;
    /**
     * 现金等价物的期初余额(万元)
     */
    @Column(name = "opening_balance_of_cash_equivalents")
    private long openingBalanceOfCashEquivalents;
    /**
     * 现金及现金等价物的净增加额(万元)
     */
    @Column(name = "net_increase_in_cash_and_cash_equivalents_2")
    private long netIncreaseInCashAndCashEquivalents2;

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

    public long getCashReceivedForTheSaleOfGoodsAndServices() {
        return cashReceivedForTheSaleOfGoodsAndServices;
    }

    public void setCashReceivedForTheSaleOfGoodsAndServices(long cashReceivedForTheSaleOfGoodsAndServices) {
        this.cashReceivedForTheSaleOfGoodsAndServices = cashReceivedForTheSaleOfGoodsAndServices;
    }

    public long getNetIncreaseInCustomerDepositsAndInterbankDeposits() {
        return netIncreaseInCustomerDepositsAndInterbankDeposits;
    }

    public void setNetIncreaseInCustomerDepositsAndInterbankDeposits(
            long netIncreaseInCustomerDepositsAndInterbankDeposits) {
        this.netIncreaseInCustomerDepositsAndInterbankDeposits = netIncreaseInCustomerDepositsAndInterbankDeposits;
    }

    public long getNetIncreaseInBorrowingFromCentralBank() {
        return netIncreaseInBorrowingFromCentralBank;
    }

    public void setNetIncreaseInBorrowingFromCentralBank(long netIncreaseInBorrowingFromCentralBank) {
        this.netIncreaseInBorrowingFromCentralBank = netIncreaseInBorrowingFromCentralBank;
    }

    public long getNetIncreaseInFundsDisbursedToOtherFinancialInstitutions() {
        return netIncreaseInFundsDisbursedToOtherFinancialInstitutions;
    }

    public void setNetIncreaseInFundsDisbursedToOtherFinancialInstitutions(
            long netIncreaseInFundsDisbursedToOtherFinancialInstitutions) {
        this.netIncreaseInFundsDisbursedToOtherFinancialInstitutions =
                netIncreaseInFundsDisbursedToOtherFinancialInstitutions;
    }

    public long getCashReceivedFromTheOriginalInsuranceContractPremium() {
        return cashReceivedFromTheOriginalInsuranceContractPremium;
    }

    public void setCashReceivedFromTheOriginalInsuranceContractPremium(
            long cashReceivedFromTheOriginalInsuranceContractPremium) {
        this.cashReceivedFromTheOriginalInsuranceContractPremium = cashReceivedFromTheOriginalInsuranceContractPremium;
    }

    public long getNetCashReceivedFromReinsuranceBusiness() {
        return netCashReceivedFromReinsuranceBusiness;
    }

    public void setNetCashReceivedFromReinsuranceBusiness(long netCashReceivedFromReinsuranceBusiness) {
        this.netCashReceivedFromReinsuranceBusiness = netCashReceivedFromReinsuranceBusiness;
    }

    public long getNetIncreaseInPolicyholdersDepositsAndInvestmentFunds() {
        return netIncreaseInPolicyholdersDepositsAndInvestmentFunds;
    }

    public void setNetIncreaseInPolicyholdersDepositsAndInvestmentFunds(
            long netIncreaseInPolicyholdersDepositsAndInvestmentFunds) {
        this.netIncreaseInPolicyholdersDepositsAndInvestmentFunds =
                netIncreaseInPolicyholdersDepositsAndInvestmentFunds;
    }

    public long getDisposalOfNetIncreaseInTradingFinancialAssets() {
        return disposalOfNetIncreaseInTradingFinancialAssets;
    }

    public void setDisposalOfNetIncreaseInTradingFinancialAssets(long disposalOfNetIncreaseInTradingFinancialAssets) {
        this.disposalOfNetIncreaseInTradingFinancialAssets = disposalOfNetIncreaseInTradingFinancialAssets;
    }

    public long getCashForInterestCommissionAndCommission() {
        return cashForInterestCommissionAndCommission;
    }

    public void setCashForInterestCommissionAndCommission(long cashForInterestCommissionAndCommission) {
        this.cashForInterestCommissionAndCommission = cashForInterestCommissionAndCommission;
    }

    public long getNetIncreaseInFundsDisbursed() {
        return netIncreaseInFundsDisbursed;
    }

    public void setNetIncreaseInFundsDisbursed(long netIncreaseInFundsDisbursed) {
        this.netIncreaseInFundsDisbursed = netIncreaseInFundsDisbursed;
    }

    public long getNetIncreaseInRepurchaseBusinessFunds() {
        return netIncreaseInRepurchaseBusinessFunds;
    }

    public void setNetIncreaseInRepurchaseBusinessFunds(long netIncreaseInRepurchaseBusinessFunds) {
        this.netIncreaseInRepurchaseBusinessFunds = netIncreaseInRepurchaseBusinessFunds;
    }

    public long getTaxRefund() {
        return taxRefund;
    }

    public void setTaxRefund(long taxRefund) {
        this.taxRefund = taxRefund;
    }

    public long getOtherCashReceivedRelatedToOperatingActivities() {
        return otherCashReceivedRelatedToOperatingActivities;
    }

    public void setOtherCashReceivedRelatedToOperatingActivities(long otherCashReceivedRelatedToOperatingActivities) {
        this.otherCashReceivedRelatedToOperatingActivities = otherCashReceivedRelatedToOperatingActivities;
    }

    public long getSubtotalOfCashInflowFromOperatingActivities() {
        return subtotalOfCashInflowFromOperatingActivities;
    }

    public void setSubtotalOfCashInflowFromOperatingActivities(long subtotalOfCashInflowFromOperatingActivities) {
        this.subtotalOfCashInflowFromOperatingActivities = subtotalOfCashInflowFromOperatingActivities;
    }

    public long getCashPaidForThePurchaseOfGoodsAndServices() {
        return cashPaidForThePurchaseOfGoodsAndServices;
    }

    public void setCashPaidForThePurchaseOfGoodsAndServices(long cashPaidForThePurchaseOfGoodsAndServices) {
        this.cashPaidForThePurchaseOfGoodsAndServices = cashPaidForThePurchaseOfGoodsAndServices;
    }

    public long getNetIncreaseInCustomerLoansAndAdvances() {
        return netIncreaseInCustomerLoansAndAdvances;
    }

    public void setNetIncreaseInCustomerLoansAndAdvances(long netIncreaseInCustomerLoansAndAdvances) {
        this.netIncreaseInCustomerLoansAndAdvances = netIncreaseInCustomerLoansAndAdvances;
    }

    public long getDepositOfNetIncreaseInCentralBankAndInterbankPayments() {
        return depositOfNetIncreaseInCentralBankAndInterbankPayments;
    }

    public void setDepositOfNetIncreaseInCentralBankAndInterbankPayments(
            long depositOfNetIncreaseInCentralBankAndInterbankPayments) {
        this.depositOfNetIncreaseInCentralBankAndInterbankPayments =
                depositOfNetIncreaseInCentralBankAndInterbankPayments;
    }

    public long getPayTheCashOfTheOriginalInsuranceContractPayment() {
        return payTheCashOfTheOriginalInsuranceContractPayment;
    }

    public void setPayTheCashOfTheOriginalInsuranceContractPayment(
            long payTheCashOfTheOriginalInsuranceContractPayment) {
        this.payTheCashOfTheOriginalInsuranceContractPayment = payTheCashOfTheOriginalInsuranceContractPayment;
    }

    public long getPayInterestCommissionAndCommissionCash() {
        return payInterestCommissionAndCommissionCash;
    }

    public void setPayInterestCommissionAndCommissionCash(long payInterestCommissionAndCommissionCash) {
        this.payInterestCommissionAndCommissionCash = payInterestCommissionAndCommissionCash;
    }

    public long getCashPaidForPolicyDividends() {
        return cashPaidForPolicyDividends;
    }

    public void setCashPaidForPolicyDividends(long cashPaidForPolicyDividends) {
        this.cashPaidForPolicyDividends = cashPaidForPolicyDividends;
    }

    public long getCashPaidToEmployeesAndPaidToEmployees() {
        return cashPaidToEmployeesAndPaidToEmployees;
    }

    public void setCashPaidToEmployeesAndPaidToEmployees(long cashPaidToEmployeesAndPaidToEmployees) {
        this.cashPaidToEmployeesAndPaidToEmployees = cashPaidToEmployeesAndPaidToEmployees;
    }

    public long getVariousTaxesPaid() {
        return variousTaxesPaid;
    }

    public void setVariousTaxesPaid(long variousTaxesPaid) {
        this.variousTaxesPaid = variousTaxesPaid;
    }

    public long getOtherCashPaidInConnectionWithOperatingActivities() {
        return otherCashPaidInConnectionWithOperatingActivities;
    }

    public void setOtherCashPaidInConnectionWithOperatingActivities(
            long otherCashPaidInConnectionWithOperatingActivities) {
        this.otherCashPaidInConnectionWithOperatingActivities = otherCashPaidInConnectionWithOperatingActivities;
    }

    public long getSubtotalOfCashOutflowFromOperatingActivities() {
        return subtotalOfCashOutflowFromOperatingActivities;
    }

    public void setSubtotalOfCashOutflowFromOperatingActivities(long subtotalOfCashOutflowFromOperatingActivities) {
        this.subtotalOfCashOutflowFromOperatingActivities = subtotalOfCashOutflowFromOperatingActivities;
    }

    public long getNetCashFlowFromOperatingActivities() {
        return netCashFlowFromOperatingActivities;
    }

    public void setNetCashFlowFromOperatingActivities(long netCashFlowFromOperatingActivities) {
        this.netCashFlowFromOperatingActivities = netCashFlowFromOperatingActivities;
    }

    public long getCashReceivedFromTheInvestment() {
        return cashReceivedFromTheInvestment;
    }

    public void setCashReceivedFromTheInvestment(long cashReceivedFromTheInvestment) {
        this.cashReceivedFromTheInvestment = cashReceivedFromTheInvestment;
    }

    public long getCashReceivedFromInvestmentIncome() {
        return cashReceivedFromInvestmentIncome;
    }

    public void setCashReceivedFromInvestmentIncome(long cashReceivedFromInvestmentIncome) {
        this.cashReceivedFromInvestmentIncome = cashReceivedFromInvestmentIncome;
    }

    public long getNetCashAssets() {
        return netCashAssets;
    }

    public void setNetCashAssets(long netCashAssets) {
        this.netCashAssets = netCashAssets;
    }

    public long getNetCashOtherBusinessUnits() {
        return netCashOtherBusinessUnits;
    }

    public void setNetCashOtherBusinessUnits(long netCashOtherBusinessUnits) {
        this.netCashOtherBusinessUnits = netCashOtherBusinessUnits;
    }

    public long getOtherCashReceivedRelatedToInvestmentActivities() {
        return otherCashReceivedRelatedToInvestmentActivities;
    }

    public void setOtherCashReceivedRelatedToInvestmentActivities(long otherCashReceivedRelatedToInvestmentActivities) {
        this.otherCashReceivedRelatedToInvestmentActivities = otherCashReceivedRelatedToInvestmentActivities;
    }

    public long getReduceCashReceivedFromPledgesAndTimeDeposits() {
        return reduceCashReceivedFromPledgesAndTimeDeposits;
    }

    public void setReduceCashReceivedFromPledgesAndTimeDeposits(long reduceCashReceivedFromPledgesAndTimeDeposits) {
        this.reduceCashReceivedFromPledgesAndTimeDeposits = reduceCashReceivedFromPledgesAndTimeDeposits;
    }

    public long getSubtotalOfCashInflowsFromInvestmentActivities() {
        return subtotalOfCashInflowsFromInvestmentActivities;
    }

    public void setSubtotalOfCashInflowsFromInvestmentActivities(long subtotalOfCashInflowsFromInvestmentActivities) {
        this.subtotalOfCashInflowsFromInvestmentActivities = subtotalOfCashInflowsFromInvestmentActivities;
    }

    public long getCashPaidForThePurchaseAndConstructionOfAssets() {
        return cashPaidForThePurchaseAndConstructionOfAssets;
    }

    public void setCashPaidForThePurchaseAndConstructionOfAssets(long cashPaidForThePurchaseAndConstructionOfAssets) {
        this.cashPaidForThePurchaseAndConstructionOfAssets = cashPaidForThePurchaseAndConstructionOfAssets;
    }

    public long getCashPaidByTheInvestment() {
        return cashPaidByTheInvestment;
    }

    public void setCashPaidByTheInvestment(long cashPaidByTheInvestment) {
        this.cashPaidByTheInvestment = cashPaidByTheInvestment;
    }

    public long getNetIncreaseInPledgeLoans() {
        return netIncreaseInPledgeLoans;
    }

    public void setNetIncreaseInPledgeLoans(long netIncreaseInPledgeLoans) {
        this.netIncreaseInPledgeLoans = netIncreaseInPledgeLoans;
    }

    public long getNetCashPaidBySubsidiariesAndOtherBusinessUnits() {
        return netCashPaidBySubsidiariesAndOtherBusinessUnits;
    }

    public void setNetCashPaidBySubsidiariesAndOtherBusinessUnits(long netCashPaidBySubsidiariesAndOtherBusinessUnits) {
        this.netCashPaidBySubsidiariesAndOtherBusinessUnits = netCashPaidBySubsidiariesAndOtherBusinessUnits;
    }

    public long getOtherCashPaidForInvestmentActivities() {
        return otherCashPaidForInvestmentActivities;
    }

    public void setOtherCashPaidForInvestmentActivities(long otherCashPaidForInvestmentActivities) {
        this.otherCashPaidForInvestmentActivities = otherCashPaidForInvestmentActivities;
    }

    public long getIncreaseCashPaidForPledgesAndTimeDeposits() {
        return increaseCashPaidForPledgesAndTimeDeposits;
    }

    public void setIncreaseCashPaidForPledgesAndTimeDeposits(long increaseCashPaidForPledgesAndTimeDeposits) {
        this.increaseCashPaidForPledgesAndTimeDeposits = increaseCashPaidForPledgesAndTimeDeposits;
    }

    public long getSubtotalOfCashOutflowsFromInvestmentActivities() {
        return subtotalOfCashOutflowsFromInvestmentActivities;
    }

    public void setSubtotalOfCashOutflowsFromInvestmentActivities(long subtotalOfCashOutflowsFromInvestmentActivities) {
        this.subtotalOfCashOutflowsFromInvestmentActivities = subtotalOfCashOutflowsFromInvestmentActivities;
    }

    public long getNetCashFlowsFromInvestingActivities() {
        return netCashFlowsFromInvestingActivities;
    }

    public void setNetCashFlowsFromInvestingActivities(long netCashFlowsFromInvestingActivities) {
        this.netCashFlowsFromInvestingActivities = netCashFlowsFromInvestingActivities;
    }

    public long getAbsorbCashReceivedFromInvestment() {
        return absorbCashReceivedFromInvestment;
    }

    public void setAbsorbCashReceivedFromInvestment(long absorbCashReceivedFromInvestment) {
        this.absorbCashReceivedFromInvestment = absorbCashReceivedFromInvestment;
    }

    public long getSubsidiariesInvestments() {
        return subsidiariesInvestments;
    }

    public void setSubsidiariesInvestments(long subsidiariesInvestments) {
        this.subsidiariesInvestments = subsidiariesInvestments;
    }

    public long getCashReceivedFromTheLoan() {
        return cashReceivedFromTheLoan;
    }

    public void setCashReceivedFromTheLoan(long cashReceivedFromTheLoan) {
        this.cashReceivedFromTheLoan = cashReceivedFromTheLoan;
    }

    public long getCashReceivedFromTheIssuanceOfBonds() {
        return cashReceivedFromTheIssuanceOfBonds;
    }

    public void setCashReceivedFromTheIssuanceOfBonds(long cashReceivedFromTheIssuanceOfBonds) {
        this.cashReceivedFromTheIssuanceOfBonds = cashReceivedFromTheIssuanceOfBonds;
    }

    public long getReceivedOtherCashRelatedToFundraisingActivities() {
        return receivedOtherCashRelatedToFundraisingActivities;
    }

    public void setReceivedOtherCashRelatedToFundraisingActivities(
            long receivedOtherCashRelatedToFundraisingActivities) {
        this.receivedOtherCashRelatedToFundraisingActivities = receivedOtherCashRelatedToFundraisingActivities;
    }

    public long getSubtotalOfCashInflowsFromFinancingActivities() {
        return subtotalOfCashInflowsFromFinancingActivities;
    }

    public void setSubtotalOfCashInflowsFromFinancingActivities(long subtotalOfCashInflowsFromFinancingActivities) {
        this.subtotalOfCashInflowsFromFinancingActivities = subtotalOfCashInflowsFromFinancingActivities;
    }

    public long getCashPaidForDebtRepayment() {
        return cashPaidForDebtRepayment;
    }

    public void setCashPaidForDebtRepayment(long cashPaidForDebtRepayment) {
        this.cashPaidForDebtRepayment = cashPaidForDebtRepayment;
    }

    public long getCashPaidForDividendsProfitsOrInterestPayments() {
        return cashPaidForDividendsProfitsOrInterestPayments;
    }

    public void setCashPaidForDividendsProfitsOrInterestPayments(long cashPaidForDividendsProfitsOrInterestPayments) {
        this.cashPaidForDividendsProfitsOrInterestPayments = cashPaidForDividendsProfitsOrInterestPayments;
    }

    public long getDividendsPaidBySubsidiaries() {
        return dividendsPaidBySubsidiaries;
    }

    public void setDividendsPaidBySubsidiaries(long dividendsPaidBySubsidiaries) {
        this.dividendsPaidBySubsidiaries = dividendsPaidBySubsidiaries;
    }

    public long getPayOtherCashRelatedToFundraisingActivities() {
        return payOtherCashRelatedToFundraisingActivities;
    }

    public void setPayOtherCashRelatedToFundraisingActivities(long payOtherCashRelatedToFundraisingActivities) {
        this.payOtherCashRelatedToFundraisingActivities = payOtherCashRelatedToFundraisingActivities;
    }

    public long getSubtotalOfCashOutflowsFromFinancingActivities() {
        return subtotalOfCashOutflowsFromFinancingActivities;
    }

    public void setSubtotalOfCashOutflowsFromFinancingActivities(long subtotalOfCashOutflowsFromFinancingActivities) {
        this.subtotalOfCashOutflowsFromFinancingActivities = subtotalOfCashOutflowsFromFinancingActivities;
    }

    public long getNetCashFlowFromFinancingActivities() {
        return netCashFlowFromFinancingActivities;
    }

    public void setNetCashFlowFromFinancingActivities(long netCashFlowFromFinancingActivities) {
        this.netCashFlowFromFinancingActivities = netCashFlowFromFinancingActivities;
    }

    public long getEffectChangesCashEquivalents() {
        return effectChangesCashEquivalents;
    }

    public void setEffectChangesCashEquivalents(long effectChangesCashEquivalents) {
        this.effectChangesCashEquivalents = effectChangesCashEquivalents;
    }

    public long getNetIncreaseInCashAndCashEquivalents() {
        return netIncreaseInCashAndCashEquivalents;
    }

    public void setNetIncreaseInCashAndCashEquivalents(long netIncreaseInCashAndCashEquivalents) {
        this.netIncreaseInCashAndCashEquivalents = netIncreaseInCashAndCashEquivalents;
    }

    public long getCashAndCashEquivalentsAtTheBeginningOfThePeriod() {
        return cashAndCashEquivalentsAtTheBeginningOfThePeriod;
    }

    public void setCashAndCashEquivalentsAtTheBeginningOfThePeriod(
            long cashAndCashEquivalentsAtTheBeginningOfThePeriod) {
        this.cashAndCashEquivalentsAtTheBeginningOfThePeriod = cashAndCashEquivalentsAtTheBeginningOfThePeriod;
    }

    public long getFinalCashAndCashEquivalentBalance() {
        return finalCashAndCashEquivalentBalance;
    }

    public void setFinalCashAndCashEquivalentBalance(long finalCashAndCashEquivalentBalance) {
        this.finalCashAndCashEquivalentBalance = finalCashAndCashEquivalentBalance;
    }

    public long getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(long netProfit) {
        this.netProfit = netProfit;
    }

    public long getMinorityShareholderGainsAndLosses() {
        return minorityShareholderGainsAndLosses;
    }

    public void setMinorityShareholderGainsAndLosses(long minorityShareholderGainsAndLosses) {
        this.minorityShareholderGainsAndLosses = minorityShareholderGainsAndLosses;
    }

    public long getUnconfirmedInvestmentLoss() {
        return unconfirmedInvestmentLoss;
    }

    public void setUnconfirmedInvestmentLoss(long unconfirmedInvestmentLoss) {
        this.unconfirmedInvestmentLoss = unconfirmedInvestmentLoss;
    }

    public long getImpairmentOfAssets() {
        return impairmentOfAssets;
    }

    public void setImpairmentOfAssets(long impairmentOfAssets) {
        this.impairmentOfAssets = impairmentOfAssets;
    }

    public long getDepreciationOfFixedAssets() {
        return depreciationOfFixedAssets;
    }

    public void setDepreciationOfFixedAssets(long depreciationOfFixedAssets) {
        this.depreciationOfFixedAssets = depreciationOfFixedAssets;
    }

    public long getAmortizationOfIntangibleAssets() {
        return amortizationOfIntangibleAssets;
    }

    public void setAmortizationOfIntangibleAssets(long amortizationOfIntangibleAssets) {
        this.amortizationOfIntangibleAssets = amortizationOfIntangibleAssets;
    }

    public long getLongTermDeferredExpensesAmortization() {
        return longTermDeferredExpensesAmortization;
    }

    public void setLongTermDeferredExpensesAmortization(long longTermDeferredExpensesAmortization) {
        this.longTermDeferredExpensesAmortization = longTermDeferredExpensesAmortization;
    }

    public long getReductionOfDeferredExpenses() {
        return reductionOfDeferredExpenses;
    }

    public void setReductionOfDeferredExpenses(long reductionOfDeferredExpenses) {
        this.reductionOfDeferredExpenses = reductionOfDeferredExpenses;
    }

    public long getIncreaseInAccruedExpenses() {
        return increaseInAccruedExpenses;
    }

    public void setIncreaseInAccruedExpenses(long increaseInAccruedExpenses) {
        this.increaseInAccruedExpenses = increaseInAccruedExpenses;
    }

    public long getDisposalOfFixedAssets() {
        return disposalOfFixedAssets;
    }

    public void setDisposalOfFixedAssets(long disposalOfFixedAssets) {
        this.disposalOfFixedAssets = disposalOfFixedAssets;
    }

    public long getFixedAssetRetirementLoss() {
        return fixedAssetRetirementLoss;
    }

    public void setFixedAssetRetirementLoss(long fixedAssetRetirementLoss) {
        this.fixedAssetRetirementLoss = fixedAssetRetirementLoss;
    }

    public long getLossOfFairValue() {
        return lossOfFairValue;
    }

    public void setLossOfFairValue(long lossOfFairValue) {
        this.lossOfFairValue = lossOfFairValue;
    }

    public long getDeferredIncomeIncrease() {
        return deferredIncomeIncrease;
    }

    public void setDeferredIncomeIncrease(long deferredIncomeIncrease) {
        this.deferredIncomeIncrease = deferredIncomeIncrease;
    }

    public long getEstimatedLiabilities() {
        return estimatedLiabilities;
    }

    public void setEstimatedLiabilities(long estimatedLiabilities) {
        this.estimatedLiabilities = estimatedLiabilities;
    }

    public long getFinancialExpenses() {
        return financialExpenses;
    }

    public void setFinancialExpenses(long financialExpenses) {
        this.financialExpenses = financialExpenses;
    }

    public long getInvestmentLoss() {
        return investmentLoss;
    }

    public void setInvestmentLoss(long investmentLoss) {
        this.investmentLoss = investmentLoss;
    }

    public long getDeferredIncomeTaxAssetsDecreased() {
        return deferredIncomeTaxAssetsDecreased;
    }

    public void setDeferredIncomeTaxAssetsDecreased(long deferredIncomeTaxAssetsDecreased) {
        this.deferredIncomeTaxAssetsDecreased = deferredIncomeTaxAssetsDecreased;
    }

    public long getDeferredIncomeTaxLiabilitiesIncreased() {
        return deferredIncomeTaxLiabilitiesIncreased;
    }

    public void setDeferredIncomeTaxLiabilitiesIncreased(long deferredIncomeTaxLiabilitiesIncreased) {
        this.deferredIncomeTaxLiabilitiesIncreased = deferredIncomeTaxLiabilitiesIncreased;
    }

    public long getReductionInInventory() {
        return reductionInInventory;
    }

    public void setReductionInInventory(long reductionInInventory) {
        this.reductionInInventory = reductionInInventory;
    }

    public long getReductionOfOperationalReceivables() {
        return reductionOfOperationalReceivables;
    }

    public void setReductionOfOperationalReceivables(long reductionOfOperationalReceivables) {
        this.reductionOfOperationalReceivables = reductionOfOperationalReceivables;
    }

    public long getIncreaseInOperationalPayables() {
        return increaseInOperationalPayables;
    }

    public void setIncreaseInOperationalPayables(long increaseInOperationalPayables) {
        this.increaseInOperationalPayables = increaseInOperationalPayables;
    }

    public long getReducedOutstandingSettlements() {
        return reducedOutstandingSettlements;
    }

    public void setReducedOutstandingSettlements(long reducedOutstandingSettlements) {
        this.reducedOutstandingSettlements = reducedOutstandingSettlements;
    }

    public long getIncreasedSettlementOfOutstandingWork() {
        return increasedSettlementOfOutstandingWork;
    }

    public void setIncreasedSettlementOfOutstandingWork(long increasedSettlementOfOutstandingWork) {
        this.increasedSettlementOfOutstandingWork = increasedSettlementOfOutstandingWork;
    }

    public long getOther() {
        return other;
    }

    public void setOther(long other) {
        this.other = other;
    }

    public long getNetCashFlowFromOperatingActivities2() {
        return netCashFlowFromOperatingActivities2;
    }

    public void setNetCashFlowFromOperatingActivities2(long netCashFlowFromOperatingActivities2) {
        this.netCashFlowFromOperatingActivities2 = netCashFlowFromOperatingActivities2;
    }

    public long getConversionOfDebtIntoCapital() {
        return conversionOfDebtIntoCapital;
    }

    public void setConversionOfDebtIntoCapital(long conversionOfDebtIntoCapital) {
        this.conversionOfDebtIntoCapital = conversionOfDebtIntoCapital;
    }

    public long getConvertibleCorporateBondsDueWithinOneYear() {
        return convertibleCorporateBondsDueWithinOneYear;
    }

    public void setConvertibleCorporateBondsDueWithinOneYear(long convertibleCorporateBondsDueWithinOneYear) {
        this.convertibleCorporateBondsDueWithinOneYear = convertibleCorporateBondsDueWithinOneYear;
    }

    public long getFinancingLeasedFixedAssets() {
        return financingLeasedFixedAssets;
    }

    public void setFinancingLeasedFixedAssets(long financingLeasedFixedAssets) {
        this.financingLeasedFixedAssets = financingLeasedFixedAssets;
    }

    public long getEndingBalanceOfCash() {
        return endingBalanceOfCash;
    }

    public void setEndingBalanceOfCash(long endingBalanceOfCash) {
        this.endingBalanceOfCash = endingBalanceOfCash;
    }

    public long getCashBeginningBalance() {
        return cashBeginningBalance;
    }

    public void setCashBeginningBalance(long cashBeginningBalance) {
        this.cashBeginningBalance = cashBeginningBalance;
    }

    public long getEndingBalanceOfCashEquivalents() {
        return endingBalanceOfCashEquivalents;
    }

    public void setEndingBalanceOfCashEquivalents(long endingBalanceOfCashEquivalents) {
        this.endingBalanceOfCashEquivalents = endingBalanceOfCashEquivalents;
    }

    public long getOpeningBalanceOfCashEquivalents() {
        return openingBalanceOfCashEquivalents;
    }

    public void setOpeningBalanceOfCashEquivalents(long openingBalanceOfCashEquivalents) {
        this.openingBalanceOfCashEquivalents = openingBalanceOfCashEquivalents;
    }

    public long getNetIncreaseInCashAndCashEquivalents2() {
        return netIncreaseInCashAndCashEquivalents2;
    }

    public void setNetIncreaseInCashAndCashEquivalents2(long netIncreaseInCashAndCashEquivalents2) {
        this.netIncreaseInCashAndCashEquivalents2 = netIncreaseInCashAndCashEquivalents2;
    }
}
