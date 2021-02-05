package com.tandra.investment.service;

import com.tandra.investment.model.QuoteDetails;
import com.tandra.investment.model.QuoteDetailsResponse;


public interface InvestmentService {
    public QuoteDetailsResponse transformQuoteDetailsResponse(QuoteDetails quoteDetails,String quote);
}
