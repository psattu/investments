package com.tandra.investment.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tandra.investment.model.QuoteDetails;
import com.tandra.investment.model.QuoteDetailsResponse;
import org.springframework.stereotype.Service;

import java.util.Map;
/*
 "symbol",
        "description",
        "closePrice",
        "netChange",
        "totalVolume",
        "tradeTimeInLong",
        "exchangeName",
        "52WkHigh",
        "52WkLow"
        "bidPrice",
        "bidSize",
        "openPrice",
        "highPrice",
        "lowPrice",
        "divAmount",
        "divYield"
 */

@Service
public class InvestmentServiceImpl implements  InvestmentService{
    @Override
    public QuoteDetailsResponse transformQuoteDetailsResponse(QuoteDetails quoteDetails,String quote) {
        Object returnResponse =  quoteDetails.getAdditionalProperties().get(quote);
        ObjectMapper oMapper = new ObjectMapper();

        QuoteDetailsResponse quoteDetailsResponse  = new QuoteDetailsResponse();
        Map<String, Object> stockMap = oMapper.convertValue(returnResponse, Map.class);
           stockMap.entrySet().forEach( entry -> {

            if(entry.getKey().equals("symbol")){
                quoteDetailsResponse.setSymbol(entry.getValue().toString());
            }else if(entry.getKey().equals("description")){
                quoteDetailsResponse.setDescription(entry.getValue().toString());
            }else if(entry.getKey().equals("closePrice")){
                quoteDetailsResponse.setClosePrice(Double.valueOf(entry.getValue().toString()));
            }else if(entry.getKey().equals("netChange")){
                quoteDetailsResponse.setNetChange(Double.valueOf(entry.getValue().toString()));
            }else if(entry.getKey().equals("totalVolume")){
                quoteDetailsResponse.setTotalVolume(Integer.valueOf(entry.getValue().toString()));
            }else if(entry.getKey().equals("bidPrice")){
                quoteDetailsResponse.setBidPrice(Double.valueOf(entry.getValue().toString()));
            }else if(entry.getKey().equals("exchangeName")){
                quoteDetailsResponse.setExchangeName(entry.getValue().toString());
            }else if(entry.getKey().equals("bidSize")){
                quoteDetailsResponse.setBidSize(Integer.valueOf(entry.getValue().toString()));
            }else if(entry.getKey().equals("52WkHigh")){
                quoteDetailsResponse.set52WkHigh(Double.valueOf(entry.getValue().toString()));
            }else if(entry.getKey().equals("52WkLow")){
                quoteDetailsResponse.set52WkLow(Double.valueOf(entry.getValue().toString()));
            }else if(entry.getKey().equals("openPrice")){
                quoteDetailsResponse.setOpenPrice(Double.valueOf(entry.getValue().toString()));
            }else if(entry.getKey().equals("highPrice")){
                quoteDetailsResponse.setHighPrice(Double.valueOf(entry.getValue().toString()));
            }else if(entry.getKey().equals("lowPrice")){
                quoteDetailsResponse.setLowPrice(Double.valueOf(entry.getValue().toString()));
            }else if(entry.getKey().equals("divAmount")){
                quoteDetailsResponse.setDivAmount(Double.valueOf(entry.getValue().toString()));
            }
        });

        return quoteDetailsResponse;
    }
}
