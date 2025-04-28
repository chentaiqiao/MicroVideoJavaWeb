package edu.hhu.qiaochentai.controller;

import edu.hhu.qiaochentai.entity.Admin;
import edu.hhu.qiaochentai.service.AdminService;
import edu.hhu.qiaochentai.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminLogin")
public class AdminLoginController extends HttpServlet {

    private AdminService adminService=new AdminServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1.获取管理员账户密码
        String account =request.getParameter("account");
        String password =request.getParameter("password");
        //2.根据账户密码取数据库查，是否有此人
        Admin admin=adminService.login(account,password);
        //3.登录成功

        if(admin!=null){
            //System.out.println(System.getProperty("file.encoding"));
            request.getSession().setAttribute("admin",admin);
            response.sendRedirect("/videoList");

        }
        //4.失败
        else{
            response.sendRedirect("/admin/login_fail.jsp");
        }
    }
}
