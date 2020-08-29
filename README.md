# mybatis-learning-examples

## 参考资料
[1] https://www.bilibili.com/video/av69586111 <br />
[2] [mybatis 官方文档](https://mybatis.org/mybatis-3/zh/index.html)
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
- 配置文件方式见源码（User+IUserDAO+IUserDAO.xml+SqlMapConfig.xml+MybatisPrimerTest.java）
- 注解方式，去除 IUserDAO.xml，其他修改处见配置文件对应注释代码

# Day2 单表 CRUD
可参看 IUserDAO.java+IUserDAO.xml+MybatisCRUDTest.java 
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
见 multi-table 分支
# Day4 注解开发
见 annotation 分支

# 其他
## 延迟加载
针对一对多或多对多的情况，可以先对左边单表查询，关联的右边的表在用到的时候再查询，自然可提高查询速度。<br />
但是当用户用到右边表关联的数据比较大时，用户需要等待较长的查询时间，用户体验就不好了。
## 缓存
把经常使用的数据缓存到内存，再次使用到该数据时，只需要查内存，不用查数据库，减少与数据库交互，提高查询速度。<br />
- 一级缓存：一级缓存是 SqlSession 级别的缓存，当调用 SqlSession 的修改，添加，删除，commit()，close()等，<br />
          一级缓存被清空。
- 二级缓存：二级缓存是 mapper 映射级别的缓存，多个 SqlSession 去操作同一个 Mapper 映射的 sql 语句，多个 <br />
          SqlSession 可以共用二级缓存，二级缓存是跨 SqlSession 的。
# Next
实践完以上内容即入门了，接下来可阅读[官方文档](https://mybatis.org/mybatis-3/zh/index.html)建立完备的 mybatis 知识体系。