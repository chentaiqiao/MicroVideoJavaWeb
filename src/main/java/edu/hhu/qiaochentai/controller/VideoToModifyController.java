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

@WebServlet("/videoToModify")
public class VideoToModifyController extends HttpServlet {

    private VideoService videoService = new VideoServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Video video= videoService.queryById(id);
        System.out.println(video.getCoverPath());
        System.out.println(video.getVideoPath());
        request.setAttribute("video",video);
        request.getRequestDispatcher("/admin/video/modify.jsp").forward(request,response);
    }
}
