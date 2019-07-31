package com.lxgzhw.test;

import com.lxgzhw.dao.UserDao;
import com.lxgzhw.domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testLogin() {
        User user = new User();
        user.setUsername("lxgzhw");
        user.setPassword("lxgzhw");
        UserDao dao = new UserDao();
        User loginUser = dao.login(user);
        System.out.println(user);
        System.out.println(loginUser);
    }
}
