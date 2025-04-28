package edu.hhu.qiaochentai.controller;

import edu.hhu.qiaochentai.entity.User;
import edu.hhu.qiaochentai.service.UserService;
import edu.hhu.qiaochentai.service.impl.UserServiceImpl;
import edu.hhu.qiaochentai.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

@WebServlet("/UserCheckAccount")
public class UserCheckAccountController extends HttpServlet {

    private UserService userService=new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        //1.获取用户所填信息
        String account=request.getParameter("account");


        QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDruidDataSource());
        String sql=" select * from t_user where account=?; ";
        User check_user=null;
        try {
            check_user=queryRunner.query(sql,new BeanHandler<>(User.class),account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("check_user =>"+check_user);
        boolean isExist=true;
        if(check_user==null){
            isExist=false;
        }
        System.out.println("isExist =>"+isExist);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.write(""+isExist);
        out.close();

    }
}
