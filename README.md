# mybatis-learning-examples

## 参考资料
[1] https://www.bilibili.com/video/av69586111 <br />
[2] [mybatis 官方文档](https://mybatis.org/mybatis-3/zh/index.html)

# Day4 注解开发
- 基本 CRUD <br />
  IUserDAO.java
- 一对一复杂查询（一个 Account 对应唯一 User） <br />
  IAccountDAO.java
- 一对多复杂查询（一个 User 对应多个 Account）<br />
  ```$xslt
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
    ```
  