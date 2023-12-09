package com.osipaton.kameleoontrialtask.service;

import com.osipaton.kameleoontrialtask.EntityMapper;
import com.osipaton.kameleoontrialtask.dto.QuoteDTO;
import com.osipaton.kameleoontrialtask.entity.Quote;
import com.osipaton.kameleoontrialtask.exception.KameleoonException;
import com.osipaton.kameleoontrialtask.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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

    public void delete(Long id) {
        Optional<Quote> quote = quoteRepository.findById(id);
        if(quote.isPresent()) {
            quoteRepository.delete(quote.get());
        } else {
            throw new KameleoonException("Quote with id = " + id + " does not exists");
        }

    }

    public void edit(QuoteDTO quoteDTO) {
        quoteRepository.updateQuoteContent(quoteDTO.getId(), quoteDTO.getContent());
    }

    public QuoteDTO get(Long id) {
        Optional<Quote> quote = quoteRepository.findById(id);
        if(quote.isPresent()) {
            return mapper.entityToDTO(quote.get());
        } else {
            throw new KameleoonException("Quote with id = " + id + " does not exists");
        }
    }

    @Transactional
    public QuoteDTO getRandom() {
        List<Long> ids = quoteRepository.getListOfAllIds();

        Random rand = new Random();
        long randomId = ids.get(rand.nextInt(ids.size()));

        Optional<Quote> quote = quoteRepository.findById(randomId);

        if(quote.isPresent()) {
            return mapper.entityToDTO(quote.get());
        } else {
            throw new KameleoonException("Random quote is lost");
        }

    }
}
