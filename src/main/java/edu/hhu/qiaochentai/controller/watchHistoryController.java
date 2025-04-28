package edu.hhu.qiaochentai.controller;


import edu.hhu.qiaochentai.entity.WatchVideo;
import edu.hhu.qiaochentai.service.WatchVideoService;
import edu.hhu.qiaochentai.service.impl.WatchVideoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.WatchService;
import java.util.List;






@WebServlet("/watchHistory")
public class watchHistoryController extends HttpServlet {
    private WatchVideoService watchVideoService = new WatchVideoServiceImpl();


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<WatchVideo> watchList = watchVideoService.queryAll();
        request.setAttribute("watchList",watchList);
        request.getRequestDispatcher("/admin/watchHistory/list.jsp").forward(request,response);
    }
}


