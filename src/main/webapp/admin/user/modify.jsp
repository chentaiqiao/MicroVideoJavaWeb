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
        <title>用户信息修改页面</title>
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
                    <h3>修改用户信息</h3>
                </div>
            </div>
            <div class="row" style="margin-top: 20px">
                <div class="col-md-10"></div>
                <div class="col-md-2">${sessionScope.admin.name}</div>
            </div>
            <div class="row" style="margin-top: 20px">

                <div class="col-md-10">

                    <form class="form-horizontal" action="/userModify" method="post">
                        <div class="form-group">
                            <label for="nick_name" class="col-sm-2 control-label">姓名:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="nick_name" name="nick_name" value="${requestScope.user.nick_name}">
                                <input type="hidden" name="id" value="${requestScope.user.id}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="account" class="col-sm-2 control-label">账号:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="account" name="account" value="${requestScope.user.account}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">密码:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="password" name="password" value="${requestScope.user.password}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="gender" class="col-sm-2 control-label">性别:</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="gender" name="gender">
                                    <option value="男" ${requestScope.user.gender=='男'?(selected='selected'):''}>=请选择=</option>
                                    <option value="男" ${requestScope.user.gender=='男'?(selected='selected'):''}>男</option>
                                    <option value="女" ${requestScope.user.gender=='女'?(selected='selected'):''}>女</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="birthday" class="col-sm-2 control-label">生日:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="birthday" name="birthday" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"  value="${requestScope.user.birthday}" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label">手机:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="phone" name="phone" value="${requestScope.user.phone}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label">邮箱:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="email" name="email" value="${requestScope.user.email}">
                            </div>
                        </div>

                        <div class="form-group">
                            <div>
                                <label for="birthplace" class="col-sm-2 control-label">籍贯：</label>
                                <div class="col-sm-10">
                                    <input type="text"  id="birthplace" name="birthplace" value="${requestScope.user.birthplace}">
                                </div>
                                <br/>
                                <!--省份选择-->
                                <select id="prov" onchange="showCity(this)">
                                    <option>=请选择省份=</option>
                                </select>
                                <!--城市选择-->
                                <select id="city" onchange="showCountry(this)">
                                    <option>=请选择城市=</option>
                                </select>
                                <!--县区选择-->
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
                                <input class="btn btn-success" type="submit" value="修改"/>
                                <input class="btn btn-info" style="margin-left: 20px" type="reset" value="重置"/>
                                <input class="btn btn-primary" style="margin-left: 20px" type="button" value="返回" onclick="history.back()"/>
                            </div>
                            <div class="col-md-4"></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
