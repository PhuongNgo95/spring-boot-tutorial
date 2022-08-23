package com.example.springboottutorial.service.interfaces;

import com.example.springboottutorial.dto.login.UserLoginDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserLoginDto findUserAccount(String userName);
}
