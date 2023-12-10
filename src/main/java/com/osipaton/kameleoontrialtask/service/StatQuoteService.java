package com.osipaton.kameleoontrialtask.service;

import com.osipaton.kameleoontrialtask.EntityMapper;
import com.osipaton.kameleoontrialtask.dto.QuoteDTO;
import com.osipaton.kameleoontrialtask.dto.VoteDTO;
import com.osipaton.kameleoontrialtask.entity.Quote;
import com.osipaton.kameleoontrialtask.entity.Vote;
import com.osipaton.kameleoontrialtask.repository.QuoteRepository;
import com.osipaton.kameleoontrialtask.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.osipaton.kameleoontrialtask.entity.VoteType.DOWNVOTE;
import static com.osipaton.kameleoontrialtask.entity.VoteType.UPVOTE;

@Service
public class StatQuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private EntityMapper mapper;

    public List<QuoteDTO> top10BestQuotes() {
        return top10Quotes(true);
    }
    public List<QuoteDTO> top10WorstQuotes() {
        return top10Quotes(false);
    }

    private List<QuoteDTO> top10Quotes(boolean isBest) {
        List<Quote> quotes = quoteRepository.findAll();
        Map<Long, Integer> quoteScores = new HashMap<>();

        for (Quote quote : quotes) {
            Long quoteId = quote.getId();
            int score;
            if(isBest) {
                score = voteRepository.countByQuoteIdAndType(quoteId, UPVOTE) -
                voteRepository.countByQuoteIdAndType(quoteId, DOWNVOTE);
            } else {
                score = voteRepository.countByQuoteIdAndType(quoteId, DOWNVOTE) -
                        voteRepository.countByQuoteIdAndType(quoteId, UPVOTE);
            }

            quoteScores.put(quoteId, score);
        }

        List<Map.Entry<Long, Integer>> sortedQuotes = quoteScores.entrySet().stream()
                .sorted(Map.Entry.<Long, Integer>comparingByValue().reversed())
                .limit(10).toList();

        return sortedQuotes.stream()
                .map(entry -> {
                    Optional<Quote> quoteOptional = quoteRepository.findById(entry.getKey());
                    return quoteOptional.map(quote -> mapper.entityToDTO(quote)).orElse(null);
                }).collect(Collectors.toList());
    }


    public List<VoteDTO> evolution(Long quoteId) {
        List<Vote> votes = voteRepository.findByQuoteIdOrderByCreateDate(quoteId);

        return votes.stream().map(vote -> mapper.entityToDTO(vote)).toList();
    }
}
