package com.tjudream.stock.dto;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by mengxiansen on 2018/9/19.
 * 股票数据库表
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(indexes = { // 定义数据库索引。
        // 唯一索引。
        @Index(name = "uni_code", columnList = "code", unique = true)
})
public class Stock {
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
    /**
     * 股票名称
     */
    private String name;
    /**
     * 0:沪市（600开头），1：深市（000或300开头）
     */
    @Column(name="type",columnDefinition="int default 0")
    private int type;
    /**
     * 总股本（元）
     */
    private long capitalization;
    /**
     * 流通股本（元）
     */
    private long current_capital_stock;
    /**
     * 上市时间
     */
    private Timestamp ipoTime;
    @Column(columnDefinition="datetime default current_timestamp")
    private Timestamp ctime;
    @Column(columnDefinition="datetime default current_timestamp ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp mtime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    @Column(name = "ipo_time")
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

    public long getCapitalization() {
        return capitalization;
    }

    public void setCapitalization(long capitalization) {
        this.capitalization = capitalization;
    }

    public long getCurrent_capital_stock() {
        return current_capital_stock;
    }

    public void setCurrent_capital_stock(long current_capital_stock) {
        this.current_capital_stock = current_capital_stock;
    }
}
