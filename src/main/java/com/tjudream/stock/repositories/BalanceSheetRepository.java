package com.tjudream.stock.repositories;

import com.tjudream.stock.dto.BalanceSheet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mengxiansen on 2018/10/28.
 */
public interface BalanceSheetRepository extends JpaRepository<BalanceSheet, Long> {
}
