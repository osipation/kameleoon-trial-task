package com.osipaton.kameleoontrialtask;

import com.osipaton.kameleoontrialtask.dto.UserDTO;
import com.osipaton.kameleoontrialtask.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EntityMapper {

    @Autowired
    private Encoder encoder;

    public User dtoToEntity(UserDTO dto) {
        User user = new User();

        user.setName(dto.getName());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setEmail(dto.getEmail());
        user.setCreateDate(LocalDateTime.now());

        return user;

    }
}
