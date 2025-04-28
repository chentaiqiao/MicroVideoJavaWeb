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
        <title>后台观看记录页面</title>
        <link href="/css/bootstrap.css" rel="stylesheet">
        <script src="/js/jquery-3.6.0.js"></script>
        <script src="/js/bootstrap.js"></script>
    </head>
    <body>
        <div class="container" style="margin-top: 30px">
            <div class="row">
                <div class="col-md-12" style="text-align: center">
                    <h3>观看记录</h3>
                </div>
            </div>
            <div class="row" style="margin-top: 20px">
                <div class="col-md-10"></div>
                <div class="col-md-2">欢迎你，${sessionScope.admin.name}</div>
            </div>
            <div class="row" style="margin-top: 20px">
                <div class="col-md-2">
                    <a href="/userList">用户管理</a>
                    </br> </br>
                    <a href="/videoList">视频管理</a>
                    </br> </br>
                    <a href="/watchHistory">用户观看记录</a>
                </div>
                <div class="col-md-10">
                    <table class="table table-striped table-bordered table-hover">
                        <tr>
                            <td>序号</td>
                            <td>用户Id</td>
                            <td>视频Id</td>
                            <td>用户姓名</td>
                            <td>视频名</td>

                        </tr>

                        <c:forEach var="watchList" items="${requestScope.watchList}" varStatus="status" >
                            <tr>
                                <td>${status.count}</td>
                                <td>${watchList.user_id}</td>
                                <td>${watchList.video_id}</td>
                                <td>${watchList.user_name}</td>
                                <td>${watchList.video_name}</td>

                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
