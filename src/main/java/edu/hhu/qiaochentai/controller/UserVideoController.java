package edu.hhu.qiaochentai.controller;


import edu.hhu.qiaochentai.entity.Video;
import edu.hhu.qiaochentai.service.VideoService;
import edu.hhu.qiaochentai.service.impl.VideoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userVideo")
public class UserVideoController extends HttpServlet {

    private VideoService videoService = new VideoServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Video> videoList =videoService.queryAll();
        //System.out.println(videoList);
        request.setAttribute("videoList",videoList);
        //response.sendRedirect("/admin/video/list.jsp");
        request.getRequestDispatcher("/front/videoList.jsp").forward(request,response);
    }
}
