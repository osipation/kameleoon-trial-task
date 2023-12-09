package com.osipaton.kameleoontrialtask.dto;

import com.osipaton.kameleoontrialtask.entity.Vote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuoteDTO {

    private Long id;

    private String content;

    private Long userId;

    private List<Vote> votes;
}
