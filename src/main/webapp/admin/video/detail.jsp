<%--
  Created by IntelliJ IDEA.
  User: 17973
  Date: 2022/10/24
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>后台视频明细页面</title>
        <link href="/css/bootstrap.css" rel="stylesheet">
        <script src="/js/jquery-3.6.0.js"></script>
        <script src="/js/bootstrap.js"></script>
        <script src="/js/My97DatePicker/WdatePicker.js"></script>
    </head>
    <body>
        <div class="container" style="margin-top: 30px">
            <div class="row">
                <div class="col-md-12" style="text-align: center">
                    <h3>视频明细</h3>
                </div>
            </div>
            <div class="row" style="margin-top: 20px">
                <div class="col-md-10"></div>
                <div class="col-md-2"></div>
            </div>
            <div class="row" style="margin-top: 20px">

                <div class="col-md-10">

                    <form class="form-horizontal" action="#" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">名称:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="${requestScope.video.name}" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">作者:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="${requestScope.video.author}" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">视频类型:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="${requestScope.video.type}" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">创建时间:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="${requestScope.video.createTime}" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">时长:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="${requestScope.video.timeLength}" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">视频:</label>
                            <div class="col-sm-10">
                                <video width="320" height="240" poster="/cover_upload${requestScope.video.coverPath}" controls>
                                    <source src="/video_upload${requestScope.video.videoPath}" type="video/mp4">
                                </video>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-2 control-label">视频描述:</label>
                            <div class="col-sm-10">
                                <textarea style="resize: none;" class="form-control" rows="5">${requestScope.video.description}</textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-4"></div>
                            <div class="col-md-4" style="text-align: center">
                                <input class="btn btn-primary" type="button" value="返回" onclick="history.back()"/>
                            </div>
                            <div class="col-md-4"></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
