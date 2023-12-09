package com.osipaton.kameleoontrialtask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuoteDTO {

    private String content;

    private Long userId;

}
