package com.osipaton.kameleoontrialtask.service;

import com.osipaton.kameleoontrialtask.EntityMapper;
import com.osipaton.kameleoontrialtask.dto.QuoteDTO;
import com.osipaton.kameleoontrialtask.entity.Quote;
import com.osipaton.kameleoontrialtask.exception.KameleoonException;
import com.osipaton.kameleoontrialtask.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private EntityMapper mapper;
    public void add(QuoteDTO quoteDTO) {
        Quote quote = mapper.dtoToEntity(quoteDTO);
        quote.setCreateDate(LocalDateTime.now());
        quoteRepository.save(quote);
    }

    public void delete(QuoteDTO quoteDTO) {
        Optional<Quote> quote = quoteRepository.findById(quoteDTO.getId());
        if(quote.isPresent()) {
            quoteRepository.delete(quote.get());
        } else {
            throw new KameleoonException("Quote with id = " + quoteDTO.getId() + " does not exists");
        }

    }
}
