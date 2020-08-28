package com.example;

import com.example.dao.IAccountDAO;
import com.example.dao.IUserDAO;
import com.example.domain.Account;
import com.example.domain.QueryVO;
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

public class AccountTest {

    private InputStream in ;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IAccountDAO accountDAO;

    @Test
    public void testFindAll() {
        List<Account> accounts = accountDAO.findAll();
        for(Account account: accounts) {
            System.out.println(account);
        }
    }

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession();
        accountDAO = session.getMapper(IAccountDAO.class);
    }
    @After
    public void destroy() throws Exception{
        session.commit();   // 事务
        session.close();
        in.close();
    }
}
