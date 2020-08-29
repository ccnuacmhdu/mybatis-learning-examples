package com.example;

import com.example.dao.IRoleDAO;
import com.example.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class RoleTest {

    private InputStream in ;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IRoleDAO roleDAO;

    @Test
    public void testFindAll() {
        List<Role> roles = roleDAO.findAll();
        for(Role role: roles) {
            System.out.println(role);
        }
    }

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession();
        roleDAO = session.getMapper(IRoleDAO.class);
    }
    @After
    public void destroy() throws Exception{
        session.commit();   // 事务
        session.close();
        in.close();
    }
}
