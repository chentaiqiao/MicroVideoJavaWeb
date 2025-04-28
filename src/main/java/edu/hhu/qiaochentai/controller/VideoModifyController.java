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

@WebServlet("/videoModify")
public class VideoModifyController extends HttpServlet {

    private VideoService videoService = new VideoServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户所填
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name= request.getParameter("name");
        String author=request.getParameter("author");
        String type=request.getParameter("type");
        String createTime=request.getParameter("createTime");
        Integer timeLength=Integer.parseInt(request.getParameter("timeLength"));
        String description=request.getParameter("description");
        //2.信息封装为video对象
        Video video=new Video();
        video.setId(id);
        video.setName(name);
        video.setAuthor(author);
        video.setType(type);
        video.setCreateTime(createTime);
        video.setTimeLength(timeLength);
        video.setDescription(description);

        //3.更新数据库
        videoService.modify(video);
        //4页面跳转
        response.sendRedirect("/videoList");
    }
}
