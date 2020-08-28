package com.example;

import com.example.dao.IUserDAO;
import com.example.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserTest {

    private InputStream in ;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDAO userDAO;

    @Test
    public void testFindAll() {
        List<User> users = userDAO.findAll();
        for(User user: users) {
            System.out.println(user);
        }
    }

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession();
        userDAO = session.getMapper(IUserDAO.class);
    }
    @After
    public void destroy() throws Exception{
        session.commit();   // 事务
        session.close();
        in.close();
    }
}
