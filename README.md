# mybatis-learning-examples

## 特别说明
这是本人的 Mybatis 学习笔记，学习地址是 https://www.bilibili.com/video/av69586111

## Day1
搭建环境（IDEA 2020.1.2 + MySQL 5.5.15 + Java 1.8 + Maven）
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
