package com.Stock.StockApplication.controller;

import com.Stock.StockApplication.entity.StockInfo;
import com.Stock.StockApplication.service.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class StockController {
    @GetMapping("/stockInfo/{symbol}")
    public StockInfo stockInfo(@PathVariable String symbol){
        StockService stockService = new StockService();
        return stockService.getStockInfo(symbol);
    }
    @GetMapping("stocksInfo/{symbols}")
    public List<StockInfo> stocksInfo(@PathVariable String symbols){
        StockService stockService = new StockService();
        return stockService.getStocksInfo(symbols);
    }

}
