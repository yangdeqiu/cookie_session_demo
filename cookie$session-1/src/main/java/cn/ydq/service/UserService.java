package cn.ydq.service;

import cn.ydq.entity.User;
import cn.ydq.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean getLogin(User user) {
        return userMapper.getUser(user) != null ? true : false;
    }
}
