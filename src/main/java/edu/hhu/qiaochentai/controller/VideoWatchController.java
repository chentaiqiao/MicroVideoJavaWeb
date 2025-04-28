package edu.hhu.qiaochentai.controller;


import edu.hhu.qiaochentai.entity.User;
import edu.hhu.qiaochentai.entity.Video;
import edu.hhu.qiaochentai.service.VideoService;
import edu.hhu.qiaochentai.service.impl.VideoServiceImpl;
import edu.hhu.qiaochentai.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/videoWatch")
public class VideoWatchController extends HttpServlet {

    private VideoService videoService = new VideoServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int videoId = Integer.parseInt(request.getParameter("videoId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        System.out.println(userId);
        Video video= videoService.queryById(videoId);
        //存用户视频播放记录
        QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDruidDataSource());
        String sql=" insert into t_watch (user_id,video_id) values(?,?) ";
        Object[] paramArray = new Object[]{
                userId,videoId
        };
        try {
            queryRunner.update(sql,paramArray);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("video",video);
        request.getRequestDispatcher("/front/videoWatch.jsp").forward(request,response);
    }
}
