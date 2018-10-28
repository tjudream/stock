package com.tjudream.stock.repositories;

import com.tjudream.stock.dto.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mengxiansen on 2018/9/19.
 */
public interface StockRepository extends JpaRepository<Stock, Long> {
}
