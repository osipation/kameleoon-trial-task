package com.osipaton.kameleoontrialtask.controller;

import com.osipaton.kameleoontrialtask.dto.QuoteDTO;
import com.osipaton.kameleoontrialtask.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        quoteService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/edit")
    public ResponseEntity<Void> edit(@RequestBody QuoteDTO quoteDTO) {
        quoteService.edit(quoteDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<QuoteDTO> get(@PathVariable Long id) {
        QuoteDTO quoteDTO = quoteService.get(id);
        return new ResponseEntity<>(quoteDTO, HttpStatus.OK);
    }

    @GetMapping("/get/random")
    public ResponseEntity<QuoteDTO> getRandom() {
        QuoteDTO quoteDTO = quoteService.getRandom();
        return new ResponseEntity<>(quoteDTO, HttpStatus.OK);
    }
}
