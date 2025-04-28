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
        <title>用户注册页面</title>
        <link href="/css/bootstrap.css" rel="stylesheet">

        <script src="/js/jquery-3.6.0.js"></script>
        <script src="/js/bootstrap.js"></script>
        <script src="/js/My97DatePicker/WdatePicker.js"></script>

        <script>
            function validate(){
                console.log("验证")

                let passwordTag= $("#password");
                console.log(passwordTag.val())
                let password2Tag= $("#password2");
                console.log(password2Tag.val())
                let passwordMatchResult
                if(passwordTag.val()==password2Tag.val()){
                    passwordMatchResult=true
                }else(
                    passwordMatchResult=false
                )
                console.log(passwordMatchResult)
                if(!passwordMatchResult){
                    alert("两次密码不一致")
                    passwordTag.focus()
                    return false
                }

                let phoneTag= $("#phone");
                console.log(phoneTag.val())
                let phoneRegex=/^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$/
                let phoneMatchResult=phoneRegex.test(phoneTag.val())
                console.log(phoneMatchResult)
                if(!phoneMatchResult){
                    alert("请输入正确的手机格式")
                    phoneTag.focus()
                    return false
                }

                let emailTag= $("#email");
                console.log(emailTag.val())
                let emailRegex=/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
                let emailMatchResult=emailRegex.test(emailTag.val())
                console.log(emailMatchResult)
                if(!emailMatchResult){
                    alert("请输入正确的邮箱格式")
                    emailTag.focus()
                    return false
                }


                return true
            }
            $(function (){
                $("#account").blur(function (){
                    console.log("失去光标了")
                    $.post(
                        "/UserCheckAccount",
                        {'account':$("#account").val(),'time':new Date()},
                        function(data){
                            console.log(data)
                            if(data=='true'){
                                //alert($("#account").val()+"已经存在！")
                                location.replace("/front/register_already.jsp")
                                //$("#account").focus()

                            }
                        }
                    )

                })
            })


        </script>


    </head>
    <body>
        <div class="container" style="margin-top: 30px">
            <div class="row">
                <div class="col-md-12" style="text-align: center">
                    <h3>用户基本信息填写</h3>
                </div>
            </div>
            <div class="row" style="margin-top: 20px">
                <div class="col-md-1">

                </div>
                <div class="col-md-10">
                    <form class="form-horizontal" action="/userAdd" method="post" onsubmit="return validate()">

                       <div class="form-group">
                            <label for="nick_name" class="col-sm-2 control-label">姓名:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="nick_name" name="nick_name" placeholder="请输入姓名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="account" class="col-sm-2 control-label">账号:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="account" name="account" placeholder="请输入账号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">密码:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password2" class="col-sm-2 control-label">确认密码:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="password2" name="password2" placeholder="请输入密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="gender" class="col-sm-2 control-label">性别:</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="gender" name="gender">
                                    <option value="男">=请选择=</option>
                                    <option value="男">男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="birthday" class="col-sm-2 control-label">生日:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="birthday" name="birthday" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"  placeholder="请输入生日" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label">手机:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="phone" name="phone" placeholder="请输入手机">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label">邮箱:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱">
                            </div>
                        </div>




                        <div class="form-group">
                            <label for="description" class="col-sm-2 control-label">个人简介:</label>
                            <div class="col-sm-10">
                                <textarea id="description" name="description" style="resize: none;" class="form-control" rows="5" placeholder="随便留下点什么吧..."></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-4"></div>
                            <div class="col-md-4" style="text-align: center">
                                <input class="btn btn-success" type="submit" value="下一步"/>
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
