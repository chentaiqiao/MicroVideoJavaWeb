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
        <title>用户信息明细页面</title>
        <link href="/css/bootstrap.css" rel="stylesheet">
        <script src="/js/jquery-3.6.0.js"></script>
        <script src="/js/bootstrap.js"></script>
        <script src="/js/My97DatePicker/WdatePicker.js"></script>
    </head>
    <body>
        <div class="container" style="margin-top: 30px">
            <div class="row">
                <div class="col-md-12" style="text-align: center">
                    <h3>用户明细</h3>
                </div>
            </div>
            <div class="row" style="margin-top: 20px">
                <div class="col-md-10"></div>
                <div class="col-md-2">${sessionScope.admin.name}</div>
            </div>
            <div class="row" style="margin-top: 20px">

                <div class="col-md-10">

                    <form class="form-horizontal" action="#" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">姓名:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="${requestScope.user.nick_name}" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">账号:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="${requestScope.user.account}" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">密码:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="${requestScope.user.password}" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">性别:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="${requestScope.user.gender}" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">生日:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="${requestScope.user.birthday}" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">手机:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="${requestScope.user.phone}" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">邮箱:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="${requestScope.user.email}" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">籍贯:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="${requestScope.user.birthplace}" readonly="readonly">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">头像:</label>
                            <div class="col-sm-10">
                                <img src="/head_upload${requestScope.user.head_pic}"></img>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-2 control-label">个人简介:</label>
                            <div class="col-sm-10">
                                <textarea style="resize: none;" class="form-control" rows="5">${requestScope.user.description}</textarea>
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
