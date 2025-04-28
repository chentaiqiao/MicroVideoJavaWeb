package edu.hhu.qiaochentai.controller;


import edu.hhu.qiaochentai.entity.User;
import edu.hhu.qiaochentai.entity.Video;
import edu.hhu.qiaochentai.service.UserService;
import edu.hhu.qiaochentai.service.WatchVideoService;
import edu.hhu.qiaochentai.service.impl.UserServiceImpl;
import edu.hhu.qiaochentai.service.impl.WatchVideoServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/userRemove")
public class UserRemoveController extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    private WatchVideoService watchVideoService = new WatchVideoServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //删target文件里数据（视频封面），java的file类的delete()
        User user= userService.queryById(id);
        String del_coverPath=user.getHead_pic();//路径
        File del_cover=new File(request.getServletContext().getRealPath("/head_upload/")+"/"+del_coverPath);//根据路径找到文件
        if(del_cover.delete()){
            System.out.println("success");
        }else{
            System.out.println("fail");
        }
        //删数据库数据
        userService.remove(id);
        watchVideoService.remove(id);//用户id
        try{
            int isUser = Integer.parseInt(request.getParameter("isUser"));//是否为用户
            response.sendRedirect("/front/userRemove.jsp");
        } catch (Exception e) {
            response.sendRedirect("/userList");

        }


    }
}
