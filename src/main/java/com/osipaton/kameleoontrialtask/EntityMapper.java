package com.osipaton.kameleoontrialtask;

import com.osipaton.kameleoontrialtask.dto.QuoteDTO;
import com.osipaton.kameleoontrialtask.dto.UserDTO;
import com.osipaton.kameleoontrialtask.dto.VoteDTO;
import com.osipaton.kameleoontrialtask.entity.Quote;
import com.osipaton.kameleoontrialtask.entity.User;
import com.osipaton.kameleoontrialtask.entity.Vote;
import com.osipaton.kameleoontrialtask.exception.KameleoonException;
import com.osipaton.kameleoontrialtask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class EntityMapper {

    @Autowired
    private Encoder encoder;

    @Autowired
    private UserRepository userRepository;

    public User dtoToEntity(UserDTO dto) {
        User user = new User();

        user.setName(dto.getName());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setEmail(dto.getEmail());
        user.setCreateDate(LocalDateTime.now());

        return user;
    }

    public Quote dtoToEntity(QuoteDTO dto) {
        Quote quote = new Quote();
        Optional<User> optionalUser = userRepository.findById(dto.getUserId());
        if(optionalUser.isPresent()) {
            quote.setContent(dto.getContent());
            quote.setUser(optionalUser.get());
            return quote;
        } else {
            throw new KameleoonException("User with id = " + dto.getUserId() + " does not exist");
        }
    }

    public QuoteDTO entityToDTO(Quote quote) {
        QuoteDTO dto = new QuoteDTO();

        dto.setId(quote.getId());
        dto.setContent(quote.getContent());
        dto.setUserId(quote.getUser().getId());
        dto.setVotes(quote.getVotes());

        return dto;
    }

    public VoteDTO entityToDTO(Vote vote) {
        VoteDTO dto = new VoteDTO();

        dto.setCreateDate(vote.getCreateDate());
        dto.setType(vote.getType());

        return dto;

    }
}
