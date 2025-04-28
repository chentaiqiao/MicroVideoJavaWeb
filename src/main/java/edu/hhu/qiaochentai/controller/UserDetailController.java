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

@WebServlet("/userDetail")
public class UserDetailController extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user= userService.queryById(id);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/admin/user/detail.jsp").forward(request,response);
    }
}
