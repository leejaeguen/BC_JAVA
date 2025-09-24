package com.worms.userservice.service;

import com.worms.userservice.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void registUser(UserDTO userDTO);
}
