package com.tandra.investment.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "symbol",
        "description",
        "closePrice",
        "netChange",
        "totalVolume",
        "tradeTimeInLong",
        "exchange",
        "exchangeName",
        "digits",
        "52WkHigh",
        "52WkLow"
})
public class QuoteDetails {

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
    @JsonProperty("tradeTimeInLong")
    private Integer tradeTimeInLong;
    @JsonProperty("exchange")
    private String exchange;
    @JsonProperty("exchangeName")
    private String exchangeName;
    @JsonProperty("digits")
    private Integer digits;
    @JsonProperty("52WkHigh")
    private Double _52WkHigh;
    @JsonProperty("52WkLow")
    private Double _52WkLow;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    @JsonProperty("tradeTimeInLong")
    public Integer getTradeTimeInLong() {
        return tradeTimeInLong;
    }

    @JsonProperty("tradeTimeInLong")
    public void setTradeTimeInLong(Integer tradeTimeInLong) {
        this.tradeTimeInLong = tradeTimeInLong;
    }

    @JsonProperty("exchange")
    public String getExchange() {
        return exchange;
    }

    @JsonProperty("exchange")
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    @JsonProperty("exchangeName")
    public String getExchangeName() {
        return exchangeName;
    }

    @JsonProperty("exchangeName")
    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    @JsonProperty("digits")
    public Integer getDigits() {
        return digits;
    }

    @JsonProperty("digits")
    public void setDigits(Integer digits) {
        this.digits = digits;
    }

    @JsonProperty("52WkHigh")
    public Double get52WkHigh() {
        return _52WkHigh;
    }

    @JsonProperty("52WkHigh")
    public void set52WkHigh(Double _52WkHigh) {
        this._52WkHigh = _52WkHigh;
    }

    @JsonProperty("52WkLow")
    public Double get52WkLow() {
        return _52WkLow;
    }

    @JsonProperty("52WkLow")
    public void set52WkLow(Double _52WkLow) {
        this._52WkLow = _52WkLow;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}