package com.osipaton.kameleoontrialtask.controller;

import com.osipaton.kameleoontrialtask.dto.QuoteDTO;
import com.osipaton.kameleoontrialtask.service.StatQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistic/quote")
public class StatQuotesController {

    @Autowired
    private StatQuoteService statQuoteService;

    @GetMapping("/top/best")
    public ResponseEntity<List<QuoteDTO>> top10BestQuotes() {
        return new ResponseEntity<>(statQuoteService.top10BestQuotes(), HttpStatus.OK);
    }
}
