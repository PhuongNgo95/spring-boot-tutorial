package com.example.springboottutorial.service.implement;

import com.example.springboottutorial.dto.login.UserLoginDto;
import com.example.springboottutorial.service.interfaces.UserService;
import com.example.springboottutorial.utils.DatabaseConnector;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserLoginDto findUserAccount(String userName) {
        UserLoginDto user = new UserLoginDto();
        try (Connection connection = DatabaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE user.user_name = ?");
            preparedStatement.setObject(1, userName);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user.setUserId(rs.getInt("user.user_id"));
                user.setUserName(rs.getString("user.user_name"));
                user.setEncrytedPassword(rs.getString("user.password"));
                user.setEnabled(rs.getInt("user.status"));
            }
            preparedStatement.close();
            connection.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
