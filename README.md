# mybatis-learning-examples

# 参考资料
 [1] https://www.bilibili.com/video/av69586111 <br />
 [2] [mybatis 官方文档](https://mybatis.org/mybatis-3/zh/index.html)
# Day3 多表查询
- 一对一：【一个 Account 对应唯一一个 User】IAccountDAO.findAll<br />
  Account.java+IAccountDAO.xml+IAccountDAO.java+AccountTest.java
- 一对多：【一个 User 对应多个 Account】IUserDAO.findAll<br />
  User.java+IUserDAO.xml+IUserDAO.java+UserTest.java
- 多对多：【Role 和 User 是多对多关系，查每个 Role 对应哪些 User】<br />
  Role.java+IRoleDAO.java+IRoleDAO.xml+RoleTest.java
  （需要准备数据库表 role + user_role，具体见 mybatis.sql）
- 多对多：【User 和 Role 是多对多关系，查每个 User 对应哪些 Role】<br />
  实现（略）