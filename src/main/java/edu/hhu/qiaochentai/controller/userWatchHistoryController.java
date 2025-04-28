package edu.hhu.qiaochentai.controller;


import edu.hhu.qiaochentai.entity.WatchVideo;
import edu.hhu.qiaochentai.service.WatchVideoService;
import edu.hhu.qiaochentai.service.impl.WatchVideoServiceImpl;
import edu.hhu.qiaochentai.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/userWatchHistory")
public class userWatchHistoryController extends HttpServlet {
    private WatchVideoService watchVideoService = new WatchVideoServiceImpl();


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDruidDataSource());
        int id = Integer.parseInt(request.getParameter("id"));
        String sql=" select t_watch.id as id,user_id,video_id,nick_name as user_name,name as video_name  from  t_watch,t_video,t_user  where t_watch.user_id=t_user.id and t_watch.video_id=t_video.id and t_watch.user_id=?; ";
        //String sql=" select id,user_id,video_id from t_watch; ";
        List<WatchVideo> watchList=null;

        try {
            watchList= queryRunner.query(sql,new BeanListHandler<>(WatchVideo.class),id);
            System.out.println(watchList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("watchList",watchList);
        request.getRequestDispatcher("/front/watchHistory/list.jsp").forward(request,response);
    }
}


