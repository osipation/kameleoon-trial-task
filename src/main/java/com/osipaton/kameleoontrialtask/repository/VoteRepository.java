package com.osipaton.kameleoontrialtask.repository;

import com.osipaton.kameleoontrialtask.entity.Vote;
import com.osipaton.kameleoontrialtask.entity.VoteType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository  extends JpaRepository<Vote, Long> {
    int countByQuoteIdAndType(Long quoteId, VoteType upvote);
}
