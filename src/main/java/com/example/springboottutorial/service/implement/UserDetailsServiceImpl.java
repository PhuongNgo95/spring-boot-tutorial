package com.example.springboottutorial.service.implement;

import com.example.springboottutorial.dto.login.UserLoginDto;
import com.example.springboottutorial.service.interfaces.RoleService;
import com.example.springboottutorial.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserLoginDto userLogin = userService.findUserAccount(userName);
        if (userLogin == null || userLogin.getEnabled() != 1){
            System.out.println("User not found!");
            throw new UsernameNotFoundException("User " + userName + " was not found or be disabled by admin");
        }
        List<String> roleNames = roleService.getRoleNamesByUserId(userLogin.getUserId());
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();

        if (roleNames != null){
            for (String role: roleNames){
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantedAuthorityList.add(authority);
            }
        }
        UserDetails userDetails = (UserDetails) new User(userLogin.getUserName(), userLogin.getEncrytedPassword(), grantedAuthorityList);
        return userDetails;
    }

//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private RoleService roleService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserLoginDto userLogin = userService.findUserAccount(username);
//        if (userLogin == null || userLogin.getEnabled() != 1){
//            System.out.println("User not found!");
//            throw new UsernameNotFoundException("User " + username + " was not found or be disabled by admin");
//        }
////        System.out.println("Found user: " + userName);
//
//        List<String> roleNames = roleService.getRoleNamesByUserId(userLogin.getUserId());
//        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
//
//        if (roleNames != null){
//            for (String role: roleNames){
//                GrantedAuthority authority = new SimpleGrantedAuthority(role);
//                grantedAuthorityList.add(authority);
//            }
//        }
//        UserDetails userDetails = (UserDetails) new User(userLogin.getUserName(), userLogin.getEncrytedPassword(), grantedAuthorityList);
//        return userDetails;
////        return null;
//    }
}
