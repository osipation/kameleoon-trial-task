package com.osipaton.kameleoontrialtask.service;

import com.osipaton.kameleoontrialtask.EntityMapper;
import com.osipaton.kameleoontrialtask.dto.UserDTO;
import com.osipaton.kameleoontrialtask.entity.User;
import com.osipaton.kameleoontrialtask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityMapper mapper;

    public void login(UserDTO userDTO) {
        User user = mapper.dtoToEntity(userDTO);
        userRepository.save(user);
    }
}
