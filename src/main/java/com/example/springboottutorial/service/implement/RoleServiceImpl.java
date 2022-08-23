package com.example.springboottutorial.service.implement;

import com.example.springboottutorial.dto.login.UserLoginDto;
import com.example.springboottutorial.service.interfaces.RoleService;
import com.example.springboottutorial.utils.DatabaseConnector;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public List<String> getRoleNamesByUserId(int userId) {
        List<String> roleNameList = new ArrayList<>();
        try(Connection connection = DatabaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM role " +
                    "WHERE role.role_id IN " +
                    "(SELECT role_id FROM user_role WHERE user_role.user_id = ?)");
            preparedStatement.setObject(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String roleName;
                roleName = rs.getString("role.name");
                roleNameList.add(roleName);
            }
            preparedStatement.close();
            connection.close();
            return roleNameList;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
