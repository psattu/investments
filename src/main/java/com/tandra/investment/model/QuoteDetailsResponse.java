package com.tandra.investment.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "symbol",
        "description",
        "closePrice",
        "netChange",
        "totalVolume",
        "exchangeName",
        "52WkHigh",
        "52WkLow",
        "bidPrice",
        "bidSize",
        "openPrice",
        "highPrice",
        "lowPrice",
        "divAmount",
        "divYield"
})
public class QuoteDetailsResponse {


    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("description")
    private String description;
    @JsonProperty("closePrice")
    private Double closePrice;
    @JsonProperty("netChange")
    private Double netChange;
    @JsonProperty("totalVolume")
    private Integer totalVolume;
    @JsonProperty("exchangeName")
    private String exchangeName;
     @JsonProperty("52WkHigh")
    private Double _52WkHigh;
    @JsonProperty("52WkLow")
    private Double _52WkLow;
    @JsonProperty("bidPrice")
    private Double bidPrice;
    @JsonProperty("bidSize")
    private Integer bidSize;
    @JsonProperty("openPrice")
    private Double openPrice;
    @JsonProperty("highPrice")
    private Double highPrice;
    @JsonProperty("lowPrice")
    private Double lowPrice;
    @JsonProperty("divAmount")
    private Double divAmount;

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("closePrice")
    public Double getClosePrice() {
        return closePrice;
    }

    @JsonProperty("closePrice")
    public void setClosePrice(Double closePrice) {
        this.closePrice = closePrice;
    }

    @JsonProperty("netChange")
    public Double getNetChange() {
        return netChange;
    }

    @JsonProperty("netChange")
    public void setNetChange(Double netChange) {
        this.netChange = netChange;
    }

    @JsonProperty("totalVolume")
    public Integer getTotalVolume() {
        return totalVolume;
    }

    @JsonProperty("totalVolume")
    public void setTotalVolume(Integer totalVolume) {
        this.totalVolume = totalVolume;
    }


    @JsonProperty("exchangeName")
    public String getExchangeName() {
        return exchangeName;
    }

    @JsonProperty("exchangeName")
    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }
    @JsonProperty("high52Week")
    public Double get52WkHigh() {
        return _52WkHigh;
    }

    @JsonProperty("52WkHigh")
    public void set52WkHigh(Double _52WkHigh) {
        this._52WkHigh = _52WkHigh;
    }

    @JsonProperty("low52Week")
    public Double get52WkLow() {
        return _52WkLow;
    }

    @JsonProperty("52WkLow")
    public void set52WkLow(Double _52WkLow) {
        this._52WkLow = _52WkLow;
    }
    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Integer getBidSize() {
        return bidSize;
    }

    public void setBidSize(Integer bidSize) {
        this.bidSize = bidSize;
    }

    public Double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
    }

    public Double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Double highPrice) {
        this.highPrice = highPrice;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Double getDivAmount() {
        return divAmount;
    }

    public void setDivAmount(Double divAmount) {
        this.divAmount = divAmount;
    }



}