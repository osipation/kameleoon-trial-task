package com.osipaton.kameleoontrialtask.controller;

import com.osipaton.kameleoontrialtask.dto.QuoteDTO;
import com.osipaton.kameleoontrialtask.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quote")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody QuoteDTO quoteDTO) {
        quoteService.add(quoteDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody QuoteDTO quoteDTO) {
        quoteService.delete(quoteDTO);
        return ResponseEntity.ok().build();
    }
}
