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
import java.io.File;

@WebServlet("/videoRemove")
public class VideoRemoveController extends HttpServlet {

    private VideoService videoService = new VideoServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //删数据库数据
        //videoService.remove(id);

        //删target文件里数据（视频封面），java的file类的delete()
        Video video= videoService.queryById(id);
        String del_coverPath=video.getCoverPath();//路径
        String del_videoPath=video.getVideoPath();
        //String path =request.getServletContext().getRealPath("/video_upload");
        //System.out.println(path);
        File del_cover=new File(request.getServletContext().getRealPath("/cover_upload/")+"/"+del_coverPath);//根据路径找到文件
        File del_video=new File(request.getServletContext().getRealPath("/video_upload/")+"/"+del_videoPath);
        //System.out.println(request.getServletContext().getRealPath("/cover_upload/")+"/"+del_coverPath);
        //System.out.println(del_cover);
        System.out.println(del_video.delete());
        if(del_cover.delete()){
            System.out.println("success");
            //删数据库数据
            videoService.remove(id);
        }else{
            System.out.println("fail");
        }
        response.sendRedirect("/videoList");
    }
}
