package com.example.dao;

import com.example.domain.Account;
import com.example.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IAccountDAO {
    @Select("select * from account")
    @Results(id = "accountMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "money", property = "money"),
            @Result(column = "uid", property = "user", javaType = User.class,
                    one = @One(select = "com.example.dao.IUserDAO.findById")
            )
    })
    List<Account> findAll();

    @Select("select * from account where uid = #{uid}")
    @ResultMap("accountMap")
    List<Account> findByUid(Integer uid);
}
