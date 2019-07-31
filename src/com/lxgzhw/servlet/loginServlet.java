package com.lxgzhw.servlet;

import com.lxgzhw.dao.UserDao;
import com.lxgzhw.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("loginDemo");
        //1.设置编码
        request.setCharacterEncoding("utf8");
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //封装user
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);

        //调用dao的login方法
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        if (user != null) {
            System.out.println("登录成功");
            request.setAttribute("user", user);
            //跳转
            request.getRequestDispatcher("/successServlet")
                    .forward(request, response);
        } else {
            System.out.println("用户名或密码错误");
            request.getRequestDispatcher("/failServlet")
                    .forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
