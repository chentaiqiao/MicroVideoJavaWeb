package edu.hhu.qiaochentai.controller;

import edu.hhu.qiaochentai.entity.User;
import edu.hhu.qiaochentai.service.UserService;
import edu.hhu.qiaochentai.service.impl.UserServiceImpl;
import edu.hhu.qiaochentai.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

@WebServlet("/userAdd")
public class UserAddController extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        User user = new User();
        request.setCharacterEncoding("UTF-8");

        //1.获取用户所填信息
        String nick_name =request.getParameter("nick_name");
        String account =request.getParameter("account");
        String password =request.getParameter("password");
        String gender =request.getParameter("gender");
        String birthday =request.getParameter("birthday");
        String phone =request.getParameter("phone");
        String email =request.getParameter("email");
        String description =request.getParameter("description");
        String birthplace =request.getParameter("birthplace");
        user.setNick_name(nick_name);
        user.setAccount(account);
        user.setPassword(password);
        user.setGender(gender);
        user.setBirthday(birthday);
        user.setPhone(phone);
        user.setEmail(email);
        user.setDescription(description);
        user.setBirthplace(birthplace);


        System.out.println("user =>"+user);
        //3，调用服务方法，添加到数据库

        //userService.add(user);
        //4.页面跳转至用户登录
        request.setAttribute("user",user);
        request.getRequestDispatcher("/front/register_perfect.jsp").forward(request,response);

    }
}
