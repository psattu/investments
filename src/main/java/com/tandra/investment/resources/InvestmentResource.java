package com.tandra.investment.resources;

import com.tandra.investment.model.QuoteDetails;
import com.tandra.investment.model.QuoteDetailsResponse;
import com.tandra.investment.service.InvestmentService;
import com.tandra.investment.service.StocksFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/investments")
public class InvestmentResource {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private InvestmentService investmentService;
    @Autowired
    private StocksFileService  stocksFileService;

    @Value("${api.key}")
    private String apiKey;

    @Value("${api.url}")
    private String apiUrl;

   @RequestMapping("/{stickerId}")
    public QuoteDetails getStickerDetails(@PathVariable String stickerId){
        QuoteDetails quoteDetails =   restTemplate.getForObject(apiUrl+"/"+stickerId+"/quotes?apikey="+apiKey, QuoteDetails.class);
        return quoteDetails;

    }

    @RequestMapping("/quotes")
    public   List<QuoteDetailsResponse> getQuotesDetails(){

        Set<String> quotesList = stocksFileService.readStockListFromFile();
        String BaseURL = apiUrl+"/quotes?apikey="+apiKey+"&symbol=";
        List<QuoteDetailsResponse> quoteResponseList = new ArrayList<>();
        quotesList.forEach(quote -> {
            QuoteDetails quoteDetails  =   restTemplate.getForObject(BaseURL+quote, QuoteDetails.class);
               QuoteDetailsResponse quoteDetailsResponse =   investmentService.transformQuoteDetailsResponse(quoteDetails,quote);
               quoteResponseList.add(quoteDetailsResponse);
        });

        return quoteResponseList;

    }
    @DeleteMapping("{stickerId}")
    public ResponseEntity<String> deleteById(@PathVariable String stickerId) throws IOException {
        stocksFileService.deleteStockByStickerID(stickerId);
        return new ResponseEntity<>("Deleted Successfully ", HttpStatus.OK);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody QuoteDetailsResponse quoteDetailsResponse) throws IOException {
        QuoteDetails quoteDetails =   restTemplate.getForObject(apiUrl+"/"+quoteDetailsResponse.getSymbol()+"/quotes?apikey="+apiKey, QuoteDetails.class);
        if(quoteDetails!= null && !quoteDetails.getAdditionalProperties().isEmpty()){
            stocksFileService.addStockToFile(quoteDetailsResponse.getSymbol());
            return new ResponseEntity<>("Saved Successfully", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Symbol is incorrect and Not Saved into List", HttpStatus.CREATED);
        }


    }
}
