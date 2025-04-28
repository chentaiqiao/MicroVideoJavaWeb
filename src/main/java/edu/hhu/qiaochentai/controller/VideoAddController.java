package edu.hhu.qiaochentai.controller;

import edu.hhu.qiaochentai.entity.Video;
import edu.hhu.qiaochentai.service.VideoService;
import edu.hhu.qiaochentai.service.impl.VideoServiceImpl;
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

@WebServlet("/videoAdd")
public class VideoAddController extends HttpServlet {

    private VideoService videoService = new VideoServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> itemList = null;
        Video video = new Video();
        //上传目录的准备
        File videoUploadDir = new File(request.getServletContext().getRealPath("/video_upload"));
        if(!videoUploadDir.exists()){
            videoUploadDir.mkdirs();
        }
        File coverUploadDir = new File(request.getServletContext().getRealPath("/cover_upload"));
        if(!coverUploadDir.exists()){
            coverUploadDir.mkdirs();
        }
        //1.获取用户所填信息
        try {
            itemList = upload.parseRequest(request);
            //2.将信息封装成video对象
            for(FileItem fileItem : itemList){
                // 如果是普通文本
                if(fileItem.isFormField()){
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");
                    if(name.equals("name")){
                        video.setName(value);
                    }
                    if(name.equals("author")){
                        video.setAuthor(value);
                    }
                    if(name.equals("type")){
                        video.setType(value);
                    }
                    if(name.equals("createTime")){
                        video.setCreateTime(value);
                    }
                    if(name.equals("timeLength")){
                        //video.setTimeLength(Integer.parseInt(value));
                        video.setTimeLength(Integer.parseInt(value));
                    }
                    if(name.equals("description")){
                        video.setDescription(value);
                    }
                }
                // 如果不是普通文本(就是文件上传域)
                else{

                    String fileName = fileItem.getName(); // xxx.mp4
                        System.out.println("fileName = "+fileName);
                    // 获取文件的后缀名
                    String fileSuffix = fileName.substring(fileName.lastIndexOf(".")); // .mp4
                    fileName = UUID.randomUUID().toString();

                    if(fileSuffix.equalsIgnoreCase(".mp4")||fileSuffix.equalsIgnoreCase(".avi")){
                        String uploadFileName = request.getServletContext().getRealPath("/video_upload/")+"/"+ fileName+fileSuffix;
                        // 将视频路径设置给 video 对象
                        video.setVideoPath("/"+fileName+fileSuffix);

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
                        //处理封面上传
                        String uploadFileName = request.getServletContext().getRealPath("/cover_upload/")+"/"+ fileName+fileSuffix;
                        // 将封面路径设置给 video 对象
                        video.setCoverPath("/"+fileName+fileSuffix);

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
                    }

                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        System.out.println("video =>"+video);
        //3，调用服务方法，添加到数据库
        videoService.add(video);
        //4.页面跳转至视频列表
        response.sendRedirect("/videoList");
    }
}
