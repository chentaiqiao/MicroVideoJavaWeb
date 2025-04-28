package edu.hhu.qiaochentai.controller;

import edu.hhu.qiaochentai.entity.Admin;
import edu.hhu.qiaochentai.entity.User;
import edu.hhu.qiaochentai.service.AdminService;
import edu.hhu.qiaochentai.service.UserService;
import edu.hhu.qiaochentai.service.impl.AdminServiceImpl;
import edu.hhu.qiaochentai.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userLogin")
public class UserLoginController extends HttpServlet {

    private UserService userService=new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1.获取管理员账户密码
        String account =request.getParameter("account");
        String password =request.getParameter("password");
        //2.根据账户密码取数据库查，是否有此人
        User user=userService.login(account,password);
        //3.登录成功

        if(user!=null){
            request.getSession().setAttribute("user",user);
            response.sendRedirect("/userVideo");

        }


        //4.失败
        else{
            response.sendRedirect("/front/login_fail.jsp");
        }
    }
}
