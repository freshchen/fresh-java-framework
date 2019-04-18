package com.ecnu.springbootmvc.service.impl;

import com.ecnu.springbootmvc.bean.User;
import com.ecnu.springbootmvc.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @anthor LingChen
 * @create 4/18/2019 4:57 PM
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    User user;

    @Override
    public String initUser(int age, String name, String city) {
        user.setAge(age);
        user.setName(name);
        user.setCity(city);

        return "success";
    }

    @Override
    public User findAllUser() {
        return user;
    }
}
