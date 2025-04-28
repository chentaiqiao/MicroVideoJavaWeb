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
import java.util.List;

@WebServlet("/userList")
public class UserListController extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList =userService.queryAll();
        //System.out.println(videoList);
        request.setAttribute("userList",userList);
        //response.sendRedirect("/admin/video/list.jsp");
        request.getRequestDispatcher("/admin/user/list.jsp").forward(request,response);
    }
}
