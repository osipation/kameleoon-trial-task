package com.osipaton.kameleoontrialtask.repository;

import com.osipaton.kameleoontrialtask.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
