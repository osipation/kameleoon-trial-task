package com.osipaton.kameleoontrialtask.repository;

import com.osipaton.kameleoontrialtask.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Quote q " +
            "  SET q.content = :content " +
            "WHERE q.id = :id")
    void updateQuoteContent(@Param("id") Long id, @Param("content") String content);

    @Query("SELECT q.id " +
            " FROM Quote q ")
    List<Long> getListOfAllIds();

}
