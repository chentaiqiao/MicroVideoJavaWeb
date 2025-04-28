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
import java.util.regex.Pattern;

@WebServlet("/userPerfect")
public class UserPerfectController extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> itemList = null;
        User user = new User();
        //上传目录的准备
        File coverUploadDir = new File(request.getServletContext().getRealPath("/head_upload"));
        if(!coverUploadDir.exists()){
            coverUploadDir.mkdirs();
        }
        //1.获取用户所填信息
        try {
            itemList = upload.parseRequest(request);
            //2.将信息封装成user对象
            for(FileItem fileItem : itemList){
                // 如果是普通文本
                if(fileItem.isFormField()){
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");
                    if(name.equals("nick_name")){
                        user.setNick_name(value);
                    }
                    if(name.equals("account")){
                        user.setAccount(value);
                    }
                    if(name.equals("password")){
                        user.setPassword(value);
                    }
                    if(name.equals("gender")){
                        user.setGender(value);
                    }
                    if(name.equals("birthday")){
                        user.setBirthday(value);
                    }
                    if(name.equals("phone")){
                        user.setPhone(value);
                    }
                    if(name.equals("email")){
                        user.setEmail(value);
                    }
                    if(name.equals("description")){
                        user.setDescription(value);
                    }
                    if(name.equals("birthplace")){
                        user.setBirthplace(value);
                    }
                }
                // 如果不是普通文本(就是文件上传域)
                else{

                    String fileName = fileItem.getName(); // xxx.png
                    System.out.println("fileName = "+fileName);
                    // 获取文件的后缀名
                    String fileSuffix = fileName.substring(fileName.lastIndexOf(".")); // .png
                    fileName = UUID.randomUUID().toString();

                    if(fileSuffix.equalsIgnoreCase(".jpg")||fileSuffix.equalsIgnoreCase(".png")){
                        String uploadFileName = request.getServletContext().getRealPath("/head_upload/")+"/"+ fileName+fileSuffix;
                        // 将视频路径设置给 video 对象
                        user.setHead_pic("/"+fileName+fileSuffix);

                        // 使用IO流将数据上传到服务器指定位置
                        InputStream is = fileItem.getInputStream();
                        OutputStream os = new FileOutputStream(uploadFileName);
                        byte[] bytes = new byte[1024*4];
                        int length = 0;
                        while((length=is.read(bytes))!=-1){
                            os.write(bytes,0,length);
                        }
                        is.close();
                        os.close();
                    }else{
                        System.out.println("not a head_pic!");
                    }

                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        System.out.println("user =>"+user);
        //3，检查；调用服务方法，添加到数据库


        userService.add(user);
        //4.页面跳转至用户登录
        response.sendRedirect("/front/login.jsp");
    }
}
