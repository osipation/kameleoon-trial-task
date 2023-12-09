package com.osipaton.kameleoontrialtask.controller;

import com.osipaton.kameleoontrialtask.dto.UserDTO;
import com.osipaton.kameleoontrialtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody UserDTO userDTO) {
        userService.create(userDTO);
        return ResponseEntity.ok().build();
    }
}
