package com.Stock.StockApplication.entity;

public class StockInfo {
    private String symbol;
    private double openPrice;
    private double closePrice;
    private String timeStamp;
    private double change;
    private double percentChange;
    private double volume;

    public StockInfo() {
    }

    public StockInfo(String symbol,double openPrice, double closePrice, String timeStamp, double change, double percentChange, double volume) {
        this.symbol = symbol;
        this.openPrice = openPrice;
        this.closePrice = closePrice;
        this.timeStamp = timeStamp;
        this.change = change;
        this.percentChange = percentChange;
        this.volume = volume;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getOpeningPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getClosingPrice() {
        return closePrice;
    }

    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }

    public String getLatestTime() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(double percentChange) {
        this.percentChange = percentChange;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "StockInfo{" +
                "symbol='" + symbol + '\'' +
                ",\n openPrice=" + openPrice +
                ",\n closePrice=" + closePrice +
                ".\n timeStamp='" + timeStamp + '\'' +
                ",\n change=" + change +
                ",\n percentChange=" + percentChange +
                ",\n volume=" + volume +
                '}';
    }
}
