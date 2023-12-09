package com.osipaton.kameleoontrialtask.repository;

import com.osipaton.kameleoontrialtask.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository  extends JpaRepository<Vote, Long> {
}
