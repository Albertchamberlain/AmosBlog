package com.amos.dao;

import com.amos.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Amos
 * @date 2020-10-28 19:41
 */


@Mapper
@Repository
public interface UserDao {

    /**
     * 根据用户名和密码查找
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}
