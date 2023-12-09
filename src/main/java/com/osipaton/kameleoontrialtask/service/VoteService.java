package com.osipaton.kameleoontrialtask.service;

import com.osipaton.kameleoontrialtask.entity.Quote;
import com.osipaton.kameleoontrialtask.entity.Vote;
import com.osipaton.kameleoontrialtask.entity.VoteType;
import com.osipaton.kameleoontrialtask.exception.KameleoonException;
import com.osipaton.kameleoontrialtask.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private QuoteService quoteService;

    public void upvote(Long quoteId) {
        vote(quoteId, VoteType.UPVOTE);

    }
    public void downvote(Long quoteId) {
        vote(quoteId, VoteType.DOWNVOTE);
    }

    private void vote(Long quoteId, VoteType voteType) {
        Vote vote = new Vote();
        Optional<Quote> quoteOptional = quoteService.getQuoteEntityById(quoteId);
        if(quoteOptional.isPresent()) {
            vote.setType(voteType);
            vote.setQuote(quoteOptional.get());
            vote.setCreateDate(LocalDateTime.now());
            voteRepository.save(vote);
        } else {
            throw new KameleoonException("Quote with id = " + quoteId + " does not exists");
        }
    }
}
