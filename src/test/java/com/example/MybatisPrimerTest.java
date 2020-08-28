package com.example;

import com.example.dao.IUserDAO;
import com.example.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Mybatis 入门示例
 */
public class MybatisPrimerTest {
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = builder.build(in);

        SqlSession session = factory.openSession();

        IUserDAO userDao = session.getMapper(IUserDAO.class);

        List<User> users = userDao.findAllUsers();
        for(User user : users) {
            System.out.println(user);
        }

        session.close();
        in.close();
    }
}
