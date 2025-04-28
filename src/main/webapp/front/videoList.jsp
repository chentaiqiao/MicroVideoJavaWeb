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
        <title>用户视频列表页面</title>
        <link href="/css/bootstrap.css" rel="stylesheet">
        <script src="/js/jquery-3.6.0.js"></script>
        <script src="/js/bootstrap.js"></script>
    </head>
    <body>
        <div class="container" style="margin-top: 30px">
            <div class="row">
                <div class="col-md-12" style="text-align: center">
                    <h3>视频列表</h3>
                </div>
            </div>
            <div class="row" style="margin-top: 20px">
                <div class="col-md-10"></div>
                <div class="col-md-2">欢迎你，${sessionScope.user.nick_name}</div>
            </div>
            <div class="row" style="margin-top: 20px">
                <div class="col-md-2">
                    <a href="/userDetail?id=${sessionScope.user.id}">我的个人信息</a>
                    </br> </br>
                    <a href="/userWatchHistory?id=${sessionScope.user.id}">我的观看记录</a>
                    </br> </br>
                    <a href="/userRemove?id=${sessionScope.user.id}&isUser=1">账号注销</a>


                </div>
                <div class="col-md-10">
                    <table class="table table-striped table-bordered table-hover">
                        <tr>
                            <td>序号</td>
                            <td>名称</td>
                            <td>作者</td>
                            <td>类型</td>
                            <td>时长（分钟）</td>
                            <td>操作</td>
                        </tr>

                        <c:forEach var="video" items="${requestScope.videoList}" varStatus="status" >
                            <tr>
                                <td>${status.count}</td>
                                <td>${video.name}</td>
                                <td>${video.author}</td>
                                <td>${video.type}</td>
                                <td>${video.timeLength}</td>
                                <td>
                                    <a class="btn btn-info btn-xs" href="/videoDetail?id=${video.id}">明细</a>
                                    <a class="btn btn-info btn-xs" href="/videoWatch?videoId=${video.id}&userId=${sessionScope.user.id}">播放</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
