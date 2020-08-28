package com.example;

import com.example.dao.IUserDAO;
import com.example.domain.QueryVO;
import com.example.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Mybatis CRUD 示例
 */
public class MybatisCRUDTest {

    private InputStream in ;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDAO userDAO;

    @Test
    public void testFindById() {
        User user = userDAO.findById(1);
        System.out.println(user);
    }

    @Test
    public void testAdd() {
        User user = new User();
        user.setUsername("Rose");
        user.setSex("男");
        user.setBirthday(LocalDateTime.of(1999, 9, 1, 0, 0, 0));
        user.setAddress("Beijing");

        System.out.println(user);
        int i = userDAO.add(user);  // 1
        System.out.println(i + " " + user); // 插入的那个 User，id 值有了
    }

    @Test
    public void testUpdate() {
        User user = userDAO.findById(1);
        user.setAddress("北京海淀区");
        int res = userDAO.update(user); // 1
        System.out.println(res + " " + user);
    }

    @Test
    public void testDelete() {
        int res = userDAO.delete(3);
        System.out.println(res);
    }

    @Test
    public void testFindByName() {
        List<User> users = userDAO.findByName("%Rose%");
        for(User user: users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() {
        int res = userDAO.findTotal();
        System.out.println(res);
    }

    @Test
    public void testFindByUser() {
        User user = new User();
        user.setUsername("%Rose%");
        user.setAddress("%hai%");
        List<User> users = userDAO.findByUser(user);
        for(User u: users) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindInIds() {
        QueryVO queryVO = new QueryVO();
        List<Integer> ids = Arrays.asList(1, 2, 3, 4, 5);
        queryVO.setIds(ids);
        List<User> users = userDAO.findInIds(queryVO);
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
