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
        <title>用户列表页面</title>
        <link href="/css/bootstrap.css" rel="stylesheet">
        <script src="/js/jquery-3.6.0.js"></script>
        <script src="/js/bootstrap.js"></script>
    </head>
    <body>
        <div class="container" style="margin-top: 30px">
            <div class="row">
                <div class="col-md-12" style="text-align: center">
                    <h3>用户列表</h3>
                </div>
            </div>
            <div class="row" style="margin-top: 20px">
                <div class="col-md-10"></div>
                <div class="col-md-2">${sessionScope.admin.name}</div>
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
                            <td>头像</td>
                            <td>姓名</td>
                            <td>账号</td>
                            <td>性别</td>
                            <td>手机</td>
                            <td>籍贯</td>
                            <td>操作</td>
                        </tr>

                        <c:forEach var="user" items="${requestScope.userList}" varStatus="status" >
                            <tr>
                                <td>${status.count}</td>
                                <td><img src="/head_upload${user.head_pic}" height="30" width="30"></img></td>
                                <td>${user.nick_name}</td>
                                <td>${user.account}</td>
                                <td>${user.gender}</td>
                                <td>${user.phone}</td>
                                <td>${user.birthplace}</td>
                                <td>
                                    <a class="btn btn-info btn-xs" href="/userDetail?id=${user.id}">明细</a>
                                    <a class="btn btn-warning btn-xs" href="/userToModify?id=${user.id}">修改</a>
                                    <a class="btn btn-danger btn-xs" href="/userRemove?id=${user.id}" onclick="return confirm('确定删除吗？')">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
