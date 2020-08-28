# mybatis-learning-examples

## 特别说明
这是本人的 Mybatis 学习笔记，学习地址是 https://www.bilibili.com/video/av69586111

# Day1 入门示例
## 搭建环境（建立 Github 项目）
IDEA 建立 Maven 项目（IDEA 2020.1.2 + MySQL 5.5.15 + Java 1.8 + Maven 3.6.3）
```$xslt
<dependencies>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.4.5</version>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.6</version>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
    </dependencies>
```
Github 创建项目 mybatis-learning-examples，建立本地和远程关联
```$xslt
// 项目根目录下
git init
git add .
git commit -m"init mybatis-learning-examples"
git remote add origin git@github.com:ccnuacmhdu/mybatis-learning-examples.git
git pull --rebase origin master
git push --set-upstream origin master 
```
## 入门示例
- 配置文件方式见源码（User+IUserDAO+IUserDAO.xml+SqlMapConfig.xml）
- 注解方式，去除 IUserDAO.xml，其他修改处见配置文件对应注释代码

# Day2 单表 CRUD
## 实体属性名和数据库列名不一致情况
```$xslt
public class User {
    private Integer userId;
    private String userName;
    private Date userBirthday;
    private String userSex;
    private String userAddress;
    ……  // 省略 setter/getter
```
处理方式1
```$xslt
<select id="findAll" resultType="com.example.domain.User">
    select id as userId,username as userName,birthday as userBirthday,
        sex as userSex,address as userAddress from user
</select>
```
处理方式2
```$xslt
<resultMap id="userMap" type="com.example.domain.User">
    <id column="id" property="userId"/>
    <result column="username" property="userName"/>
    <result column="sex" property="userSex"/>
    <result column="address" property="userAddress"/>
    <result column="birthday" property="userBirthday"/>
</resultMap>

<select id="findAll" resultMap="userMap">
    select * from user
</select>
```
# Day3 多表查询
一对一：Account 对 User
一对多：User 对 Account