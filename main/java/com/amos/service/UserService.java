package com.amos.service;

import com.amos.entity.User;

/**
 * @author Amos
 * @date 2020-10-28 20:29
 */
public interface UserService {

    User checkUser(String username,String password);
}
