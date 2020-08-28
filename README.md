# mybatis-learning-examples

## 特别说明
这是本人的 Mybatis 学习笔记，学习地址是 https://www.bilibili.com/video/av69586111

# Day1
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
入门示例
- 配置文件方式见源码（User+IUserDAO+IUserDAO.xml+SqlMapConfig.xml）
- 注解方式，去除 IUserDAO.xml，其他修改处见配置文件对应注释代码