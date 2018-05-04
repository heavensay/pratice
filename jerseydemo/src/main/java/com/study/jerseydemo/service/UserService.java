package com.study.jerseydemo.service;

import com.study.jerseydemo.web.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User queryUser(){
        User user = new User();
        user.setId(1);
        user.setAge(18);
        user.setName("tom");
        return user;
    }
}
