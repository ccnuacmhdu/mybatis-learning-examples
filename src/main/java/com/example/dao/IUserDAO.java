package com.example.dao;

import com.example.domain.Account;
import com.example.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDAO {
    @Select("select * from user")
    @Results(id="userMap",
            value= {
                    @Result(id=true,column="id",property="id"),
                    @Result(column="username",property="username"),
                    @Result(column="sex",property="sex"),
                    @Result(column="address",property="address"),
                    @Result(column="birthday",property="birthday")
            })
    List<User> findAll();

    @Select("select * from user where id = #{id}")
    @ResultMap("userMap")
    User findById(Integer id);

    @Insert("insert into user(username,sex,address,birthday) " +
            "values(#{username},#{sex},#{address},#{birthday})")
    @SelectKey(before = false,keyColumn = "id",keyProperty = "id",resultType = Integer.class,
                statement = "select last_insert_id()")
    int add(User user);

    @Update("update user set username=#{username},sex=#{sex},address=#{address},birthday=#{birthday} where id=#{id}")
    @SelectKey(before = false,keyColumn = "id",keyProperty = "id",resultType = Integer.class,
            statement = "select last_insert_id()")
    int update(User user);

    @Delete("delete from user where id = #{id}")
    int delete(Integer id);

    @Select("select count(*) from user")
    int findTotal();

    @Select("select * from user where username like #{username} ")
    List<User> findByName(String name);

    // 一个 User 对多个 Account
    @Select("select * from user")
    @Results(id = "complexUserMap", value = {
            @Result(id=true,column="id",property="id"),
            @Result(column="username",property="username"),
            @Result(column="sex",property="sex"),
            @Result(column="address",property="address"),
            @Result(column="birthday",property="birthday"),
            @Result(column = "id", property = "accounts", /*javaType = List.class,*/
                    many = @Many(select = "com.example.dao.IAccountDAO.findByUid"))
    })
    List<User> findAllUsers();
}
