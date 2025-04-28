package edu.hhu.qiaochentai.controller;


import edu.hhu.qiaochentai.entity.User;
import edu.hhu.qiaochentai.service.UserService;
import edu.hhu.qiaochentai.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userModify")
public class UserModifyController extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户所填
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String nick_name= request.getParameter("nick_name");
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        String gender=request.getParameter("gender");
        String birthday=request.getParameter("birthday");
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        String birthplace=request.getParameter("birthplace");
        String description=request.getParameter("description");

        //2.信息封装为video对象
        User user=new User();
        user.setId(id);
        user.setNick_name(nick_name);
        user.setAccount(account);
        user.setPassword(password);
        user.setGender(gender);
        user.setBirthday(birthday);
        user.setPhone(phone);
        user.setEmail(email);
        user.setBirthplace(birthplace);
        user.setDescription(description);

        //3.更新数据库
        userService.modify(user);
        //4页面跳转
        response.sendRedirect("/userList");
    }
}
