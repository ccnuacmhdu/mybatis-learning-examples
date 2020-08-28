package com.example.dao;

import com.example.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDAO {
//    @Select("select * from user")
    List<User> findAllUsers();
}
