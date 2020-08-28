package com.example.dao;

import com.example.domain.QueryVO;
import com.example.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDAO {
//    @Select("select * from user")
    List<User> findAllUsers();

    User findById(Integer id);

    int add(User user);

    int update(User user);

    int delete(Integer id);

    List<User> findByName(String username);

    int findTotal();

    List<User> findByUser(User user);

    List<User> findInIds(QueryVO queryVO);
}
