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
    <title>用户信息完善</title>
    <link href="/css/bootstrap.css" rel="stylesheet">

    <script src="/js/jquery-3.6.0.js"></script>
    <script src="/js/bootstrap.js"></script>
    <script src="/js/My97DatePicker/WdatePicker.js"></script>
    <script src="/user_place/method.js"></script>
    <script src="/user_place/city.js"></script>


</head>
<body>
<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-md-12" style="text-align: center">
            <h3>用户信息完善</h3>
        </div>
    </div>
    <div class="row" style="margin-top: 20px">
        <div class="col-md-1">

        </div>
        <div class="col-md-10">


        <form class="form-horizontal" action="/userPerfect" method="post"  enctype="multipart/form-data">

            <div class="form-group">
                <label for="nick_name" class="col-sm-2 control-label">姓名:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="nick_name" name="nick_name" value="${requestScope.user.nick_name}" readonly="readonly">
                    <input type="hidden" name="id" value="${requestScope.user.id}">
                </div>
            </div>
            <div class="form-group">
                <label for="account" class="col-sm-2 control-label">账号:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="account" name="account" value="${requestScope.user.account}" readonly="readonly">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">密码:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="password" name="password" value="${requestScope.user.password}" readonly="readonly">
                </div>
            </div>
            <div class="form-group">
                <label for="gender" class="col-sm-2 control-label">性别:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="gender" name="gender" value="${requestScope.user.gender}" readonly="readonly">
                </div>
            </div>
            <div class="form-group">
                <label for="birthday" class="col-sm-2 control-label">生日:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="birthday" name="birthday"   value="${requestScope.user.birthday}" readonly="readonly">
                </div>
            </div>
            <div class="form-group">
                <label for="phone" class="col-sm-2 control-label">手机:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="phone" name="phone" value="${requestScope.user.phone}" readonly="readonly">
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">邮箱:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="email" name="email" value="${requestScope.user.email}" readonly="readonly">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">头像:</label>
                <div class="col-sm-10">
                    <input type="file" class="form-control" name="head_pic">
                </div>
            </div>
            <div class="form-group">
                <div>
                    <label for="birthplace" class="col-sm-2 control-label">籍贯：</label>
                    <div class="col-sm-10">
                        <input type="text" value="" id="birthplace" name="birthplace">
                    </div>
                    <br/>

                    <select id="prov" onchange="showCity(this)">
                        <option>=请选择省份=</option>
                    </select>

                    <select id="city" onchange="showCountry(this)">
                        <option>=请选择城市=</option>
                    </select>

                    <select id="country" onchange="selecCountry(this)">
                        <option>=请选择县区=</option>
                    </select>
                    <button type="button" class="btn met1" onClick="showAddr()" id="button-show" >确定</button>

                </div>

                <script src="/user_place/city.js"></script>
                <script src="/user_place/method.js"></script>
            </div>


            <div class="form-group">
                <label for="description" class="col-sm-2 control-label">个人简介:</label>
                <div class="col-sm-10">
                    <textarea id="description" name="description" style="resize: none;" class="form-control" rows="5">${requestScope.user.description}</textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-4"></div>
                <div class="col-md-4" style="text-align: center">
                    <input class="btn btn-success" type="submit" value="完善"/>
                    <input class="btn btn-info" style="margin-left: 20px" type="reset" value="重置"/>
                    <input class="btn btn-primary" style="margin-left: 20px" type="button" value="返回" onclick="history.back()"/>
                </div>
                <div class="col-md-4"></div>
            </div>
        </form>

    </div>
    <div class="col-md-1">
    </div>
</div>
</div>
</body>
</html>
