package com.amos.service.Impl;

import com.amos.dao.UserDao;
import com.amos.entity.User;
import com.amos.service.UserService;
import com.amos.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Amos
 * @date 2020-10-28 20:31
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    /**
     * 这里主要是获取数据库中的用户名和密码，通过控制器传递过来的密码进行解析匹配，匹配成功则登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public User checkUser(String username, String password) {
        User user  = userDao.findByUsernameAndPassword(username, MD5Util.code(password));
        return user;
    }



}
