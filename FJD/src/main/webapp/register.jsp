<%@ page import="com.eliza.fjd.dal.UserDal" %>
<%@ page import="com.eliza.fjd.model.UserModel" %><%--
  Created by IntelliJ IDEA.
  User: 22280
  Date: 2021/12/12
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人注册</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="css/normalize.css" />
    <link rel="stylesheet" href="css/register.css" />
    <script src="js/jquery.min.js"></script>
    <script src="js/register.js"></script>
</head>
<body>
<div class="w">
    <header>
        <div class="logo"><a href="index.jsp"></a></div>
    </header>
    <div class="registerarea">
        <h3>
            注册新用户
            <em>我有账号，去<a href="login.jsp">登陆</a></em>
        </h3>
        <div class="reg_form">
            <form id="form" action="register.do" method="post">
                <ul>
                    <li>
                        <label for="tel">手机号：</label>
                        <input type="text" class="inp" id="tel" name="tel">
                        <span class="hint">
                                <i class="hint_icon"></i>
                                <em>请输入11位手机号码!</em>
                            </span>
                    </li>
                    <li>
                        <label for="name">用户名：</label>
                        <input type="text" class="inp" id="name" name="name">
                    </li>
                    <li class="password">
                        <label for="psw">登录密码：
                            <img src="images/close.png" width="24px" alt="">
                        </label>
                        <input type="password" class="inp" id="psw" name="psw">
                        <span class="hint">
                                <i class="hint_icon"></i>
                                <em>请输入1~16位密码!</em>
                            </span>
                    </li>
                    <li class="safe">
                        安全程度
                        <em class="ruo">弱</em>
                        <em class="zhong">中</em>
                        <em class="qiang">强</em>
                    </li>
                    <li class="repassword">
                        <label for="repsw">确认密码：
                            <img src="images/close.png" width="24px" alt="">
                        </label>
                        <input type="password" class="inp" id="repsw">
                        <span class="hint">
                                <i class="hint_icon"></i>
                                <em>请再次输入密码!</em>
                            </span>
                    </li>
                    <li class="agree">
                        <input type="checkbox">
                        同意协议并注册
                        <a href="#">《京东用户注册协议和隐私政策》</a>
                    </li>
                    <li>
                        <input type="submit" value="完成注册" class="over">
<%--                        <button onclick="handleClick(this)" class="over"/>--%>
                    </li>
                </ul>
            </form>
        </div>
    </div>
    <div class="footer">
        <p class="links">
            <a href="#">关于我们  |</a>
            <a href="#">联系我们  |</a>
            <a href="#">人才招聘  |</a>
            <a href="#">商家入驻  |</a>
            <a href="#">广告服务  |</a>
            <a href="#">手机京东  |</a>
            <a href="#">友情链接  |</a>
            <a href="#">销售联盟  |</a>
            <a href="#">京东社区  |</a>
            <a href="#">京东公益  |</a>
            <a href="#">English Site  |</a>
        </p>
        <p class="copyright">Copyright©2004-2019  京东JD.com 版权所有</p>
    </div>
</div>
<%--<script>--%>
<%--    function handleClick(){--%>
<%--        let form=document.getElementById("test_form");--%>
<%--        console.log(form);--%>
<%--        form.submit();--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>
