package com.example.springboottutorial.service.interfaces;

import com.example.springboottutorial.dto.login.UserLoginDto;

import java.util.List;

public interface RoleService {
    List<String> getRoleNamesByUserId(int userId);
}
