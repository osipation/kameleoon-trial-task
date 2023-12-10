package com.osipaton.kameleoontrialtask.dto;

import com.osipaton.kameleoontrialtask.entity.VoteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VoteDTO {

    private VoteType type;

    private LocalDateTime createDate;
}
